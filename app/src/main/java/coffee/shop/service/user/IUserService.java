package coffee.shop.service.user;

import java.util.List;

import coffee.shop.model.User;

public interface IUserService {
    public List<User> getAllUsers();

    public User checkLogin(String username, String password);
    public void logout(int userId);
}
