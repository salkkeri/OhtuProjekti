package com.OhtuProjekti.Screens;
import com.OhtuProjekti.SceneManager;
import com.OhtuProjekti.Utils;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static com.OhtuProjekti.Utils.*;


/**
 * Class for handling main menu
 */
public class MainMenuScreen implements ScreenInterface {

    /**
     * Pane for drawing main menu
     */
    Pane screen;

    /**
     * Should be the project common SceneManager
     */
    SceneManager sceneManager;

    /** Returns the Pane screen where the main menu is drawn
     * @return MainMenuScreen.screen
     */
    @Override
    public Pane getScreen() {
        return screen;
    }

    /** Constructor creates new MainMenuScreen object with given SceneManager
     * @param sceneManager the common project Scenemanager
     */
    public MainMenuScreen(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }


    /**
     * Initializes the game and creates the Pane layout for drawing the main menu
     */
    @Override
    public void createScreen(){
        StackPane layout = new StackPane();
        layout.setStyle(BACKGROUNDCOLOR);
        layout.setMinSize(Utils.SCREEN_WIDTH, Utils.SCREEN_HEIGHT);
        layout.setAlignment(Pos.CENTER);

        VBox menuBox = new VBox();
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setSpacing(10);

        Text menuText = new Text("Menu");
        menuText.setScaleX(3);
        menuText.setScaleY(3);
        menuText.setStroke(TITLE_TEXT_COLOR);
        //menuBox.getChildren().add(menuText);
        menuText.setTranslateY(-SCREEN_HEIGHT/2+50);

        Button mokkiButton = new Button("Mökit");
        mokkiButton.setOnAction(e -> {
            sceneManager.showMokkiScreen();
        });

        Button varauksetButton = new Button("Varaukset");
        varauksetButton.setOnAction(e -> {
            //sceneManager.showVarausScreen();
        });

        Button testButton = new Button("Testi");
        testButton.setOnAction(e -> {
            sceneManager.showTestScreen();
        });

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> {
            System.exit(0);
        });

        menuBox.getChildren().addAll(mokkiButton, varauksetButton, testButton, exitButton);
        layout.getChildren().add(menuBox);
        screen = layout;
        layout.getChildren().add(menuText);

    }

}
