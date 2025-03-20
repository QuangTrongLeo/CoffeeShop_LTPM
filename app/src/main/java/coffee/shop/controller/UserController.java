package coffee.shop.controller;

import java.util.List;

import coffee.shop.dao.UserDAO;
import coffee.shop.model.User;
import coffee.shop.service.user.IUserService;
import coffee.shop.service.user.UserService;

public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public User login(String username, String password) {
        return userService.checkLogin(username, password);
    }
    public void logout(int userId) {
        userService.logout(userId);
    }
}

