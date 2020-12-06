package horizontalMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuLayoutDemo {
	JPanel panel = new JPanel();
	  public JMenuBar createMenuBar() {
		    JMenuBar menuBar = new JMenuBar();
		    menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.Y_AXIS));
		    
		    HorizontalMenu addIncome = new HorizontalMenu("Add Income");
		    HorizontalMenu addExpense = new HorizontalMenu("Add Expense");
		    HorizontalMenu addCategory = new HorizontalMenu("Add Category");
		    HorizontalMenu moneyInWallet = new HorizontalMenu("Money In My Wallet");
		    HorizontalMenu statistics = new HorizontalMenu("Statistics");
		    
		    menuBar.add(addIncome);
		    menuBar.add(addExpense);
		    menuBar.add(addCategory);
		    menuBar.add(moneyInWallet);
		    menuBar.add(statistics);
		    
		   /* addIncome.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               panel.add(new JButton("hey"));
	               panel.repaint();
	            }
	        } );*/

		    menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		    menuBar.setBackground(Color.DARK_GRAY);
		    return menuBar;
		}
		 
		  private static void createAndShowGUI() {
		    // Create and set up the window.
		    JFrame frame = new JFrame("Wallet Demo");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		    // Create and set up the content pane.
		    MenuLayoutDemo demo = new MenuLayoutDemo();
		    Container contentPane = frame.getContentPane();
		    contentPane.setBackground(Color.WHITE); // contrasting bg
		    contentPane.add(demo.createMenuBar(), BorderLayout.WEST);

		    // Display the window.
		    frame.setSize(600,300);
		    frame.setVisible(true);
		  }
		  
		  public static void main(String[] args) {
			        createAndShowGUI();
		  }
		  
		  class HorizontalMenu extends JMenu {
			    HorizontalMenu(String label) {
			    	super(label);
			    	this.setForeground(Color.WHITE);
			    }
			    public Dimension getMinimumSize() {return getPreferredSize();}
			    public Dimension getMaximumSize() {return getPreferredSize();}
		  }
}
