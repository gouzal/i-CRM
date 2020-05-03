package com.gouzal.icrm.repository.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
