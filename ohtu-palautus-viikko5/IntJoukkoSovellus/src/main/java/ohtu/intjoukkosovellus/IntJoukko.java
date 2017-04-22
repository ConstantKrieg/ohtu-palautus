package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alustus(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        alustus(kapasiteetti, kasvatuskoko);
    }

    public void alustus(int kapasiteetti, int kasvatuskoko) {
        ljono = new int[kapasiteetti];
        alustaLukujonoNollaan();
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public void alustaLukujonoNollaan() {
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku) || alkioidenLkm == 0) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            tarkistaJoukonKapasiteetti();
            return true;
        }
        return false;
    }

    public void tarkistaJoukonKapasiteetti() {
        if (alkioidenLkm % ljono.length == 0) {
            int[] taulukkoOld = ljono;
            ljono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, ljono);
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                ljono[i] = 0;
                kavennaLukujonoa(i);
                return true;
            }
        }
        return false;
    }

    public void kavennaLukujonoa(int kohta) {
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            int apu = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apu;
        }
        alkioidenLkm--;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += ljono[i] + ", ";
            }
            return tuotos + ljono[alkioidenLkm - 1] + "}";
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        lisaaTauluun(x, aTaulu);
        lisaaTauluun(x, bTaulu);
        return x;
    }

    public static void lisaaTauluun(IntJoukko i, int[] taulukko) {
        for (int j = 0; j < taulukko.length; j++) {
            i.lisaa(taulukko[j]);

        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluu(aTaulu[i])) {
                y.lisaa(aTaulu[i]);
            }
        }
        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
          if (b.kuuluu(aTaulu[i])){
            a.poista(i);  
          }
        }
        return a;
    }
}
