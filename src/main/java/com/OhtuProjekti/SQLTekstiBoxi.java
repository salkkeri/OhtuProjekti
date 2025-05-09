package com.OhtuProjekti;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class SQLTekstiBoxi extends Application {
    private static final String DB_URL = "jdbc:sqlite:mokki_db.sqlite";

    @Override
    public void start(Stage primaryStage) {
        TextArea queryInput = new TextArea();
        queryInput.setPromptText("Enter your SQL command here...");
        queryInput.setPrefHeight(150);

        Button runButton = new Button("Run SQL");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        runButton.setOnAction(e -> {
            String sql = queryInput.getText();
            try (Connection conn = DriverManager.getConnection(DB_URL);
                 Statement stmt = conn.createStatement()) {

                boolean hasResultSet = stmt.execute(sql);

                if (hasResultSet) {
                    ResultSet rs = stmt.getResultSet();
                    StringBuilder result = new StringBuilder();
                    ResultSetMetaData meta = rs.getMetaData();
                    int columnCount = meta.getColumnCount();


                    for (int i = 1; i <= columnCount; i++) {
                        result.append(meta.getColumnName(i)).append("\t");
                    }
                    result.append("\n");

                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            result.append(rs.getString(i)).append("\t");
                        }
                        result.append("\n");
                    }

                    outputArea.setText(result.toString());
                } else {
                    int updateCount = stmt.getUpdateCount();
                    outputArea.setText("Update count: " + updateCount);
                }

            } catch (SQLException ex) {
                outputArea.setText("SQL Error:\n" + ex.getMessage());
            }
        });

        VBox root = new VBox(10, queryInput, runButton, outputArea);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("SQL Executor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
