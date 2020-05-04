package com.gouzal.icrm.repository.specification;

import com.gouzal.icrm.dto.SearchCriteria;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EntityJpaSpecification<T> {
    private Specification specification;

    public Specification convertWithOR(SearchCriteria... criteriaList) {
        if (criteriaList.length > 0) {
            this.specification = createSpecification(criteriaList[0]);
        }
        for (int i = 1; i < criteriaList.length; i++) {
            this.specification.or(createSpecification(criteriaList[i]));
        }
        return specification;
    }

    public Specification convertWithAND(SearchCriteria... criteriaList) {

        for (SearchCriteria searchCriteria : criteriaList) {
            this.specification.and(createSpecification(searchCriteria));
        }
        return this.specification;
    }

    @Bean
    private SearchCriteria createEmptySearchCriteria() {
        return new SearchCriteria("1", ":", "1");
    }

    @Bean
    private Specification createSpecification(SearchCriteria searchCriteria) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (searchCriteria.getOperation().equalsIgnoreCase(">")) {
                    return criteriaBuilder.greaterThanOrEqualTo(
                            root.<String>get(searchCriteria.getKey()), searchCriteria.getValue().toString());
                } else if (searchCriteria.getOperation().equalsIgnoreCase("<")) {
                    return criteriaBuilder.lessThanOrEqualTo(
                            root.<String>get(searchCriteria.getKey()), searchCriteria.getValue().toString());
                } else if (searchCriteria.getOperation().equalsIgnoreCase(":")) {
                    if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                        return criteriaBuilder.like(
                                root.<String>get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
                    } else {
                        return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
                    }
                }
                return null;
            }
        };
    }
}
