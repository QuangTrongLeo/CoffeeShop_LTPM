package coffee.shop.ui.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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

        int whiteColor = ContextCompat.getColor(context, R.color.white);
        int grayColor = ContextCompat.getColor(context, R.color.gray);
        int lightBlueColor = ContextCompat.getColor(context, R.color.light_blue);
        int darkBlueColor = ContextCompat.getColor(context, R.color.dark_blue);

        GradientDrawable drawable = (GradientDrawable) holder.buttonTable.getBackground().mutate();

        if ("blank".equals(table.getStatus())) {
            holder.buttonTable.setBackgroundTintList(ColorStateList.valueOf(whiteColor));
            holder.buttonTable.setTextColor(grayColor);
        } else if ("used".equals(table.getStatus())) {
            holder.buttonTable.setBackgroundTintList(ColorStateList.valueOf(lightBlueColor)); // Màu xanh đậm
            holder.buttonTable.setTextColor(darkBlueColor);
        }
        holder.buttonTable.setBackground(drawable);
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
