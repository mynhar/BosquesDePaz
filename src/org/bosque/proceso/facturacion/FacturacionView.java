package org.bosque.proceso.facturacion;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.bosque.controller.FacturacionController;
import org.bosque.model.bean.Factura;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class FacturacionView extends JPanel {

	private Long idFactura;
	private JRadioButton rdbtnCredito;
	private JRadioButton rdbtnContado;
	private JTextField txtCliente;
	private JTextField txtContrato;
	private JTextField txtPresolicitud;
	private JSpinner fecVentaSpinner;
	private JTextField txtLote;
	private JTextField txtNicho;
	private JSpinner fechaEjecucionSpinner;	
	private JRadioButton rdbtnVentaDeLote;	
	private JRadioButton rdbtnSepelio;		
	private JRadioButton rdbtnFunerario;
	private JRadioButton rdbtnCremacin;
	private JRadioButton rdbtnExhumacin;		
	private JRadioButton rdbtnMantenimientoDeLote;
	private JSpinner costoServicioSpinner;
	
	private FacturacionController controller;
	private Factura obj;
	

	/**
	 * Create the panel.
	 */
	public FacturacionView() {
		super(new GridLayout(1, 1));
		
		controller = new FacturacionController();
		obj = new Factura();
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		/***************************************************************************************************
		  Facturacion Panel
		 ***************************************************************************************************/
		JPanel FacturacionPanel = new JPanel();
		FacturacionPanel.setToolTipText("Venta de Lotes o Servicios");		
		ImageIcon icon = createImageIcon("src/graficos/middle.gif");		
		FacturacionPanel.setLayout(new BorderLayout());
		
		JButton btnSur = new JButton("Sur");
		FacturacionPanel.add(btnSur,BorderLayout.SOUTH);
		
		/***************************************************************************************************
		  Formulario
		 ***************************************************************************************************/
		
		/*** Barra de Herraminetas ***/
		JToolBar barraHerramientasFormulario = new JToolBar();
		barraHerramientasFormulario.setToolTipText("Herramientas del Formulario...");
		
		JButton btnAgregar = new JButton();		
		ImageIcon agregarButtonIcon = createImageIcon("src/graficos/add32.png");
		btnAgregar.setIcon(agregarButtonIcon);
		btnAgregar.setToolTipText("Guardar...");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Factura obj = getFormValues();
				boolean isTrue = validaciones(obj);
				if(isTrue){
					controller.create(obj);
				}
				
			}
			
		});
		
		
		JButton btnBuscar = new JButton();
		ImageIcon buscarButtonIcon = createImageIcon("src/graficos/folderSearch32.png");
		btnBuscar.setIcon(buscarButtonIcon);
		btnBuscar.setToolTipText("Buscar...");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {								
				tabbedPane.setSelectedIndex(0);// Cambiar al tab Catalogo...
			}
		});
		
		JButton btnEliminar = new JButton();
		ImageIcon eliminarButtonIcon = createImageIcon("src/graficos/deleteTrash32.png");
		btnEliminar.setIcon(eliminarButtonIcon);
		btnEliminar.setToolTipText("Eliminar...");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				Factura obj = getFormValues();
				controller.delete(obj);
			}
		});
		
		JButton btnLimpiar = new JButton();
		ImageIcon limpiarButtonIcon = createImageIcon("src/graficos/clean32.png");
		btnLimpiar.setIcon(limpiarButtonIcon);
		btnLimpiar.setToolTipText("Limpiar Formulario...");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				clean();
			}
		});
		
		barraHerramientasFormulario.add(btnAgregar);
		barraHerramientasFormulario.add(btnLimpiar);
		barraHerramientasFormulario.add(btnBuscar);
		barraHerramientasFormulario.add(btnEliminar);
				
		
		FacturacionPanel.add(barraHerramientasFormulario, BorderLayout.NORTH);
		/*** Barra de Herraminetas ***/
		
		
		JPanel centralPanel = new JPanel();
		centralPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, null));		
		JScrollPane centralJScrollPane = new JScrollPane(centralPanel);
		
		Box cajaHorizontal = Box.createHorizontalBox();
		cajaHorizontal.add(Box.createGlue());
		cajaHorizontal.add(centralJScrollPane);
		cajaHorizontal.add(Box.createGlue());
				
		FacturacionPanel.add(cajaHorizontal, BorderLayout.CENTER);
		
		Dimension dimLabel = new Dimension(200, 20);
		Dimension dimText = new Dimension(200, 20);
		centralPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("83px"),
				ColumnSpec.decode("118px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("200px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("17px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("31px"),
				RowSpec.decode("17px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),}));
		
		JLabel lblVentaDeLotes = new JLabel("Venta de Lotes o Servicios");
		lblVentaDeLotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVentaDeLotes.setBackground(Color.CYAN);
		lblVentaDeLotes.setHorizontalAlignment(SwingConstants.CENTER);		
		centralPanel.add(lblVentaDeLotes, "2, 2, 3, 1, fill, top");
		
		JLabel lblTipoFactura = new JLabel("Tipo Facturaci\u00F3n");
		lblTipoFactura.setHorizontalAlignment(SwingConstants.RIGHT);
		centralPanel.add(lblTipoFactura, "2, 4, fill, center");
		
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnCredito = new JRadioButton("Credito");
		rdbtnCredito.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnGroup.add(rdbtnCredito);
		centralPanel.add(rdbtnCredito, "4, 4, fill, top");
		
		rdbtnContado = new JRadioButton("Contado");
		rdbtnContado.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnGroup.add(rdbtnContado);
		centralPanel.add(rdbtnContado, "4, 6, fill, top");
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		centralPanel.add(lblCliente, "2, 8, right, center");
		
		txtCliente = new JTextField();
		txtCliente.setText("cliente");
		centralPanel.add(txtCliente, "4, 8, fill, top");
		txtCliente.setPreferredSize(dimText);
		txtCliente.setColumns(10);
		
		
		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setHorizontalAlignment(SwingConstants.RIGHT);
		centralPanel.add(lblContrato, "2, 10, right, center");
		
		txtContrato = new JTextField();
		txtContrato.setText("contrato");
		centralPanel.add(txtContrato, "4, 10, fill, top");
		txtContrato.setColumns(10);
		txtContrato.setPreferredSize(dimText);
		
		JLabel lblPresolicitud = new JLabel("Pre-Solicitud");
		lblPresolicitud.setHorizontalAlignment(SwingConstants.RIGHT);
		centralPanel.add(lblPresolicitud, "2, 12, right, center");
		
		txtPresolicitud = new JTextField();
		txtPresolicitud.setText("preSolicitud");
		centralPanel.add(txtPresolicitud, "4, 12, fill, top");
		txtPresolicitud.setColumns(10);
		txtPresolicitud.setPreferredSize(dimText);
		
		JLabel lblFecVenta = new JLabel("Fec. Venta");
		lblFecVenta.setHorizontalAlignment(SwingConstants.RIGHT);
		centralPanel.add(lblFecVenta, "2, 14, right, center");
		
		fecVentaSpinner = new JSpinner(new SpinnerDateModel());//
		fecVentaSpinner.setPreferredSize(dimText);		
		centralPanel.add(fecVentaSpinner, "4, 14, fill, top");		
		
		JLabel lblLote = new JLabel("Lote");
		lblLote.setHorizontalAlignment(SwingConstants.RIGHT);
		centralPanel.add(lblLote, "2, 16, right, center");
		
		txtLote = new JTextField();
		txtLote.setText("lote");
		centralPanel.add(txtLote, "4, 16, fill, top");
		txtLote.setColumns(10);
		txtLote.setPreferredSize(dimText);
		
		JLabel lblNichosuperiorInferior = new JLabel("Nicho(Superior, Inferior)");
		lblNichosuperiorInferior.setHorizontalAlignment(SwingConstants.RIGHT);
		centralPanel.add(lblNichosuperiorInferior, "2, 18, right, center");
		
		txtNicho = new JTextField();
		txtNicho.setText("nicho");
		centralPanel.add(txtNicho, "4, 18, fill, top");
		txtNicho.setColumns(10);
		txtNicho.setPreferredSize(dimText);
		
		JLabel lblFechaEjecucin = new JLabel("Fecha Ejecuci\u00F3n");
		lblFechaEjecucin.setHorizontalAlignment(SwingConstants.RIGHT);
		centralPanel.add(lblFechaEjecucin, "2, 20, right, center");
		
		fechaEjecucionSpinner = new JSpinner(new SpinnerDateModel());//
		fechaEjecucionSpinner.setPreferredSize(dimText);
		centralPanel.add(fechaEjecucionSpinner, "4, 20, center, top");
		
		JLabel lblServicioVendido = new JLabel("Servicio Vendido");
		lblServicioVendido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServicioVendido.setBackground(Color.CYAN);
		lblServicioVendido.setHorizontalAlignment(SwingConstants.CENTER);
		centralPanel.add(lblServicioVendido, "2, 22, 3, 1, fill, top");
		
		ButtonGroup rdbtnGroupServicioVendido = new ButtonGroup();
		rdbtnVentaDeLote = new JRadioButton("Venta de Lote");
		rdbtnVentaDeLote.setSelected(true);
		centralPanel.add(rdbtnVentaDeLote, "4, 24, fill, top");
		
		rdbtnSepelio = new JRadioButton("Sepelio");		
		centralPanel.add(rdbtnSepelio, "4, 26, fill, top");
		
		rdbtnFunerario = new JRadioButton("Funerario");
		centralPanel.add(rdbtnFunerario, "4, 28, fill, top");
		
		rdbtnCremacin = new JRadioButton("Cremaci\u00F3n");
		centralPanel.add(rdbtnCremacin, "4, 30, fill, top");
		
		rdbtnExhumacin = new JRadioButton("Exhumaci\u00F3n");		
		centralPanel.add(rdbtnExhumacin, "4, 32, fill, top");
		
		rdbtnMantenimientoDeLote = new JRadioButton("Mantenimiento de Lote");		
		centralPanel.add(rdbtnMantenimientoDeLote, "4, 34, fill, top");
		
		rdbtnGroupServicioVendido.add(rdbtnVentaDeLote);
		rdbtnGroupServicioVendido.add(rdbtnSepelio);
		rdbtnGroupServicioVendido.add(rdbtnFunerario);
		rdbtnGroupServicioVendido.add(rdbtnCremacin);
		rdbtnGroupServicioVendido.add(rdbtnExhumacin);
		rdbtnGroupServicioVendido.add(rdbtnMantenimientoDeLote);
		
		JLabel lblCostoDelLote = new JLabel("Costo del Lote o Servicio");
		centralPanel.add(lblCostoDelLote, "2, 36, left, center");
		
		costoServicioSpinner = new JSpinner(new SpinnerNumberModel());
		costoServicioSpinner.setToolTipText("Costo del Lote o Servicio...");
		costoServicioSpinner.setPreferredSize(dimText);
		costoServicioSpinner.setEnabled(true);
		centralPanel.add(costoServicioSpinner, "4, 36, left, center");		
	
		/*
		 * Limpiar el formulario... 
		 */
		clean();
		
		/***************************************************************************************************
		  Formulario 
		 ***************************************************************************************************/
		
		
		/***************************************************************************************************
		  Catalogo
		 ***************************************************************************************************/		
		JPanel CatalogPanel = new JPanel();
		CatalogPanel.setLayout(new BorderLayout(0, 0));				
		
		JButton btnOeste_1 = new JButton("Oeste");
		CatalogPanel.add(btnOeste_1, BorderLayout.WEST);
		
		JButton btnNorte_1 = new JButton("Norte");
		CatalogPanel.add(btnNorte_1, BorderLayout.NORTH);
		
		JButton btnSur_1 = new JButton("Sur");
		CatalogPanel.add(btnSur_1, BorderLayout.SOUTH);
		
		JButton btnEste_1 = new JButton("Este");
		CatalogPanel.add(btnEste_1, BorderLayout.EAST);
		
		JPanel CentralPanel00 = new JPanel();
		CatalogPanel.add(CentralPanel00, BorderLayout.CENTER);
		CentralPanel00.setLayout(new BorderLayout(0, 0));
		
		JButton btnBotonCentral = new JButton("Boton Central");
		CentralPanel00.add(btnBotonCentral, BorderLayout.CENTER);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane}));
		
		/***************************************************************************************************
		  Agrega el formulario y el catalogo a cada TAB
		 ***************************************************************************************************/
		tabbedPane.addTab("Catálogo", null, CatalogPanel, null);
		tabbedPane.addTab("Facturación", icon,FacturacionPanel,"Proceso Facturación");

	}
	
	
	/**
	 * Obtiene los valores del formulario
	 * @return
	 */
	public Factura getFormValues() {
        obj.setIdFactura(this.getIdFactura());
		obj.setTipofactura(this.getTipoFacturacion());
		obj.setCliente(this.getCliente());
		obj.setContrato(this.getContrato());
		obj.setServicio(this.getServicio());
		obj.setLote(this.getLote());
		obj.setFechaContratacion(new Date());
		obj.setFechaEjecucion(this.getFechaEjecucion());
		obj.setFechaVenta(this.getFecVenta());
		obj.setFechaVence(new Date());
		obj.setCostoServicio(this.getCostoServicio());
		obj.setEstado(null);
		return obj;
	}
	
	/**
	 * 
	 * @return
	 */
	private String getTipoFacturacion(){
		String tipoFactura = null;
		boolean credito = this.rdbtnCredito.isSelected();
		boolean contado = this.rdbtnContado.isSelected();
		if(credito){
			tipoFactura = "C";
			
		}else if(contado){
			tipoFactura = "C";
		}
		
		return tipoFactura;
	}
	
	/**
	 * 
	 * @return
	 */
	private Long getIdFactura() {
		return idFactura;
	}

	/**
	 * 
	 * @param idFactura
	 */
	private void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}	

	/**
	 * 
	 * @return
	 */
	private Long getCliente() {
		String numeroText = txtCliente.getText();
		if(numeroText != null){
			numeroText = numeroText.trim().toString();
			if(!numeroText.equals("")){
				return new Long(numeroText);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param numero
	 */
	private void setCliente(Long numero) {
		if(numero != null){
			this.txtCliente.setText(numero.toString());
		}		
	}

	/**
	 * 
	 * @return
	 */
	private Long getContrato() {		
		String numeroText = txtContrato.getText();
		if(numeroText != null){
			numeroText = numeroText.trim().toString();
			if(!numeroText.equals("")){
				return new Long(numeroText);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param txtContrato
	 */
	private void setContrato(Long numero) {		
		if(numero != null){
			this.txtContrato.setText(numero.toString());
		}
	}

	/**
	 * 
	 * @return
	 */
	private Long getPresolicitud() {		
		String numeroText = txtPresolicitud.getText();
		if(numeroText != null){
			numeroText = numeroText.trim().toString();
			if(!numeroText.equals("")){
				return new Long(numeroText);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param numero
	 */
	private void setPresolicitud(Long numero) {		
		if(numero != null){
			this.txtPresolicitud.setText(numero.toString());
		}
	}

	/**
	 * 
	 * @return
	 */
	private Date getFecVenta() {
		Object obj = fecVentaSpinner.getValue();
		if(obj != null){
			Date objDate = (Date) obj;
			return objDate;
		}
		return null;
	}

	/**
	 * 
	 * @param fecVentaSpinner
	 */
	private void setFecVenta(Date fecVentaSpinner) {
		if(fecVentaSpinner != null){
			this.fecVentaSpinner.setValue(fecVentaSpinner);
		}		
	}

	/**
	 * 
	 * @return
	 */
	private Long getLote() {		
		String numeroText = txtLote.getText();
		if(numeroText != null){
			numeroText = numeroText.trim().toString();
			if(!numeroText.equals("")){
				return new Long(numeroText);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param numero
	 */
	private void setLote(Long numero) {
		if(numero != null){
			this.txtLote.setText(numero.toString());
		}
	}

	/**
	 * 
	 * @return
	 */
	private String getNicho() {
		String texto = this.txtNicho.getText();
		if(texto != null){
			texto = texto.trim().toString();
			if(!texto.equals("")){
				return texto;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param txtNicho
	 */
	private void setNicho(String texto) {
		if(texto != null){
			texto = texto.trim();
			if(!texto.equals("")){
				this.txtNicho.setText(texto);
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	private Date getFechaEjecucion() {
		Object obj = fechaEjecucionSpinner.getValue();
		if(obj != null){
			Date fecha = (Date) obj;
			return fecha;
		}
		return null;
	}

	/**
	 * 
	 * @param fecha
	 */
	private void setFechaEjecucion(Date fecha) {		
		if(fecha != null){
			this.fechaEjecucionSpinner.setValue(fecha);
		}
	}

	
	/**
	 * 
	 * @return
	 */
	private Long getServicio(){
		if(this.rdbtnVentaDeLote.isSelected()){
			return new Long(2);// Mantenimiento de Lote
			
		} else if(this.rdbtnSepelio.isSelected()){
			return new Long(4);// Sepelio
			
		}else if(this.rdbtnFunerario.isSelected()){
			return new Long(5);// Servicios Funerarios
			
		}else if(this.rdbtnCremacin.isSelected()){
			return new Long(6);// Cremacion
			
		}else if(this.rdbtnExhumacin.isSelected()){
			return new Long(8);// Exhumacion
			
		}else if(this.rdbtnMantenimientoDeLote.isSelected()){
			return new Long(2);// Mantenimiento de Lote
		}		
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	private BigDecimal getCostoServicio() {		
		Object obj = this.costoServicioSpinner.getValue();				
		if(obj != null){
			BigDecimal costo = new BigDecimal(obj.toString());
			return costo;			
		}
		
		return null;
	}

	/**
	 * 
	 * @param costo
	 */
	private void setCostoServicio(BigDecimal costo) {
		if(costo != null){
			this.costoServicioSpinner.setValue(costo);
		}		
	}
	
	/**
	 * Lipia el formulario
	 */
	private void clean(){
		this.idFactura = null;
		this.rdbtnCredito.setSelected(true);
		this.txtCliente.setText("");
		this.txtContrato.setText("");
		this.txtPresolicitud.setText("");
		this.fecVentaSpinner.setValue(new Date());
		this.txtLote.setText("");
		this.txtNicho.setText("");
		this.fechaEjecucionSpinner.setValue(new Date());
		this.rdbtnVentaDeLote.setSelected(true);
		this.costoServicioSpinner.setValue(new BigDecimal("0"));
	}
	
	/**
	 * 
	 * @param obj
	 * @return boolean
	 */
	private boolean validaciones(Factura obj) {
		
		String tipofactura = obj.getTipofactura();		
		if(tipofactura == null || tipofactura.trim().equals("")){
			JOptionPane.showMessageDialog(this, "Debe seleccionar, Tipo de Factura!", "alert", JOptionPane.WARNING_MESSAGE);
			this.rdbtnCredito.setSelected(true);
			return false;
		}
		
		Long cliente = obj.getCliente();
		if(cliente == null || tipofactura.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Cliente!", "alert", JOptionPane.WARNING_MESSAGE);
			this.txtCliente.requestFocus();
			return false;
		}
		
		Long contrato = obj.getContrato();
		if(contrato == null || contrato.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Contrato!", "alert", JOptionPane.WARNING_MESSAGE);
			this.txtContrato.requestFocus();
			return false;
		}
		
		Long presolicitud = this.getPresolicitud();
		if(presolicitud == null || presolicitud.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Pre-Solicitud!", "alert", JOptionPane.WARNING_MESSAGE);
			this.txtPresolicitud.requestFocus();
			return false;
		}
		
		Date fecVenta = this.getFecVenta();
		if(fecVenta == null || fecVenta.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Fec. Venta!", "alert", JOptionPane.WARNING_MESSAGE);
			this.fecVentaSpinner.requestFocus();
			return false;
		}
		
		Long lote = this.getLote();
		if(lote == null || lote.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Lote!", "alert", JOptionPane.WARNING_MESSAGE);
			this.txtLote.requestFocus();
			return false;
		}
		
		String nicho = this.getNicho();
		if(nicho == null || nicho.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Nicho!", "alert", JOptionPane.WARNING_MESSAGE);
			this.txtNicho.requestFocus();
			return false;
		}
		
		Date fecEjecucion = this.getFechaEjecucion();
		if(fecEjecucion == null || fecEjecucion.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Fecha Ejecución!", "alert", JOptionPane.WARNING_MESSAGE);
			this.fechaEjecucionSpinner.requestFocus();
			return false;
		}
		
		Long servicio = this.getServicio();
		if(servicio == null || servicio.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Servicio Vendido!", "alert", JOptionPane.WARNING_MESSAGE);
			this.rdbtnVentaDeLote.setSelected(true);
			return false;
		}
		
		BigDecimal costoServicio = this.getCostoServicio();
		if(costoServicio == null || costoServicio.toString().trim().equals("") || costoServicio.compareTo(new BigDecimal("0")) == 0){			
			JOptionPane.showMessageDialog(this, "Debe digitar, Costo del Lote o Servicio!", "alert", JOptionPane.WARNING_MESSAGE);
			this.costoServicioSpinner.requestFocus();
			return false;
			
		} else if(costoServicio.compareTo(new BigDecimal("0")) == -1){			
			JOptionPane.showMessageDialog(this, "Costo del Lote o Servicio, debe ser mayor a 0!", "alert", JOptionPane.WARNING_MESSAGE);
			this.costoServicioSpinner.requestFocus();
			return false;
		}
		
		return true;
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
}
