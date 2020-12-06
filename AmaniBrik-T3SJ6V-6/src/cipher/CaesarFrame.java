package cipher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CaesarFrame extends JFrame{
	//default serial version ID
	private static final long serialVersionUID = 1L;
	
	//attributes
	private JTextField textField1 = new JTextField("",20);
	private JTextField textField2 = new JTextField("",20);
	private JButton button = new JButton("Code!");
	private String letters[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private JComboBox box = new JComboBox(letters);
	
	//Constructor
	public CaesarFrame() {
		//closes with the X sign
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setting the title
		JFrame jframe =new JFrame("SwingLab");
		//setting the size (not resizable)
		jframe.setSize(400,110);
		jframe.setResizable(false);
		//making the window visible
		jframe.setVisible(true);
		
		//formatting
		
		JPanel panel1 = new JPanel();
			panel1.add(box);
			panel1.add(textField1);
			panel1.add(button);
				button.setActionCommand("click");
				ActionListener al = new OkButtonActionListener();
				button.addActionListener(al);
		
		JPanel panel2 = new JPanel();
			panel2.add(new JLabel("Output"));
			textField2.setEditable(false);
			panel2.add(textField2);
		
		JPanel panel = new JPanel();
			panel.add(panel1);
			panel.add(panel2);
			
		jframe.add(panel);
	}
	
	final class OkButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals("click")) {
				char c = box.getSelectedItem().toString().charAt(0);
				CaesarCipher output = new CaesarCipher(textField1.getText(),c);
				textField2.setText(output.text);
			}
		}
		
	}
}
