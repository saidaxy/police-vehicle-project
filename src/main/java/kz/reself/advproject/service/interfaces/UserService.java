package kz.reself.advproject.service.interfaces;

import kz.reself.advproject.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAllUsers();

    User findUserById(Long id);

    User createUser(User user);

    void deleteUser(Long id);

    User login(String login, String password);
}
