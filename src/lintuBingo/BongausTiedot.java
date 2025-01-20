package lintuBingo;



/**
 * Luokka kaikille bongaustiedoille
 * osaa mm. lisätä uuden bongauksen
 * @author reettavirtanen
 * @version 20 Jan 2025
 *
 */
public class BongausTiedot {
    private int              bongausLkm    = 0;
    private String           tiedostonNimi = "";
    private Bongaus          alkiot[]      = new Bongaus[];
    
    
    /**
     * Oletusmuodostaja
     */
    public BongausTiedot() {
        //
    }

    /**
     * Lisää uuden bongauksen tietorakenteeseen. 
     * @param bongaus lisätään  Huom tietorakenne muuttuu omistajaksi
     * @throws SailoException jos tietorakenne on jo täynnä
     * muista testit
     */
    public void lisaa(Bongaus bongaus) throws SailoException {
        if (lkm >= alkiot.length) throw new SailoException("Liikaa alkioita");
        alkiot[lkm] = bongaus;
        lkm++;
    }


    
    /**
     * Testiohjelma bongauksille
     * @param args ei käytössä
     */
    public static void main(String args[]) {
        BongausTiedot bongaustiedot = new BongausTiedot();

        Bongaus lintu1 = new Bongaus();
        Bongaus lintu2 = new Bongaus();
        lintu1.rekisteroi();    lintu1.taytaLinnunTiedot();
        lintu2.rekisteroi();    lintu2.taytaLinnunTiedot();

        try {
            bongaustiedot.lisaa(lintu1);
            bongaustiedot.lisaa(lintu2);

            System.out.println("========== BongausTiedot testi ==============");

            for (int i=0; i<bongaustiedot.getLkm(); i++) {
                Bongaus bongaus = bongaustiedot.anna(i);
                System.out.println("Bongaus Id " + i);
                bongaus.tulosta(System.out);
            }

        } catch ( BongausTiedot.SailoException ex ) {
            System.out.println(ex.getMessage());
        }

}
}
