package coffee.shop.service.user;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import coffee.shop.dao.SessionDAO;
import coffee.shop.dao.UserDAO;
import coffee.shop.model.Session;
import coffee.shop.model.User;
import coffee.shop.utils.JwtUtils;

public class UserService implements IUserService{
    private final UserDAO userDAO;
    private final SessionDAO sessionDAO;

    public UserService(UserDAO userDAO, SessionDAO sessionDAO) {
        this.userDAO = userDAO;
        this.sessionDAO = sessionDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User checkLogin(String username, String password) {
        User user = userDAO.checkLogin(username, password);
        if (user != null) {
            Session session = new Session();
            session.setIdEmployee(user.getId());
            session.setStartTime(new Timestamp(System.currentTimeMillis()));
            session.setMessage("login");

            try {
                sessionDAO.saveSession(session);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
        }
        return null;
    }

    @Override
    public void logout(int userId) {
        try {
            sessionDAO.updateEndTime(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
