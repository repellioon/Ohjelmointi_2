package lintuBingo;



/**
 * Luokka hallinnoimaan linturekisteriä, 
 * lisää muokkaa ja mahdollisesti poistaa linnun
 * osaa hakea lintuja rekisteristä
 * Tallentaa tiedot taulukkoon
 * @author reettavirtanen
 * @version 22 Jan 2025
 *
 */
public class Linnut {
    private static final int MAX_LINTUJA = 1000; // Maksimimäärä lintulajeja
    private Lintu[] rekisteri = new Lintu[MAX_LINTUJA];
    private int lkm = 0; // Rekisterissä olevien lintujen määrä
    
    

    /**
     * Oletusmuodostaja
     */
    public Linnut () {
        //
    }
    
    
    /**
     * Lisää lintulajin rekisteriin
     * @param lintu
     * @throws SailoException
     */
    public void lisaaLintu(Lintu lintu) throws SailoException {
        if (lkm >= MAX_LINTUJA) throw new SailoException("Rekisteri täynnä");
        rekisteri[lkm++] = lintu;
    }
    
    
    /**
     * Testiohjelma Linnuille????
     * TODO kesken
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
