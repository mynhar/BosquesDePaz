package org.bosque.proceso.facturacion;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JTable;
import org.bosque.controller.FacturacionController;
import org.bosque.model.bean.Servicio;
import org.bosque.utils.FormatoCelda;
import org.bosque.utils.TableCellRendererColor;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Catalogo extends JPanel {

	private FacturacionView view;	
	private JTable tabla;
	private FacturaModelo modelo;
	private FacturacionController controller;


	/**
	 * Create the panel.
	 */
	public Catalogo() {		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 204, 0)));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		modelo = new FacturaModelo();
		tabla = new JTable(modelo){
			@Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }			
		};
		tabla.getColumnModel().getColumn(0).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(1).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(2).setCellRenderer(new FormatoCelda());		
		tabla.getColumnModel().getColumn(3).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(4).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(5).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(6).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(7).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(8).setCellRenderer(new FormatoCelda());		
		tabla.getColumnModel().getColumn(9).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(10).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(11).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(12).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(13).setCellRenderer(new FormatoCelda());		
		tabla.getColumnModel().getColumn(14).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(15).setCellRenderer(new FormatoCelda());
		tabla.getColumnModel().getColumn(16).setCellRenderer(new FormatoCelda());
		
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int clickCount = arg0.getClickCount();
				if(clickCount == 2){
					int selectedRow = tabla.getSelectedRow();
					if(selectedRow != -1){// -1 si no hay una fila seleccionada...
						Servicio obj = getModelo().getFila(selectedRow);
						
						if(controller == null){
							controller = new FacturacionController();
						}
						
						obj = controller.read(obj);						
						view.getFormPanel().setFormValues(obj);
						view.getTabbedPane().setSelectedIndex(1);
												
					}					
				}				
			}
		});
		tabla.setDefaultRenderer(Object.class, new TableCellRendererColor());
		tabla.setDefaultRenderer(Boolean.class, new TableCellRendererColor());		
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
        scrollPane.setViewportView(tabla);        
        add(scrollPane);

	}
	
	/**
	 * Lipia el catalogo
	 */
	public void limpiar(){
		if(tabla != null){			
			getModelo().removerTodo();			
		}
	}
	
	/**
	 * 
	 */
	public void cargarCatalogo(){
		limpiar();
		if(tabla != null){			
			if(controller == null){
				controller = new FacturacionController();
			}
			
			ArrayList<Servicio> objList = (ArrayList<Servicio>) controller.getListServicio();			
			getModelo().agregarLista(objList);
		}
	}
	
	/**
	 * @return the modelo
	 */
	public FacturaModelo getModelo() {		
		return this.modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(FacturaModelo modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * 
	 * @param form
	 */
	public void setView(FacturacionView view){
		this.view = view;
	}
	
	/**
	 * 
	 * @return
	 */	
	public FacturacionView getView(){
		return this.view;
	}
	
}
