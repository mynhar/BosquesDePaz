package org.bosque.proceso.facturacion;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FacturacionView extends JPanel {
		
	private Catalogo catalogo;
	private Formulario formPanel;
	private JTabbedPane tabbedPane;
	

	/**
	 * Create the panel.
	 */
	public FacturacionView() {
		super(new GridLayout(1, 1));
		
		ImageIcon agregarButtonIcon = createImageIcon("src/graficos/add32.png");
		ImageIcon buscarButtonIcon = createImageIcon("src/graficos/folderSearch32.png");
		ImageIcon eliminarButtonIcon = createImageIcon("src/graficos/deleteTrash32.png");
		ImageIcon limpiarButtonIcon = createImageIcon("src/graficos/clean32.png");
				
		/***************************************************************************************************
		  Formulario Facturacion Panel
		 ***************************************************************************************************/
		formPanel = new Formulario();
		
		
		
		/***************************************************************************************************/
		
		
		/***************************************************************************************************
		  Catalogo
		 ***************************************************************************************************/
		JPanel CatalogPanel = new JPanel();
		CatalogPanel.setLayout(new BorderLayout(0, 0));		
		/***************************************************************** Barra de Herraminetas Formulario ***/
			
		JToolBar barraHerramientasCatalogo = new JToolBar();
		JButton btnAgregarCatalogo = new JButton();		
		btnAgregarCatalogo.setIcon(agregarButtonIcon);
		btnAgregarCatalogo.setToolTipText("Nuevo...");
		btnAgregarCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
			
		});
		
		JButton btnLimpiarCatalogo = new JButton();		
		btnLimpiarCatalogo.setIcon(limpiarButtonIcon);
		btnLimpiarCatalogo.setToolTipText("Limpiar Catálogo...");
		btnLimpiarCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				getCatalogo().limpiar();
			}
		});
		
		
		JButton btnBuscarCatalogo = new JButton();		
		btnBuscarCatalogo.setIcon(buscarButtonIcon);
		btnBuscarCatalogo.setToolTipText("Buscar...");
		btnBuscarCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getCatalogo().cargarCatalogo();
				
			}
		});
		
		JButton btnEliminarCatalogo = new JButton();		
		btnEliminarCatalogo.setIcon(eliminarButtonIcon);
		btnEliminarCatalogo.setToolTipText("Eliminar...");
		btnEliminarCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				Long id = getIdFactura();				
				if(validarRegistroSeleccionado(id)){
					if(showConfirmDialog("Desea borrar el registro seleccionado?")){						
						boolean isDelete = controller.delete(obj);
						if(isDelete){
							clean();
							showMessageDialog("Registro Borrado. Operación realizada correctamente!");
						}
					}
				}
				*/
				
			}
		});
		
		barraHerramientasCatalogo.add(btnAgregarCatalogo);
		barraHerramientasCatalogo.add(btnLimpiarCatalogo);
		barraHerramientasCatalogo.add(btnBuscarCatalogo);
		//barraHerramientasCatalogo.add(btnEliminarCatalogo);
		CatalogPanel.add(barraHerramientasCatalogo, BorderLayout.NORTH);
		/***************************************************************** Barra de Herraminetas Formulario ***/
		
		catalogo = new Catalogo();		
		CatalogPanel.add(catalogo, BorderLayout.CENTER);		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane}));
		
		/***************************************************************************************************
		  Agrega el formulario y el catalogo a cada TAB
		 ***************************************************************************************************/
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon icon = createImageIcon("src/graficos/middle.gif");
		tabbedPane.addTab("Catálogo", icon, CatalogPanel, "Catálogo");
		tabbedPane.addTab("Facturación", icon,formPanel,"Proceso Facturación");
		
		
		add(tabbedPane);
		
		getCatalogo().setView(this);
		getFormPanel().setView(this);
		this.setCatalogo(catalogo);		

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
     * @param catalogo
     */
    public void setCatalogo(Catalogo catalogo){
    	this.catalogo = catalogo;
    }
    
    /**
     * 
     * @return
     */
    public Catalogo getCatalogo(){
    	return this.catalogo;
    }
    
    /**
     * 
     * @return
     */
	public Formulario getFormPanel() {
		return formPanel;
	}

	/**
	 * 
	 * @param formPanel
	 */
	public void setFormPanel(Formulario formPanel) {
		this.formPanel = formPanel;
	}
    
    /**
	 * 
	 * @param tabbedPane
	 */
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;		
	}
	
	/**
	 * 
	 * @return
	 */
	public JTabbedPane getTabbedPane() {
		return this.tabbedPane;		
	}
}
