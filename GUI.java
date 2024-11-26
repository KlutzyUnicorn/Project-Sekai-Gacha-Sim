import javax.swing.*;
import java.awt.*;

public class GUI {
  private JFrame frame;

  public void window() {
    // creates the window where images will be shown
    frame = new JFrame("Gacha Sim");
    frame.setSize(609, 375);
    frame.setLocation(0, 0);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }// end window

  public void img(String imgname) {
    // shows the specified image whose path is entered in the parameteres
    ImageIcon img = new ImageIcon(imgname);
    ImageIcon scaledimg = new ImageIcon(img.getImage().getScaledInstance(609, 375, Image.SCALE_SMOOTH));
    JLabel label = new JLabel(scaledimg);
    frame.setContentPane(label);
    frame.pack();
  }// end img
}// end class