package gui;

import data.EKGDAO;
import data.EKGDAOImpl;
import ekg.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GUIController implements EKGListener {
    public static GUIController instance;
    public static boolean record;
    public Label label;
    public TextArea ekgOutput;


    public void notifyekg(EKGData data) {
        System.out.println("got new ekgdata");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String text = ekgOutput.getText();
                text += "ny Data: " + data.getSample() + "\r\n";
                ekgOutput.setText(text);

            }
        });
    }

    public GUIController() {
        GUIController.instance = this;
    }

    public void startSensor(ActionEvent actionEvent) {
        this.record = !this.record;

    }


    @Override
    public void notify(EKGData data) {

        }
    }

