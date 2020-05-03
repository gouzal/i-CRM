package com.gouzal.icrm.seeder;

import com.gouzal.icrm.entity.Role;
import com.gouzal.icrm.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleTableSeeder extends AbstractSeeder {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run() {
        String[] roles = {"ADMIN", "CLIENT", "USER", "EMPLOYE", "INVITE"};
        for (String roleName : roles) {
            this.roleRepository.save(new Role(roleName));
        }
        log.info("Seeding Roles table is finished");
    }
}
