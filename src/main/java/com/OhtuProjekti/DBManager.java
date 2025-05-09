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

    public static void insertMokki(int mokkiID, String nimi, String osoite, String varustelu, double hintaPerYö, int kapasiteetti) {
        String sql = "INSERT INTO Mökki (MokkiID, Nimi, Osoite, Varustelu, \"Hinta per yö\", Kapasiteetti) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, mokkiID);
            pstmt.setString(2, nimi);
            pstmt.setString(3, osoite);
            pstmt.setString(4, varustelu);
            pstmt.setDouble(5, hintaPerYö);
            pstmt.setInt(6, kapasiteetti);

            pstmt.executeUpdate();
            System.out.println("Mökki inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting Mökki: " + e.getMessage());
        }
    }

    public static void insertAsiakas(int asiakasID, String nimi, String osoite, String puhNum, String sPosti) {
        String sql = "INSERT INTO Asiakas (Asiakas_ID, Nimi, Osoite, Puh_nro, Sähköposti) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, asiakasID);
            pstmt.setString(2, nimi);
            pstmt.setString(3, osoite);
            pstmt.setString(4, puhNum);
            pstmt.setString(5, sPosti);

            pstmt.executeUpdate();
            System.out.println("Asiakas inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting Asiakas: " + e.getMessage());
        }
    }

}
