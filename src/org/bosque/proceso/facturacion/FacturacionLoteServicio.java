package org.bosque.proceso.facturacion;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.TitledBorder;

import org.bosque.model.bean.Cliente;
import org.bosque.model.bean.Factura;
import org.bosque.utils.ComboCliente;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import com.toedter.calendar.JDateChooser;
import java.util.Locale;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FacturacionLoteServicio extends JPanel {
	
	private Long idFactura;
	private JRadioButton rdbtnCredito;
	private JRadioButton rdbtnContado;
	public JComboBox clienteComboBox;
	public JTextField txtPlazo;
	private JRadioButton rdbtnVVijente;
	private JRadioButton rdbtnAAnulada;
	public JDateChooser fecFacturaChooser;
	private JLabel lblCostoDelLote;

	/**
	 * Create the panel.
	 */
	public FacturacionLoteServicio() {
		setBorder(new TitledBorder(null, "Facturaci\u00F3n de  Lotes o Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		Dimension dimLabel = new Dimension(200, 20);
		Dimension dimText = new Dimension(200, 20);
		
		ButtonGroup rdbtnGroupTipoFacturacion = new ButtonGroup();
		
		JLabel lblTipoDeFacturacin = new JLabel("Tipo de Facturaci\u00F3n");
		add(lblTipoDeFacturacin, "10, 4");
		
		rdbtnCredito = new JRadioButton("Credito");
		rdbtnCredito.setSelected(true);
		add(rdbtnCredito, "12, 4");
		
		rdbtnGroupTipoFacturacion.add(rdbtnCredito);
		
		rdbtnContado = new JRadioButton("Contado");
		add(rdbtnContado, "12, 6");
		rdbtnGroupTipoFacturacion.add(rdbtnContado);
		
		JLabel lblFechaFactura = new JLabel("Fecha Factura");
		add(lblFechaFactura, "10, 8");
		
		ComboCliente comboCliente = new ComboCliente();
		
		
		fecFacturaChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');		
		fecFacturaChooser.setAutoscrolls(true);
		fecFacturaChooser.setLocale(new Locale("es", "CR"));		
		fecFacturaChooser.setMinimumSize(dimText);
		fecFacturaChooser.setPreferredSize(dimText);
		fecFacturaChooser.setMaximumSize(dimText);
		fecFacturaChooser.setSize(dimText);
		fecFacturaChooser.getJCalendar().setTodayButtonVisible(true);
		fecFacturaChooser.getJCalendar().setTodayButtonText("Hoy");			
		fecFacturaChooser.getJCalendar().setWeekOfYearVisible(false);		
		add(fecFacturaChooser, "12, 8, fill, fill");
		
		JLabel lblCliente = new JLabel("Cliente");
		add(lblCliente, "10, 10, right, default");
		clienteComboBox = new JComboBox(comboCliente.getList().toArray());
		clienteComboBox.setPreferredSize(dimText);
		add(clienteComboBox, "12, 10, fill, default");
		
		JLabel lblPlazomeses = new JLabel("Plazo (meses):");
		add(lblPlazomeses, "10, 12, right, default");
		
		ButtonGroup rdbtnGroupEstadoFactura = new ButtonGroup();
		
		txtPlazo = new JTextField();
		txtPlazo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
			    char c = ke.getKeyChar();
    	        if(Character.isLetter(c) || !Character.isDigit(c)) {
    	        	getToolkit().beep();
		            ke.consume();
		            mensage("Solo debe digitar numeros!");
		            txtPlazo.requestFocus();
    	        }
			}
		});
		txtPlazo.setPreferredSize(dimText);
		add(txtPlazo, "12, 12, fill, default");
		txtPlazo.setColumns(10);
		
		JLabel lblEstadoDeLa = new JLabel("Estado de la Factura");
		add(lblEstadoDeLa, "10, 14");
		rdbtnVVijente = new JRadioButton("Vigente");
		rdbtnVVijente.setSelected(true);
		add(rdbtnVVijente, "12, 14");
		
		rdbtnGroupEstadoFactura.add(rdbtnVVijente);
		
		rdbtnAAnulada = new JRadioButton("Anulada");
		add(rdbtnAAnulada, "12, 16");
		rdbtnGroupEstadoFactura.add(rdbtnAAnulada);
		
		lblCostoDelLote = new JLabel("********************");//25 espacios en blanco
		add(lblCostoDelLote, "10, 18");
		
		limpiar();

	}
	
	/**
	 * Obtiene los valores del formulario
	 * @return
	 */
	public Factura getFormValues() {
		Factura obj = new Factura();
		obj.setIdFactura(this.getIdFactura());
		obj.setTipofactura(this.getTipofactura());
		obj.setCliente(this.getClienteComboBox());
		
		//obj.setAgente(agente);
		obj.setFecFactura(this.getFecFactura());		
		obj.setMesesPlazo(this.getTxtPlazo());
		obj.setEstadoFactura(this.getEstado());
		return obj;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public void setFormValues(Factura obj) {
		this.limpiar();
		this.setIdFactura(obj.getIdFactura());
		this.setTipofactura(obj.getTipofactura());
		this.setFecFacturaSpinner(obj.getFecFactura());
		this.setClienteComboBox(obj.getCliente());
		this.setTxtPlazo(obj.getMesesPlazo());
		this.setEstado(obj.getEstadoFactura());
	}
	
	/**
	 * Lipia el formulario
	 */
	public void limpiar(){
		this.idFactura = null;
		this.rdbtnCredito.setSelected(true);
		this.rdbtnContado.setSelected(false);
		this.clienteComboBox.setSelectedIndex(-1);
		this.txtPlazo.setText("0");
		this.rdbtnVVijente.setSelected(true);
		this.rdbtnAAnulada.setSelected(false);
	}

	/**
	 * @return the idFactura
	 */
	public Long getIdFactura() {
		return idFactura;
	}

	/**
	 * @param idFactura the idFactura to set
	 */
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getTipofactura(){
		String tipoFactura = null;
		boolean credito = this.rdbtnCredito.isSelected();
		boolean contado = this.rdbtnContado.isSelected();
		if(credito){
			tipoFactura = "CR";
			
		}else if(contado){
			tipoFactura = "CO";
		}
		
		return tipoFactura;
	}
	
	/**
	 * 
	 * @param tipoFactura
	 */
	public void setTipofactura(String tipoFactura){
		
		this.rdbtnCredito.setSelected(false);
		this.rdbtnContado.setSelected(false);
		
		if(tipoFactura != null){
			tipoFactura = tipoFactura.trim().toString();
			if(tipoFactura.endsWith("CR")){
				this.rdbtnCredito.setSelected(true);
				
			}else if(tipoFactura.endsWith("C0")){
				this.rdbtnContado.setSelected(true);
			}
			
		}else{
			this.rdbtnCredito.setSelected(true);
		}
				
	}
	

	/**
	 * @return the fecFacturaSpinner
	 */
	public Date getFecFactura() {
		Date obj = fecFacturaChooser.getDate();
		if(obj != null){
			Date fecha = (Date) obj;
			return fecha;
		}
		return null;		
	}

	/**
	 * @param fecFacturaSpinner the fecFacturaSpinner to set
	 */
	public void setFecFacturaSpinner(Date fecha) {		
		if(fecha != null){
			this.fecFacturaChooser.setDate(fecha);
		}
	}

	/**
	 * @return the clienteComboBox
	 */
	public Cliente getClienteComboBox() {
		Cliente obj = (Cliente) clienteComboBox.getSelectedItem();
		if(obj != null){
			return obj;
		}
		
		return null;
	}

	/**
	 * @param clienteComboBox the clienteComboBox to set
	 */
	public void setClienteComboBox(Cliente obj) {
		if(obj != null){
			Long id = obj.getId();
			Cliente item;
	        for (int i = 0; i < this.clienteComboBox.getItemCount(); i++){
	            item = (Cliente)this.clienteComboBox.getItemAt(i);
	            if (item.getId() == id){
	            	this.clienteComboBox.setSelectedIndex(i);
	                break;
	            }
	        }			
		}else{
			this.clienteComboBox.setSelectedIndex(-1);
		}		
	}

	/**
	 * @return the txtPlazo
	 */
	public Long getTxtPlazo() {
		
		String objTXT = txtPlazo.getText();
		if(objTXT != null && !objTXT.trim().equals("")){
			Long numero = new Long(objTXT);
			return numero;
		}
		
		return null;
	}

	/**
	 * @param txtPlazo the txtPlazo to set
	 */
	public void setTxtPlazo(Long numero) {
		if(numero != null){
			this.txtPlazo.setText(numero.toString());
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEstado(){
		
		if(this.rdbtnVVijente.isSelected()){
			return "V";
			
		}else if(this.rdbtnAAnulada.isSelected()){
			return "A";
			
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param estado
	 */
	public void setEstado(String estado){
		if(estado != null && !estado.equals("")){
			estado = estado.trim().toString();
			if(estado.equalsIgnoreCase("V")){
				this.rdbtnVVijente.setSelected(true);
				this.rdbtnAAnulada.setSelected(false);
				
			}else if(estado.equalsIgnoreCase("A")){
				this.rdbtnVVijente.setSelected(false);
				this.rdbtnAAnulada.setSelected(true);
				
			}else{
				this.rdbtnVVijente.setSelected(false);
				this.rdbtnAAnulada.setSelected(false);
			}
			
		}else{
			this.rdbtnVVijente.setSelected(false);
			this.rdbtnAAnulada.setSelected(false);
		}
	}
	
	/**
	 * 
	 * @param msg
	 */
	public void mensage(String msg){
		JOptionPane.showMessageDialog(this, msg, "Alerta", JOptionPane.WARNING_MESSAGE);    
	}

}
