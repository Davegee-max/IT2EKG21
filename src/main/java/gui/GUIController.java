package gui;

import ekg.EKGController;
import ekg.EKGData;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class GUIController {
    public static GUIController instance;
    public Label label;

    public void notifyekg(EKGData data) {
        System.out.println("got new ekgdata");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                label.setText(String.valueOf(data.getSample()));
            }
        });
    }
    public GUIController(){
        GUIController.instance = this;
    }
}
