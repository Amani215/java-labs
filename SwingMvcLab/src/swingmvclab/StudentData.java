package swingmvclab;

import java.util.List;

import javax.swing.table.AbstractTableModel;

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

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return students.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return students.get(arg0)[arg1];
	}
	
	public boolean isCellEditable(int row,int column) {
		if(column==3) return true;
		else return false;
	}
	
	public void setValueAt(Object value,int row,int column) {
		students.get(row)[column]=value;
	}
	
	public void addStudent(String name,String neptun) {
		Object[] student={name,neptun,false,0};
		students.add(student);
		fireTableRowsInserted(0, getRowCount());
	}
}
