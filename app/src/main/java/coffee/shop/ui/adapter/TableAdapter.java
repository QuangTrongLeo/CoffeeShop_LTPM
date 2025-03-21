package coffee.shop.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import coffee.shop.R;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder> {
    private Context context;
    private List<String> tableList;

    public TableAdapter(Context context, List<String> tableList) {
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
        holder.buttonTable.setText("BÀN " + (position + 1));
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
