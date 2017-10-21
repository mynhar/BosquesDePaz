package org.bosque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.Transaccion;
import org.bosque.utils.Constantes;

public class TransaccionDao {
    /**
     * 
     * @return
     */
    private Long getMaxIdTransaccion() {
	Long transaccion = new Long(0);
	ResultSet resultSet = null;
	Connection conexion = null;
	Statement objStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    objStatement = conexion.createStatement();

	    // String msgSQL = "select max(transaccion) transaccion from transaccion";
	    String msgSQL = "select nvl(max(transaccion),0) + 1 id from transaccion";

	    resultSet = objStatement.executeQuery(msgSQL);

	    while (resultSet.next()) {
		transaccion = resultSet.getLong("id");
	    }
	    /*
	     * if(transaccion != null && !transaccion.equals(new Long(0))) { transaccion
	     * = transaccion + 1; } else if(transaccion <= new Long(0)) { transaccion =
	     * new Long(1); } else { transaccion = new Long(1); }
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
	return transaccion;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Transaccion create(Transaccion obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		    "insert into transaccion(" +
		    "    transaccion, tipo_trans, cliente, agente, fec_trans, aplicar, vence, monto, saldo, " +
		    "    estado_trans) " +
		    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // obj.setTransaccion(this.getMaxIdTransaccion());

	    preparedStatement.setLong(1, obj.getTransaccion());
	    preparedStatement.setString(2, obj.getTipoTransaccion());
	    preparedStatement.setLong(3, obj.getCliente().getId());
	    preparedStatement.setLong(4, obj.getAgente().getAgente());
	    preparedStatement.setDate(5, new java.sql.Date(obj.getFecTransaccion().getTime()));
	    preparedStatement.setLong(6, obj.getAplicar());
	    preparedStatement.setDate(7, new java.sql.Date(obj.getVence().getTime()));
	    preparedStatement.setBigDecimal(8, obj.getMonto());
	    preparedStatement.setBigDecimal(9, obj.getSaldo());
	    preparedStatement.setString(10, obj.getEstadoTransaccion());

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
    public Transaccion update(Transaccion obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		    "update transaccion " +
		    "set    tipo_trans = ?, " +
		    "       cliente = ?, " +
		    "       agente = ?, " +
		    "       fec_trans = ?, " +
		    "       aplicar = ?, " +
		    "       vence = ?, " +
		    "       monto = ?, " +
		    "       saldo = ?, " +
		    "       estado_trans = ? " +
		    "where  transaccion = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setString(1, obj.getTipoTransaccion());
	    preparedStatement.setLong(2, obj.getCliente().getId());
	    preparedStatement.setLong(3, obj.getAgente().getAgente());
	    preparedStatement.setDate(4, new java.sql.Date(obj.getFecTransaccion().getTime()));
	    preparedStatement.setLong(5, obj.getAplicar());
	    preparedStatement.setDate(6, new java.sql.Date(obj.getVence().getTime()));
	    preparedStatement.setBigDecimal(7, obj.getMonto());
	    preparedStatement.setBigDecimal(8, obj.getSaldo());
	    preparedStatement.setString(9, obj.getEstadoTransaccion());
	    preparedStatement.setLong(10, obj.getTransaccion());

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
    public Transaccion read(Transaccion obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		    "select transaccion, tipo_trans, cliente, agente, fec_trans, " +
		    "       aplicar, vence, monto, saldo, estado_transaccion " +
		    "from   transaccion " +
		    "where  transaccion = ? ";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getTransaccion());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setTransaccion(resultSet.getLong("transaccion"));
		obj.setTipoTransaccion(resultSet.getString("tipo_trans"));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("agente")));
		obj.setFecTransaccion(resultSet.getDate("fec_trans"));
		obj.setAplicar(resultSet.getLong("aplicar"));
		obj.setVence(resultSet.getDate("vence"));
		obj.setMonto(resultSet.getBigDecimal("monto"));
		obj.setSaldo(resultSet.getBigDecimal("saldo"));
		obj.setEstadoTransaccion(resultSet.getString("estado_trans"));
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
    public boolean delete(Transaccion obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from transaccion where transaccion = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getTransaccion());

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
    public List<Transaccion> getList(Transaccion trn) {
	List<Transaccion> objList = new ArrayList<Transaccion>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		    "select transaccion, tipo_trans, cliente, agente, fec_trans, " +
		    "       aplicar, vence, monto, saldo, estado_transaccion " +
		    "from   transaccion " +
		    "where  cliente = ? ";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, trn.getCliente().getId());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		Transaccion obj = new Transaccion();

		obj.setTransaccion(resultSet.getLong("transaccion"));
		obj.setTipoTransaccion(resultSet.getString("tipo_trans"));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("agente")));
		obj.setFecTransaccion(resultSet.getDate("fec_trans"));
		obj.setAplicar(resultSet.getLong("aplicar"));
		obj.setVence(resultSet.getDate("vence"));
		obj.setMonto(resultSet.getBigDecimal("monto"));
		obj.setSaldo(resultSet.getBigDecimal("saldo"));
		obj.setEstadoTransaccion(resultSet.getString("estado_trans"));

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