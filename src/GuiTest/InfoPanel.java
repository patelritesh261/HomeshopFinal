package GuiTest;

import Assignment_1.*;
import JDBC.JDBCTest;
import io.ErrorDataLog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;



public class InfoPanel extends JPanel {

    //Variable Declaration

    private JLabel lblFirstName, lblLastName, lblAge, lblPosition, lblAddress, lblPhoneNumber, lblStatus, lblCommisionRate, lblGrossSale, lblDay, lblMonth, lblYear;
    //text Fields Declaration
    private JTextField txtFirstName, txtLastName, txtAge, txtPosition, txtDateOfHire, txtPhoneNumber, txtStatus, txtCommisionRate, txtGrossSale;
    private JTextField txtAddress;
    private final String[] DAYLIST = {"<!-- Select -->", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private final String[] MONTHLIST = {"<!-- Select -->", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    private final String[] YEARLIST = {"<!-- Select -->", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000"};
    private JButton btnSubmit, btnreset;
    private JComboBox<String> ddDay, ddMonth, ddYear;
    private int year, month, day;
    private String firstName, lastName, address, status, position, dateOfHire1;
    private int age;
    private long phoneNumber;
    private double grossSale, commisionRate;
    public static ArrayList<Employee> emps = new ArrayList<>();
    boolean flag = true;
    
    //create class object
    JDBCTest jdbc = new JDBCTest();
    ErrorDataLog ioLog = new ErrorDataLog();

    public InfoPanel() {
        buildPanel();
    }

    private void buildPanel() {
        //set layout
        setLayout(new GridLayout(15, 1));
        //Create labels
        lblFirstName = new JLabel("First Name : ");
        lblLastName = new JLabel("Last Name : ");
        lblAge = new JLabel("Age : ");
        lblPosition = new JLabel("Position : ");
        //lblDateOfHire = new JLabel("Hire Date : ");
        lblAddress = new JLabel("Address : ");
        lblPhoneNumber = new JLabel("Phone Number : ");
        lblStatus = new JLabel("Status : ");
        //lblPayRate = new JLabel("Pay Rate : ");
        lblCommisionRate = new JLabel("Commision Rate : ");
        lblGrossSale = new JLabel("Gross Sale : ");
        lblDay = new JLabel("Hire Day");
        lblMonth = new JLabel("Hire Month");
        lblYear = new JLabel("Hire Year");

        //create textboxes
        txtFirstName = new JTextField(15);
        txtLastName = new JTextField(15);
        txtAge = new JTextField(2);
        txtPosition = new JTextField(15);
        txtDateOfHire = new JTextField(15);
        txtAddress = new JTextField(15);
        txtPhoneNumber = new JTextField(15);
        txtStatus = new JTextField(15);
        //txtPayRate = new JTextField(15);
        txtCommisionRate = new JTextField(15);
        txtGrossSale = new JTextField(15);
        ddDay = new JComboBox<>(DAYLIST);
        ddMonth = new JComboBox<>(MONTHLIST);
        ddYear = new JComboBox<>(YEARLIST);
        
      
        
        btnSubmit = new JButton("Submit");
        btnreset = new JButton("Reset All");
        //set border
        setBorder(BorderFactory.createTitledBorder("Employee Information"));
          
        //add compoments
        add(lblFirstName);
        add(txtFirstName);
        add(lblLastName);
        add(txtLastName);
        add(lblAge);
        add(txtAge);
        add(lblPosition);
        add(txtPosition);
        add(lblDay);
        add(ddDay);
        add(lblMonth);
        add(ddMonth);
        add(lblYear);
        add(ddYear);
       // add(lblDateOfHire);
        // add(txtDateOfHire);
        add(lblAddress);
        add(txtAddress);
        add(lblStatus);
        add(txtStatus);
        add(lblPhoneNumber);
        add(txtPhoneNumber);
        add(lblCommisionRate);
        add(txtCommisionRate);
        add(lblGrossSale);
        add(txtGrossSale);

        add(btnSubmit);
        add(btnreset);

        //set background color
        setBackground(Color.decode("#a4ced9"));
        
        
        // add action listener
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                basic_info();

                if (flag) {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to Save data?", "Warning", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        //calculate salary
                        CommissionEmployee CM=new CommissionEmployee();
                        CM.setGrossSale(grossSale);
                        CM.setCommisionRate(commisionRate);
                        Double totalSalary=CM.earning();
                        //generate query
                        String Sqlquery = "insert into employee(`firstName`, `lastName`, "
                                + "`age`, `position`, `hireDate`,"
                                + "`address`, `status`, `phoneNumber`,"
                                + "`commissionRate`, `grossSale`,`totalSalary`)"
                                + " VALUES('" + firstName + "','" + lastName + "','"
                                + age + "','" + position + "','" + dateOfHire1 + "','"
                                + address + "','" + status + "','" + phoneNumber + "','"
                                + commisionRate + "','" + grossSale + "','"+totalSalary+"');";

                        //insert data into database
                        jdbc.insertData(Sqlquery);
                        JOptionPane.showMessageDialog(lblAge, "Records Added successfully.");
                        if (flag) {
                            resetAll();
                        }
                    } else {

                    }
                }

               
            }

            private void basic_info() {
                //check validation
                flag = true;
                if (flag) {
                    try {

                        if (txtFirstName.getText() != null && txtFirstName.getText() != "") {
                            firstName = txtFirstName.getText().trim();
                            flag = true;

                        } else {
                            JOptionPane.showMessageDialog(lblFirstName, "First Name can not be null");
                            flag = false;

                        }

                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblFirstName, "Plese Enter value of first name.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtFirstName", new GregorianCalendar().getTime());
                    }
                }

                if (flag) {
                    try {

                        if (txtLastName.getText() != null) {
                            lastName = txtLastName.getText().trim();
                            flag = true;

                        } else {
                            JOptionPane.showMessageDialog(lblLastName, "Last Name can not be null");
                            flag = false;

                        }

                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblLastName, "Plese Enter value of Last name.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtLastName", new GregorianCalendar().getTime());
                    }
                }

                if (flag) {
                    try {
                        int age1 = Integer.parseInt(txtAge.getText().trim());
                        if (age1 > 0 && age1 < 100) {
                            age = age1;
                            flag = true;
                        } else {
                            JOptionPane.showMessageDialog(lblAge, "Enter value Between 0 and 100 in Age Field.");
                            flag = false;
                        }

                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblAge, "Plese Enter Numeric Value in Age Field.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtAge", new GregorianCalendar().getTime());
                    }
                }
                position = txtPosition.getText().trim();
                if (flag) {
                    Date doh = null;
                    try {
                        if (flag) {
                            if (ddDay.getSelectedIndex() != 0) {
                                day = Integer.parseInt(ddDay.getSelectedItem().toString());
                                flag = true;
                            } else {
                                JOptionPane.showMessageDialog(lblGrossSale, "Plese Select Day.");
                                flag = false;
                            }
                        }
                        if (flag) {
                            if (ddMonth.getSelectedIndex() != 0) {
                                month = Integer.parseInt(ddMonth.getSelectedItem().toString());
                                flag = true;
                            } else {
                                JOptionPane.showMessageDialog(lblGrossSale, "Plese Select Month.");
                                flag = false;

                            }
                        }
                        if (flag) {
                            if (ddYear.getSelectedIndex() != 0) {
                                year = Integer.parseInt(ddYear.getSelectedItem().toString());
                                flag = true;
                            } else {
                                JOptionPane.showMessageDialog(lblGrossSale, "Plese Select Year.");
                                flag = false;
                            }
                        }
                        if (flag) {
                            dateOfHire1 = (year + "-" + month + "-" + day);
                            //doh = new SimpleDateFormat("ddMMyyyy").parse(txtDateOfHire.getText().trim().replaceAll("/", ""));
                            flag = true;
                        }
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblGrossSale, "Plese Select Valid Option  in Hiredate Field.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "dateOfHire", new GregorianCalendar().getTime());
                    }
                }
                //dateOfHire = doh;

                address = txtAddress.getText().trim();
                status = txtStatus.getText().trim();
                if (flag) {
                    try {
                        phoneNumber = Long.parseLong(txtPhoneNumber.getText().trim());
                        flag = true;
                        if (txtPhoneNumber.getText().length() != 10) {
                            JOptionPane.showMessageDialog(lblPhoneNumber, "Plese Enter 10 Digits Number in Phone Numner Field.");
                            flag = false;
                        }
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblPhoneNumber, "Plese Enter Numeric Value in Phone Number Field.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtPhoneNumber", new GregorianCalendar().getTime());
                    }
                }
                if (flag) {
                    try {
                        commisionRate = Double.parseDouble(txtCommisionRate.getText().trim());
                        flag = true;
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblGrossSale, "Plese Enter Numeric/Floating Value in Commission Rate Field.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtCommisionRate", new GregorianCalendar().getTime());
                    }
                }
                if (flag) {
                    try {
                        grossSale = Double.parseDouble(txtGrossSale.getText().trim());
                        flag = true;
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblGrossSale, "Plese Enter Numeric/Floating Value in Gross Sale Field.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtGrossSale", new GregorianCalendar().getTime());

                    }
                }
            }

        });

        btnreset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                resetAll();
            }
        });

    }

    private void resetAll() {
        txtGrossSale.setText("");
        txtCommisionRate.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
        txtPosition.setText("");
        txtDateOfHire.setText("");
        txtAddress.setText("");
        txtPhoneNumber.setText("");
        txtStatus.setText("");
        ddDay.setSelectedIndex(0);
        ddMonth.setSelectedIndex(0);
        ddYear.setSelectedIndex(0);

    }

    private void saveErrorLogDB(String errorlog, String field, Date time) {
        String Sqlquery = "INSERT INTO `errorLog`( `panelName`,`fieldName`, `errorMsg`, `time`) "
                + "VALUES ('InfoPanel','" + field + "','" + errorlog + "','" + time + "');";

        jdbc.insertData(Sqlquery);
    }

   

}
