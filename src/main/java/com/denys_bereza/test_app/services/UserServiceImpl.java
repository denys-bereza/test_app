package com.denys_bereza.test_app.services;

import com.denys_bereza.test_app.dto.UserCreateDTO;
import com.denys_bereza.test_app.models.User;
import com.denys_bereza.test_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserCreateDTO data) {
        User user = new User(data.getName(), data.getEmail(), data.getRegion());
        this.userRepository.save(user);

        return user;
    }

//    private User getUser(UUID id) {
//    }
//
//    private List<User> getFollowers() {
//    }
}
