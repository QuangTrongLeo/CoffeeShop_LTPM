package coffee.shop.ui.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import coffee.shop.R;
import coffee.shop.ui.adapter.TableAdapter;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerViewTables;
    private TableAdapter tableAdapter;
    private List<String> tables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        recyclerViewTables = findViewById(R.id.recyclerViewTables);
        recyclerViewTables.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerViewTables.setNestedScrollingEnabled(true);

        tables = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            tables.add("Bàn " + i);
        }

        tableAdapter = new TableAdapter(this, tables);
        recyclerViewTables.setAdapter(tableAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}