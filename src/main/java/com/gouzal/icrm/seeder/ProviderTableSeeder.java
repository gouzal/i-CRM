package com.gouzal.icrm.seeder;

import com.gouzal.icrm.entity.City;
import com.gouzal.icrm.entity.Provider;
import com.gouzal.icrm.repository.CityRepository;
import com.gouzal.icrm.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProviderTableSeeder extends AbstractSeeder {

    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run() {
        List<City> cities = cityRepository.findAll();
        for (int i = 0; i < 30; i++) {
            Provider provider = new Provider();
            provider.setAddress(faker.address().fullAddress());
            provider.setCity(cities.get(Math.abs(rand.nextInt(cities.size()))));
            provider.setCompanyName(faker.company().name());
            provider.setEmail(faker.internet().emailAddress());
            provider.setFixNumber(faker.phoneNumber().phoneNumber());
            provider.setMobileNumber(faker.phoneNumber().cellPhone());
            provider.setLegalType(faker.company().bs());
            provider.setIce(String.valueOf(faker.number().randomNumber()));
            providerRepository.save(provider);
        }
        log.info("Seeding Provider table is finished");
    }
}
