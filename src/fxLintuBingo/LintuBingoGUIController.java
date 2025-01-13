package fxLintuBingo;

import java.net.URL;
import java.util.ResourceBundle;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


/**
 * Luokka käyttöliittymäan tapahtumien hoitamiseksi
 * @author reettavirtanen
 * @version 10.1.2025
 *
 */
public class LintuBingoGUIController implements Initializable {
    

    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        //      
    }

    
    
    @FXML private void handleTallenna() {
        tallenna();
    }
    
    @FXML private void handleLisaaBongaus() {
        Dialogs.showMessageDialog("Vielä ei osata lisätä bongausta");
        // avaa tyhjän muokkaus dialogin
    }
    
    @FXML private void handleLopeta() {
        tallenna();
        Platform.exit();
        //kysyy ensin tallennetaanko
    }

    @FXML private void handleMuokkaaBongausta() {
        ModalController.showModal(LintuBingoGUIController.class.getResource("BongausTiedotGUIView.fxml"),
                "Bongaus", null, "");
        //toimii myös 2x klikkauksella bongaustiedon kohdalla

    }

    @FXML private void handleMuokkaaLajitietoja() {
        Dialogs.showMessageDialog("Vielä ei osata muokata lajitietoja");
        //Kysyy ensin että valitse lintu ja avaa LintuBingo näkymän oikealle linnulle
    }

    @FXML private void handlePoista() {
        Dialogs.showMessageDialog("Vielä ei osata poistaa");
    }

    @FXML private void handleTulosta() {
        TulostusController.tulosta(null);
    }

    
    
    //=====================================
    // Tästä eteenpäin ei käyttöliittymään suoraan liittyvää koodia    

    
    private void tallenna() {
        Dialogs.showMessageDialog("Tallennetaan! Mutta ei toimi vielä");
    }

    
}