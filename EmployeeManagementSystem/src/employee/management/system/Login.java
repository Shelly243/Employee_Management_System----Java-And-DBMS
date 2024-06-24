package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login() {
        // Username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(40, 20, 100, 30);
        add(usernameLabel);

        tusername = new JTextField();
        tusername.setBounds(40, 50, 250, 30);
        add(tusername);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 90, 100, 30);
        add(passwordLabel);

        tpassword = new JPasswordField();
        tpassword.setBounds(40, 120, 250, 30);
        add(tpassword);

        // Login button
        login = new JButton("LOGIN");
        login.setBounds(95, 170, 150, 30); // Adjusted position and size
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // Login button
        back = new JButton("CLOSE");
        back.setBounds(95, 220, 150, 30); // Adjusted position and size
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Frame settings
        setSize(350, 320);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(null); // Use absolute positioning
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tusername.getText();
                String password = new String(tpassword.getPassword());

                conn conn = new conn();
                String query = "select * from login where username = '" + username + "' and password = '" + password
                        + "'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()) {
                    setVisible(false);
                    new Main_class();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (e.getSource() == back) {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
