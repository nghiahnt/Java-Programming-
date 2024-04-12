package StudentManagement_FileSystemData;

import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Student_TableData extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Initial 
	private JScrollPane tableResult;
	private  JTable table;
	private static DefaultTableModel model;
	
	String[] columns = {"Name", "Id", "Aver"};
	private Vector<Object> data = new Vector<Object>();
	private Vector<Object> title = new Vector<Object>();
	
	@SuppressWarnings("unchecked")
	public Student_TableData(Vector data) {	
		this.data = data;
		load();
		
		// Interface
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		tableResult = new JScrollPane(table);
		table.addMouseListener(this);
	}

	public void load() {
		title.clear();		
		for (String column : columns) {
			title.add(column);
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public JScrollPane getTableResult() {
		return tableResult;
	}
	
	public static DefaultTableModel getModel() {
		return model;
	}

}
