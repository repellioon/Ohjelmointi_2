package lintuBingo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Luokka kaikille bongaustiedoille
 * osaa mm. lisätä uuden bongauksen
 * Tallentaa tiedot dynaamisesti
 * @author reettavirtanen
 * @version 20 Jan 2025
 *
 */
public class BongausTiedot implements Iterable<Bongaus> {
    private String           tiedostonNimi = "";
    
    /**Taulukko bongauksista */
    private List<Bongaus>    bongaustiedot = new ArrayList<>();

    
    /**
     * Bongaustietojen alustaminen
     */
    public BongausTiedot() {
        //
    }
    
    
    /**
     * Lisää uuden bongaustiedon
     * @param bong Lisättävä bongaustieto
     * 
     */
    public void lisaa(Bongaus bong) {
        bongaustiedot.add(bong);
    }
    
    
    /**
     * Lukee Bongaustietoja tiedostosta
     * TODO kesken
     * @param hakemisto tiedoston hakemisto
     * @throws SailoException jos lukeminen epäonnistuu
     */
    public void lueTiedostosta(String hakemisto) throws SailoException {
        tiedostonNimi = hakemisto + "/bongaustiedot";
        throw new SailoException("Ei osata vielä lukea tiedostoa " + tiedostonNimi);
    }
    
    
    /**
     * Tallentaa bongaustiedon tiedostoon
     * @throws SailoException jos tallennus epäonnistuu
     */
    public void tallenna() throws SailoException {
        throw new SailoException("Ei osaa vielä tallentaa tiedostoa " + tiedostonNimi);
    }
    
    
    /**
     * palauttaa bongaustietojen lukumäärän
     * @return bongaustietojen lukumäärä
     */
    public int getLkm() {
        return bongaustiedot.size();
    }
    
    
    /**
     * Iteraattori kaikkien bongaustietojen läpikäymiseen
     * @return bongausiteraattori
     */
    @Override
    public Iterator<Bongaus> iterator(){
        return bongaustiedot.iterator();
    }
    
    
    /**
     * Haetaan kaikki linnusta tehdyt bongaukset
     * @param lajiid linnun laji-id jolle bongauksia haetaan
     * @return palauttaa tiedot löydetyuistä bongauksista
     */
    public List<Bongaus> haeBongaustiedot(int lajiid) {
        List<Bongaus> tiedot = new ArrayList<Bongaus>();
        for (Bongaus bong : bongaustiedot)
            if(bong.getLajiid() == lajiid) tiedot.add(bong);
        return tiedot;
    }
    
    
    /**
     * Testiohjelma Bongaustiedoille
     * @param args ei käytössä
     */
    public static void main (String[] args) {
        BongausTiedot bongaukset = new BongausTiedot();
        
        Bongaus lintu1 = new Bongaus();
        lintu1.bongaus(2);
        
        Bongaus lintu2 = new Bongaus();
        lintu2.bongaus(3);
        
        Bongaus lintu3 = new Bongaus();
        lintu3.bongaus(4);
        
        Bongaus lintu4 = new Bongaus();
        lintu4.bongaus(5);
        
        bongaukset.lisaa(lintu1);
        bongaukset.lisaa(lintu2);
        bongaukset.lisaa(lintu3);
        bongaukset.lisaa(lintu4);
        
        System.out.println("BongausTiedot Testi");
        
        List<Bongaus> bongaukset2 = bongaukset.haeBongaustiedot(2);
        
        for (Bongaus bong : bongaukset2) {
            System.out.print(bong.getLajiid() + " ");
            bong.tulosta(System.out);
        }
    }
   
}
