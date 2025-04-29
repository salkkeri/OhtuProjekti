package com.OhtuProjekti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQL {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:mokki_db.sqlite";

        String[] statements = {

                "CREATE TABLE Tyontekija (" +
                        "TyontekijaID INTEGER PRIMARY KEY," +
                        "Nimi TEXT," +
                        "Sähköposti TEXT," +
                        "Puh_nro TEXT," +
                        "Titteli TEXT" +
                        ");",


                "CREATE TABLE Asiakas (" +
                        "AsiakasID INTEGER PRIMARY KEY," +
                        "Nimi TEXT," +
                        "Osoite TEXT," +
                        "Sähköposti TEXT," +
                        "Puh_nro TEXT" +
                        ");",

                "CREATE TABLE Mokki (" +
                        "MokkiID INTEGER PRIMARY KEY," +
                        "Nimi TEXT," +
                        "Osoite TEXT," +
                        "Varustelu TEXT," +
                        "Kapasiteetti INTEGER," +
                        "HintaPerYo REAL" +
                        ");",

                "CREATE TABLE Varaus (" +
                        "VarausID INTEGER PRIMARY KEY," +
                        "AsiakasID INTEGER," +
                        "MokkiID INTEGER," +
                        "FOREIGN KEY (AsiakasID) REFERENCES Asiakas(AsiakasID)," +
                        "FOREIGN KEY (MokkiID) REFERENCES Mokki(MokkiID)" +
                        ");",


                "CREATE TABLE Lasku (" +
                        "LaskuID INTEGER PRIMARY KEY," +
                        "Summa REAL," +
                        "Erapaiva TEXT," +
                        "VarausID INTEGER," +
                        "Maksettu INTEGER" +
                        "FOREIGN KEY (VarausID) REFERENCES Varaus(VarausID)" +
                        ");"
        };

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            for (String sql : statements) {
                stmt.execute(sql);
            }

            System.out.println("Database schema created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

