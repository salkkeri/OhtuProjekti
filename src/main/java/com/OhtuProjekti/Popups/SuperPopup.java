package com.OhtuProjekti.Popups;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.OhtuProjekti.Utils.TITLE_TEXT_COLOR;

abstract public class SuperPopup {
    BorderPane popupPane;

    StackPane centerPane;

    GridPane bottomButtonRow;


    public void createPopupSuper(String titleText){
        popupPane = new BorderPane();
        bottomButtonRow = new GridPane();
        centerPane = new StackPane();
        Text labelText = new Text(titleText);
        labelText.setScaleX(3);
        labelText.setScaleY(3);
        labelText.setStroke(TITLE_TEXT_COLOR);

        //menuText.setTranslateY(-SCREEN_HEIGHT/2+50);
        StackPane labelTextPane = new StackPane();
        labelTextPane.setMinHeight(100);
        labelTextPane.setAlignment(Pos.CENTER);
        labelTextPane.getChildren().add(labelText);

        popupPane.setTop(labelTextPane);
        popupPane.setCenter(centerPane);
        popupPane.setBottom(bottomButtonRow);





    }

    public void showPopup(){
        Stage stage = new Stage();
        stage.setScene(new Scene(popupPane, 300, 200));
        stage.show();

    }

    public void closePopup(){

    }



}
