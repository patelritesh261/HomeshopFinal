/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiTest;

import JDBC.JDBCTest;
import io.ErrorDataLog;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author ritesh
 */
public class JTabGui extends JFrame {

    private JTabbedPane tabPainMain;

//declare Panel
    private JPanel westPanel, northPanel, centerPanel, eastPanel, southPanel;
//create class object
    JDBCTest jdbc = new JDBCTest();
    ErrorDataLog ioLog = new ErrorDataLog();

    public JTabGui() {
        //call super class and set title
        super("HOMESHOP");

        setLayout(new BorderLayout());

        //create tab
        tabPainMain = new JTabbedPane();
        //add the Employee tab
        tabPainMain.addTab("Employee Panel", null, new InfoPanel(), "Employee Panel");
        //create Product panel
        tabPainMain.addTab("Product Panel", null, new ProductInfo(), "Product Panel");
        //create Search panel
        tabPainMain.addTab("Search Panel", null, new SearchPanel(), "Search Panel");
        //create Error Log panel
        tabPainMain.addTab("Error Log Panel", null, new ErrorLog(), "Error Log Panel");

        //create and add north panel
        northPanel = new GreetingPanel();
        add(northPanel, BorderLayout.NORTH);
        add(tabPainMain, BorderLayout.CENTER);
        southPanel = new FooterPanel();
        add(southPanel, BorderLayout.SOUTH);
        windowFeatures();
    }

    private void windowFeatures() {
        //pack the content()
        pack();
        //set background color
        getContentPane().setBackground(Color.decode("#a4ced9"));
        //set location
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set fix size
        setResizable(false);
        //set frame to center location
        centerLocation();
        setVisible(true);
    }

    public static void main(String[] args) {

        JTabGui gui = new JTabGui();
        gui.setVisible(true);

    }

    //method for set frame at center in windows

    private void centerLocation() {
        try {
            final Toolkit toolkit = Toolkit.getDefaultToolkit();
            final Dimension screenSize = toolkit.getScreenSize();
            final int x = (screenSize.width - this.getWidth()) / 2;
            final int y = (screenSize.height - this.getHeight()) / 2;
            this.setLocation(x, y);
        } catch (Exception error) {
            //write data in error log..
            StringWriter exceptionData = new StringWriter();
            error.printStackTrace(new PrintWriter(exceptionData));

            //sent to file
            ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
            //save errorlog in database
            saveErrorLogDB(exceptionData.toString(), "Main Panel", new GregorianCalendar().getTime());
        }
    }

    //method for inserting error log into database

    private void saveErrorLogDB(String errorlog, String field, Date time) {
        String Sqlquery = "INSERT INTO `errorLog`( `panelName`,`fieldName`, `errorMsg`, `time`) "
                + "VALUES ('MainPanel','" + field + "','" + errorlog + "','" + time + "');";
        //call insert method
        jdbc.insertData(Sqlquery);
    }
}
