import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Klasa CSlownik zawierająca zawierająca metodę throws IOException
 */
public class CSlownik {

    /**
     *Blok wywolujacy metode IOException wymaga szczegolnej uwagi.
     * Odpowiedzialny jest za pobieranie rzeczownikow z pliku
     * i wyswietlanie wyniku
     * file - zmienna przechowujaca plik z haslami
     * randomIndex - zmienna ktora losuje losowa liczbe. Na jej podstawie jest dobierana litera koncowa wyrazu
     */
    public  void CSlownik() throws IOException {

        File file = new File("slownik.txt");

        Scanner fin = new Scanner(file);
        
        // Pobieranie rzeczownikow z pliku
        ArrayList<String> nouns = new ArrayList<>();
        while (fin.hasNext()) {
            nouns.add(fin.next());
        }

        int randomIndex = (int)(Math.random() * nouns.size());
        String randomNoun = nouns.get(randomIndex);
        
        // Wyswietlanie wyniku
        Main.wylosowane_haslo=randomNoun;
        System.out.print("HASLO " + Main.wylosowane_haslo);

    }
}


