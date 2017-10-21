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

import org.bosque.model.bean.Lote;

public class LoteDao {
    /**
     * 
     * @return
     */
    private Long getMaxIdLote() {
	Long lote = new Long(0);
	ResultSet resultSet = null;
	Connection conexion = null;
	Statement objStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    objStatement = conexion.createStatement();

	    // String msgSQL = "select max(lote) lote from lote";
	    String msgSQL = "select nvl(max(lote),0) + 1 id from lote";

	    resultSet = objStatement.executeQuery(msgSQL);

	    while (resultSet.next()) {
		lote = resultSet.getLong("id");
	    }
	    /*
	     * if(lote != null && !lote.equals(new Long(0))) { lote = lote + 1;
	     * } else if(lote <= new Long(0)) { lote = new Long(1); } else {
	     * lote = new Long(1); }
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
	return lote;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Lote create(Lote obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "insert into lote(lote, zona, fila, secuencia, folio, plano, fec_venta, fec_ult_pago, costo, saldo, estado_lote) "
		    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    obj.setLote(this.getMaxIdLote());

	    preparedStatement.setLong(1, obj.getLote());
	    preparedStatement.setString(2, obj.getZona());
	    preparedStatement.setString(3, obj.getFila());
	    preparedStatement.setLong(4, obj.getSecuencia());
	    preparedStatement.setString(5, obj.getFolio());
	    preparedStatement.setString(6, obj.getPlano());
	    preparedStatement.setDate(7, new java.sql.Date(obj.getFecVenta().getTime()));
	    preparedStatement.setDate(8, new java.sql.Date(obj.getFecUltimoPago().getTime()));
	    preparedStatement.setBigDecimal(9, obj.getCosto());
	    preparedStatement.setBigDecimal(10, obj.getSaldo());
	    preparedStatement.setString(11, obj.getEstadoLote());

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
    public Lote update(Lote obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "update lote " + "  set    zona = ?, " + "         fila = ?, " + "         secuencia = ?, "
		    + "         folio = ?, " + "         plano = ?, " + "         fec_venta = ?, "
		    + "         fec_ult_pago = ?, " + "         costo = ?, " + "         saldo = ?, "
		    + "         estado_lote = ? " + " where   lote = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setString(1, obj.getZona());
	    preparedStatement.setString(2, obj.getFila());
	    preparedStatement.setLong(3, obj.getSecuencia());
	    preparedStatement.setString(4, obj.getFolio());
	    preparedStatement.setString(5, obj.getPlano());
	    preparedStatement.setDate(6, new java.sql.Date(obj.getFecVenta().getTime()));
	    preparedStatement.setDate(7, new java.sql.Date(obj.getFecUltimoPago().getTime()));
	    preparedStatement.setBigDecimal(8, obj.getCosto());
	    preparedStatement.setBigDecimal(9, obj.getSaldo());
	    preparedStatement.setString(10, obj.getEstadoLote());
	    preparedStatement.setLong(11, obj.getLote());

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
    public Lote read(Lote obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select lote, zona, fila, secuencia, folio, plano, fec_venta, fec_ult_pago, costo, saldo, estado_lote "
		    + "from lote " + "where lote = ?";

	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getLote());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setLote(resultSet.getLong("lote"));
		obj.setZona(resultSet.getString("zona"));
		obj.setFila(resultSet.getString("fila"));
		obj.setSecuencia(resultSet.getLong("secuencia"));
		obj.setFolio(resultSet.getString("folio"));
		obj.setPlano(resultSet.getString("plano"));
		obj.setFecVenta(resultSet.getDate("fec_venta"));
		obj.setFecUltimoPago(resultSet.getDate("fec_ult_pago"));
		obj.setCosto(resultSet.getBigDecimal("costo"));
		obj.setSaldo(resultSet.getBigDecimal("saldo"));
		obj.setEstadoLote(resultSet.getString("estado_lote"));
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
    public boolean delete(Lote obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from lote where lote = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getLote());

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
    public List<Lote> getList() {
	List<Lote> objList = new ArrayList<Lote>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select lote, zona, fila, secuencia, folio, plano, fec_venta, fec_ult_pago, costo, saldo, estado_lote "
		    + "from lote";

	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // preparedStatement.setLong(1,obj.getIdLote());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		Lote obj = new Lote();

		obj.setLote(resultSet.getLong("lote"));
		obj.setZona(resultSet.getString("zona"));
		obj.setFila(resultSet.getString("fila"));
		obj.setSecuencia(resultSet.getLong("secuencia"));
		obj.setFolio(resultSet.getString("folio"));
		obj.setPlano(resultSet.getString("plano"));
		obj.setFecVenta(resultSet.getDate("fec_venta"));
		obj.setFecUltimoPago(resultSet.getDate("fec_ult_pago"));
		obj.setCosto(resultSet.getBigDecimal("costo"));
		obj.setSaldo(resultSet.getBigDecimal("saldo"));
		obj.setEstadoLote(resultSet.getString("estado_lote"));

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