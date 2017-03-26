package ohtu.verkkokauppa;

import jdk.nashorn.internal.codegen.CompilerConstants;

public class Pankki implements PankkiIf {

    private static Pankki instanssi;
    
    private KirjanpitoIF kirjanpito;

    public Pankki(KirjanpitoIF kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

    public static Pankki getInstance(KirjanpitoIF kirjanpito) {
        if (instanssi == null) {
            instanssi = new Pankki(kirjanpito);
        }

        return instanssi;
    }
    

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
