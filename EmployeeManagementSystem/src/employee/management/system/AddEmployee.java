package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid;
    JDateChooser tdob;

    JButton add, back;

    JComboBox<String> Boxeducation;

    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 100, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 100, 150, 30);
        tname.setBackground(Color.WHITE);
        add(tname);

        // father's name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 100, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 100, 150, 30);
        tfname.setBackground(Color.WHITE);
        add(tfname);

        // date of birth
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 150, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 150, 150, 30);
        tdob.setBackground(Color.WHITE);
        add(tdob);

        // salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 150, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 150, 150, 30);
        tsalary.setBackground(Color.WHITE);
        add(tsalary);

        // address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 200, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 200, 150, 30);
        taddress.setBackground(Color.WHITE);
        add(taddress);

        // phone number
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 200, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 200, 150, 30);
        tphone.setBackground(Color.WHITE);
        add(tphone);

        // email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 250, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 250, 150, 30);
        temail.setBackground(Color.WHITE);
        add(temail);

        // highest education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 250, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        String items[] = { "BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD" };
        Boxeducation = new JComboBox<>(items);
        Boxeducation.setBackground(Color.WHITE);
        Boxeducation.setBounds(600, 250, 150, 30);
        add(Boxeducation);

        // aadhar number
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(50, 300, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(200, 300, 150, 30);
        taadhar.setBackground(Color.WHITE);
        add(taadhar);

        // employee id
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(400, 300, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(600, 300, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        // designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(Color.WHITE);
        add(tdesignation);

        // add button
        add = new JButton("ADD");
        add.setBounds(450, 450, 150, 40);
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // back button
        back = new JButton("BACK");
        back.setBounds(250, 450, 150, 40);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(850, 550);
        setLayout(null);
        setLocation(350, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempid.getText();

            try {
                conn c = new conn();
                String query = "insert into employee values('" + name + "', '" + fname + "', '" + dob + "', '" + salary
                        + "','" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation
                        + "','" + aadhar + "', '" + empID + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_class();

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
