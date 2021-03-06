package org.bosque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.Cliente;
import org.bosque.utils.Constantes;

public class ClienteDao {
    /**
     * 
     * @return
     */
    private Long getMaxIdCliente() {
	Long persona = new Long(0);
	ResultSet resultSet = null;
	Connection conexion = null;
	Statement objStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    objStatement = conexion.createStatement();

	    // String msgSQL = "select max(persona) persona from persona";
	    String msgSQL = "select nvl(max(cliente),0) + 1 id from cliente";

	    resultSet = objStatement.executeQuery(msgSQL);

	    while (resultSet.next()) {
		persona = resultSet.getLong("id");
	    }
	    /*
	     * if(persona != null && !persona.equals(new Long(0))) { persona =
	     * persona + 1; } else if(persona <= new Long(0)) { persona = new
	     * Long(1); } else { persona = new Long(1); }
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
	return persona;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Cliente create(Cliente obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "insert into cliente(" + "cliente, persona, pre_solicitud, contrato, agente, fec_apertura_cta)"
		    + "values(?, ?, ?, ?, ?, ?)";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    obj.setId(this.getMaxIdCliente());

	    preparedStatement.setLong(1, obj.getId());
	    preparedStatement.setLong(2, obj.getPersona().getPersona());
	    preparedStatement.setLong(3, obj.getPreSolicitud());
	    preparedStatement.setLong(4, obj.getContrato());

	    if (obj.getAgente() == null) {
		preparedStatement.setNull(5, 0);
	    } else {
		preparedStatement.setLong(5, obj.getAgente().getAgente());
	    }
	    preparedStatement.setDate(6, new java.sql.Date(obj.getFecAperturaCta().getTime()));

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
    public Cliente update(Cliente obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "update cliente " + "  set persona = ?, " + "      pre_solicitud = ?,  "
		    + "      contrato = ?,  " + "      agente = ?,  " + "      fec_apertura_cta = ?,  "
		    + " where Cliente = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getPersona().getPersona());
	    preparedStatement.setLong(2, obj.getPreSolicitud());
	    preparedStatement.setLong(3, obj.getContrato());
	    preparedStatement.setLong(4, obj.getAgente().getAgente());
	    preparedStatement.setDate(5, new java.sql.Date(obj.getFecAperturaCta().getTime()));
	    preparedStatement.setLong(6, obj.getId());

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
    public Cliente read(Cliente obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select * from cliente where cliente = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getId());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setId(resultSet.getLong("cliente"));
		obj.setPersona(Constantes.getPersona(resultSet.getLong("persona")));
		obj.setPreSolicitud(resultSet.getLong("pre_solicitud"));
		obj.setContrato(resultSet.getLong("contrato"));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("agente")));
		obj.setFecAperturaCta(resultSet.getDate("fec_apertura_cta"));
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
    public boolean delete(Cliente obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from cliente where cliente = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getId());

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
    public List<Cliente> getList() {
	List<Cliente> objList = new ArrayList<Cliente>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select * from cliente";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // preparedStatement.setLong(1,obj.getIdCliente());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		Cliente obj = new Cliente();

		obj.setId(resultSet.getLong("CLIENTE"));
		obj.setPersona(Constantes.getPersona(resultSet.getLong("PERSONA")));
		obj.setPreSolicitud(resultSet.getLong("PRE_SOLICITUD"));
		obj.setContrato(resultSet.getLong("CONTRATO"));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("AGENTE")));
		obj.setFecAperturaCta(resultSet.getDate("FEC_APERTURA_CTA"));

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