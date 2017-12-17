package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static sample.RadioController.radioStop;

public class Main extends Application {
    static FXMLLoader loader;
    public Scene scene;
    static MetadataGetter metadataGetter = new MetadataGetter();
    @Override
    public void start(Stage primaryStage) throws Exception{
        loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root =  loader.load();
        scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Feather Radio");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("95.png")));
        primaryStage.setOnCloseRequest(event -> radioStop());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static void changeTitle(){
        Controller controller = loader.getController();
        Platform.runLater(() -> controller.changeTitle(metadataGetter.getTitle()));

    }
}
