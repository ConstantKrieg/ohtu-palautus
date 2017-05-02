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
public class Erotus implements Komento{
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvo;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        sovellus.miinus(arvo);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());

    }

    @Override
    public void peru() {
        sovellus.plus(arvo);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

}

