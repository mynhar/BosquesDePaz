package org.bosque.inicio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.bosque.mantenimiento.cliente.ClienteView;
import org.bosque.mantenimiento.persona.PersonaView;
import org.bosque.proceso.facturacion.FacturacionView;

public class PrincipalFrame extends JFrame {
	
	private static JPanel mantPanel = new JPanel();
	
	public PrincipalFrame(){
		
		this.setLayout(new BorderLayout());
		this.setTitle("Campo Santo Bosques de Paz");		
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();		
		Dimension tamPantalla = pantalla.getScreenSize();		
		int ancho = tamPantalla.width;
		int alto = tamPantalla.height;
		this.setSize(800, 600);
		this.setLocation(ancho/4, alto/14);
		
		Image imagen = pantalla.getImage("src/graficos/IMG-20160305-WA0006.jpg");
		this.setIconImage(imagen);		
		
		MenuPrincipal menu = new MenuPrincipal();		
		this.setJMenuBar(menu.getBarraMenu());
		
	}
	
	/**
	 * 
	 */
	public void agregarPanel(){		
		this.add(this.getMantPanel(),BorderLayout.CENTER);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * 
	 * @return
	 */
	public JPanel getMantPanel() {
		return mantPanel;
	}

	/**
	 * 
	 * @param mantPanel
	 */
	public void setMantPanel(JPanel mantPanel) {
		this.mantPanel = mantPanel;
	}
	
	/*
	***************************************************************************************
	***************************************************************************************
	***************************************************************************************
	*/
	  
	private class MenuPrincipal extends JPanel{
		
		private JMenuBar barraMenu = new JMenuBar();
		

		public MenuPrincipal(){

			this.setLayout(new BorderLayout());
					
			JMenu procesos = new JMenu("Procesos");
			JMenu mantenimientos = new JMenu("Mantenimientos");
			JMenu consultas = new JMenu("Consultas");
			//******************************************************************************
			JMenuItem ventaLotes = new JMenuItem("Venta Lotes");
			
			JMenuItem facturacion = new JMenuItem("Facturación");
			facturacion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if(getMantPanel() == null){
						FacturacionView mantenimiento = new FacturacionView();				
						setMantPanel(mantenimiento);
						agregarPanel();
						
					} else if(getMantPanel() instanceof FacturacionView){
						if(!getMantPanel().isEnabled()){
							getMantPanel().setVisible(true);
							
						}
						
					}else if(!(getMantPanel() instanceof FacturacionView)){
						getMantPanel().removeAll();
						FacturacionView mantenimiento = new FacturacionView();				
						setMantPanel(mantenimiento);
						agregarPanel();
					}
					
				}
			});
			
			
			JMenuItem clientes = new JMenuItem("Clientes");
			clientes.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					getMantPanel().setVisible(false);
					
					if(getMantPanel() instanceof ClienteView){
						if(!getMantPanel().isEnabled()){
							getMantPanel().setVisible(true);							
						}
						
					}else if(getMantPanel() == null){
						getMantPanel().setVisible(true);
						ClienteView mantenimiento = new ClienteView();				
						setMantPanel(mantenimiento);
						agregarPanel();
					} else if(!(getMantPanel() instanceof ClienteView)){
						getMantPanel().removeAll();
						ClienteView mantenimiento = new ClienteView();				
						setMantPanel(mantenimiento);
						agregarPanel();
					}					
				}
			});
			
			JMenuItem personas = new JMenuItem("Personas");			
			personas.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					getMantPanel().setVisible(false);
					
					if(getMantPanel() instanceof PersonaView){
						if(!getMantPanel().isEnabled()){
							getMantPanel().setVisible(true);							
						}
						
					}else if(getMantPanel() == null){
						getMantPanel().setVisible(true);
						PersonaView mantenimiento = new PersonaView();				
						setMantPanel(mantenimiento);
						agregarPanel();
					} else if(!(getMantPanel() instanceof PersonaView)){
						getMantPanel().removeAll();
						PersonaView mantenimiento = new PersonaView();				
						setMantPanel(mantenimiento);
						agregarPanel();
					}					
				}
			});
			
			JMenuItem lotes = new JMenuItem("Lotes");
			
			//******************************************************************************
			
			procesos.add(ventaLotes);
			procesos.add(facturacion);			
			mantenimientos.add(clientes);
			mantenimientos.add(personas);
			mantenimientos.add(lotes);
					
			barraMenu.add(procesos);
			barraMenu.add(mantenimientos);
			barraMenu.add(consultas);	
			//******************************************************************************		
			this.add(barraMenu,BorderLayout.NORTH);
			
		}

		/**
		 * 
		 * @return
		 */
		public JMenuBar getBarraMenu() {
			return barraMenu;
		}

		/**
		 * 
		 * @param barraMenu
		 */
		public void setBarraMenu(JMenuBar barraMenu) {
			this.barraMenu = barraMenu;
		}	

	}	  
	  
	 
	//**********************************************************************

}
