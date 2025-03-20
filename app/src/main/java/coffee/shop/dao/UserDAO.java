package coffee.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import coffee.shop.database.DatabaseConnection;
import coffee.shop.model.User;

public class UserDAO {
    private Connection conn = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            // Kết nối cơ sở dữ liệu
            conn = DatabaseConnection.getConnection();

            // Câu lệnh SQL lấy tất cả người dùng
            String sql = "SELECT * FROM user";
            pr = conn.prepareStatement(sql);

            // Thực thi câu lệnh và nhận kết quả
            rs = pr.executeQuery();

            // Duyệt qua kết quả và tạo đối tượng User
            while (rs.next()) {
                // Lấy dữ liệu từ ResultSet và tạo đối tượng User
                int id = rs.getInt("id");
                int salary = rs.getInt("salary");
                Timestamp startDate = rs.getTimestamp("startDate");
                String phoneNumber = rs.getString("phoneNumber");
                String fullname = rs.getString("fullname");
                String password = rs.getString("password");
                String username = rs.getString("username");
                int roleId = rs.getInt("role_id");

                // Tạo đối tượng User và thêm vào danh sách
                User user = new User(id, salary, startDate, phoneNumber, fullname, password, username, roleId);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng các tài nguyên
            closeResources();
        }

        return users;
    }

    public User checkLogin(String username, String password) {
        User user = null;
        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            pr = conn.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);
            rs = pr.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                int salary = rs.getInt("salary");
                Timestamp startDate = rs.getTimestamp("startDate");
                String phoneNumber = rs.getString("phoneNumber");
                String fullname = rs.getString("fullname");
                int roleId = rs.getInt("role_id");

                user = new User(id, salary, startDate, phoneNumber, fullname, password, username, roleId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return user;
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
