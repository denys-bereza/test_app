package com.denys_bereza.test_app.controllers;

import com.denys_bereza.test_app.constants.Regions;
import com.denys_bereza.test_app.constants.UserStatuses;
import com.denys_bereza.test_app.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(
            value = "/users",
            method = RequestMethod.POST,
            produces="application/json",
            consumes="application/json"
    )
    public User getUsers() {
        User user = new User();
        user.setRegion(Regions.OCEANIA);
        user.setEmail("some@mail.com");
        user.setName("xxx");
        user.setStatus(UserStatuses.ACTIVE);

        return user;
    }
}
