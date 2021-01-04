package kz.reself.advproject.controller;

import kz.reself.advproject.models.User;
import kz.reself.advproject.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/id={id}")
    public User findAuthorByName(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        if(userService.createUser(user) != null)
            return "Registered";
        return "Error";
    }

    @PostMapping("/deleteUser={id}")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/loginUser")
    public String login(@RequestParam String login, @RequestParam String password){
        if(userService.login(login, password) != null) {
            return "log in";
        }
        return "Error";
    }

}
