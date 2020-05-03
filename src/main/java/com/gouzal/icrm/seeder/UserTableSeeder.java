package com.gouzal.icrm.seeder;

import com.gouzal.icrm.entity.Role;
import com.gouzal.icrm.entity.User;
import com.gouzal.icrm.repository.RoleRepository;
import com.gouzal.icrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserTableSeeder extends AbstractSeeder {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void run() {
        //PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        List<Role> roles = roleRepository.findAll();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setActive(faker.bool().bool());
            user.setLogin(roles.get(rand.nextInt(roles.size())).getName().toLowerCase()+"@localhost.com");
            user.setPassword("pass");
            user.setPoste(faker.name().title());
            user.setPrefix(faker.name().prefix());
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setRoles(getAssignedRoles(roles));
            user.setAvatar(faker.random().nextInt(1,12).toString().concat(".jpg"));
            this.userRepository.save(user);
        }
        log.info("Seeding Users table is finished");
    }

    /**
     * This method get random roles from Table Roles
     *
     * @param roles list of  all available roles
     * @return list of random roles
     */
    private List<Role> getAssignedRoles(List<Role> roles) {
        List<Role> assignedRoles = new ArrayList<>();
        for (int j = 0; j < Math.abs(this.rand.nextInt(roles.size())); j++) {
            assignedRoles.add(roles.get(Math.abs(this.rand.nextInt(roles.size()))));
        }
        return assignedRoles;
    }
}
