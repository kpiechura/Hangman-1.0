import java.awt.*;

/**
 *Definiowanie klasy, ktora bedzie odpowiedzalna za czesc graficzna
 */
public class CRysunek extends Canvas {

    Toolkit t;
    Image i;

    /**
     *Funkcja odpowiedzialna za wyswietlanie odpowiedniego obrazka przy danej liczbie niepowodzen
     * g.drawimage - metoda ktora wyswietla obrazek
     */
    public void paint(Graphics g) {

        if(Main.iteracja_obrazka==0) {
            t = Toolkit.getDefaultToolkit();
            i = t.getImage("src/hangman_0.png");
            g.drawImage(i, 0, 0, this);
            System.out.print("\nZMIENNA: " + Main.iteracja_obrazka);
        }

        if(Main.iteracja_obrazka==1)
        {

            t = Toolkit.getDefaultToolkit();
            i = t.getImage("src/hangman_1.png");
            g.drawImage(i, 0, 0, this);
            System.out.print("\nZMIENNA: " + Main.iteracja_obrazka);
        }
        if(Main.iteracja_obrazka==2)
        {

            t = Toolkit.getDefaultToolkit();
            i = t.getImage("src/hangman_2.png");
            g.drawImage(i, 0, 0, this);
            System.out.print("\nZMIENNA: " + Main.iteracja_obrazka);
        }

        if(Main.iteracja_obrazka==3)
        {

            t = Toolkit.getDefaultToolkit();
            i = t.getImage("src/hangman_3.png");
            g.drawImage(i, 0, 0, this);
            System.out.print("\nZMIENNA: " + Main.iteracja_obrazka);
        }

        if(Main.iteracja_obrazka==4)
        {

            t = Toolkit.getDefaultToolkit();
            i = t.getImage("src/hangman_4.png");
            g.drawImage(i, 0, 0, this);
            System.out.print("\nZMIENNA: " + Main.iteracja_obrazka);
        }

        if(Main.iteracja_obrazka==5)
        {

            t = Toolkit.getDefaultToolkit();
            i = t.getImage("src/hangman_5.png");
            g.drawImage(i, 0, 0, this);
            System.out.print("\nZMIENNA: " + Main.iteracja_obrazka);
        }

        if(Main.iteracja_obrazka==6)
        {

            t = Toolkit.getDefaultToolkit();
            i = t.getImage("src/hangman_6.png");
            g.drawImage(i, 0, 0, this);
            System.out.print("\nZMIENNA: " + Main.iteracja_obrazka);
        }

    }

}


