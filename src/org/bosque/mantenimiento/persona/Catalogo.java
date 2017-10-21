package org.bosque.mantenimiento.persona;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.bosque.controller.PersonaController;
import org.bosque.model.bean.Factura;
import org.bosque.mantenimiento.persona.PersonaView;

public class Catalogo extends JPanel {

	private PersonaView view;
	private PersonaController controller;
	private JTable catalogTable;
	
	private String[] columnas = {"Factura", "Tipo Factura", "Cliente", "Contrato", "Servicio", "Lote", "Contrataci\u00F3n", "Ejecuci\u00F3n", "Venta", "Vence", "Costo", "Estado", "Pre-Solicitud"};
	private Object[][] data = null;
	private DefaultTableModel modelo = null;	

	/**
	 * Create the panel.
	 */
	public Catalogo() {

	}

	/**
	 * 
	 * @return
	 */
	public Object[][] getData(){
		return data;
	}
	
	/**
	 * 
	 * @param objList
	 */
	public void setData(List<Factura> objList){
		if(objList != null && !objList.isEmpty() && objList.size() > 0){
			data = new Object[objList.size()][13];
			for(int i=0; i< objList.size(); i++){
				Factura obj = objList.get(i);
				Object[] newRow = {};
			    modelo.addRow(newRow);				
			}
		}		
	}

	/**
	 * 
	 * @param form
	 */
	public void setView(PersonaView view){
		this.view = view;
	}
	
	/**
	 * 
	 * @return
	 */	
	public PersonaView getView(){
		return this.view;
	}

	public void limpiar() {
		// TODO Auto-generated method stub
		
	}

	public void cargarCatalogo() {
		// TODO Auto-generated method stub
		
	}

}
