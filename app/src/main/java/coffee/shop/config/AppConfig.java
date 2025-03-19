package coffee.shop.config;

import coffee.shop.controller.UserController;
import coffee.shop.dao.UserDAO;
import coffee.shop.service.user.UserService;

public class AppConfig {
    private static AppConfig instance;

    // DAO
    private final UserDAO userDAO;

    // SERVICE
    private final UserService userService;


    // CONTROLLER
    private final UserController userController;

    private AppConfig(){
        // dao
        this.userDAO = new UserDAO();

        // service
        this.userService = new UserService(userDAO);

        // controller
        this.userController = new UserController(userService);
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
    public UserController provideUserController() {
        return userController;
    }
}
