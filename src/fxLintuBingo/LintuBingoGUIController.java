package fxLintuBingo;

import java.awt.Desktop;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.TextAreaOutputStream;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//import lintuBingo.Bongaus;
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
    @FXML private ListChooser<Lintu> chooserLinnut;
    @FXML private ScrollPane panelBongaustiedot;

    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        alusta();      
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
    
    
   // @FXML private void handleAvaa() {
       // avaa();
    

    
    @FXML private void handleLisaaBongaus() {
        //Dialogs.showMessageDialog("Vielä ei osata lisätä bongausta");
        // avaa tyhjän muokkaus dialogin
        
        lisaaBongaus();
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
        //Kysyy ensin että valitse lintu ja avaa LintuBingo näkymän oikealle linnulle?
    }

    
    @FXML private void handlePoista() {
        Dialogs.showMessageDialog("Vielä ei osata poistaa");
    }

    
    @FXML private void handleTulosta() {
        TulostusController tulostusCtrl = TulostusController.tulosta(null); 
        tulostaValitut(tulostusCtrl.getTextArea()); 
    }

    
    @FXML private void handleApua() { //näyttää ht suunnitelman timissä
        avustus();
    }

//============================================================================================
// Tästä eteenpäin ei käyttöliittymään suoraan liittyvää koodia    

    private LintuBingo lintubingo;
    private TextArea areaBongaustiedot = new TextArea();

    //TODO: poista lopuksi
    
    /**
     * Tekee tarvittavat muut alustukset, nyt vaihdetaan GridPanen tilalle
     * yksi iso tekstikenttä, johon voidaan tulostaa jäsenten tiedot.
     * Alustetaan myös  kuuntelija 
     */
    protected void alusta() {
        panelBongaustiedot.setContent(areaBongaustiedot);
        panelBongaustiedot.setFitToHeight(true);
        
        chooserLinnut.clear(); // tyhjentää linnut lstauksen, onko tarpeellinen tässä ohjelmassa?
        chooserLinnut.addSelectionListener(e -> naytaLintu());
        
    }
    
    
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
    
    
    /**
     * Näyttää listasta valitun Linnun bongaustiedot, tilapäisesti yhteen isoon edit-kenttään
     */
    protected void naytaLintu() {
        Lintu linnunKohdalla = chooserLinnut.getSelectedObject();

        if (linnunKohdalla == null) return;

        areaBongaustiedot.setText("");
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaBongaustiedot)) {
            linnunKohdalla.tulosta(os);
        }
    }

    
    /**
     * Hakee lintujen tiedot listaan
     * @param lajiId Linnun lajinumero, joka aktivoidaan haun jälkeen
     */
    private void hae(int lajiId) {
        chooserLinnut.clear(); // tyhjentää linnut listauksen
        
        int index = 0; // mistä löytyy oikea lintu
        //Käydään kaikki linnut läpi
        for (int i = 0; i < lintubingo.getLintuja(); i++ ) { 
            Lintu bongaus = lintubingo.haeLintu(i);
            if (bongaus == null) {
                System.out.println("Virhe: lintubingo.haeLintu(" + i + ") palautti null!");
                continue; // Siirrytään seuraavaan lintuun
            }
            if (bongaus.getLajiid() == lajiId) index = i;
            chooserLinnut.add("" + bongaus.getLintu(), bongaus);
        }
        chooserLinnut.setSelectedIndex(index);
    }       
    
    
    /**
     * Lisätään uusi bongaus
     */
    private void lisaaBongaus() {
        Lintu uusi = new Lintu();
        uusi.rekisteroi(); // rekisteröoi bongaukselle seuraavan tunnisnumeron
        uusi.linnunTiedot(); // int id viite lintuun, joka on bongattu
        try {
            lintubingo.lisaa(uusi);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia uuden luomisessa " + e.getMessage());
            return;
                    
        }
        hae(uusi.getLajiid()); //kysytään mikä on bongatun linnun laji-id
        
        
    }
    
       
    /**
     * Tulostaa linnun tiedot tiedot
     * @param os tietovirta johon tulostetaan
     * @param lintu tulostettava lintu
     */
    public void tulosta(PrintStream os, final Lintu lintu) {
        os.println("----------------------------------------------");
        lintu.tulosta(os);
        os.println("----------------------------------------------");
    }
    
    
    /**
     * Tulostaa listassa olevat linnut tekstialueeseen
     * @param text alue johon tulostetaan
     */
    public void tulostaValitut(TextArea text) {
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(text)) {
            os.println("Tulostetaan kaikki linnut");
            for (int i = 0; i < lintubingo.getLintuja(); i++) {
                Lintu lintu = lintubingo.haeLintu(i);
                tulosta(os, lintu);
                os.println("\n\n");
            }
        }
    }


} 
