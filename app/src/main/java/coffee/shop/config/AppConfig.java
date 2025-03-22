package coffee.shop.config;

import android.util.Log;

import coffee.shop.controller.TableController;
import coffee.shop.controller.UserController;
import coffee.shop.dao.SessionDAO;
import coffee.shop.dao.TableCoffeeDAO;
import coffee.shop.dao.UserDAO;
import coffee.shop.service.table.TableService;
import coffee.shop.service.user.UserService;

public class AppConfig {
    private static AppConfig instance;

    // DAO
    private final UserDAO userDAO;
    private final SessionDAO sessionDAO;
    private final TableCoffeeDAO tableDAO;


    // SERVICE
    private final UserService userService;
    private final TableService tableService;


    // CONTROLLER
    private final UserController userController;
    private final TableController tableController;

    private AppConfig(){
        // dao
        this.userDAO = new UserDAO();
        this.sessionDAO = new SessionDAO();
        this.tableDAO = new TableCoffeeDAO();

        // service
        this.userService = new UserService(userDAO, sessionDAO);
        this.tableService = new TableService(tableDAO);

        // controller
        this.userController = new UserController(userService);
        this.tableController = new TableController(tableService);
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            Log.d("AppConfig", "Khởi tạo AppConfig...");
            instance = new AppConfig();
        }
        return instance;
    }
    public UserController provideUserController() {
        return userController;
    }
    public TableController provideTableController(){
        return tableController;
    }
}
