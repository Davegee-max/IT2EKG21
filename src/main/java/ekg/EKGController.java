package ekg;

import data.EKGDAO;
import data.EKGDAOImpl;
import dataCollector.DataSampleReader;
import dataCollector.DataSampleReaderSimImpl;
import gui.GUIController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.Timestamp;
import java.util.List;

public class EKGController extends Application implements EKGListener  {

    private GUIController guicontroller;

    public static EKGController instance;


    public static void main(String[] args) {
        EKGSimulator generator = new EKGSimulator();
        EKGController ekgController = new EKGController();
        new Thread(generator).start();
        generator.register(ekgController);
        launch();
        instance = ekgController;

    }

    @Override
    public void notify(EKGData data) {
        DataSampleReader reader = new DataSampleReaderSimImpl();
        List<Double> doubles = reader.loadData();
        System.out.println(doubles);
        System.out.println("Got Data " + data.getSample());
        if (GUIController.instance != null) {
            GUIController.instance.notifyekg(data);
        }

        if (GUIController.record) {
            EKGDAO ekgdao = new EKGDAOImpl();
            ekgdao.save(data);
        }

            //TODO Lav database
        }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
        Parent load = loader.load();
        primaryStage.setScene(new Scene(load));
        primaryStage.show();



    }


    public void registerGUI(GUIController guiController) {
        this.guicontroller=guiController;
    }


}
