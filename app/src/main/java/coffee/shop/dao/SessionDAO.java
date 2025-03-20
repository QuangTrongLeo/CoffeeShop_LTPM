package coffee.shop.dao;

import android.os.Build;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import coffee.shop.database.DatabaseConnection;
import coffee.shop.model.Session;

public class SessionDAO {
    private Connection conn = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    public void saveSession(Session session) throws SQLException {
        if (session == null) {
            throw new SQLException("Session rỗng");
        }
        String query = "INSERT INTO `session` (`idEmployee`, `startTime`, `message`) VALUES (?, ?, ?)";
        try {
            conn = DatabaseConnection.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, session.getIdEmployee());
            pr.setTimestamp(2, session.getStartTime());
            pr.setNString(3, session.getMessage());

            pr.executeUpdate();
        } finally {
            closeResources();
        }
    }

    public void updateEndTime(int idEmployee) throws SQLException {
        String query = "UPDATE `session` SET `endTime` = ? WHERE `idEmployee` = ? AND `endTime` IS NULL ORDER BY `startTime` DESC LIMIT 1";

        try {
            conn = DatabaseConnection.getConnection();
            pr = conn.prepareStatement(query);
            pr.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            pr.setInt(2, idEmployee);

            pr.executeUpdate();
        } finally {
            closeResources();
        }
    }
    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (pr != null) {
                pr.close();
                pr = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
