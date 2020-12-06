package jframe;

import java.awt.event.*;
import javax.swing.*;
import caesar.*;

public class CaesarFrame extends JFrame{
	private JTextField text1 = new JTextField("",20) ,text2 = new JTextField("",20);
	private JButton b = new JButton("Code!");
	private String[] alphabet= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private JComboBox comboBox=new JComboBox(alphabet);
	
	public CaesarFrame() {
		setDefaultCloseOperation(0);
		JFrame frame = new JFrame("SwingLab");
		frame.setSize(400, 110);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JPanel panel = new JPanel(),panel1 = new JPanel() ,panel2 = new JPanel();
		panel1.add(comboBox);
		panel1.add(text1);
		panel1.add(b);
		
		b.setActionCommand("code");
		ActionListener al = new OkButtonActionListener();
		b.addActionListener(al);
		
		panel2.add(new JLabel("Output"));
		panel2.add(text2);
		text2.setEditable(false);
		
		panel.add(panel1);
		panel.add(panel2);
		frame.add(panel);
	}
	
	final class OkButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("code")) {
				char offSet = comboBox.getSelectedItem().toString().charAt(0);
				text2.setText(new CaesarCipher().returnCode(text1.getText(),offSet));
			}
		}
	}
}
