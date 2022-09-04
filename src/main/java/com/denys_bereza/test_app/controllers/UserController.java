package com.denys_bereza.test_app.controllers;

import com.denys_bereza.test_app.dto.GenericResponse;
import com.denys_bereza.test_app.dto.UserDTO;
import com.denys_bereza.test_app.models.User;
import com.denys_bereza.test_app.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(
            value = "/users",
            method = RequestMethod.POST,
            produces="application/json",
            consumes="application/json"
    )
    @ResponseBody
    public GenericResponse<User> createUser(@RequestBody UserDTO userData) {
        try {
            User user = this.service.createUser(userData);
            return new GenericResponse<User>(true, "Created").withData(user);
        } catch (DataIntegrityViolationException e) {
            return new GenericResponse(false, "Already exist");
        }
    }
}
