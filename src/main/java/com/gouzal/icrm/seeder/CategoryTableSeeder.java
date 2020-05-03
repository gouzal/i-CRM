package com.gouzal.icrm.seeder;

import com.gouzal.icrm.repository.CategoryRepository;
import com.gouzal.icrm.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CategoryTableSeeder extends AbstractSeeder {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Category category = new Category();
            category.setName(faker.pokemon().name());
            if (faker.bool().bool()) {
                List<Category> categories = this.categoryRepository.findAll();
                if (categories.size() > 0) {
                    Category parentCategory = categories.get(Math.abs(rand.nextInt(categories.size())));
                    category.setCategory(parentCategory);
                }
            }
            this.categoryRepository.save(category);
        }
        log.info("Seeding Category table is finished");
    }
}
