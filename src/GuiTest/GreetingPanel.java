
package GuiTest;

import javax.swing.*;
import java.awt.*;

public class GreetingPanel extends JPanel{
    // Variable Declaration
   private JLabel lblGreeting;
   
   public GreetingPanel()
           {
               //create and set font for the lable
               lblGreeting =new JLabel("Welcome to HomeShop!");
               lblGreeting.setFont(new Font("Arial",Font.BOLD,24));
               //add label to the panel
               add(lblGreeting);
               //adding border presentation
               setBorder(BorderFactory.createRaisedBevelBorder());
               
                //set background color
                setBackground(Color.decode("#d9afa4"));
           }
}
