package org.bosque.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TableCellRendererColor extends DefaultTableCellRenderer{
	
	private Component componente;
	// choose whatever color you prefer
	private static final Color STRIPE = new Color(0.929f, 0.953f, 0.996f);
	private static final Color WHITE = UIManager.getColor("Table.background");
	
	public TableCellRendererColor() {
	    setOpaque(true); //MUST do this for background to show up.
	}	
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
		componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	
		if(row%2 == 0){			
			componente.setBackground(STRIPE);
			
		}else{
			componente.setBackground(WHITE);
			
		}
		
		if(isSelected){
			componente.setBackground(Color.ORANGE);
		}	
		
		
		return componente;
	}	
}
