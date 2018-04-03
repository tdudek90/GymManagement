package pl.tomekdudek.GymManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.tomekdudek.GymManagement.model.User;
import pl.tomekdudek.GymManagement.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getUser(int userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>(userRepository.findAll());
        return userList;
    }

    @Override
    public void updateUser(int userId, User user) {
        edit(user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void edit(User user) {
        User currentUser = userRepository.findAllById(user.getId());
        if (user.getName().isEmpty()) {
            user.setName(currentUser.getName());
        }
        if (user.getLastname().isEmpty()) {
            user.setLastname(currentUser.getLastname());
        }
        if (user.getMail().isEmpty()) {
            user.setMail(currentUser.getMail());
        }
        if (user.getPassword().isEmpty()) {
            user.setPassword(currentUser.getPassword());
        }
    }
}
