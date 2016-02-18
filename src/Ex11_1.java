//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import java.awt.Color;
//import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This class implements and tests a simple text field.
 *
 * @author woytek
 */
public class Ex11_1 {

    static JLabel myLabel;
    static JButton myButton;
    static JTextField myTextField;
    static JButton textFieldUpdate;
    static GridBagLayout layout;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a window for our app
        JFrame myFrame = new JFrame("Example 11.1");
        // Set it to quit the app when we close the window
        // NOTE that this is the default behavior--we could omit this here
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // make it visible (important!)
        ////myFrame.setVisible( true );
        //myFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        //myFrame.setLayout( new GridLayout( 2, 2, 50, 10 ) );
        layout = new GridBagLayout();
        myFrame.setLayout( layout );
        
        GridBagConstraints c = new GridBagConstraints();
        // general constraints
        c.fill = GridBagConstraints.BOTH;
        
        // label constraints
        c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        // OK, now let's add a label
        myLabel = new JLabel("Hello, GUI World! This is awesome!");
        // let's set some properties
        // NOTE: These properties (font and color) come from AWT!!!!
        myLabel.setForeground(Color.BLUE);
        myLabel.setFont(new Font("TimesRoman", Font.BOLD, 24));
        layout.setConstraints( myLabel, c );
        // Now add it to the frame (ALSO IMPORTANT!!!!!!!)
        myFrame.add(myLabel);

        // button constraints
        c.gridwidth = GridBagConstraints.REMAINDER;
        // make button
        myButton = new JButton("Cycle Color");
        myButton.setFont(new Font("TimesRoman", Font.ITALIC, 12));

        ActionListener listener = new MyListener();
        myButton.addActionListener(listener);

        layout.setConstraints( myButton, c);
        myFrame.add(myButton);

        // text field setup
        // text field constraints
        c.gridwidth = GridBagConstraints.RELATIVE;
        myTextField = new JTextField( myLabel.getText(), 40 );
        layout.setConstraints(myTextField, c);
        myFrame.add( myTextField );
        
        // text button add
        c.gridwidth = GridBagConstraints.REMAINDER;
        textFieldUpdate = new JButton("Update Label");
        textFieldUpdate.addActionListener(listener);
        layout.setConstraints(textFieldUpdate, c);
        myFrame.add( textFieldUpdate );
        
        
        myFrame.pack();
        myFrame.setSize( myFrame.getPreferredSize() );
        // Our size will be wrong, so let's fix it
        //myFrame.setSize(600, 200);
        // alternate: use pack
        //myFrame.pack();

        myFrame.setVisible(true);

    }

    static class MyListener implements ActionListener {

        Color theColors[] = {Color.BLUE, Color.RED, Color.GREEN, Color.BLACK, Color.WHITE};
        int index = 0;

        public void actionPerformed(ActionEvent e) {
            //JButton eventSource = (JButton) e.getSource();
            //eventSource.setForeground(theColors[index++]);
            JButton eventSource = (JButton)e.getSource();
            if( eventSource.getText().equals("Update Label") ) {
                myLabel.setText( myTextField.getText() );
            }
        }
    }
}
