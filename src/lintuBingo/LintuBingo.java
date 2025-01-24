package lintuBingo;

import java.util.List;

/**
 * Luokka huolehtimaan bongaustietojen ja lintujen välisestä yhteistyöstä.
 * Osaa lisätä ja muokata tietoja.
 * Osaa etsia lintuja sekä bongaustietoja.
 * @author reettavirtanen
 * @version 22 Jan 2025
 *
 */
public class LintuBingo {
    private final BongausTiedot bongaustiedot = new BongausTiedot();
    private final Linnut linnut = new Linnut(); 

    
    /**
     * palauttaa lintujen määrän 
     * @return lintujen määrä rekisrerissä
     */
    public int getLintuja() {
        return linnut.getLkm();
    }
    
    
    /**
     * Palauttaa i:n jäsenen
     * @param i monesko jäsen palautetaan
     * @return viite i:teen jäseneen
     * @throws IndexOutOfBoundsException jos i väärin
     */
    public Lintu haeLintu(int i) throws IndexOutOfBoundsException {
        return linnut.hae(i);
    }

    
    /**
     * Lisää lintulajin rekisteriin
     * @param lintu lisättävä lintu
     * @throws SailoException jos lisäystä ei voi tehdä
     */
    public void lisaa(Lintu lintu) throws SailoException {
        linnut.lisaaLintu(lintu);
    }
    
    
    /**
     * Lisätään uusi bongaus
     * @param bong lisättävä bongaus
     */
    public void lisaa (Bongaus bong) {
        bongaustiedot.lisaa(bong);
    }
    
    
    /**
     * Haetaan kaikki bongaukset
     * @param lintu lintu jonka bongaukset haetaan
     * @return tieroakennen viitteineen
     */
    public List<Bongaus> haeBongaustiedot(Lintu lintu) {
        return bongaustiedot.haeBongaustiedot(lintu.getLajiid());
    }
    
    
    /**
     * Lukee kaikki bongaajan tiedot, bongaukset
     * @param nimi jota käytetään lukemisessä
     * @throws SailoException jos lukeminen epäonnistuu
     */
    public void lueTiedostosta(String nimi) throws SailoException {
        linnut.lueTiedostosta(nimi);
        bongaustiedot.lueTiedostosta(nimi);
    }
    
    
    /**
     * TODO mietitään onko tarpeellinen????
     * Tallentaa bongaajan tiedot tiedostoon
     * @throws SailoException jos tallentamisessa ongelmia
     */
    public void tallenna() throws SailoException {
        linnut.tallenna();
        bongaustiedot.tallenna();
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        LintuBingo  lintubingo = new LintuBingo();
        
        
        try {
            // lintubingo.lueTiedostosta("reetta");

            Lintu lintu1 = new Lintu(), lintu2 = new Lintu();
            lintu1.rekisteroi();
            lintu1.linnunTiedot(1);
            lintu2.rekisteroi();
            lintu2.linnunTiedot(1);

            lintubingo.lisaa(lintu1);
            lintubingo.lisaa(lintu2);
            int id1 = lintu1.getLajiid();
            int id2 = lintu2.getLajiid();
            Bongaus pitsi11 = new Bongaus(id1); pitsi11.bongaus(id1); lintubingo.lisaa(pitsi11);
            Bongaus pitsi12 = new Bongaus(id1); pitsi12.bongaus(id1); lintubingo.lisaa(pitsi12);
            Bongaus pitsi21 = new Bongaus(id2); pitsi21.bongaus(id2); lintubingo.lisaa(pitsi21);
            Bongaus pitsi22 = new Bongaus(id2); pitsi22.bongaus(id2); lintubingo.lisaa(pitsi22);
            Bongaus pitsi23 = new Bongaus(id2); pitsi23.bongaus(id2); lintubingo.lisaa(pitsi23);

            System.out.println("============= testi =================");
            for (int i = 0; i < lintubingo.getLintuja(); i++) {
                Lintu lintu = lintubingo.haeLintu(i);
                System.out.println("Lintu paikassa: " + i);
                lintu.tulosta(System.out);
                List<Bongaus> loytyneet = lintubingo.haeBongaustiedot(lintu);
                for (Bongaus bongaus : loytyneet)
                    bongaus.tulosta(System.out);
            }

        } catch (SailoException ex) {
        
            System.out.println(ex.getMessage());
        }
    }
    
}

