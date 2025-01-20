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
        Bongaus toyhtohyyppa = new Bongaus();
        Bongaus sinitiainen = new Bongaus();
        
       //toyhtohyyppa.rekisteroi();
       // sinitiainen.rekisteroi();
        toyhtohyyppa.tulosta(System.out);
       // toyhtohyyppa.taytaLinnunTiedot();// täyttää linnun tiedot valmiiksi 
        toyhtohyyppa.tulosta(System.out);
        
        //sinitiainen.taytaLinnunTiedot();
        sinitiainen.tulosta(System.out);
        
        //sinitiainen.taytaLinnunTiedot();
        sinitiainen.tulosta(System.out); 

    }

}
