package org.bosque.inicio;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GeneralView extends JPanel{
	
	public GeneralView(){
		super(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
	}

}
