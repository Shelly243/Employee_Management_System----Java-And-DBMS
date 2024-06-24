package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class() {

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(20, 20, 400, 40); // Adjusted heading position
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(110, 100, 200, 40); // Adjusted add button position
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLUE);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(110, 160, 200, 40); // Adjusted view button position
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLUE);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);
            }
        });
        add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(110, 220, 200, 40); // Adjusted remove button position
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLUE);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        add(rem);

        int width = 430;
        int height = 350;
        setSize(width, height);
        setLocation(550, 200); // Adjusted frame location
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Main_class();
    }
}
