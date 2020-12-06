package swingmvclab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * The main window.
 */
public class StudentFrame extends JFrame {
    
    /*
     * This object stores the student data.
     * When the program is started it loads the data from the file,
     * when it is closed, it saves the data.
     * 
     * DO NOT MODIFY THIS ATTRIBUTE!
     */
    private StudentData data;
    
    private JTextField nameField=new JTextField(20), neptunField=new JTextField(6);

    /*
     * This function should create the components of the window.
     * E.g. table, labels, text fields, etc.
     */
    private void initComponents() {
        this.setLayout(new BorderLayout());
        
        JTable t = new JTable(data);
        t.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(t);
        	this.add(scrollPane,BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        JLabel name=new JLabel("name"),neptun=new JLabel("neptun");
        JButton button=new JButton("New Student");
        	panel.add(name); panel.add(nameField);
        	panel.add(neptun); panel.add(neptunField);
        	panel.add(button);
        	  button.setActionCommand("ok");
        	  ActionListener al = new ButtonActionListener();
        	  button.addActionListener(al);
        		this.add(panel,BorderLayout.SOUTH);
    }

    final class ButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getActionCommand()=="ok") {
				data.addStudent(nameField.getText(), neptunField.getText());
			}
		}	
    }
    /*
     * Constructor of the window.
     * 
     * DO NOT MODIFY THIS CONSTRUCTOR!
     */
    @SuppressWarnings("unchecked")
    public StudentFrame() {
        super("Student administration");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Load data at startup:
        try {
            data = new StudentData();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            data.students = (List<Object[]>)ois.readObject();
            ois.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        // Save data at shutdown:
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
                    oos.writeObject(data.students);
                    oos.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Build the window:
        setMinimumSize(new Dimension(400, 300));
        initComponents();
        pack();
    }

    /*
     * Entry point of the program.
     * 
     * DO NOT MODIFY THIS FUNCTION!
     */
    public static void main(String[] args) {
        // Show the window:
        StudentFrame sf = new StudentFrame();
        sf.setVisible(true);
    }
    
}
