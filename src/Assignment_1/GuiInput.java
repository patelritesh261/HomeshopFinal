/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author ritesh
 */
public class GuiInput extends JFrame {
    private JPanel panel;
    private JLabel FirstLabel,SecondLabel,TotalLabel;
    private JTextField Number1,Number2,Answer;
    private JRadioButton AddButton,MultiplyButton;
    private ButtonGroup RadioGroup;
    
    public GuiInput()
    {
        setTitle("Calculator");
        setSize(250,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        buildPanel();
        
        add(panel);
        
        setVisible(true);
    }

     private void buildPanel(){
        panel = new JPanel();
        FirstLabel = new JLabel("First Number");
        FirstLabel.setToolTipText("Enter your first number");
        
        
        Number1 = new JTextField(10);
        Number1.setToolTipText("First Number textbox");
        Number1.setFont(new Font("Arial",Font.BOLD,12));
       
        
        SecondLabel = new JLabel("Second Number");
        FirstLabel.setToolTipText("Enter your Second number");
       
        
        
        
        Number2 = new JTextField(10);
        Number2.setToolTipText("Second Nuber textbox");
        Number2.setFont(new Font("Arial",Font.BOLD,12));
        
        
        TotalLabel = new JLabel("Total Number");
        TotalLabel.setToolTipText("Anser");
        
        Answer = new JTextField(10);
        Answer.setToolTipText("Answer for your option");
        Answer.setFont(new Font("Arial",Font.BOLD,12));
     
        
        AddButton = new JRadioButton("Radio 1", true);
        AddButton.addActionListener((ActionListener) new addButtonListerner());
        add(AddButton);
        MultiplyButton = new JRadioButton("Radio 2" , false);
       
        
        RadioGroup = new ButtonGroup();
        RadioGroup.add(AddButton);
        RadioGroup.add(MultiplyButton);
        panel.add(FirstLabel);
        panel.add(Number1);
        panel.add(SecondLabel);
        panel.add(Number2);
        panel.add(TotalLabel);
        panel.add(Answer);
        panel.add(AddButton);
        panel.add(MultiplyButton);
    }
    
    private class addButtonListerner implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
          double firstNumber = Double.parseDouble(Number1.getText());
          double secondNumber = Double.parseDouble(Number2.getText());
          
          double total = firstNumber+secondNumber;
         Answer.setText(" "+ total);
          
        }

       
        
    }
    public static void main(String[] args)
    {
        new GuiInput();
        
    }
}
