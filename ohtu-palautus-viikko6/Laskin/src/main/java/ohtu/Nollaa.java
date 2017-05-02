/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author kim
 */
public class Nollaa implements Komento{
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinenArvo;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        edellinenArvo = sovellus.tulos();
        sovellus.nollaa();
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());

    }

    @Override
    public void peru() {
        sovellus.plus(edellinenArvo);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
