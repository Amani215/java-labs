package swingmvclab;

import java.util.List;

import javax.swing.table.*;

/*
 * Stores student data
 */
public class StudentData extends AbstractTableModel{

    /*
     * This attribute stores the student data.
     * Each item of List<> is an Object array of length 4. 
     * Each of these Object arrays stores the data corresponding
     * to a student in the following order:
     *   Name       (String)
     *   Neptun     (String)
     *   Signature  (Boolean)
     *   Mark       (Integer)
     * 
     * E.g. if the neptun code of the third student is required,
     * it can be accessed as follows:
     *   (String)students.get(2)[1]
     * 
     * DO NOT MODIFY THIS ATTRIBUTE!
     */
    public List<Object[]> students;

	public int getColumnCount() {return 4;}

	public int getRowCount() {return students.size();}

	public Object getValueAt(int arg0, int arg1) {
		return (Object)students.get(arg0)[arg1];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex==3) return true;
		return false;
	}
	
	public void setValueAt(Object aValue, int rowIndex,int columnIndex) {
		students.get(rowIndex)[columnIndex]=aValue;
	}
	
	public void addStudent(String name,String neptun) {
		Object[] obj = {name,neptun,false,0};	
		students.add(obj);
		this.fireTableRowsInserted(0, getRowCount());
	}
}
