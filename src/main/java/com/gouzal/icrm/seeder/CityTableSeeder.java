package com.gouzal.icrm.seeder;

import com.gouzal.icrm.entity.City;
import com.gouzal.icrm.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityTableSeeder extends AbstractSeeder {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run() {
        String[] villes = {"Tanger", "Casablanca", "Rabat", "Fes", "Agadir", "Layoun"};
        for (String cityName : villes) {
            this.cityRepository.save(new City(cityName));
        }
        log.info("Seeding City table is finished");
    }
}
