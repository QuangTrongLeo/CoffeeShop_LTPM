package coffee.shop.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import coffee.shop.R;
import coffee.shop.model.CoffeeTable;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder> {
    private Context context;
    private List<CoffeeTable> tableList;

    public TableAdapter(Context context, List<CoffeeTable> tableList) {
        this.context = context;
        this.tableList = tableList;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_table, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position) {
        CoffeeTable table = tableList.get(position);
        holder.buttonTable.setText(table.getName());
        Log.d("TableAdapter", "Table " + table.getName() + " - Status: " + table.getStatus());

        if ("blank".equals(table.getStatus())) {
            holder.buttonTable.setBackgroundResource(R.drawable.button_background_white);
        } else if ("used".equals(table.getStatus())) {
            holder.buttonTable.setBackgroundResource(R.drawable.button_background_blue);
        }
    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    // ✅ Định nghĩa TableViewHolder bên trong Adapter
    public static class TableViewHolder extends RecyclerView.ViewHolder {
        Button buttonTable;

        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonTable = itemView.findViewById(R.id.buttonTable);
        }
    }
}
