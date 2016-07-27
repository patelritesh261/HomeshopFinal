/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiTest;

import Assignment_1.*;
import JDBC.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author ritesh
 */
public class SearchPanel extends JPanel {

    //Label Declaration

    private JLabel lblType;

    //text area
    private JTextArea txtarInfo;
    private JComboBox<String> ddsearch, ddemployee, ddproduct, dddbemployee, dddbproduct;
    private final String[] SEARCH = {"<!-- Select -->", "Employee", "Product"};
    private final String[] EMPSEARCHLIST = {"<!-- Select -->", "First Name", "Last Name", "Employee ID"};
    private final String[] PDSEARCHLIST = {"<!-- Select -->", "Product Name", "Product ID"};
    private String[] EMPDBLIST = {"<!-- Select -->"};
    private String[] PDDBLIST = {"<!-- Select -->"};

    // button Decalration
    private JButton btnSubmit, btnreset;

    //create class object
    JDBCTest jdbc = new JDBCTest();

    public SearchPanel() {

        buildPanel();

    }

    private void buildPanel() {
        //set layout
        //setLayout(new GridLayout(15,2));
        //set border
        setBorder(BorderFactory.createTitledBorder("Search Details"));
        //create the dropdown
        ddsearch = new JComboBox<>(SEARCH);
        ddproduct = new JComboBox<>(PDSEARCHLIST);
        ddemployee = new JComboBox<>(EMPSEARCHLIST);
        dddbemployee = new JComboBox<>(EMPDBLIST);
        dddbproduct = new JComboBox<>(PDDBLIST);
        //create labels
        lblType = new JLabel("Search Type : ");

        txtarInfo = new JTextArea("", 20, 20);
        txtarInfo.setEditable(false); // set textArea non-editable
        //create buttons
        btnSubmit = new JButton("Submit");
        btnreset = new JButton("Reset All");
        //scroll bar
        JScrollPane scrollPane = new JScrollPane(txtarInfo);

        add(lblType);
        add(ddsearch);
        add(ddproduct);
        add(dddbproduct);
        add(ddemployee);
        add(dddbemployee);

        add(btnSubmit);
        add(btnreset);
        add(scrollPane);

        //set background color
        setBackground(Color.decode("#a4ced9"));

        //set visible false
        ddemployee.setVisible(false);

        ddproduct.setVisible(false);
        txtarInfo.setVisible(false);
        dddbemployee.setVisible(false);
        dddbproduct.setVisible(false);
        ddsearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ddsearch.getSelectedIndex() == 1) {
                    // JOptionPane.showMessageDialog(lblFirstName, "Records Added successfully.");
                    employeeSearchPanel();
                } else if (ddsearch.getSelectedIndex() == 2) {
                    // JOptionPane.showMessageDialog(lblFirstName, "Records Added successfully.");
                    productSearchPanel();
                } else {
                    ddemployee.setVisible(false);

                    ddproduct.setVisible(false);

                    txtarInfo.setVisible(false);
                    dddbemployee.setVisible(false);
                    dddbproduct.setVisible(false);
                }
            }

            private void productSearchPanel() {
                ddemployee.setVisible(false);
                //txtFirstName.setVisible(true);
                ddproduct.setVisible(true);
                // txtProductName.setVisible(false);
                dddbemployee.setVisible(false);
                dddbproduct.setVisible(true);
            }

            private void employeeSearchPanel() {
                ddemployee.setVisible(true);
                //txtFirstName.setVisible(true);
                ddproduct.setVisible(false);
                //txtProductName.setVisible(false);
                dddbemployee.setVisible(true);
                dddbproduct.setVisible(false);

            }

        });

        ddemployee.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ddemployee.getSelectedIndex() == 1) {
                    dddbemployee.removeAllItems();
                    dddbemployee.addItem("<!-- Select -->");
                    txtarInfo.setText("");
                    String strr;
                    String sqlQuery = "Select distinct firstName from employee";
                    strr = jdbc.selectData(sqlQuery, "firstName");
                    
                    EMPDBLIST = strr.toString().split("/");
                    for (int i = 0; i < EMPDBLIST.length; i++) {
                        dddbemployee.addItem(EMPDBLIST[i]);
                    }

                } else if (ddemployee.getSelectedIndex() == 2) {
                    dddbemployee.removeAllItems();
                    dddbemployee.addItem("<!-- Select -->");
                    txtarInfo.setText("");
                    String strr;
                    String sqlQuery = "Select distinct lastName from employee";
                    strr = jdbc.selectData(sqlQuery, "lastName");
                   
                    EMPDBLIST = strr.toString().split("/");
                    for (int i = 0; i < EMPDBLIST.length; i++) {
                        dddbemployee.addItem(EMPDBLIST[i]);

                    }

                } else if (ddemployee.getSelectedIndex() == 3) {
                    String strr;
                    dddbemployee.removeAllItems();
                    dddbemployee.addItem("<!-- Select -->");
                    txtarInfo.setText("");
                    String sqlQuery = "Select distinct Id from employee";
                    strr = jdbc.selectData(sqlQuery, "Id");
                    
                    EMPDBLIST = strr.toString().split("/");
                    for (int i = 0; i < EMPDBLIST.length; i++) {
                        dddbemployee.addItem(EMPDBLIST[i]);
                    }

                } else {
                    dddbemployee.removeAllItems();
                    dddbemployee.addItem("<!-- Select -->");
                    txtarInfo.setText("");
                }
            }
        });

        ddproduct.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ddproduct.getSelectedIndex() == 1) {
                    dddbproduct.removeAllItems();
                    dddbproduct.addItem("<!-- Select -->");
                    txtarInfo.setText("");
                    String strr;
                    String sqlQuery = "Select distinct productName from javaproduct";
                    strr = jdbc.selectData(sqlQuery, "productName");

                    PDDBLIST = strr.toString().split("/");
                    for (int i = 0; i < PDDBLIST.length; i++) {
                        dddbproduct.addItem(PDDBLIST[i]);
                    }

                } else if (ddproduct.getSelectedIndex() == 2) {
                    dddbproduct.removeAllItems();
                    txtarInfo.setText("");
                    dddbproduct.addItem("<!-- Select -->");
                    String strr;
                    String sqlQuery = "Select distinct pdId from javaproduct";
                    strr = jdbc.selectData(sqlQuery, "pdId");

                    PDDBLIST = strr.toString().split("/");
                    for (int i = 0; i < PDDBLIST.length; i++) {
                        dddbproduct.addItem(PDDBLIST[i]);
                    }

                } else {
                    dddbproduct.removeAllItems();
                    dddbproduct.addItem("<!-- Select -->");
                    txtarInfo.setText("");
                }
            }
        });
        
        dddbemployee.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(dddbemployee.getSelectedIndex()==0){
                    txtarInfo.setText("");
                }
            }
        });
        
        dddbproduct.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               txtarInfo.setText("");
            }
        });

        btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                //search in employee based on criteria
                if (ddsearch.getSelectedIndex() == 1) {
                    if (ddemployee.getSelectedIndex() == 1) {

                        String Sqlquery = "Select * from employee where firstName='" + dddbemployee.getSelectedItem().toString() + "';";

                        String strr;
                        strr = jdbc.selectDataAll(Sqlquery);

                        txtarInfo.setText(strr);
                        txtarInfo.setVisible(true);
                    } else if (ddemployee.getSelectedIndex() == 2) {
                        String Sqlquery = "Select * from employee where lastName='" + dddbemployee.getSelectedItem().toString() + "';";

                        String strr;
                        strr = jdbc.selectDataAll(Sqlquery);
                        txtarInfo.setText(strr);
                        txtarInfo.setVisible(true);

                    } else if (ddemployee.getSelectedIndex() == 3) {
                        String Sqlquery = "Select * from employee where Id='" + dddbemployee.getSelectedItem().toString() + "';";

                        String strr;
                        strr = jdbc.selectDataAll(Sqlquery);
                        txtarInfo.setText(strr);
                        txtarInfo.setVisible(true);

                    }
                }
                if (ddsearch.getSelectedIndex() == 2) {
                    //search in produ based on criteria
                    if (ddproduct.getSelectedIndex() == 1) {
                        String Sqlquery = "Select * from javaproduct where productName='" + dddbproduct.getSelectedItem().toString() + "';";

                        String strr;
                        strr = jdbc.selectDataAll(Sqlquery);
                        txtarInfo.setText(strr);
                        txtarInfo.setVisible(true);
                    } else if (ddproduct.getSelectedIndex() == 2) {
                        String Sqlquery = "Select * from javaproduct where pdId='" + dddbproduct.getSelectedItem().toString() + "';";

                        String strr;
                        strr = jdbc.selectDataAll(Sqlquery);
                        txtarInfo.setText(strr);
                        txtarInfo.setVisible(true);
                    }
                }
            }

        });

        //add action listener for reset button
        btnreset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                resetAll();
            }

            //resetall fields

            private void resetAll() {
              //set selelect default item

                ddsearch.setSelectedIndex(0);
                ddproduct.setSelectedIndex(0);
                ddemployee.setSelectedIndex(0);
                dddbproduct.setSelectedIndex(0);
                dddbemployee.setSelectedIndex(0);

                //set some drop-down false
                ddproduct.setVisible(false);
                ddemployee.setVisible(false);
                dddbemployee.setVisible(false);
                dddbproduct.setVisible(false);

                txtarInfo.setText("");
                txtarInfo.setVisible(false);
            }
        });

    }

}
