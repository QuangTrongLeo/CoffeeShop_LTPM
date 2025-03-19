package coffee.shop.service.user;

import java.util.List;

import coffee.shop.dao.UserDAO;
import coffee.shop.model.User;

public class UserService implements IUserService{
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
