import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author SJHSStudent
 *
 */
public class LayoutTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JLabel outputLabel;
	
	public LayoutTest() {
		super("Layout Test");
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout( new BorderLayout() );
		
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		
		JButton button;
		JLabel label;
		
		buttonPanel.setLayout(new GridLayout(1, 3));
		
		button = new JButton( "One" );
		button.setActionCommand( "One" ); //adds string to button, user cannot see, added to button, can say getActionCommand() 
		button.addActionListener( this ); //this class implements actionListener, totally self contained
		buttonPanel.add(button);
		
		button = new JButton( "Two" );
		button.setActionCommand( "Two" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		button = new JButton( "Three" );
		button.setActionCommand( "Three" );
		button.addActionListener( this );
		buttonPanel.add(button);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		mainPanel.setLayout( new FlowLayout() );
		label = new JLabel( "Here is what you wanted" );
		mainPanel.add(label);

		outputLabel = new JLabel();
		outputLabel.setPreferredSize(new Dimension(150, 15));
		mainPanel.add( outputLabel );
		
		add(mainPanel, BorderLayout.CENTER);
		
		setSize(getPreferredSize());
		pack();
		setVisible(true);
		
	}
	
	public void actionPerformed( ActionEvent e ) {
		JButton button = (JButton)e.getSource();
		switch( button.getActionCommand() ) {
		case "One":
			outputLabel.setText("You pressed one!");
			break;
		case "Two":
			outputLabel.setText("You pressed two!");
			break;
		case "Three":
			outputLabel.setText("You pressed three!");
			break;
		default:
			JOptionPane.showMessageDialog(this, "Unknown button pressed!");
			break;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LayoutTest();

	}
}
