package com.OhtuProjekti.Screens;

import com.OhtuProjekti.SceneManager;
import com.OhtuProjekti.Utils;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import static com.OhtuProjekti.Utils.*;

abstract public class SuperScreen {


    /**
     * SceneManager, should be the common project SceneManager
     */
    SceneManager sceneManager;


    /**
     * Screen for drawing the game
     */
    public Pane screen;


    /** Returns the Pane where the game is drawn
     * @return returns this.screen
     */
    public Pane getScreen(){
        return screen;
    }


    /**
     * Creates the StackPane for drawing the screen
     */
    public void createScreenSuper(String titleText){

        StackPane layout = new StackPane();
        layout.setStyle(BACKGROUNDCOLOR);

        layout.setMinSize(Utils.SCREEN_WIDTH, Utils.SCREEN_HEIGHT);
        screen = layout;

        Text menuText = new Text(titleText);
        menuText.setScaleX(3);
        menuText.setScaleY(3);
        menuText.setStroke(TITLE_TEXT_COLOR);
        layout.getChildren().add(menuText);
        menuText.setTranslateY(-SCREEN_HEIGHT/2+50);



        Button backButton = new Button();
        backButton.setText("Menu");
        backButton.setOnAction(
                e -> {
                    System.out.println("Back button clicked");
                    sceneManager.showMainMenu();
                });
        backButton.setTranslateX(-SCREEN_WIDTH/2+50);
        backButton.setTranslateY(SCREEN_HEIGHT/2-50);
        screen.getChildren().add(backButton);
    }




}
