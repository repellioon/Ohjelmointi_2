package fxLintuBingo;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import lintuBingo.Bongaus;
import lintuBingo.Lintu;
import lintuBingo.LintuBingo;
import lintuBingo.SailoException;


/**
 * Luokka käyttöliittymäan tapahtumien hoitamiseksi
 * @author reettavirtanen
 * @version 10.1.2025
 *
 */
public class LintuBingoGUIController implements Initializable {
    
    @FXML private TextField hakuehto;
    @FXML private ComboBoxChooser<String> cbKentat;
    @FXML private Label labelVirhe;

    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        //      
    }
    
    @FXML private void handleHakuehto() {
        String hakukentta = cbKentat.getSelectedText();
        String ehto = hakuehto.getText(); 
        if ( ehto.isEmpty() )
            naytaVirhe(null);
        else
            naytaVirhe("Ei osata vielä hakea " + hakukentta + ": " + ehto);
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

    private LintuBingo lintubingo;
    
    
    /*
     * kommentteja
     */
    private void tallenna() {
        Dialogs.showMessageDialog("Tallennetaan! Mutta ei toimi vielä");
    }
    
    
    /*
     * Kommennetteja
     */
    private void naytaVirhe(String virhe) {
        if ( virhe == null || virhe.isEmpty() ) {
            labelVirhe.setText("");
            labelVirhe.getStyleClass().removeAll("virhe");
            return;
        }
        labelVirhe.setText(virhe);
        labelVirhe.getStyleClass().add("virhe");
    }
    
    
    /**
     * Näytetään ohjelman suunnitelma erillisessä selaimessa.
     */
    private void avustus() {
        Desktop desktop = Desktop.getDesktop();
        try {
            URI uri = new URI("https://tim.jyu.fi/view/kurssit/tie/ohj2/v/2024/syksy/ht/reevirta");
            desktop.browse(uri);
        } catch (URISyntaxException e) {
            return;
        } catch (IOException e) {
            return;
        }
    }   
    

    /**
     * @param lintubingo näytetään tässä käyttöliittymässä
     */
    public void setLintuBingo(LintuBingo lintubingo) {
        this.lintubingo = lintubingo;
        
    }

    } 
