package coffee.shop.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import coffee.shop.R;
import coffee.shop.config.AppConfig;
import coffee.shop.controller.TableController;
import coffee.shop.model.CoffeeTable;
import coffee.shop.ui.adapter.TableAdapter;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeTest";
    private RecyclerView recyclerViewTables;
    private TableAdapter tableAdapter;
    private TableController tableController;
    private List<CoffeeTable> tables = new ArrayList<>(); // ✅ Khởi tạo danh sách trống

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        recyclerViewTables = findViewById(R.id.recyclerViewTables);
        recyclerViewTables.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerViewTables.setNestedScrollingEnabled(true);

        tableController = AppConfig.getInstance().provideTableController();

        // ✅ Khởi tạo adapter với danh sách trống trước
        tableAdapter = new TableAdapter(this, tables);
        recyclerViewTables.setAdapter(tableAdapter);

        loadTables();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadTables() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                List<CoffeeTable> fetchedTables = tableController.getAllCoffeeTables();

                if (fetchedTables != null) {
                    tables.clear();
                    tables.addAll(fetchedTables);
                }

                // ✅ Cập nhật giao diện trên luồng chính
                runOnUiThread(() -> tableAdapter.notifyDataSetChanged());

                // ✅ Ghi log để kiểm tra dữ liệu
                for (CoffeeTable table : tables) {
                    Log.d(TAG, "Table: " + table.toString());
                }
            } catch (Exception e) {
                Log.e(TAG, "Lỗi khi truy xuất database", e);
            }
        });
        executor.shutdown();
    }
}
