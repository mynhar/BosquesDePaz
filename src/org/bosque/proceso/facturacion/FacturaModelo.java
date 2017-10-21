package org.bosque.proceso.facturacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.bosque.controller.FacturacionController;
import org.bosque.model.bean.Servicio;

public class FacturaModelo extends AbstractTableModel {

	private FacturacionController controller;
	
	private List<Servicio> servicios = new ArrayList<Servicio>();
	private String columnas[] = {"Servicio","Factura", "Cliente","Agente","Pre_Solicitud","Contrato","Persona","Nicho","Es Traslado (S/N)","Fecha Ejecución","Fecha Contratación","Costo", "Tipo", "Fecha Factura", "Plazo", "Monto", "Estado"};
	//private Class[] columnTypes = new Class[] {Long.class, String.class, String.class, String.class, Date.class, Long.class, BigDecimal.class, String.class};
	
	public FacturaModelo(){
		// busca la lista de servicios...
		if(controller == null){
			controller = new FacturacionController();
		}
		
		servicios = controller.getListServicio();
				
	}

	@Override
	public int getColumnCount() {
		int count = columnas.length;
		return count;
	}

	@Override
	public int getRowCount() {
		int count = servicios.size();
		return count;
	}
	
	@Override
	public String getColumnName(int columnIndex){
		return columnas[columnIndex];
	}
	
	/*
	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}
	*/

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0: return servicios.get(rowIndex).getServicio();
		case 1: return servicios.get(rowIndex).getFactura().getIdFactura();
		case 2: return servicios.get(rowIndex).getCliente().getPersona().toString();
		case 3: return servicios.get(rowIndex).getAgente().getNombre();
		case 4: return servicios.get(rowIndex).getPreSolicitud();
		case 5: return servicios.get(rowIndex).getContrato();
		case 6: return servicios.get(rowIndex).getPersona().toString();
		
		case 7:
			String nicho = servicios.get(rowIndex).getNicho();
			if(nicho.equalsIgnoreCase("S")){
				nicho = "Superior";
			}else if(nicho.equalsIgnoreCase("I")){
				nicho = "Inferior";
			}
			return nicho;
		
		case 8: return servicios.get(rowIndex).getIndTraslado();
		case 9: return servicios.get(rowIndex).getFecEjecucion();
		case 10: return servicios.get(rowIndex).getFecContratacion();
		case 11: return servicios.get(rowIndex).getCostoServicio();
		
		case 12:
			String tipo = servicios.get(rowIndex).getFactura().getTipofactura();
			if(tipo.equalsIgnoreCase("CR")){
				tipo = "Credito";
			}else if(tipo.equalsIgnoreCase("CO")){
				tipo = "Contado";
			}			
			return tipo;
			
		case 13: return servicios.get(rowIndex).getFactura().getFecFactura();
		case 14: return servicios.get(rowIndex).getFactura().getMesesPlazo();
		case 15: return servicios.get(rowIndex).getFactura().getMontoFactura();
		
		case 16:
			String estado = servicios.get(rowIndex).getFactura().getEstadoFactura();
			if(estado.equalsIgnoreCase("V")){
				estado = "Vigente";
			}else if(estado.equalsIgnoreCase("A")){
				estado = "Anulada";
			}
			return estado;
		default: return null;
		}		
	}
	
	
	/**
	 * 
	 * @param rowIndex
	 * @return
	 */
	public Servicio getFila(int rowIndex){
		Servicio obj = new Servicio();
		obj.setServicio(servicios.get(rowIndex).getServicio());		
		return obj;
	}
	
	/**
	 * 
	 * @param obj
	 */
	public void agregarFila(Servicio obj){
		servicios.add(obj);
		this.fireTableRowsInserted(servicios.size(), servicios.size());
	}
	
	/**
	 * 
	 * @param index
	 */
	public void removerFila(int index){
		servicios.remove(index);
		this.fireTableRowsDeleted(index, index);		
	}
	
	/**
	 * 
	 * @param objList
	 */
	public void removerTodo(){
		while(servicios.size()>0){
			int index = servicios.size()-1;
			this.removerFila(index);
		}						
	}
	
	
	/**
	 * 
	 * @param objList
	 */
	public void agregarLista(ArrayList<Servicio> objList){
		if(objList != null && objList.size()>0){			
			for(int index=0; index<objList.size(); index++){
				Servicio obj = objList.get(index);
				this.agregarFila(obj);				
			}			
		}
	}
	
	/**
	 * 
	 * @param objList
	 */
	public void removerLista(){
		if(servicios != null && servicios.size()>0){
			for(int index=0; index<servicios.size(); index++){
				this.removerFila(index);
			}
		}
	}	

}
