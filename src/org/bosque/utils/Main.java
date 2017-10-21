package org.bosque.utils;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame();

    JPanel entreePanel = new JPanel();
    final ButtonGroup entreeGroup = new ButtonGroup();
    JRadioButton radioButton;
    entreePanel.add(radioButton = new JRadioButton("A"));
    radioButton.setActionCommand("A");
    entreeGroup.add(radioButton);
    entreePanel.add(radioButton = new JRadioButton("B"));
    radioButton.setActionCommand("B");
    entreeGroup.add(radioButton);
    entreePanel.add(radioButton = new JRadioButton("C", true));
    radioButton.setActionCommand("C");
    entreeGroup.add(radioButton);

    final JPanel condimentsPanel = new JPanel();
    condimentsPanel.add(new JCheckBox("Ketchup"));
    condimentsPanel.add(new JCheckBox("Mustard"));
    condimentsPanel.add(new JCheckBox("Pickles"));

    JPanel orderPanel = new JPanel();
    JButton orderButton = new JButton("Place Order");
    orderPanel.add(orderButton);

    frame.setLayout(new GridLayout(3, 1));
    frame.add(entreePanel);
    frame.add(condimentsPanel);
    frame.add(orderPanel);

    orderButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
    	  ButtonModel sel = entreeGroup.getSelection();
    	  int rb = (int) sel.getMnemonic();
    	  
    	  String entree = entreeGroup.getSelection().getActionCommand();
        System.out.println(entree + " sandwich");
        Component[] components = condimentsPanel.getComponents();
        for (Component c : components) {
          JCheckBox cb = (JCheckBox) c;
          if (cb.isSelected())
            System.out.println("With " + cb.getText());
        }
      }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);
    frame.setVisible(true);
  }
}
