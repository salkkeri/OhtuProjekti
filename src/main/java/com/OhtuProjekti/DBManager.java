package com.OhtuProjekti;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final String DB_URL = "jdbc:sqlite:mokki_db.sqlite";

    public static List<String[]> executeQuery(String sql) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            List<String[]> results = new ArrayList<>();
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = meta.getColumnName(i);
            }
            results.add(columnNames);

            while (rs.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getString(i);
                }
                results.add(row);
            }

            return results;
        }
    }

    public static int executeUpdate(String sql) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(sql);
        }
    }
}
