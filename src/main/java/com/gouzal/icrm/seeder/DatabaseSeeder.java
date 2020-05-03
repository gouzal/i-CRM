package com.gouzal.icrm.seeder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DatabaseSeeder {

    @Value("${myapp.seeder.start:false}")
    private boolean enable;

    private CategoryTableSeeder categoryTableSeeder;
    private CityTableSeeder cityTableSeeder;
    private RoleTableSeeder roleTableSeeder;
    private UserTableSeeder userTableSeeder;
    private CustomerTableSeeder customerTableSeeder;
    private ProviderTableSeeder providerTableSeeder;
    private ProductTableSeeder productTableSeeder;

    @Autowired
    public DatabaseSeeder(CategoryTableSeeder categoryTableSeeder, CityTableSeeder cityTableSeeder, RoleTableSeeder roleTableSeeder, UserTableSeeder userTableSeeder, CustomerTableSeeder customerTableSeeder, ProviderTableSeeder providerTableSeeder, ProductTableSeeder productTableSeeder) {
        this.categoryTableSeeder = categoryTableSeeder;
        this.cityTableSeeder = cityTableSeeder;
        this.roleTableSeeder = roleTableSeeder;
        this.userTableSeeder = userTableSeeder;
        this.customerTableSeeder = customerTableSeeder;
        this.providerTableSeeder = providerTableSeeder;
        this.productTableSeeder = productTableSeeder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        if (enable) {
            this.categoryTableSeeder.run();
            this.cityTableSeeder.run();
            this.roleTableSeeder.run();
            this.userTableSeeder.run();
            this.customerTableSeeder.run();
            this.providerTableSeeder.run();
            this.productTableSeeder.run();
            log.info("SEEDER IS FINISHED");
        }

    }

}
