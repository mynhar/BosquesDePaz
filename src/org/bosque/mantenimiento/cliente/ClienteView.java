package org.bosque.mantenimiento.cliente;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ClienteView extends JPanel{
	
	public ClienteView(){
		super(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("src/graficos/middle.gif");
		
		JComponent panel1 = makeTextPanel("Mantenimiento de Clientes#");
        tabbedPane.addTab("Mantenimiento de Clientes", icon,panel1,"Mantenimiento de Clientes");
        
        JComponent panel2 = makeTextPanel("Cat�logo de Clientes#");
        tabbedPane.addTab("Cat�logo", icon, panel2,"Cat�logo de Clientes!");
        
      //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);		
	}
	
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        //java.net.URL imgURL = PersonaView.class.getResource(path);
    	Toolkit pantalla = Toolkit.getDefaultToolkit();
    	Image imagen = pantalla.getImage(path);
    	
        if (imagen != null) {
            return new ImageIcon(imagen);
        } else {
            System.err.println("No puede encontrar la Imagen: " + path);
            return null;
        }
    }

}
