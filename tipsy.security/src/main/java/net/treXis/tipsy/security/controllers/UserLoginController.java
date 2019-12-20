package net.treXis.tipsy.security.controllers;

import net.treXis.tipsy.security.model.UserLogin;
import net.treXis.tipsy.security.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/api/user_login")
public class UserLoginController {


    private final UserLoginRepository userLoginRepository;
    @Autowired
    public UserLoginController(UserLoginRepository userLoginRepository){
        this.userLoginRepository = userLoginRepository;
    }

//    @GetMapping
//    public List<UserLogin> list(){
//        List<UserLogin> userLogins = new ArrayList<>();
//        return userLogins;
//    }

    // Replaced by Jpa Code
    @GetMapping
    public List<UserLogin> list(){
        return userLoginRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK) // code 200, changes the original 201 code.
    public void create(@RequestBody UserLogin userLogins){  // for processing new Fund Requests
        userLoginRepository.save(userLogins); // Added for Jpa repo
    }

    @GetMapping("/{id}")
    public UserLogin get(@PathVariable("id") long id) {  // will return a single fund request from an ID search
//        return new FundRequests();
        return userLoginRepository.getOne(id);
    }


}
