package org.bosque.proceso.facturacion;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.TitledBorder;
import org.bosque.model.bean.Agente;
import org.bosque.model.bean.Concepto;
import org.bosque.model.bean.Lote;
import org.bosque.model.bean.Persona;
import org.bosque.model.bean.Servicio;
import org.bosque.utils.ComboAgente;
import org.bosque.utils.ComboConcepto;
import org.bosque.utils.ComboLote;
import org.bosque.utils.ComboPersona;
import java.awt.Color;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;

public class InformacionServicio extends JPanel {
	
	private JSpinner noServicioSpinner;
	public JComboBox beneficiarioComboBox;
	public JComboBox loteComboBox;
	public JTextField textZona;
	public JTextField textFila;
	public JSpinner secuenciaSpinner;
	private JRadioButton rdbtnSuperior;
	private JRadioButton rdbtnInferior;
	private JCheckBox chckbxEsTrasladosn;
	public JComboBox conceptoComboBox;
	public JComboBox agenteComboBox;
	public JSpinner contratoSpinner;
	public JSpinner preSolicitudSpinner;
	public JDateChooser fecVentaChooser;
	public JDateChooser fechaEjecucionChooser;
	public JFormattedTextField costoLoteServicio;
	

	/**
	 * Create the panel.
	 */
	public InformacionServicio() {
		setBorder(new TitledBorder(null, "Informaci\u00F3n del Servicio", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
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
				ColumnSpec.decode("max(72dlu;default)"),
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
		
		Dimension dimText = new Dimension(200, 20);
		
		JLabel lblNoServicio = new JLabel("No. Servicio");
		add(lblNoServicio, "10, 4");
		
		ComboPersona comboPersona = new ComboPersona();
		
		noServicioSpinner = new JSpinner(new SpinnerNumberModel());
		noServicioSpinner.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
    	        if(Character.isLetter(c) || !Character.isDigit(c)) {
    	        	getToolkit().beep();
		            ke.consume();
		            mensage("Solo debe digitar numeros!");
		            noServicioSpinner.requestFocus();
    	        }
			}
		});
		noServicioSpinner.setMinimumSize(dimText);
		noServicioSpinner.setMaximumSize(dimText);
		noServicioSpinner.setPreferredSize(dimText);
		noServicioSpinner.setEnabled(false);
		add(noServicioSpinner, "12, 4, fill, default");
		
		JLabel lblBeneficiario = new JLabel("Beneficiario");
		add(lblBeneficiario, "10, 6, right, default");
		beneficiarioComboBox = new JComboBox(comboPersona.getList().toArray());
		beneficiarioComboBox.setMinimumSize(dimText);
		beneficiarioComboBox.setMaximumSize(dimText);
		beneficiarioComboBox.setPreferredSize(dimText);
		add(beneficiarioComboBox, "12, 6, fill, default");
		
		JLabel lblContrato = new JLabel("Contrato");
		add(lblContrato, "10, 8, right, default");
		
		contratoSpinner = new JSpinner(new SpinnerNumberModel());
		contratoSpinner.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
    	        if(Character.isLetter(c) || !Character.isDigit(c)) {
    	        	getToolkit().beep();
		            ke.consume();
		            mensage("Solo debe digitar numeros!");
		            contratoSpinner.requestFocus();
    	        }
			}
		});
		contratoSpinner.setPreferredSize(new Dimension(200, 20));
		contratoSpinner.setMinimumSize(new Dimension(200, 20));
		contratoSpinner.setMaximumSize(new Dimension(200, 20));
		add(contratoSpinner, "12, 8");
		
		JLabel lblPresolicitud = new JLabel("Pre-Solicitud");
		add(lblPresolicitud, "10, 10, right, default");
		
		preSolicitudSpinner = new JSpinner(new SpinnerNumberModel());
		preSolicitudSpinner.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
    	        if(Character.isLetter(c) || !Character.isDigit(c)) {
    	        	getToolkit().beep();
		            ke.consume();
		            mensage("Solo debe digitar numeros!");
		            preSolicitudSpinner.requestFocus();
    	        }
			}
		});
		preSolicitudSpinner.setPreferredSize(new Dimension(200, 20));
		preSolicitudSpinner.setMinimumSize(new Dimension(200, 20));
		preSolicitudSpinner.setMaximumSize(new Dimension(200, 20));
		add(preSolicitudSpinner, "12, 10");
		
		JLabel lblFecventa = new JLabel("Fec.Venta");
		add(lblFecventa, "10, 12");
		
		fecVentaChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		fecVentaChooser.setAutoscrolls(true);
		fecVentaChooser.setLocale(new Locale("es", "CR"));		
		fecVentaChooser.setMinimumSize(dimText);
		fecVentaChooser.setPreferredSize(dimText);
		fecVentaChooser.setMaximumSize(dimText);
		fecVentaChooser.setSize(dimText);
		fecVentaChooser.getJCalendar().setTodayButtonVisible(true);
		fecVentaChooser.getJCalendar().setTodayButtonText("Hoy");			
		fecVentaChooser.getJCalendar().setWeekOfYearVisible(false);
		add(fecVentaChooser, "12, 12, fill, fill");
		
		ComboLote comboLote = new ComboLote();
		
		JLabel lblLote = new JLabel("Lote:");
		add(lblLote, "10, 14, right, default");
		loteComboBox = new JComboBox(comboLote.getList().toArray());
		loteComboBox.setMinimumSize(dimText);
		loteComboBox.setMaximumSize(dimText);		
		loteComboBox.setPreferredSize(dimText);
		add(loteComboBox, "12, 14, fill, default");
		
		JLabel lblZona = new JLabel("Zona");
		add(lblZona, "10, 16, right, default");
		
		textZona = new JTextField();
		textZona.setMinimumSize(dimText);
		textZona.setMaximumSize(dimText);		
		textZona.setPreferredSize(dimText);
		add(textZona, "12, 16, fill, default");
		textZona.setColumns(10);
		
		JLabel lblFila = new JLabel("Fila");
		add(lblFila, "10, 18, right, default");
		
		textFila = new JTextField();
		textFila.setMinimumSize(dimText);
		textFila.setMaximumSize(dimText);
		textFila.setPreferredSize(dimText);
		add(textFila, "12, 18, fill, default");
		textFila.setColumns(10);
		
		JLabel lblSecuencia = new JLabel("Secuencia");
		add(lblSecuencia, "10, 20");
		
		secuenciaSpinner = new JSpinner(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		secuenciaSpinner.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
    	        if(Character.isLetter(c) || !Character.isDigit(c)) {
    	        	getToolkit().beep();
		            ke.consume();
		            mensage("Solo debe digitar numeros!");
		            secuenciaSpinner.requestFocus();
    	        }				
			}
		});
		secuenciaSpinner.setMinimumSize(dimText);
		secuenciaSpinner.setMaximumSize(dimText);
		secuenciaSpinner.setPreferredSize(dimText);
		add(secuenciaSpinner, "12, 20, fill, default");
		
		JLabel lblNicho = new JLabel("Nicho");
		add(lblNicho, "10, 22");
		
		ButtonGroup rdbtnGroupNicho = new ButtonGroup();
		
		rdbtnSuperior = new JRadioButton("Superior");
		rdbtnSuperior.setPreferredSize(dimText);
		rdbtnGroupNicho.add(rdbtnSuperior);
		add(rdbtnSuperior, "12, 22");
		
		rdbtnInferior = new JRadioButton("Inferior");
		rdbtnInferior.setSelected(true);
		rdbtnInferior.setPreferredSize(dimText);
		rdbtnGroupNicho.add(rdbtnInferior);
		add(rdbtnInferior, "12, 24");
		
		chckbxEsTrasladosn = new JCheckBox("Es Traslado (S/N)");
		chckbxEsTrasladosn.setPreferredSize(dimText);
		add(chckbxEsTrasladosn, "12, 26");
		
		JLabel lblFechaEjecucin = new JLabel("Fecha Ejecuci\u00F3n:");
		add(lblFechaEjecucin, "10, 28");
		
		fechaEjecucionChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');		
		fechaEjecucionChooser.setAutoscrolls(true);
		fechaEjecucionChooser.setLocale(new Locale("es", "CR"));		
		fechaEjecucionChooser.setMinimumSize(dimText);
		fechaEjecucionChooser.setPreferredSize(dimText);
		fechaEjecucionChooser.setMaximumSize(dimText);
		fechaEjecucionChooser.setSize(dimText);
		fechaEjecucionChooser.getJCalendar().setTodayButtonVisible(true);
		fechaEjecucionChooser.getJCalendar().setTodayButtonText("Hoy");			
		fechaEjecucionChooser.getJCalendar().setWeekOfYearVisible(false);
		add(fechaEjecucionChooser, "12, 28, fill, fill");
		
		ComboConcepto comboConcepto = new ComboConcepto();
		
		JLabel lblConcepto = new JLabel("Concepto");
		add(lblConcepto, "10, 30, right, default");
		conceptoComboBox = new JComboBox(comboConcepto.getList().toArray());
		conceptoComboBox.setMinimumSize(dimText);
		conceptoComboBox.setMaximumSize(dimText);
		conceptoComboBox.setPreferredSize(dimText);
		add(conceptoComboBox, "12, 30, fill, default");
		
		ComboAgente comboAgente = new ComboAgente();
		
		JLabel lblAgente = new JLabel("Agente");
		add(lblAgente, "10, 32, right, default");
		agenteComboBox = new JComboBox(comboAgente.getList().toArray());
		agenteComboBox.setMinimumSize(dimText);
		agenteComboBox.setMaximumSize(dimText);
		agenteComboBox.setPreferredSize(dimText);
		add(agenteComboBox, "12, 32, fill, default");
		
		Locale inLocale = new Locale("es", "CR");
		NumberFormat formateador =  DecimalFormat.getCurrencyInstance(inLocale); 
		
		JLabel lblCostoDelLote = new JLabel("Costo del Lote o Servicio");
		add(lblCostoDelLote, "10, 34, right, default");
		costoLoteServicio = new JFormattedTextField(formateador);		
		costoLoteServicio.setLocale(inLocale);
		costoLoteServicio.setFocusLostBehavior(JFormattedTextField.COMMIT);
		costoLoteServicio.setForeground(Color.BLUE);        
		costoLoteServicio.setMinimumSize(dimText);
		costoLoteServicio.setMaximumSize(dimText);
		costoLoteServicio.setPreferredSize(dimText);
		costoLoteServicio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char tecla;
				tecla = evt.getKeyChar();
				String cod = costoLoteServicio.getText();
				int punto = cod.indexOf(".")+1;
				
				if(punto == 0){
					if(!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_PERIOD){
						getToolkit().beep();// emite sonido
						evt.consume();
			            //mensage("Solo debe digitar numeros, o un punto para los decimales!");
			            costoLoteServicio.requestFocus();
					}
				}else{
					if(!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE){
						getToolkit().beep();// emite sonido
						evt.consume();
			            //mensage("Solo debe digitar numeros, o un punto para los decimales!");
			            costoLoteServicio.requestFocus();
					}
				}
			}
		});
		add(costoLoteServicio, "12, 34, fill, default");
		
		limpiar();
	}
	
	
	/**
	 * Obtiene los valores del formulario
	 * @return
	 */
	public Servicio getFormValues() {		
		Servicio obj = new Servicio();
		obj.setServicio(this.getNoServicioSpinner());
		obj.setPersona(this.getBeneficiarioComboBox());
		obj.setContrato(this.getTextContrato());
		obj.setPreSolicitud(this.getPreSolicitud());
		//this.setFecVenta(obj.getFecEjecucion());
		
		obj.setLote(this.getLoteComboBox());		
		/*
		lote.setZona(this.getTextZona());
		lote.setFila(this.getTextFila());
		lote.setSecuencia(this.getSecuenciaSpinner());
		*/
		
		obj.setNicho(this.getNicho());		
		obj.setIndTraslado(this.getEsTraslado());
		obj.setFecEjecucion(this.getFechaEjecucion());
		obj.setConcepto(this.getConceptoComboBox());
		obj.setAgente(this.getAgenteComboBox());
		obj.setCostoServicio(this.getCostoLoteServicio());
		return obj;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public void setFormValues(Servicio obj) {
		this.limpiar();
		this.setNoServicioSpinner(obj.getServicio());
		this.setBeneficiarioComboBox(obj.getPersona());
		this.setContrato(obj.getContrato());
		this.setPreSolicitud(obj.getPreSolicitud());
		//this.setFecVentaSpinner(obj.getf);
		this.setLoteComboBox(obj.getLote());
		
		if(obj.getLote() != null){
			this.setLoteComboBox(obj.getLote());
			this.setTextZona(obj.getLote().getZona());
			this.setTextFila(obj.getLote().getFila());
			this.setSecuenciaSpinner(obj.getLote().getSecuencia());
		}
		
		this.setNicho(obj.getNicho());		
		this.setEsTraslado(obj.getIndTraslado());
		this.setFechaEjecucion(obj.getFecEjecucion());
		this.setConceptoComboBox(obj.getConcepto());
		this.setAgenteComboBox(obj.getAgente());
		this.setCostoLoteServicio(obj.getCostoServicio());
		
	}


	/**
	 * 
	 */
	public void limpiar() {
		this.noServicioSpinner.setValue(new Long(0));
		this.beneficiarioComboBox.setSelectedIndex(-1);
		this.contratoSpinner.setValue(new Long(0));
		this.preSolicitudSpinner.setValue(new Long(0));
		this.fecVentaChooser.setDate(new Date());
		this.loteComboBox.setSelectedIndex(-1);
		this.textZona.setText("");
		this.textFila.setText("");
		this.secuenciaSpinner.setValue(new Long(0));
		this.rdbtnSuperior.setSelected(false);
		this.rdbtnInferior.setSelected(false);
		this.chckbxEsTrasladosn.setSelected(false);
		this.fechaEjecucionChooser.setDate(new Date());;
		this.conceptoComboBox.setSelectedIndex(-1);
		this.agenteComboBox.setSelectedIndex(-1);
		this.costoLoteServicio.setText(new BigDecimal(0).toString());		
	}


	/**
	 * @return the noServicioSpinner
	 */
	public Long getNoServicioSpinner() {
		Object obj = noServicioSpinner.getValue();
		if(obj != null){
			Long numero = new Long(obj.toString());
			return numero;
		}
		return null;
	}


	/**
	 * @param noServicioSpinner the noServicioSpinner to set
	 */
	public void setNoServicioSpinner(Long numero) {
		if(numero != null){
			this.noServicioSpinner.setValue(numero);
			
		}else{
			this.noServicioSpinner.setValue(new Long(0));
		}
		
	}


	/**
	 * @return the beneficiarioComboBox
	 */
	public Persona getBeneficiarioComboBox() {		
		Object item = beneficiarioComboBox.getSelectedItem();
		if(item != null){
			Persona obj = (Persona)item;
			return obj;
			
		}
		
		return null;
	}


	/**
	 * @param beneficiarioComboBox the beneficiarioComboBox to set
	 */
	public void setBeneficiarioComboBox(Persona obj) {
		if(obj != null){
			Long id = obj.getPersona();
			Persona item;
	        for (int i = 0; i < this.beneficiarioComboBox.getItemCount(); i++){
	            item = (Persona)this.beneficiarioComboBox.getItemAt(i);
	            if (item.getPersona() == id){
	            	this.beneficiarioComboBox.setSelectedIndex(i);
	                break;
	            }
	        }			
		}else{
			this.beneficiarioComboBox.setSelectedIndex(-1);
		}
	}


	/**
	 * @return the textContrato
	 */
	public Long getTextContrato() {		
		Object obj = contratoSpinner.getValue();
		if(obj != null){
			Long numero = new Long(obj.toString());
			return numero;
			
		}
		
		return null;
	}


	/**
	 * @param textContrato the textContrato to set
	 */
	public void setContrato(Long numero) {		 
		if(numero != null && !numero.toString().trim().equals("")){			
			this.contratoSpinner.setValue(numero);
			
		}else{
			this.contratoSpinner.setValue(new Long(0));
		}
	}


	/**
	 * @return the textPreSolicitud
	 */
	public Long getPreSolicitud() {		
		Object obj = this.preSolicitudSpinner.getValue();
		if(obj != null){			
			Long numero = new Long(obj.toString());
			return numero;
		}
		
		return null;
	}


	/**
	 * @param textPreSolicitud the textPreSolicitud to set
	 */
	public void setPreSolicitud(Long numero) {		
		if(numero != null){			
			this.preSolicitudSpinner.setValue(numero);
			
		}else{
			this.preSolicitudSpinner.setValue(new Long(0));
		}
	}


	/**
	 * @return the fecVentaSpinner
	 */
	public Date getFecVenta() {
		Date obj = this.fecVentaChooser.getDate();
		if(obj != null){
			Date fecha = (Date)obj;
		}
		
		return null;
	}


	/**
	 * @param fecVentaSpinner the fecVentaSpinner to set
	 */
	public void setFecVenta(Date fecha) {
		if(fecha != null){
			this.fecVentaChooser.setDate(fecha);
		}else{
			this.fecVentaChooser.setDate(new Date());
		}		 
	}


	/**
	 * @return the loteComboBox
	 */
	public Lote getLoteComboBox() {
		Object item = loteComboBox.getSelectedItem();
		if(item != null){
			Lote obj = (Lote)item;
			return obj;
			
		}
		
		return null;
	}


	/**
	 * @param loteComboBox the loteComboBox to set
	 */
	public void setLoteComboBox(Lote obj) {
		if(obj != null){
			Long id = obj.getLote();
			Lote item;
	        for (int i = 0; i < this.loteComboBox.getItemCount(); i++){
	            item = (Lote)this.loteComboBox.getItemAt(i);
	            if (item.getLote() == id){
	            	this.loteComboBox.setSelectedIndex(i);
	                break;
	            }
	        }			
		}else{
			this.loteComboBox.setSelectedIndex(-1);
		}				
	}


	/**
	 * @return the textZona
	 */
	public String getTextZona() {		
		String texto = textZona.getText();
		if(texto != null && !texto.trim().equals("")){
			texto = texto.trim();
			return texto;
			
		}
		
		return null;
	}


	/**
	 * @param textZona the textZona to set
	 */
	public void setTextZona(String texto) {		
		if(texto != null && !texto.trim().equals("")){
			texto = texto.trim();
			this.textZona.setText(texto);
			
		}else{
			this.textZona.setText("");
		}
	}


	/**
	 * @return the textFila
	 */
	public String getTextFila() {
		String texto = textFila.getText();
		if(texto != null && !texto.trim().equals("")){
			texto = texto.trim();
			return texto;
			
		}
		
		return null;
	}


	/**
	 * @param textFila the textFila to set
	 */
	public void setTextFila(String texto) {
		if(texto != null && !texto.trim().equals("")){
			texto = texto.trim();
			this.textFila.setText(texto);
			
		}else{
			this.textFila.setText("");
		}
		
	}


	/**
	 * @return the secuenciaSpinner
	 */
	public Long getSecuenciaSpinner() {
		Object obj = this.secuenciaSpinner.getValue();
		if(obj != null){
			Long numero = new Long(obj.toString());
			return numero;
		}
		
		return null;
	}


	/**
	 * @param secuenciaSpinner the secuenciaSpinner to set
	 */
	public void setSecuenciaSpinner(Long numero) {
		if(numero != null){
			this.secuenciaSpinner.setValue(numero);
			
		}else{
			this.secuenciaSpinner.setValue(new Long(0));
		}
		
	}

	
	public String getNicho(){
		if(rdbtnSuperior.isSelected()){
			return "S";
			
		} else if(rdbtnInferior.isSelected()){
			return "I";
			
		}else{
			return null;
		}		
		
	}
	
	public void setNicho(String letra){
		if(letra != null && !letra.trim().equals("")){
			letra = letra.trim();
			if(letra.equalsIgnoreCase("S")){
				rdbtnSuperior.setSelected(true);
				rdbtnInferior.setSelected(false);
				
			}else if(letra.equalsIgnoreCase("I")){
				rdbtnSuperior.setSelected(false);
				rdbtnInferior.setSelected(true);
				
			}else{
				rdbtnSuperior.setSelected(false);
				rdbtnInferior.setSelected(false);
			}
			
		}else{
			rdbtnSuperior.setSelected(false);
			rdbtnInferior.setSelected(false);
		}		
	}	


	/**
	 * @return the chckbxEsTrasladosn
	 */
	public String getEsTraslado() {
		boolean isTrue = chckbxEsTrasladosn.isSelected();
		if(isTrue){
			return "S"; 
		}else{
			return "N";
		}		
	}


	/**
	 * @param chckbxEsTrasladosn the chckbxEsTrasladosn to set
	 */
	public void setEsTraslado(String letra) {
		
		if(letra != null && !letra.trim().equals("")){
			letra = letra.trim();
			if(letra.equalsIgnoreCase("S")){
				chckbxEsTrasladosn.setSelected(true);
			}else{
				chckbxEsTrasladosn.setSelected(false);
			}			 
		}else{
			chckbxEsTrasladosn.setSelected(false);
		}		
	}


	/**
	 * @return the fechaEjecucionSpinner
	 */
	public Date getFechaEjecucion() {
		Date obj = fechaEjecucionChooser.getDate();
		if(obj != null){
			Date fecha = (Date) obj;
			return fecha;
		}
		
		return null;
	}


	/**
	 * @param fechaEjecucionSpinner the fechaEjecucionSpinner to set
	 */
	public void setFechaEjecucion(Date fecha) {
		if(fecha != null){
			this.fechaEjecucionChooser.setDate(fecha);
		}		
	}


	/**
	 * @return the conceptoComboBox
	 */
	public Concepto getConceptoComboBox() {
		Object item = conceptoComboBox.getSelectedItem();
		if(item != null){
			Concepto obj = (Concepto) item;
			return obj;
			
		}
		
		return null;		
	}


	/**
	 * @param conceptoComboBox the conceptoComboBox to set
	 */
	public void setConceptoComboBox(Concepto obj) {
		if(obj != null){
			Long id = obj.getConcepto();
			Concepto item;
	        for (int i = 0; i < this.conceptoComboBox.getItemCount(); i++){
	            item = (Concepto)this.conceptoComboBox.getItemAt(i);
	            if (item.getConcepto() == id){
	            	this.conceptoComboBox.setSelectedIndex(i);
	                break;
	            }
	        }			
		}else{
			this.conceptoComboBox.setSelectedIndex(-1);
		}		
	}


	/**
	 * @return the agenteComboBox
	 */
	public Agente getAgenteComboBox() {
		Object item = agenteComboBox.getSelectedItem();
		if(item != null){
			Agente obj = (Agente) item;
			return obj;
			
		}
		
		return null;
	}


	/**
	 * @param agenteComboBox the agenteComboBox to set
	 */
	public void setAgenteComboBox(Agente obj) {
		if(obj != null){
			Long id = obj.getAgente();
			Agente item;
	        for (int i = 0; i < this.agenteComboBox.getItemCount(); i++){
	            item = (Agente)this.agenteComboBox.getItemAt(i);
	            if (item.getAgente() == id){
	            	this.agenteComboBox.setSelectedIndex(i);
	                break;
	            }
	        }			
		}else{
			this.agenteComboBox.setSelectedIndex(-1);
		}
	}


	/**
	 * @return the costoLoteServicioSpinner
	 */
	public BigDecimal getCostoLoteServicio() {
		Object obj = costoLoteServicio.getText();
		if(obj != null){
			String objS = obj.toString();
			if(objS != null && !objS.trim().toString().equals("")){
				objS = objS.replace(",", "");				
				BigDecimal objB = new BigDecimal(objS);
				return objB;
			}			
		}
		
		return null;
	}


	/**
	 * @param costoLoteServicioSpinner the costoLoteServicioSpinner to set
	 */
	public void setCostoLoteServicio(BigDecimal costo) {
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat formateador = new DecimalFormat("###,###,###,###.######",simbolos);
		
		if(costo != null){			
			String texto = formateador.format(costo);			
			this.costoLoteServicio.setText(texto);
			
		}else {
			this.costoLoteServicio.setText(new BigDecimal("0").toString());
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
