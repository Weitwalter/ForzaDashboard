package wauz.forza.dashboard.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import wauz.forza.dashboard.backend.ForzaDataOutReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Properties configuration = new Properties();
        InputStream streamConfig;
        int listeningPort = 1337;
        String filePath = Paths.get("").toAbsolutePath().toString();
        System.out.println("Loading Config");
        try{
            streamConfig = new FileInputStream(filePath+"/ForzaConfig.properties");
            configuration.load(streamConfig);
            listeningPort = Integer.parseInt(configuration.getProperty("listeningPort"));
            System.out.println("Done.");
        } catch (Exception e){
            System.out.println("Could not load Config file: "+e.toString());
        }
        ForzaDataOutReader reader = new ForzaDataOutReader(configuration);
        reader.startListener(listeningPort);
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane root = fxmlLoader.load(getClass().getResource("forzaDash.fxml"));
        primaryStage.setTitle("Forza Dashboard");
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        try {
            primaryStage.getScene().getStylesheets().add(getClass().getResource("ForzaDash.css").toExternalForm());
        }catch (Exception e){
            System.out.println("Could not load ForzaDash CSS: "+e.toString());
        }
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> reader.stopProcessing());

    }


    public static void main(String[] args) {
        launch(args);
    }
}
