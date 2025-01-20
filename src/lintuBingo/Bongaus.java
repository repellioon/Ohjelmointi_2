package lintuBingo;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 
 * @author reettavirtanen
 * @version 20 Jan 2025
 *
 */
public class Bongaus {
    private int        bongausId;
    private String     lintu       = "";
    private String     bongattu    = "";
    private String     paikka      = "";
    private String     kellonaika  = "";
    private String     huomioita   = "";

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
     * Tulostetaan bongaustiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(String.format("%03d", bongausId, 1) + "  " + lintu + "  "+ bongattu);
        out.println("  " + paikka + "  " + kellonaika);
        out.println("  " + huomioita);
    }


    /**
     * Tulostetaan bongaustiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }


    
    /**
     * Testiohjelma bongauksille
     * @param args ei käytössä
     * 
     */
    public static void main(String[]args) {
        Bongaus lintu1 = new Bongaus();
        Bongaus lintu2 = new Bongaus();
        
       //lintu1.rekisteroi();
       //lintu2.rekisteroi();
        lintu1.tulosta(System.out);
       //lintu1.taytaLinnunTiedot();// täyttää linnun tiedot valmiiksi 
        lintu1.tulosta(System.out);
        
        //lintu2.taytaLinnunTiedot();
        lintu2.tulosta(System.out);
        
        //lintu2.taytaLinnunTiedot();
        lintu2.tulosta(System.out); 

    }

}
