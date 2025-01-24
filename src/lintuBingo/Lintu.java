package lintuBingo;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Tallentaa yksittäisen lintulajin tiedot, 
 * ID, nimi, ravinto, pesimisaika, elinympäristö, levinneisyys.
 * @author reettavirtanen
 * @version 22 Jan 2025
 *
 */
public class Lintu {
    private int lajiId              = 0;
    private String lintu            = "";
    private String ravinto          = "";
    private String pesimisaika      = "";
    private String elinymparisto    = "";
    private String levinneisyys     = "";
    
    private static int seuraavaNro = 1;
    
    
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
     * apumetodilla täytetään linnun tiedot
     * @param id linnun lajikohtain tunnistusnumero
     */
    public void linnunTiedot(int id) {
        lajiId = id; // pitää miettiä pitääkö tässä olla vielä bongaus id, jos lintujen tiedoissa näkyy kaikki tehdyt bongaukset?
        lintu = "Sinitiainen";
        ravinto = "18.5.2023";
        pesimisaika = "Heinola";
        elinymparisto = "12:40";
        levinneisyys = "teki pesää";
    }
    
    
    /**
     * Tulostetaan linnun tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(String.format("%03d", lajiId, 3)); 
        out.println("Laji: " + lintu);
        out.println("Ravinto: " + ravinto);
        out.println("Pesimisaika: " + pesimisaika);
        out.println("Elinympäristö: " + elinymparisto);
        out.println("Levinneisyys: " + levinneisyys + "\n");

    }

    
    /**
     * Antaa UUDELLE linnulle seuraavan rekisterinumeron.
     * MITEN voi teuttaa niin että aina vain uudelle 
     * linnulle tulee nhumero ja jo rekisteröidylle linnulle numero pysyy samana????
     * @return linnun uusi tunnusNro
     * @example
     * <pre name="test">
     *   Jasen aku1 = new Jasen();
     *   aku1.getTunnusNro() === 0;
     *   aku1.rekisteroi();
     *   Jasen aku2 = new Jasen();
     *   aku2.rekisteroi();
     *   int n1 = aku1.getTunnusNro();
     *   int n2 = aku2.getTunnusNro();
     *   n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        lajiId = seuraavaNro;
        seuraavaNro++;
        return lajiId;
    }
    
    
    /**
     * palauttaa linnun tunnusnumeron
     * @return palauttaa lajikohtaisen tunnistenumeron, laji-id
     */
    public int getLajiid() { 
        return lajiId;
    }

    
    /**
     * Tulostetaan henkilön tiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    
    /**
     * Testiohjelma linnulle
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Lintu lintu1 = new Lintu();
        Lintu lintu2 = new Lintu();
        
        lintu1.rekisteroi();
        lintu1.tulosta(System.out);
        lintu1.linnunTiedot(1);
        
        lintu2.rekisteroi();
        lintu2.tulosta(System.out);
    }

    
   

}
