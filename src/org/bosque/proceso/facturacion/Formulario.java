package org.bosque.proceso.facturacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import org.bosque.controller.FacturacionController;
import org.bosque.model.bean.Agente;
import org.bosque.model.bean.Cliente;
import org.bosque.model.bean.Concepto;
import org.bosque.model.bean.Factura;
import org.bosque.model.bean.Lote;
import org.bosque.model.bean.Persona;
import org.bosque.model.bean.Servicio;
import org.bosque.model.dao.FacturaDao;
import org.bosque.model.dao.ServicioDao;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class Formulario extends JPanel{
	
	private FacturacionLoteServicio facturacionLoteServicio;
	private InformacionServicio informacionServicio;
	private FacturacionController controller;		
	private FacturacionView view;
	

	public Formulario(){
		setBorder(null);		
		setLayout(new BorderLayout());
		facturacionLoteServicio = new FacturacionLoteServicio();		
		informacionServicio = new InformacionServicio();
		controller = new FacturacionController();
		
		/*** Barra de Herraminetas Formulario ***/
		JToolBar barraHerramientasFormulario = new JToolBar();
		barraHerramientasFormulario.setToolTipText("Herramientas del Formulario...");
		
		ImageIcon agregarButtonIcon = createImageIcon("src/graficos/add32.png");
		ImageIcon buscarButtonIcon = createImageIcon("src/graficos/folderSearch32.png");
		ImageIcon eliminarButtonIcon = createImageIcon("src/graficos/deleteTrash32.png");
		ImageIcon limpiarButtonIcon = createImageIcon("src/graficos/clean32.png");
		
		
		JButton btnAgregar = new JButton();
		btnAgregar.setIcon(agregarButtonIcon);
		btnAgregar.setToolTipText("Guardar...");
		
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servicio obj = getFormValues();
				boolean isTrue = validaciones(obj);
				if(isTrue){
					if(obj.getFactura().getIdFactura() == null){
						obj = create(obj);
						
					}else{
						obj = update(obj);
						
					}
					
					setFormValues(obj);
					if(obj.getFactura().getIdFactura() != null){
						showMessageDialog("Registro Guardado. Operación realizada correctamente!");
					}else{
						showMessageDialog("Registro NO Guardado. Operación Falló!");
					}
					
				}
				
			}
			
		});
		
		
		JButton btnBuscar = new JButton();
		btnBuscar.setIcon(buscarButtonIcon);
		btnBuscar.setToolTipText("Buscar...");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//getView().getCatalogo().cargarCatalogo();
				getView().getTabbedPane().setSelectedIndex(0);// Cambiar al tab Catalogo...
			}
		});
		
		JButton btnEliminar = new JButton();
		btnEliminar.setIcon(eliminarButtonIcon);
		btnEliminar.setToolTipText("Eliminar...");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Long id = facturacionLoteServicio.getIdFactura();				
				if(validarRegistroSeleccionado(id)){
					if(showConfirmDialog("Desea borrar el registro seleccionado?")){
						Servicio obj = getFormValues();
						boolean isDelete = delete(obj);
						if(isDelete){
							limpiar();
							showMessageDialog("Registro Borrado. Operación realizada correctamente!");
						}
					}
				}								
			}
		});
		
		JButton btnLimpiar = new JButton();
		btnLimpiar.setIcon(limpiarButtonIcon);
		btnLimpiar.setToolTipText("Limpiar Formulario...");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				limpiar();
			}
		});
		
		barraHerramientasFormulario.add(btnAgregar);
		barraHerramientasFormulario.add(btnLimpiar);
		barraHerramientasFormulario.add(btnBuscar);
		barraHerramientasFormulario.add(btnEliminar);
				
		
		add(barraHerramientasFormulario, BorderLayout.NORTH);
		/*** Barra de Herraminetas ***/
		
		
		JPanel CentralPanel = new JPanel();
		CentralPanel.setLayout(new BoxLayout(CentralPanel,BoxLayout.Y_AXIS));//new GridLayout(2, 1, 0, 0)
		
		CentralPanel.add(facturacionLoteServicio);
		CentralPanel.add(informacionServicio);
		
		JScrollPane centralJScrollPane = new JScrollPane(CentralPanel);		
		
		Box cajaHorizontal = Box.createHorizontalBox();
		cajaHorizontal.add(Box.createGlue());
		cajaHorizontal.add(centralJScrollPane);
		cajaHorizontal.add(Box.createGlue());
				
		add(cajaHorizontal, BorderLayout.CENTER);
		
		JButton btnSur = new JButton("Sur");
		add(btnSur,BorderLayout.SOUTH);
		
	}
	
		
	/**
	 * 
	 * @param id
	 * @return
	 */
	private boolean validarRegistroSeleccionado(Long id) {
		
		if(id == null || id.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe seleccionar, Factura!", "Alerta", JOptionPane.WARNING_MESSAGE);			
			return false;
		}
		
		return true;
	}
	
	
	private boolean validaciones(Servicio obj) {
		
		Factura factura = obj.getFactura();		
		
		String tipofactura = factura.getTipofactura();		
		if(tipofactura == null || tipofactura.trim().equals("")){
			JOptionPane.showMessageDialog(this, "Debe seleccionar, Tipo de Factura!", "Alerta", JOptionPane.WARNING_MESSAGE);
			facturacionLoteServicio.setTipofactura("CR");
			return false;
		}		
		
		Date fecFactura = factura.getFecFactura();
		if(fecFactura == null){
			JOptionPane.showMessageDialog(this, "Debe digitar, fecha Factura!", "Alerta", JOptionPane.WARNING_MESSAGE);
			facturacionLoteServicio.fecFacturaChooser.requestFocus();
			return false;
		}
		
		Cliente cliente = factura.getCliente();
		if(cliente == null){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Cliente!", "Alerta", JOptionPane.WARNING_MESSAGE);
			facturacionLoteServicio.clienteComboBox.requestFocus();
			return false;
		}		
		
		Long mesesPlazo = factura.getMesesPlazo();
		if(mesesPlazo == null){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Meses Plazo!", "Alerta", JOptionPane.WARNING_MESSAGE);
			facturacionLoteServicio.txtPlazo.requestFocus();
			return false;
		}
		
		String estadoFactura = factura.getEstadoFactura();
		if(estadoFactura == null){			
			JOptionPane.showMessageDialog(this, "Debe Seleccionar, Estado de la Factura!", "Alerta", JOptionPane.WARNING_MESSAGE);
			facturacionLoteServicio.setEstado("V");
			return false;
		}
		
		/***************************************************************************************************************
		 Informacion del Servicio
		****************************************************************************************************************/
		Persona persona = obj.getPersona();
		if(persona == null){
			JOptionPane.showMessageDialog(this, "Debe Seleccionar, El Beneficiario!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.beneficiarioComboBox.requestFocus();
			return false;
		}
		
		Long contrato = obj.getContrato();
		if(contrato == null){
			JOptionPane.showMessageDialog(this, "Debe digitar, Contrato!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.contratoSpinner.requestFocus();
			return false;
		}
		
		Long preSolicitud = obj.getPreSolicitud();
		if(preSolicitud == null){
			JOptionPane.showMessageDialog(this, "Debe digitar, Pre-Solicitud!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.preSolicitudSpinner.requestFocus();
			return false;
		}
		
		/*
		Date preSolicitud = obj.getF
		if(preSolicitud == null){
			JOptionPane.showMessageDialog(this, "Debe Seleccionar, Fecha Venta!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.fecVentaSpinner.requestFocus();
			return false;
		}
		*/
		
		/*
		Lote lote = obj.getLote();
		if(lote == null){
			JOptionPane.showMessageDialog(this, "Debe Seleccionar, El Lote!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.loteComboBox.requestFocus();
			return false;
		}
		*/

		/*
		String zona = obj.getLote().getZona();
		if(zona == null){
			JOptionPane.showMessageDialog(this, "Debe digitar, la zona!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.textZona.requestFocus();
			return false;
		}		
		
		String fila = obj.getLote().getFila();
		if(fila == null){
			JOptionPane.showMessageDialog(this, "Debe digitar, la fila!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.textFila.requestFocus();
			return false;
		}				
		
		Long secuencia = obj.getLote().getSecuencia();
		if(secuencia == null){
			JOptionPane.showMessageDialog(this, "Debe digitar, la secuencia!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.secuenciaSpinner.requestFocus();
			return false;
		}
		*/
		String nicho = obj.getNicho();
		if(nicho == null){
			JOptionPane.showMessageDialog(this, "Debe Seleccionar, el nicho!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.setNicho(null);
			return false;
		}
		
		Date fecEjecucion = obj.getFecEjecucion();
		if(fecEjecucion == null){
			JOptionPane.showMessageDialog(this, "Debe Seleccionar, la fecha ejecucion!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.fechaEjecucionChooser.requestFocus();
			return false;
		}
		
		Concepto concepto = obj.getConcepto(); 
		if(concepto == null){
			JOptionPane.showMessageDialog(this, "Debe Seleccionar, un concepto!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.conceptoComboBox.requestFocus();
			return false;
		}
		
		Agente agente = obj.getAgente();
		if(agente == null){
			JOptionPane.showMessageDialog(this, "Debe Seleccionar, un agente!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.agenteComboBox.requestFocus();
			return false;
		}

		
		BigDecimal costoServicio = obj.getCostoServicio();
		if(costoServicio == null || costoServicio.toString().trim().equals("") || costoServicio.compareTo(new BigDecimal("0")) == 0){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Costo del Lote o Servicio!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.costoLoteServicio.requestFocus();
			return false;
			
		} else if(costoServicio.compareTo(new BigDecimal("0")) == -1){			
			JOptionPane.showMessageDialog(this, "Costo del Lote o Servicio, debe ser mayor a 0!", "Alerta", JOptionPane.WARNING_MESSAGE);
			informacionServicio.costoLoteServicio.requestFocus();
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * INFORMATION_MESSAGE
	 * @param msg
	 */
	private void showMessageDialog(String msg){
		JOptionPane.showMessageDialog(this, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 
	 * @param msg
	 * @return
	 */
	private boolean showConfirmDialog(String msg){
		int rest = JOptionPane.showConfirmDialog(this, msg, "Confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(rest == 0){
			return true;
			
		}else if(rest == 1){
			return false;
			
		}else{
			
			return false;
		}
		
	}	
	
	/**
	 * Returns an ImageIcon, or null if the path was invalid. 
	 * @param path
	 * @return
	 */
    protected static ImageIcon createImageIcon(String path) {        
    	Toolkit pantalla = Toolkit.getDefaultToolkit();
    	Image imagen = pantalla.getImage(path);
    	
        if (imagen != null) {
            return new ImageIcon(imagen);
        } else {
            System.err.println("No puede encontrar la Imagen, Facturación: " + path);
            return null;
        }
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
	
	/**
	 * 
	 * @return
	 */
	public Servicio getFormValues(){
		Factura factura = facturacionLoteServicio.getFormValues();
		Servicio servicio = informacionServicio.getFormValues();
		Agente agente = informacionServicio.getAgenteComboBox();
		
		if(agente != null){
			factura.setAgente(agente);
		}
		
		factura.setMontoFactura(servicio.getCostoServicio());				
		servicio.setFactura(factura);		
		servicio.setCliente(factura.getCliente());
		
		return servicio;
	}
	
	/**
	 * 
	 * @param obj
	 */
	public void setFormValues(Servicio obj){
		facturacionLoteServicio.setFormValues(obj.getFactura());
		informacionServicio.setFormValues(obj);		
	}
	
	
	public Servicio create(Servicio obj) {
    	obj = controller.create(obj);
		return obj;
    }
    
    /**
	 * 
	 * @param obj
	 * @return
	 */
	public Servicio update(Servicio obj){
		obj = controller.update(obj);		
		return obj;
	}
	
	/**
	 * 
	 */
	public boolean delete(Servicio obj){
		return controller.delete(obj);
	}
	
	/**
	 * 
	 */
	public void limpiar(){
		facturacionLoteServicio.limpiar();
		informacionServicio.limpiar();
	}
	
    
}
