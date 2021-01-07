package kz.sai_ven.advproject.controller;

import kz.sai_ven.advproject.models.User;
import kz.sai_ven.advproject.service.interfaces.UserService;
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

    @GetMapping("/user/{id}")
    public User findAuthorByName(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        if(userService.createUser(user) != null)
            return "Registered";
        return "Error";
    }

    @PostMapping("/deleteUser/{id}")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/loginUser")
    public String login(@RequestParam String login, @RequestParam String password){
        if(userService.login(login, password) != null) {
            return String.valueOf(userService.login(login, password).getId());
        }
        return "Error";
    }

}
