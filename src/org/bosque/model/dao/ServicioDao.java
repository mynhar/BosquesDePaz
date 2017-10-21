package org.bosque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bosque.model.bean.Servicio;
import org.bosque.utils.Constantes;

public class ServicioDao {
    /**
     * 
     * @return
     */
    private Long getMaxIdServicio() {
	Long servicio = new Long(0);
	ResultSet resultSet = null;
	Connection conexion = null;
	Statement objStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    objStatement = conexion.createStatement();

	    // String msgSQL = "select max(servicio) servicio from servicio";
	    String msgSQL = "select nvl(max(servicio),0) + 1 id from servicio";

	    resultSet = objStatement.executeQuery(msgSQL);

	    while (resultSet.next()) {
		servicio = resultSet.getLong("id");
	    }
	    /*
	     * if(servicio != null && !servicio.equals(new Long(0))) { servicio
	     * = servicio + 1; } else if(servicio <= new Long(0)) { servicio =
	     * new Long(1); } else { servicio = new Long(1); }
	     */

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	} finally {
	    try {
		if (resultSet != null) {
		    resultSet.close();
		}
		if (objStatement != null) {
		    objStatement.close();
		}
		if (conexion != null) {
		    conexion.close();
		}
	    } catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	    }
	}
	return servicio;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Servicio create(Servicio obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "insert into SERVICIO(SERVICIO,FACTURA,CLIENTE,AGENTE,PRE_SOLICITUD,CONTRATO,CONCEPTO,PERSONA,LOTE,NICHO,IND_TRASLADO,FEC_EJECUCION,FEC_CONTRATACION,COSTO_SERVICIO)"
	    			+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    obj.setServicio(this.getMaxIdServicio());

	    preparedStatement.setLong(1, obj.getServicio());
	    preparedStatement.setLong(2, obj.getFactura().getIdFactura());
	    preparedStatement.setLong(3, obj.getCliente().getId());
	    preparedStatement.setLong(4, obj.getAgente().getAgente());
	    preparedStatement.setLong(5, obj.getPreSolicitud());
	    preparedStatement.setLong(6, obj.getContrato());
	    preparedStatement.setLong(7, obj.getConcepto().getConcepto());
	    preparedStatement.setLong(8, obj.getPersona().getPersona());
	    if(obj.getLote() != null){
	    	preparedStatement.setLong(9, obj.getLote().getLote());
	    }else{
	    	preparedStatement.setNull(9, java.sql.Types.INTEGER);
	    }
	    
	    preparedStatement.setString(10, obj.getNicho());
	    preparedStatement.setString(11, obj.getIndTraslado());
	    preparedStatement.setDate(12, new java.sql.Date(obj.getFecEjecucion().getTime()));
	    //preparedStatement.setDate(13, new java.sql.Date(obj.getFecContratacion().getTime()));
	    preparedStatement.setDate(13, new java.sql.Date((new Date()).getTime()));
	    preparedStatement.setBigDecimal(14, obj.getCostoServicio());

	    // 4. Ejecutar SQL
	    int result = preparedStatement.executeUpdate();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	} finally {
	    try {
		if (preparedStatement != null) {
		    preparedStatement.close();
		}

		if (conexion != null) {
		    conexion.close();
		}

	    } catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	    }
	}

	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Servicio update(Servicio obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		    "update servicio " +
		    "set    factura = ?, " +
		    "       cliente = ?, " +
		    "       agente = ?, " +
		    "       pre_solicitud = ?, " +
		    "       contrato = ?, " +
		    "       concepto = ?, " +
		    "       persona = ?, " +
		    "       lote = ?, " +
		    "       nicho = ?, " +
		    "       ind_traslado = ?, " +
		    "       fec_ejecucion = ?, " +
		    "       fec_contratacion = ?, " +
		    "       costo_servicio = ? " +
		    "where servicio = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getFactura().getIdFactura());
	    preparedStatement.setLong(2, obj.getCliente().getId());
	    preparedStatement.setLong(3, obj.getAgente().getAgente());
	    preparedStatement.setLong(4, obj.getPreSolicitud());
	    preparedStatement.setLong(5, obj.getContrato());
	    preparedStatement.setLong(6, obj.getConcepto().getConcepto());
	    preparedStatement.setLong(7, obj.getPersona().getPersona());
	    
	    if(obj.getLote() != null){
	    	preparedStatement.setLong(8, obj.getLote().getLote());
	    }else{
	    	preparedStatement.setNull(8, java.sql.Types.INTEGER);
	    }
	    
	    preparedStatement.setString(9, obj.getNicho());
	    preparedStatement.setString(10, obj.getIndTraslado());
	    preparedStatement.setDate(11, new java.sql.Date(obj.getFecEjecucion().getTime()));
	    //preparedStatement.setDate(12, new java.sql.Date(obj.getFecContratacion().getTime()));
	    preparedStatement.setDate(12, new java.sql.Date((new Date()).getTime()));
	    preparedStatement.setBigDecimal(13, obj.getCostoServicio());
	    preparedStatement.setLong(14, obj.getServicio());
	    
	    // 4. Ejecutar SQL
	    int result = preparedStatement.executeUpdate();

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	} finally {
	    try {
		if (preparedStatement != null) {
		    preparedStatement.close();
		}
		if (conexion != null) {
		    conexion.close();
		}
	    } catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	    }
	}
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Servicio read(Servicio obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		"select servicio, factura, cliente, agente, pre_solicitud, contrato,  " +
	        "       concepto, persona, lote, nicho, ind_traslado, fec_ejecucion, fec_contratacion, " +
	        "       costo_servicio " +
	    	"from   servicio " +
		"where  servicio = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getServicio());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setServicio(resultSet.getLong("servicio"));
		obj.setFactura(Constantes.getFactura(resultSet.getLong("factura")));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("agente")));
		obj.setPreSolicitud(resultSet.getLong("pre_solicitud"));
		obj.setContrato(resultSet.getLong("contrato"));
		obj.setConcepto(Constantes.getConcepto(resultSet.getLong("concepto")));
		obj.setPersona(Constantes.getPersona(resultSet.getLong("persona")));
		obj.setLote(Constantes.getLote(resultSet.getLong("lote")));
		obj.setNicho(resultSet.getString("nicho"));
		obj.setIndTraslado(resultSet.getString("ind_traslado"));
		obj.setFecEjecucion(resultSet.getDate("fec_ejecucion"));
		obj.setFecContratacion(resultSet.getDate("fec_contratacion"));
		obj.setCostoServicio(resultSet.getBigDecimal("costo_servicio"));
	    }

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	} finally {
	    try {
		if (resultSet != null) {
		    resultSet.close();
		}
		if (preparedStatement != null) {
		    preparedStatement.close();
		}
		if (conexion != null) {
		    conexion.close();
		}
	    } catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	    }
	}
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Servicio obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from servicio where servicio = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getServicio());

	    // 4. Ejecutar SQL
	    int result = preparedStatement.executeUpdate();
	    if (result > 0) {
		return true;
	    }

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	} finally {
	    try {
		if (preparedStatement != null) {
		    preparedStatement.close();
		}
		if (conexion != null) {
		    conexion.close();
		}
	    } catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	    }
	}
	return false;
    }

    /**
     * 
     * @return
     */
    public List<Servicio> getList() {
	List<Servicio> objList = new ArrayList<Servicio>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = 
		"select servicio, factura, cliente, agente, pre_solicitud, contrato,  " +
	        "       concepto, persona, lote, nicho, ind_traslado, fec_ejecucion, fec_contratacion, " +
	        "       costo_servicio " +
	    	"from   servicio ";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // preparedStatement.setLong(1,obj.getIdServicio());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		Servicio obj = new Servicio();

		obj.setServicio(resultSet.getLong("servicio"));
		obj.setFactura(Constantes.getFactura(resultSet.getLong("factura")));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("agente")));
		obj.setPreSolicitud(resultSet.getLong("pre_solicitud"));
		obj.setContrato(resultSet.getLong("contrato"));
		obj.setConcepto(Constantes.getConcepto(resultSet.getLong("concepto")));
		obj.setPersona(Constantes.getPersona(resultSet.getLong("persona")));
		obj.setLote(Constantes.getLote(resultSet.getLong("lote")));
		obj.setNicho(resultSet.getString("nicho"));
		obj.setIndTraslado(resultSet.getString("ind_traslado"));
		obj.setFecEjecucion(resultSet.getDate("fec_ejecucion"));
		obj.setFecContratacion(resultSet.getDate("fec_contratacion"));
		obj.setCostoServicio(resultSet.getBigDecimal("costo_servicio"));

		objList.add(obj);
	    }
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	} finally {
	    try {
		if (resultSet != null) {
		    resultSet.close();
		}
		if (preparedStatement != null) {
		    preparedStatement.close();
		}
		if (conexion != null) {
		    conexion.close();
		}
	    } catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	    }
	}
	return objList;
    }
}