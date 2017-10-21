package org.bosque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.Transaccion;
import org.bosque.model.bean.TransaccionDetalle;
import org.bosque.utils.Constantes;

public class TransaccionDetalleDao {

    /**
     * 
     * @param obj
     * @return
     */
    public TransaccionDetalle create(TransaccionDetalle obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		    "insert into transaccion_det(" +
		    "    transaccion, tipo_trans, fec_aplica, cliente, tipo_aplica, num_aplica, monto_aplica) " +
		    "values(?, ?, ?, ?, ?)";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // obj.setTransaccion(this.getMaxIdTransaccion());

	    preparedStatement.setLong(1, obj.getTransaccion());
	    preparedStatement.setString(2, obj.getTipoTransaccion());
	    preparedStatement.setDate(3, new java.sql.Date(obj.getFecAplica().getTime()));
	    preparedStatement.setLong(4, obj.getCliente().getId());
	    preparedStatement.setString(5, obj.getTipoAplica());
	    preparedStatement.setLong(6, obj.getNumAplica());
	    preparedStatement.setBigDecimal(7, obj.getMontoAplica());

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
    public TransaccionDetalle update(TransaccionDetalle obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");
	    //"    transaccion, tipo_trans, cliente, tipo_aplica, num_aplica) " +

	    // 2. Crear objecto statement
	    String sql =
		    "update transaccion_det " +
		    "set    fec_aplica = ?, " +
		    "       cliente = ?, " +
		    "       monto_aplica = ? " +
		    "where  transaccion = ?" +
		    "and    tipo_trans  = ?" +
		    "and    num_aplica  = ?" +
		    "and    tipo_aplica = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setDate(1, new java.sql.Date(obj.getFecAplica().getTime()));
	    preparedStatement.setLong(2, obj.getCliente().getId());
	    preparedStatement.setBigDecimal(3, obj.getMontoAplica());
	    preparedStatement.setLong(4, obj.getTransaccion());
	    preparedStatement.setString(5, obj.getTipoTransaccion());
	    preparedStatement.setString(6, obj.getTipoAplica());
	    preparedStatement.setLong(7, obj.getNumAplica());

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
    public TransaccionDetalle read(TransaccionDetalle obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		    "select transaccion, tipo_trans, fec_aplica, cliente, " +
		    "       tipo_aplica, num_aplica, monto_aplica " +
		    "from   transaccion_det " +
		    "where  transaccion = ? " +
		    "and    tipo_trans = ? " +
		    "and    num_aplica = ? " +
		    "and    tipo_aplica = ? ";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getTransaccion());
	    preparedStatement.setString(2, obj.getTipoTransaccion());
	    preparedStatement.setLong(3, obj.getNumAplica());
	    preparedStatement.setString(4, obj.getTipoAplica());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setTransaccion(resultSet.getLong("transaccion"));
		obj.setTipoTransaccion(resultSet.getString("tipo_trans"));
		obj.setFecAplica(resultSet.getDate("fec_aplica"));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setNumAplica(resultSet.getLong("tipo_aplica"));
		obj.setNumAplica(resultSet.getLong("num_aplica"));
		obj.setMontoAplica(resultSet.getBigDecimal("monto_aplica"));
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
    public boolean delete(TransaccionDetalle obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from transaccion where transaccion = ? and tipo_trans = ? and num_aplica = ? and tipo_aplica = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getTransaccion());
	    preparedStatement.setString(2, obj.getTipoTransaccion());
	    preparedStatement.setLong(3, obj.getNumAplica());
	    preparedStatement.setString(4, obj.getTipoAplica());

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
    public List<TransaccionDetalle> getList(TransaccionDetalle trn) {
	List<TransaccionDetalle> objList = new ArrayList<TransaccionDetalle>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
		    "select transaccion, tipo_trans, fec_aplica, cliente, " +
		    "       tipo_aplica, num_aplica, monto_aplica " +
		    "from   transaccion_det " +
		    "where  transaccion = ? " +
		    "and    tipo_trans = ? ";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, trn.getCliente().getId());
	    preparedStatement.setString(2, trn.getTipoTransaccion());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		TransaccionDetalle obj = new TransaccionDetalle();

		obj.setTransaccion(resultSet.getLong("transaccion"));
		obj.setTipoTransaccion(resultSet.getString("tipo_trans"));
		obj.setFecAplica(resultSet.getDate("fec_aplica"));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setNumAplica(resultSet.getLong("tipo_aplica"));
		obj.setNumAplica(resultSet.getLong("num_aplica"));
		obj.setMontoAplica(resultSet.getBigDecimal("monto_aplica"));

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