package lintuBingo;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Luokka bongaukselle, tallentaa tiedon bongauksesta ja 
 * rekisteröi uuden linnun jos sitä ei ole jo linturekisterissä.
 * @author reettavirtanen
 * @version 20 Jan 2025
 *
 */
public class Bongaus {
    private int        bongausId;
    private int        lajiId;
    private String     lintu       = "";
    private String     bongattu    = "";
    private String     paikka      = "";
    private String     kellonaika  = "";
    private String     huomioita   = "";

    private static int seuraavaNro = 1;

    
    /**
     * Alustetaan bongaus. 
     */
    public Bongaus() {
        //
    }
    
    
    /**
     * Alustetaan tietystä linnusta tehty bongaus
     * @param lajiId lintulajin tunnistenumero
     */
    public Bongaus(int lajiId) {
        this.lajiId = lajiId;
    }
    
    
    /**
     * apumetodilla täytetään testiarvot bongaukselle
     * @param id viite lintuun joka on bongattu
     */
    public void bongaus(int id) {
        lajiId = id;
        lintu = "Sinitiainen";
        bongattu = "18.5.2023";
        paikka = "Heinola";
        kellonaika = "12:40";
        huomioita = "teki pesää";
    }
    
    
    /**
     * Etsii ja palauttaa linnun nimen
     * @return palauttaa linnun nimen
     * @example
     * <pre name="test">
     *   Bongaus toyhtohyyppa = new Bongaus();
     *   toyhtohyyppa.taytaLinnunTiedot();
     *   toyhtohyyppa.getLintu() =R= "Töyhtöhyyppä .*";
     * </pre>
     */
    public String getLintu() {
        return lintu;
    }


    /**
     * Tulostetaan bongaustiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(String.format("%03d" + bongausId, 2));
        out.println("Laji:          " + lintu);
        out.println("Bongattu:      " + bongattu);
        out.println("Paikka:        " + paikka);
        out.println("Kellonaika:    " + kellonaika);
        out.println("Huomioita:     " + huomioita + "\n");

    }


    /**
     * Tulostetaan bongaustiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }

    
    
    /**
     * antaa bongaukselle seuraavan tunnistenumeron.
     * @return palauttaa uuden tunnistenumeron bongaukselle.
     */
    public int rekisteroi() {
        bongausId = seuraavaNro;
        seuraavaNro++;
        return bongausId;
    }

    
    /**
     * palautetaan bongauksen oma id
     * @return bongauksen id
     */
    public int getBongausId() {
        return bongausId;
    }
    
    
    /**
     * Kerrotaan mille linnulle bongaustieto kuuluu
     * @return palauttaa lajikohtaisen tunnistenumeron, laji-id
     */
    public int getLajiid() {
        return lajiId;
    }
    
    
    /**
     * testiohjelma bongauksille
     * @param args ei käytössä
     */
    public static void main(String[]args) {
        Bongaus bong = new Bongaus();
        Bongaus bong2 = new Bongaus();
        
        bong.bongaus(1);
        bong.rekisteroi();
        bong.tulosta(System.out);
        
        bong2.bongaus(2);
        bong2.rekisteroi();
        bong2.tulosta(System.out);
                
    }

}
