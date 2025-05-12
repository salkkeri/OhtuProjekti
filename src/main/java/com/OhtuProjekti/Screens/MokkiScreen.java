package com.OhtuProjekti.Screens;

import com.OhtuProjekti.DBManager;
import com.OhtuProjekti.Classes.Mokki;
import com.OhtuProjekti.SceneManager;
import com.OhtuProjekti.Utils;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import static com.OhtuProjekti.Utils.*;


/**
 * Class for handling mokkis
 */
public class MokkiScreen extends SuperScreen {

    /** Constructor, sets MokkiScreen.sceneManager
     * @param sceneManager The common project SceneManager
     */
    public MokkiScreen(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }


    /** Returns the Pane where the game is drawn
     * @return returns GameScreen.screen
     */
    @Override
    public Pane getScreen(){
        return screen;
    }


    /**
     * Creates the StackPane for drawing the screen
     */
    public void createScreen(){
        super.createScreenSuper("Mökit");


        TextField idField = new TextField();
        TextField nameField = new TextField();
        TextField addressField = new TextField();
        TextField equipmentField = new TextField();
        TextField priceField = new TextField();
        TextField capacityField = new TextField();
        Button insertButton = new Button("Insert Mökki");

        // Layout
        GridPane grid = new GridPane();

        grid.add(new Label("Mökki ID:"), 0, 0);
        grid.add(idField, 1, 0);
        grid.add(new Label("Nimi:"), 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(new Label("Osoite:"), 0, 2);
        grid.add(addressField, 1, 2);
        grid.add(new Label("Varustelu:"), 0, 3);
        grid.add(equipmentField, 1, 3);
        grid.add(new Label("Hinta per yö:"), 0, 4);
        grid.add(priceField, 1, 4);
        grid.add(new Label("Kapasiteetti:"), 0, 5);
        grid.add(capacityField, 1, 5);
        grid.add(insertButton, 1, 6);

        // Button action
        insertButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String nimi = nameField.getText();
                String osoite = addressField.getText();
                String varustelu = equipmentField.getText();
                double hinta = Double.parseDouble(priceField.getText());
                int kapasiteetti = Integer.parseInt(capacityField.getText());

                Mokki mokki = new Mokki(id, nimi, osoite, varustelu, hinta, kapasiteetti);
                DBManager.insertMokki(mokki);
                //showAlert(Alert.AlertType.INFORMATION, "Success", "Mökki inserted successfully!");
            } catch (Exception ex) {
                //showAlert(Alert.AlertType.ERROR, "Error", "Failed to insert Mökki: " + ex.getMessage());
            }
        });

        screen.getChildren().add(grid);



    }





}
