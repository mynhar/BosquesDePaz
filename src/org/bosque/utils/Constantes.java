package org.bosque.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.bosque.model.bean.Agente;
import org.bosque.model.bean.Cliente;
import org.bosque.model.bean.Concepto;
import org.bosque.model.bean.Factura;
import org.bosque.model.bean.Lote;
import org.bosque.model.bean.Ocupacion;
import org.bosque.model.bean.Persona;
import org.bosque.model.dao.AgenteDao;
import org.bosque.model.dao.ClienteDao;
import org.bosque.model.dao.ConceptoDao;
import org.bosque.model.dao.FacturaDao;
import org.bosque.model.dao.LoteDao;
import org.bosque.model.dao.OcupacionDao;
import org.bosque.model.dao.PersonaDao;

public class Constantes {

    private static final String dateFormat = "dd/MM/yyyy";
    private static final String diaMesPagarMask = "##-##";
    private static final String decimalFormat = "0.00";
    private static final String idMask = "#-####-####";
    private static final String phoneMask = "####-####";

    private Constantes() {
    }

    public static java.sql.Date string2SQLDate(String fecha) {
        java.sql.Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            date = new java.sql.Date(sdf.parse(fecha).getTime());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String SQLDate2String(java.sql.Date date) {
        String sDate = "";
        if (date != null) {
            DateFormat df = new SimpleDateFormat(dateFormat);
            sDate = df.format(date);
        }
        return sDate;
    }

    public static double string2Decimal(String sValor) {
        Double valor = Double.parseDouble(sValor);

        DecimalFormat df = new DecimalFormat(decimalFormat);
        df.setMaximumFractionDigits(2);
        
        valor = Double.parseDouble(df.format(valor));
        
        return valor;
    }
    
    public static Long string2Long(String valor) {
    	if (valor == null || valor.equals(""))
    		return null;
    	else
    		return new Long(Long.parseLong(valor));
    }

    public static double stringF2Double(String valor) {
        // devolver el double del valor de cadena eliminando el caractér de agrupación (blanco o coma)
    	if (valor.equals(""))
    		return 0.00;
    	else
    		return Double.valueOf(valor.replace(" ", "").replace(",", ""));
    }

    public static String double2String(double d) {

        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        String num = df.format(d);

        return num;
    }

    public static int JTextField2Integer(JTextField textField) {
        if (textField.getText().equals(""))
            return 0;
        else
            return Integer.parseInt(textField.getText());
   	
    }

    public static MaskFormatter getIdMask() {
    	MaskFormatter mask = null;
    	try {
    		mask = new MaskFormatter(idMask);
    	} catch (Exception e) {
    	}
    	return mask;
    }

    public static MaskFormatter getPhoneMask() {
    	MaskFormatter mask = null;
    	try {
    		mask = new MaskFormatter(phoneMask);
    	} catch (Exception e) {
    	}
    	return mask;
    }

    public static MaskFormatter getDiaMesPagarMask() {
    	MaskFormatter mask = null;
    	try {
    		mask = new MaskFormatter(diaMesPagarMask);
    	} catch (Exception e) {
    	}
    	return mask;
    }

    /*
     * Obtiene el objeto Cliente desde el Dao respectivo
     */
    public static Factura getFactura(Long id) {
	Factura obj = new Factura();

	obj.setIdFactura(id);

	FacturaDao dao = new FacturaDao();
	obj = dao.read(obj);

	return obj;
    }

    /*
     * Obtiene el objeto persona desde el Dao respectivo
     */
    public static Persona getPersona(Long id) {
	Persona obj = new Persona();

	obj.setPersona(id);

	PersonaDao dao = new PersonaDao();
	obj = dao.read(obj);

	return obj;
    }


    /*
     * Obtiene el objeto Cliente desde el Dao respectivo
     */
    public static Cliente getCliente(Long id) {
	Cliente obj = new Cliente();

	obj.setId(id);

	ClienteDao dao = new ClienteDao();
	obj = dao.read(obj);

	return obj;
    }

    /*
     * Obtiene el objeto Cliente desde el Dao respectivo
     */
    public static Lote getLote(Long id) {
	Lote obj = new Lote();

	obj.setLote(id);

	LoteDao dao = new LoteDao();
	obj = dao.read(obj);

	return obj;
    }

    /*
     * Obtiene el objeto agente desde el Dao respectivo
     */
    public static Agente getAgente(Long id) {
	Agente obj = new Agente();

	obj.setAgente(id);

	AgenteDao dao = new AgenteDao();
	obj = dao.read(obj);

	return obj;
    }

    /*
     * Obtiene el objeto ocupación desde el Dao respectivo
     */
    public static Ocupacion getOcupacion(Long id) {
	Ocupacion obj = new Ocupacion();

	obj.setOcupacion(id);

	OcupacionDao dao = new OcupacionDao();
	obj = dao.read(obj);

	return obj;
    }

    /*
     * Obtiene el objeto Concepto desde el Dao respectivo
     */
    public static Concepto getConcepto(Long id) {
	Concepto obj = new Concepto();

	obj.setConcepto(id);

	ConceptoDao dao = new ConceptoDao();
	obj = dao.read(obj);

	return obj;
    }
}