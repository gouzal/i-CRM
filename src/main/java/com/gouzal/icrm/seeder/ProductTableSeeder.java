package com.gouzal.icrm.seeder;

import com.gouzal.icrm.entity.Category;
import com.gouzal.icrm.entity.Product;
import com.gouzal.icrm.repository.CategoryRepository;
import com.gouzal.icrm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTableSeeder extends AbstractSeeder {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run() {
        List<Category> categories = categoryRepository.findAll();
        for (int i = 0; i < 50; i++) {
            float purchasePrice = (float) faker.number().randomDouble(2, 1, 100);
            Product product = new Product();
            product.setName(faker.food().fruit());
            product.setPurchasePrice(purchasePrice);
            product.setReference(faker.number().digits(8));
            product.setSalePrice((float) (purchasePrice * 1.4));
            product.setCategory(categories.get(Math.abs(rand.nextInt(categories.size()))));
            productRepository.save(product);
        }
        log.info("Seeding product table is finished");
    }
}
