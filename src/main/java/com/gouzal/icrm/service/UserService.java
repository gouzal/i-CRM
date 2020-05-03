package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.repository.UserRepository;
import com.gouzal.icrm.repository.specification.SearchCriteria;
import com.gouzal.icrm.repository.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.gouzal.icrm.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserService implements Operation<User> {

    @Autowired
    UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        //UserSpecification userSpecification = new UserSpecification(new SearchCriteria("lastName", ":", ""));
        org.springframework.data.jpa.domain.Specification userSpecification=  Specification.where(new UserSpecification(new SearchCriteria("lastName",":","Colin"))).or(new UserSpecification(new SearchCriteria("firstName", ":", "Emilie ")));
        return userRepository.findAll(userSpecification, pageable);
        //return userRepository.findAll(pageable);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);

    }

    public void save(User user) {
        userRepository.save(user);

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

}
