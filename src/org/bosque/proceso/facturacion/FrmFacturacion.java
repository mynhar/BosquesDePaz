package org.bosque.proceso.facturacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class FrmFacturacion extends JPanel{
	
	public FrmFacturacion(){
		
		this.setLayout(new BorderLayout());
		
		
		JLabel ventaLotesServicios = new JLabel("Venta de Lotes o Servicios");
		JPanel tituloPanel = new JPanel();
		tituloPanel.add(ventaLotesServicios);
			
		JLabel tipoFacturacion = new JLabel("Tipo de Facturación.");
		JRadioButton credito = new JRadioButton("Credito");
		JRadioButton contado = new JRadioButton("Contado");
		ButtonGroup tipoFactura = new ButtonGroup();
		tipoFactura.add(credito);
		tipoFactura.add(contado);
		/*
		JPanel radioButtonPanel = new JPanel();
		radioButtonPanel.setBorder(BorderFactory.createTitledBorder("Tipo de Facturación."));
		radioButtonPanel.add(credito);
		radioButtonPanel.add(contado);
		*/
		
		JLabel clienteLabel = new JLabel("Cliente.");
		JTextField clienteJTextField = new JTextField();
		
		JLabel contratoLabel = new JLabel("Contrato.");
		JTextField contratoJTextField = new JTextField();
		
		JLabel preSolicitudLabel = new JLabel("Pre-Solicitud.");
		JTextField preSolicitudJTextField = new JTextField("");
		
		JLabel fecVentaLabel = new JLabel("Fec. Venta.");
		JTextField fecVentaJTextField = new JTextField();
		
		JLabel loteLabel = new JLabel("Lote.");
		JSpinner loteJTextField = new JSpinner();
		
		JLabel nichoLabel = new JLabel("Nicho (Superior, Inferior).");
		JTextField nichoJTextField = new JTextField();
		
		JLabel fecEjecucionLabel = new JLabel("Fecha Ejecución.");
		JTextField fecEjecucionJTextField = new JTextField("");
		
		JLabel servicioVendidoLabel = new JLabel("Servicio Vendido");
		
		ventaLotesServicios.setHorizontalAlignment(JLabel.CENTER);
		tipoFacturacion.setHorizontalAlignment(JLabel.RIGHT);
		credito.setHorizontalAlignment(JLabel.LEFT);
        contado.setHorizontalAlignment(JLabel.LEFT);
        
        clienteLabel.setHorizontalAlignment(JLabel.RIGHT);
		clienteJTextField.setHorizontalAlignment(JLabel.LEFT);
		
		contratoLabel.setHorizontalAlignment(JLabel.RIGHT);
		contratoJTextField.setHorizontalAlignment(JLabel.LEFT);
		
		preSolicitudLabel.setHorizontalAlignment(JLabel.RIGHT);
		preSolicitudJTextField.setHorizontalAlignment(JLabel.LEFT);
		
		fecVentaLabel.setHorizontalAlignment(JLabel.RIGHT);
		fecVentaJTextField.setHorizontalAlignment(JLabel.LEFT);
		
		loteLabel.setHorizontalAlignment(JLabel.RIGHT);
		//loteJTextField.set.setHorizontalAlignment(JLabel.CENTER);		
		nichoLabel.setHorizontalAlignment(JLabel.RIGHT);
		nichoJTextField.setHorizontalAlignment(JLabel.LEFT);
		
		fecEjecucionLabel.setHorizontalAlignment(JLabel.RIGHT);
		fecEjecucionJTextField.setHorizontalAlignment(JLabel.LEFT);		
		servicioVendidoLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel blanco1Label = new JLabel("BLANCO1");
		JLabel blanco2Label = new JLabel("BLANCO2");
		JLabel blanco3Label = new JLabel("BLANCO3");
		JLabel blanco4Label = new JLabel("BLANCO4");
		
		JPanel ventaLotesServiciosPanel = new JPanel();		
		ventaLotesServiciosPanel.setLayout(new GridLayout(9,2));
                
        ventaLotesServiciosPanel.add(tipoFacturacion);				
        ventaLotesServiciosPanel.add(credito);
        ventaLotesServiciosPanel.add(blanco1Label);//*********************************************
        ventaLotesServiciosPanel.add(contado);
        ventaLotesServiciosPanel.add(clienteLabel);
        ventaLotesServiciosPanel.add(clienteJTextField);
        ventaLotesServiciosPanel.add(contratoLabel);
        ventaLotesServiciosPanel.add(contratoJTextField);		
        ventaLotesServiciosPanel.add(preSolicitudLabel);
        ventaLotesServiciosPanel.add(preSolicitudJTextField);		
        ventaLotesServiciosPanel.add(fecVentaLabel);
        ventaLotesServiciosPanel.add(fecVentaJTextField);		
        ventaLotesServiciosPanel.add(loteLabel);
        ventaLotesServiciosPanel.add(loteJTextField);		
        ventaLotesServiciosPanel.add(nichoLabel);
        ventaLotesServiciosPanel.add(nichoJTextField);		
        ventaLotesServiciosPanel.add(fecEjecucionLabel);
        ventaLotesServiciosPanel.add(fecEjecucionJTextField);        
        ventaLotesServiciosPanel.setBorder(BorderFactory.createMatteBorder(10, 2, 2, 2,Color.RED));//.createLineBorder(Color.black));
        
      //ventaLotesServiciosPanel.add(servicioVendidoLabel);
        
        this.add(tituloPanel, BorderLayout.NORTH);
        this.add(ventaLotesServiciosPanel,BorderLayout.CENTER);
        
        this.add(blanco3Label,BorderLayout.WEST);
        this.add(blanco4Label,BorderLayout.EAST);
        this.add(blanco2Label,BorderLayout.SOUTH);
        
	}

}
