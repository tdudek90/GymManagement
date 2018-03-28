package pl.tomekdudek.GymManagement.service;

import pl.tomekdudek.GymManagement.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User getUser(int userId);

    List<User> getAllUsers();

    void updateUser(int userId, User user);

    void deleteUser(User user);

}
