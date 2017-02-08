package com.example.controller;

import com.example.entity.User;
import com.example.entity.request.AddUserRequest;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by will cao on 9/9/2016.
 */

@RestController
@RequestMapping("/users")
public class UserControler {

    private UserRepository userRepository;

    @Autowired
    public UserControler (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers(){

        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest){
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSuname(addUserRequest.getSurname());
        userRepository.save(user);
    }
}
