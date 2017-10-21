package org.bosque.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class FormatoCelda implements TableCellRenderer{
	
	// choose whatever color you prefer
	private static final Color STRIPE = new Color(0.929f, 0.953f, 0.996f);
	private static final Color WHITE = UIManager.getColor("Table.background");
		
	private DecimalFormatSymbols simbolos = new DecimalFormatSymbols();	
	private DecimalFormat formateador;
	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMM/yyyy");
	
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		simbolos.setDecimalSeparator('.');
		formateador = new DecimalFormat("###,###,###,###.######",simbolos);
		
		//Si values es nulo dara problemas de renderizado, por lo tanto se pone como vacio
		JLabel etiqueta = new JLabel("");
		if(value != null){			
			if(value instanceof String){
				String texto = value.toString();
				etiqueta.setHorizontalAlignment(SwingConstants.LEFT); //alina a la derecha
				etiqueta.setOpaque(true);
				etiqueta.setText(texto);
				etiqueta.setToolTipText(texto);
				
			}else if(value instanceof Long){				
				String texto = value.toString();
				etiqueta.setHorizontalAlignment(SwingConstants.RIGHT); //alina a la izquierda
				etiqueta.setOpaque(true);
				etiqueta.setText(texto);
				etiqueta.setToolTipText(texto);
				
			}else if(value instanceof Date){				
				String texto = formatoFecha.format(value);
				etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //alina a la izquierda
				etiqueta.setOpaque(true);
				etiqueta.setText(texto);
				etiqueta.setToolTipText(texto);
				
			}else if(value instanceof BigDecimal){
				String texto = formateador.format(value);				
				etiqueta.setHorizontalAlignment(SwingConstants.RIGHT); //alina a la izquierda
				etiqueta.setOpaque(true);
				etiqueta.setText(texto);
				etiqueta.setToolTipText(texto);
			}			
		}		
		
		if(row%2 == 0){			
			etiqueta.setBackground(STRIPE);
			
		}else{
			etiqueta.setBackground(WHITE);
			
		}
		
		if(isSelected){
			etiqueta.setBackground(Color.ORANGE);
		}

        return etiqueta;

    }

}
