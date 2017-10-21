package org.bosque.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.Placa;
import org.bosque.utils.Constantes;

public class PlacaDao {
    /**
     * 
     * @return
     */
    private Long getMaxIdPlaca() {
	Long placa = new Long(0);
	ResultSet resultSet = null;
	Connection conexion = null;
	Statement objStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    objStatement = conexion.createStatement();

	    // String msgSQL = "select max(placa) placa from placa";
	    String msgSQL = "select nvl(max(placa),0) + 1 id from placa";

	    resultSet = objStatement.executeQuery(msgSQL);

	    while (resultSet.next()) {
		placa = resultSet.getLong("id");
	    }
	    /*
	     * if(placa != null && !placa.equals(new Long(0))) { placa = placa +
	     * 1; } else if(placa <= new Long(0)) { placa = new Long(1); } else
	     * { placa = new Long(1); }
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
	return placa;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Placa create(Placa obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "insert into placa(placa, factura, cliente, agente, fec_solicitud, fec_entrega, " +
		    "persona, fec_nacimiento, fec_defuncion,  " +
		    "adorno, tamano, texto, tipo_letra, lote, costo_placa) " +
		    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    obj.setPlaca(this.getMaxIdPlaca());

	    preparedStatement.setLong(1, obj.getPlaca());
	    preparedStatement.setLong(2, obj.getFactura().getIdFactura());
	    preparedStatement.setLong(3, obj.getCliente().getId());
	    preparedStatement.setLong(4, obj.getAgente().getAgente());
	    preparedStatement.setDate(5, new java.sql.Date(obj.getFecSolicitud().getTime()));
	    preparedStatement.setDate(6, new java.sql.Date(obj.getFecEntrega().getTime()));
	    preparedStatement.setLong(7, obj.getPersona().getPersona());
	    preparedStatement.setDate(8, new java.sql.Date(obj.getFecNacimiento().getTime()));
	    preparedStatement.setDate(9, new java.sql.Date(obj.getFecDefuncion().getTime()));
	    preparedStatement.setString(10, obj.getAdorno());
	    preparedStatement.setString(11, obj.getTamano());
	    preparedStatement.setString(12, obj.getTexto());
	    preparedStatement.setString(13, obj.getTipoLetra());
	    preparedStatement.setLong(14, obj.getLote().getLote());
	    preparedStatement.setBigDecimal(15, obj.getCostoPlaca());

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
    public Placa update(Placa obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		    "update placa " +
		    "set    factura = ?, " +
		    "       cliente = ?, " +
		    "       agente = ?, " +
		    "       fec_solicitud = ?, " +
		    "       fec_entrega = ?, " +
		    "       persona = ?, " +
		    "       fec_nacimiento = ?, " +
		    "       fec_defuncion = ?, " +
		    "       adorno = ?, " +
		    "       tamano = ?, " +
		    "       texto = ?, " +
		    "       tipo_letra = ?, " +
		    "       lote = ?, " +
		    "       costo_placa = ? " +
		    "where  placa = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getFactura().getIdFactura());
	    preparedStatement.setLong(2, obj.getCliente().getId());
	    preparedStatement.setLong(3, obj.getAgente().getAgente());
	    preparedStatement.setDate(4, new java.sql.Date(obj.getFecSolicitud().getTime()));
	    preparedStatement.setDate(5, new java.sql.Date(obj.getFecEntrega().getTime()));
	    preparedStatement.setLong(6, obj.getPersona().getPersona());
	    preparedStatement.setDate(7, new java.sql.Date(obj.getFecNacimiento().getTime()));
	    preparedStatement.setDate(8, new java.sql.Date(obj.getFecDefuncion().getTime()));
	    preparedStatement.setString(9, obj.getAdorno());
	    preparedStatement.setString(10, obj.getTamano());
	    preparedStatement.setString(11, obj.getTexto());
	    preparedStatement.setString(12, obj.getTipoLetra());
	    preparedStatement.setLong(13, obj.getLote().getLote());
	    preparedStatement.setBigDecimal(14, obj.getCostoPlaca());
	    preparedStatement.setLong(15, obj.getPlaca());

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
    public Placa read(Placa obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select placa, factura, cliente, agente, fec_solicitud, fec_entrega, " +
		    "persona, fec_nacimiento, fec_defuncion,  " +
		    "adorno, tamano, texto, tipo_letra, lote, costo_placa " +
		    "from placa " +
		    "where placa = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getPlaca());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setPlaca(resultSet.getLong("placa"));
		obj.setFactura(Constantes.getFactura(resultSet.getLong("factura")));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("agente")));
		obj.setFecSolicitud(resultSet.getDate("fec_solicitud"));
		obj.setFecEntrega(resultSet.getDate("fec_entrega"));
		obj.setPersona(Constantes.getPersona(resultSet.getLong("persona")));
		obj.setFecNacimiento(resultSet.getDate("fec_nacimiento"));
		obj.setFecDefuncion(resultSet.getDate("fec_defuncion"));
		obj.setAdorno(resultSet.getString("adorno"));
		obj.setTamano(resultSet.getString("tamano"));
		obj.setTexto(resultSet.getString("Texto"));
		obj.setTipoLetra(resultSet.getString("tipo_letra"));
		obj.setLote(Constantes.getLote(resultSet.getLong("lote")));
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
    public boolean delete(Placa obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from placa where placa = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getPlaca());

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
    public List<Placa> getList() {
	List<Placa> objList = new ArrayList<Placa>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select placa, factura, cliente, agente, fec_solicitud, fec_entrega, " +
		    "persona, fec_nacimiento, fec_defuncion,  " +
		    "adorno, tamano, texto, tipo_letra, lote, costo_placa " +
		    "from placa ";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // preparedStatement.setLong(1,obj.getPlaca());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		Placa obj = new Placa();
		obj.setPlaca(resultSet.getLong("placa"));
		obj.setFactura(Constantes.getFactura(resultSet.getLong("factura")));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("agente")));
		obj.setFecSolicitud(resultSet.getDate("fec_solicitud"));
		obj.setFecEntrega(resultSet.getDate("fec_entrega"));
		obj.setPersona(Constantes.getPersona(resultSet.getLong("persona")));
		obj.setFecNacimiento(resultSet.getDate("fec_nacimiento"));
		obj.setFecDefuncion(resultSet.getDate("fec_defuncion"));
		obj.setAdorno(resultSet.getString("adorno"));
		obj.setTamano(resultSet.getString("tamano"));
		obj.setTexto(resultSet.getString("Texto"));
		obj.setTipoLetra(resultSet.getString("tipo_letra"));
		obj.setLote(Constantes.getLote(resultSet.getLong("lote")));

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