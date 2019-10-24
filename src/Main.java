import javax.swing.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

/**
 *Klasa main - wywolywanie programu
 */
public class Main {

    //zmienne

    /**
     *Losowanie napisu
     */

    public static String los_napis;

    /**
     *Wyswietlanie ilosci prob
     */
    public static int ilosc_prob=6;

    /**
     * Zmienna odpowiedzalna za ilosc poprawnych odpowiedzi
     */
    public static int poprawne_odpowiedzi=0;

    /**
     * Zmienna odpowiedzalna za wyswietlanie odpowiedniego obrazka 
     */
    public static int iteracja_obrazka=0;

    /**
     * Zmienna przechowujaca losowa litere wyswietlana dla uzytkownika 
     */
    public static int losowa_litera;

    /**
     * Wywolywanie klasy CRysunek
     */
    public static CRysunek rysunek=new CRysunek();

    /**
     * Mozliwosc wpisanie znanego hasla
     */
    public static String zgadniety_ciag="";

    /**
     * Zmienna odpowiedzalna za wyswietlanie wylosowanego hasla
     */
    public static String wylosowane_haslo;

    /**
     * Zmienna przechwycona z JtextField, ktora zwraca za pomoca metody .get() haslo wpisane przez gracza
     */
    public static String name;

    //interfejs

    /**
     * Interfejs - wyswietlania ilosc zyc
     */

    public static JLabel liczba_prob = new JLabel("ILOSC ZYC: " + Main.ilosc_prob);

    /**
     * Interfejs - wyswietlanie zgadniete litery
     */
    public static JLabel zgadniete_litery=new JLabel("Litery: " + zgadniety_ciag);

    /**
     * Interfejs - wyswietlania podpowiedz
     */
    public static JLabel podpowiedz;

    /**
     * Interfejs - wyswietlanie okna "zgadnij" do wpisania odpowiedzi
     */
    public static JTextField zgadnij = new JTextField();

    /**
     * Okno w ktorym rysowane sa obrazki
     */
    public static JFrame f=new JFrame();
    
    /**
     *Losowa litera z hasla
     */
    public static Random rand = new Random();

    /**
     * Start programu
     * Losowa litera / koncowka dana uzytkownikowi
     * Start interfejsu
     */
    public static void main(String[] args) throws IOException {

        //dzialanie na pliku (losowanie linii z haslem)

        File file = new File("slownik.txt");

        Scanner fin = new Scanner(file);

        ArrayList<String> nouns = new ArrayList<>();
        while (fin.hasNext()) {
            nouns.add(fin.next());
        }

        int randomIndex = (int)(Math.random() * nouns.size());
        String randomNoun = nouns.get(randomIndex);


        Main.wylosowane_haslo=randomNoun;
        System.out.print("HASLO " + Main.wylosowane_haslo);

        //dzialanie na pliku


        //losowa litera dana uzytkownikowi
        losowa_litera  = rand.nextInt(Main.wylosowane_haslo.length()) + 1;

        //losowa koncowka hasla dana uzytkownikowi
        los_napis = wylosowane_haslo.substring(losowa_litera,wylosowane_haslo.length());
        System.out.print("NAPIS: " + los_napis);


        podpowiedz=new JLabel("PODPOWIEDZ: " + los_napis);


        //start interfejsu

        JOptionPane.showMessageDialog(null, "| ZASADY | \n\n 1. Program wręczy Ci końcówkę szukanego hasła. \n" +
                " 2. Klikaj w przyciski alfabetu, aby odkryc hasło." +
                "\n 3. Zwróć uwage na długość szukanego hasła! \n" +
                " 4. Masz 6 prób. Potem zawiśniesz!\n\n" +
                "POWODZENIA! ");


        CGra gra = new CGra();

}
}
