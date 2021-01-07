package kz.sai_ven.advproject.service;

import kz.sai_ven.advproject.models.User;
import kz.sai_ven.advproject.repo.UserRepository;
import kz.sai_ven.advproject.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(userRepository.findById(id).get());
        userRepository.flush();
    }

    @Override
    public User login(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }
}
