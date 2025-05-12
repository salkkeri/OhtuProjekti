package com.OhtuProjekti.Screens;

import com.OhtuProjekti.SceneManager;
import com.OhtuProjekti.Utils;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
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
    public BorderPane screen;


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

        BorderPane layout = new BorderPane();
        layout.setStyle(BACKGROUNDCOLOR);

        layout.setMinSize(Utils.SCREEN_WIDTH, Utils.SCREEN_HEIGHT);
        layout.setMaxSize(Utils.SCREEN_WIDTH, Utils.SCREEN_HEIGHT);
        screen = layout;

        Text labelText = new Text(titleText);
        labelText.setScaleX(3);
        labelText.setScaleY(3);
        labelText.setStroke(TITLE_TEXT_COLOR);

        //menuText.setTranslateY(-SCREEN_HEIGHT/2+50);
        StackPane labelTextPane = new StackPane();
        labelTextPane.setMinHeight(100);
        labelTextPane.setAlignment(Pos.CENTER);
        labelTextPane.getChildren().add(labelText);

        screen.setTop(labelTextPane);


        Button backButton = new Button();
        backButton.setText("Menu");
        backButton.setOnAction(
                e -> {
                    //System.out.println("Back button clicked");
                    sceneManager.showMainMenu();
                });
        //backButton.setTranslateX(-SCREEN_WIDTH/2+50);
        //backButton.setTranslateY(SCREEN_HEIGHT/2-50);
        StackPane buttonPane = new StackPane();
        buttonPane.getChildren().add(backButton);
        backButton.setAlignment(Pos.CENTER);

        //screen.setBottom(backButton);
        screen.setLeft(buttonPane);

    }




}
