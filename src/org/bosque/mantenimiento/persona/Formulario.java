package org.bosque.mantenimiento.persona;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerDateModel;
import javax.swing.text.MaskFormatter;

import org.bosque.controller.PersonaController;
import org.bosque.model.bean.EstadoCivil;
import org.bosque.model.bean.Ocupacion;
import org.bosque.model.bean.Persona;
import org.bosque.utils.ComboEstadoCivil;
import org.bosque.utils.ComboOcupacion;
import org.bosque.utils.Constantes;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class Formulario extends JPanel {
	private Long id;

	private JTextField txtPersona;
	private JTextField txtIdentificacion;
	private JTextField txtRazonSocial;
	private JTextField txtNombre;
	private JTextField txtPrimerApellido;
	private JTextField txtSegundoApellido;
	private JComboBox cbEstadoCivil;
	private JTextField txtCorreoPrincipal;
	private JTextField txtCorreoSecundario;
	private JTextField txtDireccion;
	private ButtonGroup bgEstadoPersona;
	private JRadioButton rdbtnDifunto;
	private JRadioButton rdbtnVivo;

	private ButtonGroup bgTipoPersona;
	private JRadioButton rdbtnFisico;
	private JRadioButton rdbtnJuridico;
	
	private JFormattedTextField txtTelefonoHabitacion;
	private JFormattedTextField txtTelefonoOficina;
	private JTextField txtExtension;
	private JFormattedTextField txtCelular;
	private JComboBox cbOcupacion;

	private JSpinner spFechaNacimiento;
	private JSpinner spFechaDefuncion;

	private PersonaView view;
	private PersonaController controller;
	// private Persona ;


	/**
	 * Create the panel.
	 */
	public Formulario() {
		setLayout(new BorderLayout(0, 0));

		controller = new PersonaController();


		
		/*** Barra de Herramientas Formulario ***/
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
				Persona obj = getFormValues();
				boolean isTrue = validaciones(obj);
				if(isTrue) {
					if(obj.getPersona() == null) {
						obj = controller.create(obj);
						
					} else {
						obj = controller.update(obj);
						
					}

					setFormValues(obj);
					if(obj.getPersona() != null){
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
				getView().getCatalogo().cargarCatalogo();
				getView().getTabbedPane().setSelectedIndex(0);// Cambiar al tab Catalogo...
			}
		});
		
		JButton btnEliminar = new JButton();
		btnEliminar.setIcon(eliminarButtonIcon);
		btnEliminar.setToolTipText("Eliminar...");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Long id = getId();				
				if(validarRegistroSeleccionado(id)){
					if(showConfirmDialog("Desea borrar el registro seleccionado?")){
						Persona obj = getFormValues();
						boolean isDelete = controller.delete(obj);
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

		Dimension dimLabel = new Dimension(200, 20);
		Dimension dimText  = new Dimension(200, 20);
		
		JPanel centralPanel = new JPanel();
		add(centralPanel, BorderLayout.CENTER);
		centralPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
		
		JLabel lblPersona = new JLabel("Persona");
		centralPanel.add(lblPersona, "6, 10, right, default");
		
		txtPersona = new JTextField();
		centralPanel.add(txtPersona, "8, 10, fill, default");
		txtPersona.setColumns(10);
		txtPersona.setPreferredSize(dimText);
		
		txtPersona.setEnabled(false);
		
		bgTipoPersona = new ButtonGroup();

		JLabel lblTipoPersona = new JLabel("Tipo Persona");
		centralPanel.add(lblTipoPersona, "10, 10, right, default");
		
		rdbtnFisico = new JRadioButton("F\u00EDsico");
		rdbtnFisico.setSelected(true);
		centralPanel.add(rdbtnFisico, "12, 10");

		rdbtnJuridico = new JRadioButton("Jur\u00EDdico");
		centralPanel.add(rdbtnJuridico, "12, 12");
		bgTipoPersona.add(rdbtnFisico);
		bgTipoPersona.add(rdbtnJuridico);

		JLabel lblIdentificacion = new JLabel("Identificaci\u00F3n");
		centralPanel.add(lblIdentificacion, "6, 12, right, default");
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setPreferredSize(new Dimension(200, 20));
		txtIdentificacion.setColumns(10);
		centralPanel.add(txtIdentificacion, "8, 12, fill, default");
		
		JLabel lblRazonSocial = new JLabel("Raz\u00F3n Social");
		centralPanel.add(lblRazonSocial, "6, 14, right, default");
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setPreferredSize(new Dimension(200, 20));
		txtRazonSocial.setColumns(10);
		centralPanel.add(txtRazonSocial, "8, 14, fill, default");
		
		JLabel lblTelfonoHabitacin = new JLabel("Tel\u00E9fono Habitaci\u00F3n");
		centralPanel.add(lblTelfonoHabitacin, "10, 14, right, default");

		txtTelefonoHabitacion = new JFormattedTextField(Constantes.getPhoneMask());
		txtTelefonoHabitacion.setPreferredSize(new Dimension(200, 20));
		txtTelefonoHabitacion.setColumns(10);
		centralPanel.add(txtTelefonoHabitacion, "12, 14, fill, default");
		
		JLabel lblNombre = new JLabel("Nombre");
		centralPanel.add(lblNombre, "6, 16, right, center");
		
		txtNombre = new JTextField();
		txtNombre.setPreferredSize(new Dimension(200, 20));
		txtNombre.setColumns(10);
		centralPanel.add(txtNombre, "8, 16, fill, default");
		
		JLabel lblTelfonoOficina = new JLabel("Tel\u00E9fono Oficina");
		centralPanel.add(lblTelfonoOficina, "10, 16, right, default");
		
		txtTelefonoOficina = new JFormattedTextField(Constantes.getPhoneMask());
		txtTelefonoOficina.setPreferredSize(new Dimension(200, 20));
		txtTelefonoOficina.setColumns(10);
		centralPanel.add(txtTelefonoOficina, "12, 16, fill, default");
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		centralPanel.add(lblPrimerApellido, "6, 18, right, center");
		
		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setPreferredSize(new Dimension(200, 20));
		txtPrimerApellido.setColumns(10);
		centralPanel.add(txtPrimerApellido, "8, 18, fill, default");
		
		JLabel lblExtensin = new JLabel("Extensi\u00F3n");
		centralPanel.add(lblExtensin, "10, 18, right, default");
		
		txtExtension = new JTextField();
		txtExtension.setPreferredSize(new Dimension(200, 20));
		txtExtension.setColumns(10);
		centralPanel.add(txtExtension, "12, 18, fill, default");
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		centralPanel.add(lblSegundoApellido, "6, 20, right, default");
		
		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setPreferredSize(new Dimension(200, 20));
		txtSegundoApellido.setColumns(10);
		centralPanel.add(txtSegundoApellido, "8, 20, fill, default");
		
		JLabel lblCelular = new JLabel("Celular");
		centralPanel.add(lblCelular, "10, 20, right, default");
		
		txtCelular = new JFormattedTextField(Constantes.getPhoneMask());
		txtCelular.setPreferredSize(new Dimension(200, 20));
		txtCelular.setColumns(10);
		centralPanel.add(txtCelular, "12, 20, fill, default");
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		centralPanel.add(lblEstadoCivil, "6, 22, right, default");
		
		ComboEstadoCivil estadoCivilList = new ComboEstadoCivil();
		cbEstadoCivil = new JComboBox(estadoCivilList.getList().toArray());
		centralPanel.add(cbEstadoCivil, "8, 22, fill, default");

		JLabel lblOcupacin = new JLabel("Ocupaci\u00F3n");
		centralPanel.add(lblOcupacin, "10, 22, right, default");
		
		ComboOcupacion ocupacionList = new ComboOcupacion();
		cbOcupacion = new JComboBox(ocupacionList.getList().toArray());
		centralPanel.add(cbOcupacion, "12, 22, fill, default");
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		centralPanel.add(lblFechaNacimiento, "6, 24, center, fill");
		
		spFechaNacimiento = new JSpinner(new SpinnerDateModel());
		centralPanel.add(spFechaNacimiento, "8, 24");
		
		JLabel lblFechaDefuncin = new JLabel("Fecha Defunci\u00F3n");
		centralPanel.add(lblFechaDefuncin, "10, 24");
		
		spFechaDefuncion = new JSpinner(new SpinnerDateModel());
		centralPanel.add(spFechaDefuncion, "12, 24");
		
		JLabel lblCorreoPrincipal = new JLabel("Correo Principal");
		centralPanel.add(lblCorreoPrincipal, "6, 26, right, default");
		
		txtCorreoPrincipal = new JTextField();
		txtCorreoPrincipal.setPreferredSize(new Dimension(200, 20));
		txtCorreoPrincipal.setColumns(10);
		centralPanel.add(txtCorreoPrincipal, "8, 26, 5, 1, fill, default");
		
		JLabel lblCorreoSecundario = new JLabel("Correo Secundario");
		centralPanel.add(lblCorreoSecundario, "6, 28, right, default");
		
		txtCorreoSecundario = new JTextField();
		txtCorreoSecundario.setPreferredSize(new Dimension(200, 20));
		txtCorreoSecundario.setColumns(10);
		centralPanel.add(txtCorreoSecundario, "8, 28, 5, 1, fill, default");
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		centralPanel.add(lblDireccin, "6, 30, right, default");
		
		txtDireccion = new JTextField();
		txtDireccion.setPreferredSize(new Dimension(200, 20));
		txtDireccion.setColumns(10);
		centralPanel.add(txtDireccion, "8, 30, 5, 1, fill, default");
		
		JLabel lblEstadoPersona = new JLabel("Estado Persona");
		centralPanel.add(lblEstadoPersona, "6, 32");
		
		bgEstadoPersona = new ButtonGroup();
		rdbtnVivo = new JRadioButton("Vivo");
		rdbtnVivo.setSelected(true);
		centralPanel.add(rdbtnVivo, "8, 32");
		
		bgEstadoPersona.add(rdbtnVivo);
		
		rdbtnDifunto = new JRadioButton("Difunto");
		centralPanel.add(rdbtnDifunto, "8, 34");
		bgEstadoPersona.add(rdbtnDifunto);

		if (this.getBgTipoPersona().equals("F")) {
			txtRazonSocial.setEnabled(false);
			txtNombre.setEnabled(true);
			txtPrimerApellido.setEnabled(true);
			txtSegundoApellido.setEnabled(true);
		} else {
			txtRazonSocial.setEnabled(true);
			txtNombre.setEnabled(false);
			txtPrimerApellido.setEnabled(false);
			txtSegundoApellido.setEnabled(false);
		}
	}

	public PersonaView getView() {
		return view;
	}
	public void setView(PersonaView view) {
		this.view = view;
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

	private void limpiar() {

		txtPersona.setText("");
		txtIdentificacion.setText("");
		txtRazonSocial.setText("");
		txtNombre.setText("");
		txtPrimerApellido.setText("");
		txtSegundoApellido.setText("");
		cbEstadoCivil.setSelectedIndex(-1);
		txtCorreoPrincipal.setText("");
		txtCorreoSecundario.setText("");
		txtDireccion.setText("");

		this.setBgEstadoPersona("V");
		this.setBgTipoPersona("F");
		
		txtTelefonoHabitacion.setText("");
		txtTelefonoOficina.setText("");
		txtExtension.setText("");
		txtCelular.setText("");
		cbOcupacion.setSelectedIndex(-1);

		spFechaNacimiento.setValue(new Date());
		spFechaDefuncion.setValue(new Date());

	}

    /**
	 * Obtiene los valores del formulario
	 * @return
	 */
	public Persona getFormValues() {
		Persona obj = new Persona();

		obj.setPersona(this.getTxtPersona());
		obj.setTipoPersona(this.getBgTipoPersona());
		obj.setIdentificacion(this.getTxtIdentificacion());
		obj.setRazonSocial(this.getTxtRazonSocial());
		obj.setNombreCompleto(this.getTxtNombre());
		obj.setPrimerApellido(this.getTxtPrimerApellido());
		obj.setSegundoApellido(this.getTxtSegundoApellido());
		obj.setEstadoCivil(this.getEstadoCivil());
		obj.setDireccion(this.getTxtDireccion());
		obj.setCorreoPrincipal(this.getTxtCorreoPrincipal());
		obj.setCorreoSecundario(this.getTxtCorreoSecundario());
		obj.setTelefHabitacion(this.getTxtTelefonoHabitacion());
		obj.setTelefOficina(this.getTxtTelefonoOficina());
		obj.setExtOficina(this.getTxtExtension());
		obj.setTelefMovil(this.getTxtCelular());
		obj.setOcupacion(this.getCbOcupacion());
		obj.setFecNacimiento(this.getSpFechaNacimiento());
		obj.setFecDefuncion(this.getSpFechaDefuncion());

		return obj;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public Persona setFormValues(Persona obj) {
		this.limpiar();

		this.setTxtPersona(obj.getPersona());
		this.setTxtIdentificacion(obj.getIdentificacion());
		this.setTxtRazonSocial(obj.getRazonSocial());
		this.setTxtNombre(obj.getNombreCompleto());
		this.setTxtPrimerApellido(obj.getPrimerApellido());
		this.setTxtSegundoApellido(obj.getSegundoApellido());
		this.setEstadoCivil(obj.getEstadoCivil());
		this.setTxtCorreoPrincipal(obj.getCorreoPrincipal());
		this.setTxtCorreoSecundario(obj.getCorreoSecundario());
		this.setTxtDireccion(obj.getDireccion());

		this.setBgEstadoPersona(obj.getEstadoPersona());
		this.setBgTipoPersona(obj.getTipoPersona());
		
		this.setTxtTelefonoHabitacion(obj.getTelefHabitacion());
		this.setTxtTelefonoOficina(obj.getTelefOficina());
		this.setTxtExtension(obj.getExtOficina());
		this.setTxtCelular(obj.getTelefMovil());
		this.setCbOcupacion(obj.getOcupacion());

		spFechaNacimiento.setValue(obj.getFecNacimiento());
		spFechaDefuncion.setValue(obj.getFecDefuncion());

		return obj;
	}
	/**
	 * INFORMATION_MESSAGE
	 * @param msg
	 */
	private void showMessageDialog(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 
	 * @param msg
	 * @return
	 */
	private boolean showConfirmDialog(String msg) {
		int rest = JOptionPane.showConfirmDialog(this, msg, "Confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(rest == 0) {
			return true;
			
		} else if(rest == 1) {
			return false;
			
		} else {
			return false;
		}
	}	

	/**
	 * 
	 * @param id
	 * @return
	 */
	private boolean validarRegistroSeleccionado(Long id) {
		
		if(id == null || id.toString().trim().equals("")){			
			JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de Persona!", "Alerta", JOptionPane.WARNING_MESSAGE);			
			return false;
		}
		
		return true;
	}
	

	private boolean validaciones(Persona obj) {

		String identificacion = obj.getIdentificacion();
		if(identificacion == null) {
			JOptionPane.showMessageDialog(this, "Favor ingrese la Idenficación!", "Alerta", JOptionPane.WARNING_MESSAGE);
			this.txtIdentificacion.requestFocus();

			return false;
		}

		String tipoPersona = obj.getTipoPersona();
		if(tipoPersona == null) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar Tipo de Persona!", "Alerta", JOptionPane.WARNING_MESSAGE);
			this.rdbtnFisico.setSelected(true);
			return false;
		}

		if (tipoPersona.equals("F")) {
			String txt = obj.getNombreCompleto();
			if(txt == null) {
				JOptionPane.showMessageDialog(this, "Favor ingrese el Nombre de la Persona!", "Alerta", JOptionPane.WARNING_MESSAGE);
				this.txtNombre.requestFocus();

				return false;
			}

			txt = obj.getPrimerApellido();
			if(txt == null) {
				JOptionPane.showMessageDialog(this, "Favor ingrese el Primer Apellido!", "Alerta", JOptionPane.WARNING_MESSAGE);
				this.txtPrimerApellido.requestFocus();

				return false;
			}

			txt = obj.getSegundoApellido();
			if(txt == null) {
				JOptionPane.showMessageDialog(this, "Favor ingrese el Segundo Apellido!", "Alerta", JOptionPane.WARNING_MESSAGE);
				this.txtSegundoApellido.requestFocus();

				return false;
			}
		} else {
			String txt = obj.getRazonSocial();
			if(txt == null) {
				JOptionPane.showMessageDialog(this, "Favor ingrese la Razón Social!", "Alerta", JOptionPane.WARNING_MESSAGE);
				this.txtRazonSocial.requestFocus();

				return false;
			}
		}

		String txt = obj.getEstadoCivil();
		if(txt == null) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar el Estado Civil!", "Alerta", JOptionPane.WARNING_MESSAGE);
			this.cbEstadoCivil.requestFocus();
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	private Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	private void setId(Long id) {
		this.id = id;
	}	


	/* ************************************************* */
	// get y sets de cada campo del formulario

	public Long getTxtPersona() {
		return Constantes.string2Long(txtPersona.getText());
	}

	public void setTxtPersona(Long txtPersona) {
		this.txtPersona.setText(txtPersona.toString());
	}

	public String getTxtIdentificacion() {
		String txt = txtIdentificacion.getText();
		
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtIdentificacion(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtIdentificacion.setText(txt);
		}
	}

	public String getTxtRazonSocial() {
		String txt = txtRazonSocial.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtRazonSocial(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtRazonSocial.setText(txt);
		}
	}

	public String getTxtNombre() {
		String txt = txtNombre.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtNombre(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtNombre.setText(txt);
		}
	}

	public String getTxtPrimerApellido() {
		String txt = txtPrimerApellido.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtPrimerApellido(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtPrimerApellido.setText(txt);
		}
	}

	public String getTxtSegundoApellido() {
		String txt = txtSegundoApellido.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtSegundoApellido(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtSegundoApellido.setText(txt);
		}
	}

	public String getTxtCorreoPrincipal() {
		String txt = txtCorreoPrincipal.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtCorreoPrincipal(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtCorreoPrincipal.setText(txt);
		}
	}

	public String getTxtCorreoSecundario() {
		String txt = txtCorreoSecundario.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtCorreoSecundario(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtCorreoSecundario.setText(txt);
		}
	}

	public String getTxtDireccion() {
		String txt = txtDireccion.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtDireccion(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtDireccion.setText(txt);
		}
	}

	public String getTxtTelefonoHabitacion() {
		String txt = txtTelefonoHabitacion.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtTelefonoHabitacion(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtTelefonoHabitacion.setText(txt);
		}
	}

	public String getTxtTelefonoOficina() {
		String txt = txtTelefonoOficina.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtTelefonoOficina(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtTelefonoOficina.setText(txt);
		}
	}

	public String getTxtExtension() {
		String txt = txtExtension.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtExtension(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtExtension.setText(txt);
		}
	}

	public String getTxtCelular() {
		String txt = txtCelular.getText();
		if (txt != null && !txt.trim().equals("")) {
			return txt;
		} else {
			return null;
		}
	}

	public void setTxtCelular(String txt) {
		if (txt != null && !txt.trim().equals("")) {
			this.txtCelular.setText(txt);
		}
	}

	public PersonaController getController() {
		return controller;
	}

	public void setController(PersonaController controller) {
		this.controller = controller;
	}

    public String getEstadoCivil() {
    	Object obj = cbEstadoCivil.getSelectedItem();
    	
    	if (obj != null) {
    		EstadoCivil estadoCivil = (EstadoCivil) obj;
    		return estadoCivil.getId();
    	}
		return null;

    }
 
    public void setEstadoCivil(String estadoCivil) {
    	// ??????????????????????????????????????????????????????
        this.cbEstadoCivil.setSelectedItem(estadoCivil);
    }

    public Ocupacion getCbOcupacion() {
    	Object obj = cbOcupacion.getSelectedItem();
    	
    	if (obj != null) {
    		Ocupacion ocupacion = (Ocupacion) obj;
    		return ocupacion;
    	}
		return null;
		
	}

	public void setCbOcupacion(Ocupacion ocupacion) {
		if (ocupacion != null) {
			this.cbOcupacion.setSelectedItem(ocupacion);
		}
	}


	public String getBgTipoPersona() {
		if (rdbtnFisico.isSelected()) {
			return "F";
		} else if (rdbtnJuridico.isSelected()) {
			return "J";
		}
		return null;
	}

	public void setBgTipoPersona(String tipoPersona) {
		if (tipoPersona != null && !tipoPersona.trim().equals("")) {
			if (tipoPersona.equals("F")) {
				rdbtnFisico.setSelected(true);
				rdbtnJuridico.setSelected(false);
			} else if (tipoPersona.equals("J")) {
				rdbtnFisico.setSelected(false);
				rdbtnJuridico.setSelected(true);
			} else {
				rdbtnFisico.setSelected(false);
				rdbtnJuridico.setSelected(false);
			}
		} else {
			rdbtnFisico.setSelected(false);
			rdbtnJuridico.setSelected(false);
		}
	}

	public String getBgEstadoPersona() {
		if (rdbtnDifunto.isSelected()) {
			return "F";
		} else if (rdbtnVivo.isSelected()) {
			return "V";
		}
		return null;
	}

	public void setBgEstadoPersona(String estadoPersona) {
		if (estadoPersona != null && !estadoPersona.trim().equals("")) {
			if (estadoPersona.equals("V")) {
				rdbtnVivo.setSelected(true);
				rdbtnDifunto.setSelected(false);
			} else if (estadoPersona.equals("F")) {
				rdbtnVivo.setSelected(false);
				rdbtnDifunto.setSelected(true);
			} else {
				rdbtnVivo.setSelected(false);
				rdbtnDifunto.setSelected(false);
			}
		} else {
			rdbtnVivo.setSelected(false);
			rdbtnDifunto.setSelected(false);
		}
	}

	public Date getSpFechaDefuncion() {
		Object obj = spFechaDefuncion.getValue();
		
		if (obj != null && !obj.toString().trim().equals("")) {
			Date fecha = (Date) obj;
			return fecha;
		}
		return null;
	}

	public void setSpFechaDefuncion(Date fecha) {
		if (fecha != null) {
			this.spFechaDefuncion.setValue(fecha);
		}
	}

	public Date getSpFechaNacimiento() {
		
		Object obj = spFechaNacimiento.getValue();
		
		if (obj != null && !obj.toString().trim().equals("")) {
			Date fecha = (Date) obj;
			return fecha;
		}
		return null;

	}

	public void setSpFechaNacimiento(Date fecha) {
		if (fecha != null) {
			this.spFechaNacimiento.setValue(fecha);
		}
	}

}