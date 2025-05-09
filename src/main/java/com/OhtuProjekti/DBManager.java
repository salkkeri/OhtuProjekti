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

    public static void insertAsiakas(int AsiakasID, String Nimi, String Osoite, String Puh_nro, String Sähköposti) {
        String sql = "INSERT INTO Asiakas (AsiakasID, Nimi, Osoite, Puhnro, Sähköposti) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, AsiakasID);
            pstmt.setString(2, Nimi);
            pstmt.setString(3, Osoite);
            pstmt.setString(4, Puh_nro);
            pstmt.setString(5, Sähköposti);

            pstmt.executeUpdate();
            System.out.println("Asiakas inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting Asiakas: " + e.getMessage());
        }
    }

    public static void insertMokki(int mokkiID, String nimi, String osoite, String varustelu, double hintaPerYo, int kapasiteetti) {
        String sql = "INSERT INTO Mokki (MokkiID, Nimi, Osoite, Varustelu, HintaPerYo, Kapasiteetti) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, mokkiID);
            pstmt.setString(2, nimi);
            pstmt.setString(3, osoite);
            pstmt.setString(4, varustelu);
            pstmt.setDouble(5, hintaPerYo);
            pstmt.setInt(6, kapasiteetti);

            pstmt.executeUpdate();
            System.out.println("Mökki inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting Mökki: " + e.getMessage());
        }
    }

    public static void insertVaraus(int VarausID, int AsiakasID, int MokkiID) {
        String sql = "INSERT INTO Varaus (VarausID, AsiakasID, MokkiID) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, VarausID);
            pstmt.setInt(2, AsiakasID);
            pstmt.setInt(3, MokkiID);


            pstmt.executeUpdate();
            System.out.println("Asiakas inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting Asiakas: " + e.getMessage());
        }
    }


    public static void insertLasku(int LaskuID, double Summa, String Erapaiva, int VarausID, int Maksettu) {
        String sql = "INSERT INTO Lasku (LaskuID, Summa, Erapaiva, VarausID, Maksettu) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, LaskuID);
            pstmt.setDouble(2, Summa);
            pstmt.setString(3, Erapaiva);
            pstmt.setInt(4, VarausID);
            pstmt.setInt(5, Maksettu);

            pstmt.executeUpdate();
            System.out.println("Asiakas inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting Asiakas: " + e.getMessage());
        }
    }

}
