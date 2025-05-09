package com.OhtuProjekti.Screens;

import com.OhtuProjekti.SceneManager;
import com.OhtuProjekti.Utils;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import static com.OhtuProjekti.Utils.BACKGROUNDCOLOR;


/**
 * Class for handling the game screen
 * @author Antti Puuronen
 */
public class MokkiScreen implements ScreenInterface {


    /**
     * SceneManager, should be the common project SceneManager
     */
    private SceneManager sceneManager;


    /**
     * Screen for drawing the game
     */
    public Pane screen;

    /** Constructor, sets GameScreen.sceneManager
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
     * Creates the StackPane for drawing the game
     */
    public void createScreen(){

        StackPane layout = new StackPane();
        layout.setStyle(BACKGROUNDCOLOR);

        
        layout.setMinSize(Utils.SCREEN_WIDTH, Utils.SCREEN_HEIGHT);
        screen = layout;

    }

    /** Starts the GameEngine
     * @param scene Scene object, where the game is drawn
     */
    public void startGame(Scene scene){

    }




}
