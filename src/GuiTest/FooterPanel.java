/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ritesh
 */
public class FooterPanel extends JPanel {

    //declare button

    private JButton btnExitButton;

    public FooterPanel() {
        //create button
        btnExitButton = new JButton("Exit");
        add(btnExitButton);

        //add action listener
        btnExitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //close aplliaction
                System.exit(0);
            }
        });

        //set background color
        setBackground(Color.decode("#d9afa4"));
    }

}
