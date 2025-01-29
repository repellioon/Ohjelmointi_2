package fxLintuBingo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

import lintuBingo.LintuBingo;

/**
 * @author reettavirtanen
 * @version 1.10.2024
 * pääohjelma Lintubingon käynnistämiseksi
 */
public class LintuBingoMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("LintuBingoGUIView.fxml"));
            final Pane root = ldr.load();
            final LintuBingoGUIController lintubingoCtrl = (LintuBingoGUIController) ldr.getController();
            
            final Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("lintubingo.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("LintuBingo");
            
            primaryStage.setOnCloseRequest((event) -> {
                //if ( !lintubingoCtrl.voikoSulkea() ) event.consume();
            });

            
            LintuBingo lintubingo = new LintuBingo();
            lintubingoCtrl.setLintuBingo(lintubingo);
            
            primaryStage.show();
            //if ( !lintubingoCtrl.avaa() ) Platform.exit();
        } catch(Exception e) {
            e.printStackTrace();
            
        }
    }

    /**
     * Käynnistetään jäyttöliittymä
     * @param args Ei kaytossa
     */
    public static void main(String[] args) {
        launch(args);
    }
}