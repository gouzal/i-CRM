package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.gouzal.icrm.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements Operation<User> {

    @Autowired
    UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
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
