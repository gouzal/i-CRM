package com.gouzal.icrm.seeder;

import com.gouzal.icrm.entity.City;
import com.gouzal.icrm.entity.Customer;
import com.gouzal.icrm.repository.CityRepository;
import com.gouzal.icrm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerTableSeeder extends AbstractSeeder {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run() {
        List<City> cities = cityRepository.findAll();
        for (int i = 0; i < 30; i++) {
            Customer customer = new Customer();
            customer.setAddress(faker.address().fullAddress());
            customer.setCity(cities.get(Math.abs(rand.nextInt(cities.size()))));
            customer.setCompanyName(faker.company().name());
            customer.setEmail(faker.internet().emailAddress());
            customer.setFixNumber(faker.phoneNumber().phoneNumber());
            customer.setMobileNumber(faker.phoneNumber().cellPhone());
            customer.setLegalType(faker.company().bs());
            customer.setIce(String.valueOf(faker.number().randomNumber()));
            customerRepository.save(customer);
        }
        log.info("Seeding Customer table is finished");
    }
}
