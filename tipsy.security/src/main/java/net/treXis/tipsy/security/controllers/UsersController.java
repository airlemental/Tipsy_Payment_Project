package net.treXis.tipsy.security.controllers;

import net.treXis.tipsy.security.model.User;
import net.treXis.tipsy.security.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(UsersController.class);

    @Value("{ninja.site.test}")
    private String testString;


    private final UserRepository usersRepository;
    @Autowired
    public UsersController(UserRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<User> list(){
        LOG.debug("Connection Error: " + testString);
        return usersRepository.findAll();
    }

    //Get
    @GetMapping
    @RequestMapping("{id}")
    public User get(@PathVariable Long id){
        return usersRepository.getOne(id);
    }

    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user){
        return usersRepository.saveAndFlush(user);
    }

    //Delete
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        usersRepository.deleteById(id);

    }

    //Update
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user){
        User existinguser = usersRepository.getOne(id);
        BeanUtils.copyProperties(user, existinguser, "user_account");
        return usersRepository.saveAndFlush(user);
    }

}
