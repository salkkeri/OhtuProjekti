package com.OhtuProjekti.Screens;

import com.OhtuProjekti.DBManager;
import com.OhtuProjekti.Classes.Mokki;
import com.OhtuProjekti.SceneManager;
import com.OhtuProjekti.Utils;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

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


        VBox contentBox = new VBox(10);
        contentBox.setPadding(new Insets(20));

        Text title = new Text("Valitse mökki nähdäksesi tiedot:");
        contentBox.getChildren().add(title);

        // Container for buttons
        VBox buttonBox = new VBox(5);
        buttonBox.setFillWidth(true);


        Text detailsText = new Text();
        detailsText.setWrappingWidth(400);

        List<Mokki> mokit = DBManager.getAllMokit();

        for (Mokki mokki : mokit) {
            final Mokki currentMokki = mokki;  // Fix lambda capture

            System.out.println("Mökki: " + currentMokki.nimi);
            Button button = new Button(currentMokki.nimi);
            button.setMaxWidth(Double.MAX_VALUE);
            button.setPrefWidth(200);

            button.setOnAction(e -> {
                String details = "ID: " + currentMokki.mokkiID + "\n" +
                        "Nimi: " + currentMokki.nimi + "\n" +
                        "Osoite: " + currentMokki.osoite + "\n" +
                        "Varustelu: " + currentMokki.varustelu + "\n" +
                        "Hinta per yö: " + currentMokki.hintaPerYo + " €\n" +
                        "Kapasiteetti: " + currentMokki.kapasiteetti + " hlö";

                detailsText.setText(details);
            });

            buttonBox.getChildren().add(button);
        }

        contentBox.getChildren().addAll(buttonBox, detailsText);
        screen.setCenter(contentBox);





    }





}
