import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *Klasa zawierajaca glowne funkcje odpowiedzialne za dzialanie programu takie jak
 * losowanie hasla
 * sprawdzanie wygrana/przegrana
 * wyswietlanie przyciskow
 * sprawdzanie znakow w hasle
 */
public class CGra extends JFrame {

    /**
     *Losowanie hasla
     */
    public String SLOWO_KOPIA=Main.wylosowane_haslo; //ukryte za gwiazdakmi haslo

    /**
     *Odpowiedzalna za tworzenie okna grafinczego, w ktorym bedzie wyswietlany program
     */
    public JPanel panel = new JPanel();

    //KLAWIATURA ALFABET
    final int ZNAKI_ALFABETU=23;

    /**
     *Wyswietlane znaki z klawiatury sa przyciskami
     */
    public JButton klawiatura[] = new JButton[ZNAKI_ALFABETU];
    //KLAWIATURA ALFABET


    //Funkcje przegranej i wygranej

    boolean Przegrana(){
        if(Main.ilosc_prob==1)
            return true;

        return false;
    }

    boolean Wygrana(){
        if(Main.poprawne_odpowiedzi==Main.wylosowane_haslo.length()-1)
            return true;

        return false;
    }
    
    //Jesli uzytkownik wpisze haslo nastepuje natychmiastowa wygrana
    void Wygrana_bez_sprawdzania(){
        {
            JOptionPane.showMessageDialog(null, "WYGRANA! Hasło to " + Main.wylosowane_haslo);
            System.exit(0);
        }
    }
    //Funkcje przegranej i wygranej

    /**
     *Lista funkcji odpowiedzialny za
     * okno klawiatury
     * dodanie hasla do panelu
     * rysowanie wisielca 
     * wyswietlanie przyciskow/klawiatury
     */
    public CGra() {
        
        //OKNO klawiatury
        
        super("WISIELEC");//tytul okna

        panel.setLayout(null);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 370); //200
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        //OKNO klawiatury

        //DODANIE HASLA DO PANELU
        
        ZakryjHaslo(); //ZAKRYCIE GWIAZDKAMI HASLA
        JLabel slowo_do_zgadniecia = new JLabel("HASŁO: " + SLOWO_KOPIA);

        Main.zgadnij.setLocation(150, 170);
        Main.zgadnij.setSize(100, 30);
        panel.add(Main.zgadnij);

        JButton loginBtn = new JButton("ZGADNIJ!");
        loginBtn.setBounds(30, 170, 100, 30);
        panel.add(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.name = Main.zgadnij.getText();
                if(Main.name.equals(Main.wylosowane_haslo)) Wygrana_bez_sprawdzania();
                System.out.print(Main.name);
            }
        });

        Main.podpowiedz.setFont (Main.podpowiedz.getFont ().deriveFont (16.0f));
        Main.podpowiedz.setForeground(Color.BLUE);
        Main.podpowiedz.setLocation(800, 220);
        Main.podpowiedz.setSize(200, 100);
        panel.add(Main.podpowiedz);

        Main.zgadniete_litery.setFont (Main.zgadniete_litery.getFont ().deriveFont (45.0f));
        Main.zgadniete_litery.setForeground(Color.GREEN);
        Main.zgadniete_litery.setLocation(30, 220);
        Main.zgadniete_litery.setSize(200, 100);
        panel.add(Main.zgadniete_litery);

        panel.add(slowo_do_zgadniecia);
        slowo_do_zgadniecia.setFont (slowo_do_zgadniecia.getFont ().deriveFont (16.0f));
        slowo_do_zgadniecia.setLocation(30, 130);
        slowo_do_zgadniecia.setSize(200, 14);

        panel.add(Main.liczba_prob);
        Main.liczba_prob.setFont (slowo_do_zgadniecia.getFont ().deriveFont (16.0f));
        Main.liczba_prob.setLocation(850, 130);
        Main.liczba_prob.setSize(200, 14);

        //DODANIE HASLA DO PANELU
        
        //RYSOWANIE WISIELCA (klatka nr 0)
        
        Main.f.add(Main.rysunek);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width/2)-160; //zmiana
        Main.f.setResizable(false);
        Main.f.setLocation(centerX,40);
        Main.f.setSize(400,300);

        Main.f.setVisible(true);

        //RYSOWANIE WISIELCA
        
        //KLAWIATURA WYSWiETLANIE PRZYCISKOW

        for (int i=0; i<ZNAKI_ALFABETU; ++i)
        {
            klawiatura[i] = new JButton();
            panel.add(klawiatura[i]);
        }

        klawiatura[0].setText("A");
        klawiatura[0].setBounds(30, 30, 50, 50);

        klawiatura[0].addActionListener(new KlikListener());

        klawiatura[1].setText("B");
        klawiatura[1].setBounds(85, 30, 50, 50);

        klawiatura[1].addActionListener(new KlikListener());

        klawiatura[2].setText("C");
        klawiatura[2].setBounds(140, 30, 50, 50);

        klawiatura[2].addActionListener(new KlikListener());

        klawiatura[3].setText("D");
        klawiatura[3].setBounds(195, 30, 50, 50);

        klawiatura[3].addActionListener(new KlikListener());

        klawiatura[4].setText("E");
        klawiatura[4].setBounds(250, 30, 50, 50);

        klawiatura[4].addActionListener(new KlikListener());

        klawiatura[5].setText("F");
        klawiatura[5].setBounds(305, 30, 50, 50);

        klawiatura[5].addActionListener(new KlikListener());

        klawiatura[6].setText("G");
        klawiatura[6].setBounds(360, 30, 50, 50);

        klawiatura[6].addActionListener(new KlikListener());

        klawiatura[7].setText("H");
        klawiatura[7].setBounds(415, 30, 50, 50);

        klawiatura[7].addActionListener(new KlikListener());

        klawiatura[8].setText("I");
        klawiatura[8].setBounds(470, 30, 50, 50);

        klawiatura[8].addActionListener(new KlikListener());

        klawiatura[9].setText("J");
        klawiatura[9].setBounds(525, 30, 50, 50);

        klawiatura[9].addActionListener(new KlikListener());

        klawiatura[10].setText("K");
        klawiatura[10].setBounds(580, 30, 50, 50);

        klawiatura[10].addActionListener(new KlikListener());

        klawiatura[11].setText("L");
        klawiatura[11].setBounds(635, 30, 50, 50);

        klawiatura[11].addActionListener(new KlikListener());

        klawiatura[12].setText("M");
        klawiatura[12].setBounds(690, 30, 50, 50);

        klawiatura[12].addActionListener(new KlikListener());

        klawiatura[13].setText("N");
        klawiatura[13].setBounds(745, 30, 50, 50);

        klawiatura[13].addActionListener(new KlikListener());

        klawiatura[14].setText("O");
        klawiatura[14].setBounds(800, 30, 50, 50);

        klawiatura[14].addActionListener(new KlikListener());

        klawiatura[15].setText("P");
        klawiatura[15].setBounds(855, 30, 50, 50);

        klawiatura[15].addActionListener(new KlikListener());

        klawiatura[16].setText("R");
        klawiatura[16].setBounds(910, 30, 50, 50);

        klawiatura[16].addActionListener(new KlikListener());

        klawiatura[17].setText("S");
        klawiatura[17].setBounds(360, 100, 50, 50);

        klawiatura[17].addActionListener(new KlikListener());

        klawiatura[18].setText("T");
        klawiatura[18].setBounds(415, 100, 50, 50);

        klawiatura[18].addActionListener(new KlikListener());

        klawiatura[19].setText("U");
        klawiatura[19].setBounds(470, 100, 50, 50);

        klawiatura[19].addActionListener(new KlikListener());

        klawiatura[20].setText("W");
        klawiatura[20].setBounds(525, 100, 50, 50);

        klawiatura[20].addActionListener(new KlikListener());

        klawiatura[21].setText("Y");
        klawiatura[21].setBounds(580, 100, 50, 50);

        klawiatura[21].addActionListener(new KlikListener());

        klawiatura[22].setText("Z");
        klawiatura[22].setBounds(635, 100, 50, 50);

        klawiatura[22].addActionListener(new KlikListener());
        
        //KLAWIATURA WYSWIETLANIE PRZYCISKOW
    }
    //kazdy char w stringu jest zamieniany na znak X
    
    /**
     *Funkcja odpowiedzialna za zakrycie hasla znakami "X"
     */
    public void ZakryjHaslo(){
        char[]  tablica_znakow=new char[SLOWO_KOPIA.length()];
        for (int i=0; i<SLOWO_KOPIA.length(); ++i)
        {
            tablica_znakow[i]='X';
        }
        SLOWO_KOPIA = new String(tablica_znakow);
    }

    //LISTENER
    /**
     *Klasa obslugi zdarzen
     */
    public class KlikListener implements ActionListener{

        /**
         *Sprawdzanie czy w hasle do odgadniecia wystepuje wybrana litera.
         * Jezeli tak, wybrana litera zostaje podswietlona na zielono.
         * Jezeli nie, wybrana litera zostaje podswietlona na czerwono.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();

            if(Wygrana()==true) {
                JOptionPane.showMessageDialog(null, "WYGRANA! Hasło to " + Main.wylosowane_haslo);
                System.exit(0);}

            if(Przegrana()) {
                JOptionPane.showMessageDialog(null, "PRZEGRANA! Hasło to " + Main.wylosowane_haslo);
                System.exit(0);}

            if(source==klawiatura[0] && Main.wylosowane_haslo.indexOf("a")==-1) 
            {

                klawiatura[0].setEnabled(false);
                klawiatura[0].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;

                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();
            }

            else if((source==klawiatura[0] && Main.wylosowane_haslo.indexOf("a")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[0].setEnabled(false);
                klawiatura[0].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="A";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[1] && Main.wylosowane_haslo.indexOf("b")==-1) 
            {
                klawiatura[1].setEnabled(false);
                klawiatura[1].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[1] && Main.wylosowane_haslo.indexOf("b")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;

                klawiatura[1].setEnabled(false);
                klawiatura[1].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="B";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[2] && Main.wylosowane_haslo.indexOf("c")==-1) 
            {
                klawiatura[2].setEnabled(false);
                klawiatura[2].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[2] && Main.wylosowane_haslo.indexOf("c")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[2].setEnabled(false);
                klawiatura[2].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="C";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[3] && Main.wylosowane_haslo.indexOf("d")==-1) 
            {
                klawiatura[3].setEnabled(false);
                klawiatura[3].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[3] && Main.wylosowane_haslo.indexOf("d")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[3].setEnabled(false);
                klawiatura[3].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="D";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[4] && Main.wylosowane_haslo.indexOf("e")==-1) 
            {
                klawiatura[4].setEnabled(false);
                klawiatura[4].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[4] && Main.wylosowane_haslo.indexOf("e")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[4].setEnabled(false);
                klawiatura[4].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="E";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[5] && Main.wylosowane_haslo.indexOf("f")==-1) 
            {
                klawiatura[5].setEnabled(false);
                klawiatura[5].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[5] && Main.wylosowane_haslo.indexOf("f")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[5].setEnabled(false);
                klawiatura[5].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="F";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[6] && Main.wylosowane_haslo.indexOf("g")==-1) 
            {
                klawiatura[6].setEnabled(false);
                klawiatura[6].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[6] && Main.wylosowane_haslo.indexOf("g")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[6].setEnabled(false);
                klawiatura[6].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="G";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[7] && Main.wylosowane_haslo.indexOf("h")==-1) 
            {
                klawiatura[7].setEnabled(false);
                klawiatura[7].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[7] && Main.wylosowane_haslo.indexOf("h")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[7].setEnabled(false);
                klawiatura[7].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="H";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[8] && Main.wylosowane_haslo.indexOf("i")==-1) 
            {
                klawiatura[8].setEnabled(false);
                klawiatura[8].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[8] && Main.wylosowane_haslo.indexOf("i")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[8].setEnabled(false);
                klawiatura[8].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="I";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[9] && Main.wylosowane_haslo.indexOf("j")==-1) 
            {
                klawiatura[9].setEnabled(false);
                klawiatura[9].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[9] && Main.wylosowane_haslo.indexOf("j")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[9].setEnabled(false);
                klawiatura[9].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="J";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[10] && Main.wylosowane_haslo.indexOf("k")==-1) 
            {
                klawiatura[10].setEnabled(false);
                klawiatura[10].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[10] && Main.wylosowane_haslo.indexOf("k")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[10].setEnabled(false);
                klawiatura[10].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="K";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[11] && Main.wylosowane_haslo.indexOf("l")==-1) 
            {
                klawiatura[11].setEnabled(false);
                klawiatura[11].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[11] && Main.wylosowane_haslo.indexOf("l")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[11].setEnabled(false);
                klawiatura[11].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="L";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[12] && Main.wylosowane_haslo.indexOf("m")==-1) 
            {
                klawiatura[12].setEnabled(false);
                klawiatura[12].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[12] && Main.wylosowane_haslo.indexOf("m")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[12].setEnabled(false);
                klawiatura[12].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="M";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[13] && Main.wylosowane_haslo.indexOf("n")==-1) 
            {
                klawiatura[13].setEnabled(false);
                klawiatura[13].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[13] && Main.wylosowane_haslo.indexOf("n")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[13].setEnabled(false);
                klawiatura[13].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="N";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[14] && Main.wylosowane_haslo.indexOf("o")==-1) 
            {
                klawiatura[14].setEnabled(false);
                klawiatura[14].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[14] && Main.wylosowane_haslo.indexOf("o")!=-1))
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[14].setEnabled(false);
                klawiatura[14].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="O";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[15] && Main.wylosowane_haslo.indexOf("p")==-1) 
            {
                klawiatura[15].setEnabled(false);
                klawiatura[15].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[15] && Main.wylosowane_haslo.indexOf("p")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[15].setEnabled(false);
                klawiatura[15].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="P";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[16] && Main.wylosowane_haslo.indexOf("r")==-1) 
            {
                klawiatura[16].setEnabled(false);
                klawiatura[16].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[16] && Main.wylosowane_haslo.indexOf("r")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[16].setEnabled(false);
                klawiatura[16].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="R";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[17] && Main.wylosowane_haslo.indexOf("s")==-1) 
            {
                klawiatura[17].setEnabled(false);
                klawiatura[17].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[17] && Main.wylosowane_haslo.indexOf("s")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[17].setEnabled(false);
                klawiatura[17].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="S";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[18] && Main.wylosowane_haslo.indexOf("t")==-1) 
            {
                klawiatura[18].setEnabled(false);
                klawiatura[18].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[18] && Main.wylosowane_haslo.indexOf("t")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[18].setEnabled(false);
                klawiatura[18].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="T";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[19] && Main.wylosowane_haslo.indexOf("u")==-1) 
            {
                klawiatura[19].setEnabled(false);
                klawiatura[19].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[19] && Main.wylosowane_haslo.indexOf("u")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[19].setEnabled(false);
                klawiatura[19].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="U";
                Main.zgadniete_litery.setText(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[20] && Main.wylosowane_haslo.indexOf("w")==-1) 
            {
                klawiatura[20].setEnabled(false);
                klawiatura[20].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[20] && Main.wylosowane_haslo.indexOf("w")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[20].setEnabled(false);
                klawiatura[20].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="W";
                System.out.print(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[21] && Main.wylosowane_haslo.indexOf("y")==-1) 
            {
                klawiatura[21].setEnabled(false);
                klawiatura[21].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[21] && Main.wylosowane_haslo.indexOf("y")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[21].setEnabled(false);
                klawiatura[21].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="Y";
                System.out.print(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }

            if(source==klawiatura[22] && Main.wylosowane_haslo.indexOf("z")==-1) 
            {
                klawiatura[22].setEnabled(false);
                klawiatura[22].setBackground(Color.RED);
                ++Main.iteracja_obrazka;
                --Main.ilosc_prob;
                Main.liczba_prob.setText("LICZBA ZYC: " + Main.ilosc_prob);
                panel.add(Main.liczba_prob);

                Main.rysunek.repaint();

            }
            else if((source==klawiatura[22] && Main.wylosowane_haslo.indexOf("z")!=-1)) 
            {
                ++Main.poprawne_odpowiedzi;
                klawiatura[22].setEnabled(false);
                klawiatura[22].setBackground(Color.GREEN);

                Main.zgadniety_ciag+="Z";
                System.out.print(Main.zgadniety_ciag);
                panel.add(Main.zgadniete_litery);
            }
        }
    }
}