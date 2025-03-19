package coffee.shop.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import coffee.shop.R;
import coffee.shop.config.AppConfig;
import coffee.shop.controller.UserController;
import coffee.shop.dao.UserDAO;
import coffee.shop.service.user.UserService;
import coffee.shop.model.User;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "DatabaseTest";
    private UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        userController = AppConfig.getInstance().provideUserController();
        // Chạy trên luồng phụ để tránh lag UI
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            List<User> users = userController.getAllUsers();
            for (User user : users) {
                Log.d(TAG, "User: " + user.toString());
            }
        });
        executor.shutdown();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
