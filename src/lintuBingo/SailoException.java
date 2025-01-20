package lintuBingo;



/**
 * Poikkeusluokka tietorakenteesta aiheutuville poikkeuksille.
 * @author reettavirtanen
 * @version 20 Jan 2025
 */
    public class SailoException extends Exception {
        private static final long serialVersionUID = 1L;


        /**
         * Poikkeuksen muodostaja jolle tuodaan poikkeuksessa
         * käytettävä viesti
         * @param viesti Poikkeuksen viesti
         */
        public SailoException(String viesti) {
            super(viesti);
        }
    }
