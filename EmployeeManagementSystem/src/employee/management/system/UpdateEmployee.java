package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField teducation, tphone, temail, tsalary, tdesignation, taddress;
    JLabel tname, tfname, tdob, taadhar, tempid;
    JButton add, back;
    String number;

    UpdateEmployee(String number) {
        this.number = number;
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAILS");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 150, 150, 30);
        nameLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(nameLabel);

        tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        // father's name
        JLabel fnameLabel = new JLabel("Father's Name");
        fnameLabel.setBounds(400, 150, 150, 30);
        fnameLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fnameLabel);

        tfname = new JLabel();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        // dob
        JLabel dobLabel = new JLabel("Date Of Birth");
        dobLabel.setBounds(50, 200, 150, 30);
        dobLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dobLabel);

        tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tdob);

        // salary
        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(400, 200, 150, 30);
        salaryLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salaryLabel);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(Color.WHITE);
        add(tsalary);

        // address
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 250, 150, 30);
        addressLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(addressLabel);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(Color.WHITE);
        add(taddress);

        // phone
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(400, 250, 150, 30);
        phoneLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phoneLabel);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(Color.WHITE);
        add(tphone);

        // email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 300, 150, 30);
        emailLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(emailLabel);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(Color.WHITE);
        add(temail);

        // highest education
        JLabel educationLabel = new JLabel("Highest Education");
        educationLabel.setBounds(400, 300, 150, 30);
        educationLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(educationLabel);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setBackground(Color.WHITE);
        add(teducation);

        // aadhar number
        JLabel aadharLabel = new JLabel("Aadhar Number");
        aadharLabel.setBounds(50, 350, 150, 30);
        aadharLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadharLabel);

        taadhar = new JLabel();
        taadhar.setBounds(200, 350, 150, 30);
        taadhar.setBackground(Color.WHITE);
        add(taadhar);

        // employee id
        JLabel empidLabel = new JLabel("Employee ID");
        empidLabel.setBounds(400, 350, 150, 30);
        empidLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empidLabel);

        tempid = new JLabel();
        tempid.setBounds(600, 350, 150, 30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        // designation
        JLabel designationLabel = new JLabel("Designation");
        designationLabel.setBounds(50, 400, 150, 30);
        designationLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designationLabel);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 400, 150, 30);
        tdesignation.setBackground(Color.WHITE);
        add(tdesignation);

        try {
            conn c = new conn();
            String query = "select * from employee where empId = '" + number + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhar.setText(resultSet.getString("addhar"));
                tempid.setText(resultSet.getString("empId"));
                tdesignation.setText(resultSet.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // update button
        add = new JButton("UPDATE");
        add.setBounds(450, 480, 150, 40);
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // back button
        back = new JButton("BACK");
        back.setBounds(250, 480, 150, 40);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(850, 600);
        setLayout(null);
        setLocation(350, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {
                conn c = new conn();
                String query = "update employee set salary = '" + salary + "', address = '"
                        + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education
                        + "', designation = '" + designation + "' where empId = '" + number + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Main_class();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
