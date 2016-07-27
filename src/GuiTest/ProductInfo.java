/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiTest;

import Assignment_1.Product;
import JDBC.JDBCTest;
import io.ErrorDataLog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

/**
 *
 * @author ritesh
 */
public class ProductInfo extends JPanel {

    //Variable Declaration
    private JLabel lblProductName, lblCategory, lblDescription, lblPartNum, lblProductCost, lblProductPrice, lblProductMarkup, lblMinimumInventory, lblManufacturerName, lblAddress, lblPhoneNumber, lblContact;
    //text Fields Declaration
    private JTextField txtProductName, txtCategory, txtDescription, txtPartNum, txtProductCost, txtProductPrice, txtProductMarkup, txtMinimumInventory, txtManufacturerName, txtAddress, txtPhoneNumber, txtContact;
    //variable declarations
    private String productName;
    private String category;
    private String description, partNum, manufacturer;
    private double productCost, productPrice, productMarkup;
    private int minimumInventory;
    private String manufacuteName;
    private String address;
    private long phoneNumber;
    private String contact;
    private JButton btnSubmit, btnreset;
    private Boolean flag;

    //create class object
    JDBCTest jdbc = new JDBCTest();
    ErrorDataLog ioLog = new ErrorDataLog();

    public ProductInfo() {
        buildPanel();
        //set background color
        setBackground(Color.decode("#a4ced9"));
    }

    private void buildPanel() {
        //set layout
        setLayout(new GridLayout(15, 1));
        //Create labels
        lblProductName = new JLabel("Product Name : ");
        lblCategory = new JLabel("Category : ");
        lblDescription = new JLabel("Description : ");
        lblPartNum = new JLabel("Part Number : ");
        lblProductCost = new JLabel("Product Cost : ");
        lblProductPrice = new JLabel("Product Price : ");
        lblProductMarkup = new JLabel("Product Markup : ");
        lblMinimumInventory = new JLabel("Minimum Inventory : ");
        lblManufacturerName = new JLabel("Manufacture Name : ");
        lblAddress = new JLabel("Address : ");
        lblPhoneNumber = new JLabel("Phone Number : ");
        lblContact = new JLabel("Contact : ");

        //create textboxes
        txtProductName = new JTextField(15);
        txtCategory = new JTextField(15);
        txtDescription = new JTextField(2);
        txtPartNum = new JTextField(15);
        txtProductCost = new JTextField(15);
        txtProductPrice = new JTextField(15);
        txtProductMarkup = new JTextField(15);
        txtMinimumInventory = new JTextField(15);
        txtManufacturerName = new JTextField(15);
        txtAddress = new JTextField(15);
        txtPhoneNumber = new JTextField(15);
        txtContact = new JTextField(15);

        //create buttons
        btnSubmit = new JButton("Submit");
        btnreset = new JButton("Reset All");
        //set border
        setBorder(BorderFactory.createTitledBorder("Product Details"));

        //add compoments
        add(lblProductName);
        add(txtProductName);
        add(lblCategory);
        add(txtCategory);
        add(lblDescription);
        add(txtDescription);
        add(lblPartNum);
        add(txtPartNum);
        add(lblProductCost);
        add(txtProductCost);
        add(lblProductPrice);
        add(txtProductPrice);
        add(lblProductMarkup);
        add(txtProductMarkup);
        add(lblMinimumInventory);
        add(txtMinimumInventory);
        add(lblManufacturerName);
        add(txtManufacturerName);
        add(lblAddress);
        add(txtAddress);
        add(lblPhoneNumber);
        add(txtPhoneNumber);
        add(lblContact);
        add(txtContact);

        add(btnSubmit);
        add(btnreset);

        // add action listener
        btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                basic_productinfo();

                if (flag) {
                    //confirm dialog box
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to Save data?", "Warning", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        //Create SQL Query
                        String Sqlquery = "INSERT INTO `javaproduct`(`productName`, `category`, `description`,"
                                + " `partNum`, `productCost`, `productPrice`, `productMarkup`, `minInventory`,"
                                + " `mnName`, `address`, `phoneNumber`, `contact`) "
                                + "VALUES( '" + productName + "','" + category + "','" + description + "','"
                                + partNum + "','" + productCost + "','" + productPrice + "','" + productMarkup + "','" + minimumInventory + "','"
                                + manufacuteName + "','" + address + "','" + phoneNumber + "','" + contact + "')";
                        //Save Data into Database
                        jdbc.insertData(Sqlquery);
                        JOptionPane.showMessageDialog(lblAddress, "Records Added successfully.");
                        if (flag) {
                            resetAll();
                        }
                    } else {

                    }
                }

            }

            private void basic_productinfo() {

                flag = true;
                productName = txtProductName.getText().trim();
                category = txtCategory.getText().trim();
                description = txtDescription.getText().trim();
                partNum = txtPartNum.getText().trim();

                if (flag) {
                    try {
                        productCost = Double.parseDouble(txtProductCost.getText().trim());
                        flag = true;
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblProductCost, "Plese Enter Numeric Value in product cost.");
                        flag = false;

                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtProductCost", new GregorianCalendar().getTime());
                    }
                }
                if (flag) {
                    try {
                        productPrice = Double.parseDouble(txtProductPrice.getText().trim());
                        flag = true;
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblProductPrice, "Plese Enter Numeric Value in product price.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtProductPrice", new GregorianCalendar().getTime());
                    }
                }
                if (flag) {
                    try {
                        productMarkup = Double.parseDouble(txtProductMarkup.getText().trim());
                        flag = true;
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblProductMarkup, "Plese Enter Numeric Value in product cost.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtProductMarkup", new GregorianCalendar().getTime());
                    }
                }
                if (flag) {
                    try {
                        minimumInventory = Integer.parseInt(txtMinimumInventory.getText().trim());
                        flag = true;
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(lblMinimumInventory, "Plese Enter Numeric Value in product cost.");
                        flag = false;
                        //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "txtMinimumInventory", new GregorianCalendar().getTime());
                    }
                }
                manufacuteName = txtManufacturerName.getText().trim();
                address = txtAddress.getText().trim();
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

                contact = txtContact.getText().trim();

            }

        });

        //add action listener for resetall
        btnreset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                resetAll();
            }
        });

    }

    //methods for resetting all fields

    private void resetAll() {

        txtProductName.setText("");
        txtCategory.setText("");
        txtPartNum.setText("");
        txtProductCost.setText("");
        txtProductPrice.setText("");
        txtProductMarkup.setText("");
        txtMinimumInventory.setText("");
        txtManufacturerName.setText("");
        txtAddress.setText("");
        txtPhoneNumber.setText("");
        txtContact.setText("");
        txtDescription.setText("");

    }

    //methods for save error log to DB

    private void saveErrorLogDB(String errorlog, String field, Date time) {
        //create SQL Query
        String Sqlquery = "INSERT INTO `errorLog`( `panelName`,`fieldName`, `errorMsg`, `time`) "
                + "VALUES ('ProductPanel','" + field + "','" + errorlog + "','" + time + "');";
        //call insert Method
        jdbc.insertData(Sqlquery);
    }

}
