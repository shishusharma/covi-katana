package coronaKatana;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

//Button Renderer Class
@SuppressWarnings("serial")
public class ButtonRenderer extends JButton implements TableCellRenderer{
	
	//Constructor
	public ButtonRenderer() {
		//set Button properties
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		setText((value==null)?"":value.toString());
		return this;
	}
	
}

class ButtonEditor extends DefaultCellEditor{
	protected JButton btn;
	private String lbl;
	private Boolean clicked;

	public ButtonEditor(JTextField txt) {
		super(txt);
		// TODO Auto-generated constructor stub
		btn=new JButton();
		btn.setOpaque(true);
		
		//when button is clicked
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fireEditingStopped();
			}
			
		});
	}
	
	//override a couple of methods
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		//set text to button ,set clicked to true, then return the bin object
		lbl=(value==null)?"":value.toString();
		btn.setText(lbl);
		clicked=true;
		return btn;
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		if(clicked) {
			//show us some message
			JOptionPane.showConfirmDialog(btn, lbl+"clicked");			
		}
		//set it to false now that its clicked
		clicked=false;
		return new String(lbl);		
	}
	
	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		clicked=false;
		return super.stopCellEditing();
		
	}
	@Override
	protected void fireEditingStopped() {
		// TODO Auto-generated method stub
		super.fireEditingStopped();
	}
	
	
}


