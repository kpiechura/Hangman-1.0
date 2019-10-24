import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author Adam
 */
public class SwingOpenImage {

    /**
     *Ladowanie obrazu
     */
    public SwingOpenImage(String filePath)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame=new JFrame(filePath);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                BufferedImage img=null;

                try {
                    img = ImageIO.read(new File(filePath));
                }catch(Exception e){
                    e.printStackTrace();
                }
                JLabel lbl = new JLabel();
                lbl.setIcon(new ImageIcon(img));
                frame.getContentPane().add(lbl, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);


            }
        });
    }

}

