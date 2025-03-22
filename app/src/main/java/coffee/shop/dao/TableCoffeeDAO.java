package coffee.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coffee.shop.database.DatabaseConnection;
import coffee.shop.model.CoffeeTable;

public class TableCoffeeDAO {
    private Connection conn = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;

    // Get all Tables
    public List<CoffeeTable> getAllCoffeeTables(){
        List<CoffeeTable> tables = new ArrayList<>();
        try {
            conn = DatabaseConnection.getConnection();
            String query = "select * from coffee_table";
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String status = rs.getString("status");

                CoffeeTable table = new CoffeeTable(id, name, status);
                tables.add(table);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return tables;
    }

    // Lấy tất cả bàn trống
    public List<CoffeeTable> getAllBlankTables(){
        return getTablesByStatus("blank");
    }

    // Lấy tất cả bàn có khách
    public List<CoffeeTable> getAllUsedTables(){
        return getTablesByStatus("used");
    }

    private List<CoffeeTable> getTablesByStatus(String status) {
        List<CoffeeTable> tables = new ArrayList<>();
        try {
            conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM coffee_table";

            // Nếu có điều kiện trạng thái, thêm WHERE vào query
            if (status != null) {
                query += " WHERE status = ?";
            }

            pr = conn.prepareStatement(query);

            if (status != null) {
                pr.setString(1, status);
            }

            rs = pr.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String tableStatus = rs.getString("status");

                CoffeeTable table = new CoffeeTable(id, name, tableStatus);
                tables.add(table);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return tables;
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pr != null) pr.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}