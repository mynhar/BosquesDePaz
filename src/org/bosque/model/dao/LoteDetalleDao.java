package org.bosque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.LoteDetalle;
import org.bosque.utils.Constantes;

public class LoteDetalleDao {

    /**
     * 
     * @param obj
     * @return
     */
    public LoteDetalle create(LoteDetalle obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "insert into loteDetalle(lote, nicho, persona, fec_suceso, estado_nicho "
		    + "values(?, ?, ?, ?, ?)";

	    preparedStatement = conexion.prepareStatement(sql);

	    preparedStatement.setLong(1, obj.getLote().getLote());
	    preparedStatement.setString(2, obj.getNicho());
	    preparedStatement.setLong(3, obj.getPersona().getPersona());
	    preparedStatement.setDate(4, new java.sql.Date(obj.getFecSuceso().getTime()));
	    preparedStatement.setString(5, obj.getEstadoNicho());

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
    public LoteDetalle update(LoteDetalle obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "update lote_detalle " + "set   fec_suceso = ?, " + "      estado_nicho = ? "
		    + "where lote    = ? " + "and   nicho   = ? " + "and   persona = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getPersona().getPersona());
	    preparedStatement.setDate(2, new java.sql.Date(obj.getFecSuceso().getTime()));
	    preparedStatement.setString(3, obj.getEstadoNicho());
	    preparedStatement.setLong(4, obj.getLote().getLote());
	    preparedStatement.setString(5, obj.getNicho());

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
    public LoteDetalle read(LoteDetalle obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select lote, nicho, persona, fec_suceso, estado_nicho " + "from lote_detalle "
		    + "where lote    = ? " + "and   nicho   = ? " + "and   persona = ? ";

	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getLote().getLote());
	    preparedStatement.setString(2, obj.getNicho());
	    preparedStatement.setLong(3, obj.getPersona().getPersona());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setLote(Constantes.getLote(resultSet.getLong("lote")));
		obj.setNicho(resultSet.getString("nicho"));
		obj.setPersona(Constantes.getPersona(resultSet.getLong("persona")));
		obj.setFecSuceso(new java.sql.Date(resultSet.getDate("fec_suceso").getTime()));
		obj.setEstadoNicho(resultSet.getString("estado_lote"));
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
    public boolean delete(LoteDetalle obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from lote_detalle where lote = ? and nicho = ? and persona = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getLote().getLote());
	    preparedStatement.setString(2, obj.getNicho());
	    preparedStatement.setLong(3, obj.getPersona().getPersona());

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
    public List<LoteDetalle> getList(LoteDetalle objDet) {
	List<LoteDetalle> objList = new ArrayList<LoteDetalle>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select lote, nicho, persona, fec_suceso, estado_nicho " + "from lote_detalle "
		    + "where lote     = ? ";

	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, objDet.getLote().getLote());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		LoteDetalle obj = new LoteDetalle();

		obj.setLote(Constantes.getLote(resultSet.getLong("lote")));
		obj.setNicho(resultSet.getString("nicho"));
		obj.setPersona(Constantes.getPersona(resultSet.getLong("persona")));
		obj.setFecSuceso(new java.sql.Date(resultSet.getDate("fec_suceso").getTime()));
		obj.setEstadoNicho(resultSet.getString("estado_lote"));

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