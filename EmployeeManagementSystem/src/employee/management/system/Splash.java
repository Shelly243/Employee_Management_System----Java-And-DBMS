package employee.management.system;

import java.awt.Image;
import javax.swing.*;

public class Splash extends JFrame {
    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Employee-Management-System.png"));
        Image i2 = i1.getImage().getScaledInstance(770, 452, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 770, 452);
        add(image);

        setSize(770, 452);
        setLocation(400, 150);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(3000);
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}