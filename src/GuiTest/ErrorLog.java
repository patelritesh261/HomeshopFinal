/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiTest;

import Assignment_1.Employee;
import Assignment_1.Product;
import JDBC.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

/**
 *
 * @author ritesh
 */
public class ErrorLog extends JPanel {

    //text area declaration
    private JTextArea txtarInfo;
    //drop down declaration
    private JComboBox<String> dderror;
    private final String[] SEARCH = {"<!-- Select -->", "InfoPanel", "ProductInfo"};
    //create class object
    JDBCTest jdbc = new JDBCTest();

    public ErrorLog() {
        //create panel 
        build_panel();
        //set background color
        setBackground(Color.decode("#a4ced9"));
    }

    private void build_panel() {
        //set border
        setBorder(BorderFactory.createTitledBorder("Error Logs"));
        //create the dropdown
        dderror = new JComboBox<>(SEARCH);
        txtarInfo = new JTextArea(25, 50);
        txtarInfo.setEditable(false); // set textArea non-editable
        //set scroll bar in text area
        JScrollPane scrollPane = new JScrollPane(txtarInfo);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //add componets into pannel
        add(dderror);
        add(scrollPane);
        //define action listener 
        dderror.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (dderror.getSelectedIndex() == 0) {
                    txtarInfo.setText("");
                }
                if (dderror.getSelectedIndex() == 1) {
                    String strr;
                    //get data from Database
                    String Sqlquery = "Select * from errorLog where panelName='InfoPanel'";
                    strr = jdbc.selectDataAll(Sqlquery);
                    txtarInfo.setText(strr);
                } else if (dderror.getSelectedIndex() == 2) {
                    String strr;
                    //get data from Database
                    String Sqlquery = "Select * from errorLog where panelName='ProductPanel'";
                    strr = jdbc.selectDataAll(Sqlquery);
                    txtarInfo.setText(strr);
                }
            }
        });

    }
}
