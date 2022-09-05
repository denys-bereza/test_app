package com.denys_bereza.test_app.services;

import com.denys_bereza.test_app.dto.UserCreateDTO;
import com.denys_bereza.test_app.models.User;

public interface UserService {
    public User createUser(UserCreateDTO data);
}
