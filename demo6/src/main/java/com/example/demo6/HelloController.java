package com.example.demo6;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.ImageCollection;
import model.Iterator;
import javafx.event.ActionEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    public ImageView view;
    @FXML
    public Button stop;

    public ImageCollection imgs = new ImageCollection();
    public Iterator iter_main = imgs.getIterator();
    public Timeline timeline = new Timeline();
    public TextField taimer;

    public void onForwardButtonClick(ActionEvent actionEvent) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            view.setImage(name);
        }
    }

    public void onBackButtonClick(ActionEvent event) {
        if (iter_main.hasPreview()) {
            Image name = (Image) iter_main.preview();
            view.setImage(name);
        }
    }

    public void onLaunchButtonClick(ActionEvent event) {
        timeline.play();
    }

    public void onStopButtonClick(ActionEvent event) {
        timeline.stop();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline.setCycleCount(Timeline.INDEFINITE);//кол-во повторов
        timeline.getKeyFrames().add(new KeyFrame(new Duration(400), new EventHandler() {
            @Override
            public void handle(Event event) {
                if (iter_main.hasNext()) {
                    Image name = (Image) iter_main.next();
                    view.setImage(name);
                }
            }
        }));
    }
}