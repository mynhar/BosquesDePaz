package org.bosque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.Recibo;
import org.bosque.utils.Constantes;

public class ReciboDao {
    /**
     * 
     * @return
     */
    private Long getMaxIdRecibo() {
	Long recibo = new Long(0);
	ResultSet resultSet = null;
	Connection conexion = null;
	Statement objStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    objStatement = conexion.createStatement();

	    // String msgSQL = "select max(recibo) recibo from recibo";
	    String msgSQL = "select nvl(max(recibo),0) + 1 id from recibo";

	    resultSet = objStatement.executeQuery(msgSQL);

	    while (resultSet.next()) {
		recibo = resultSet.getLong("id");
	    }
	    /*
	     * if(recibo != null && !recibo.equals(new Long(0))) { recibo =
	     * recibo + 1; } else if(recibo <= new Long(0)) { recibo = new
	     * Long(1); } else { recibo = new Long(1); }
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
	return recibo;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Recibo create(Recibo obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "insert into recibo("
		    + "recibo, cliente, factura, fec_recibo, concepto, tipo_pago, monto, estado_recibo) "
		    + "values(?, ?, ?, ?, ?, ?, ?, ?)";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    obj.setRecibo(this.getMaxIdRecibo());

	    preparedStatement.setLong(1, obj.getRecibo());
	    preparedStatement.setLong(2, obj.getCliente().getId());
	    preparedStatement.setLong(3, obj.getFactura().getIdFactura());
	    preparedStatement.setDate(4, new java.sql.Date(obj.getFecRecibo().getTime()));
	    preparedStatement.setLong(5, obj.getConcepto().getConcepto());
	    preparedStatement.setString(6, obj.getTipoPago());
	    preparedStatement.setBigDecimal(7, obj.getMonto());
	    preparedStatement.setString(8, obj.getEstadoRecibo());

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
    public Recibo update(Recibo obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql =
	    	"update recibo " +
	    	"set    cliente = ?, " +
	    	"       factura = ?, " +
	    	"       fec_recibo = ?, " +
	    	"       concepto = ?, " +
	    	"       tipo_pago = ?, " +
	    	"       monto = ?, " +
	    	"       estado_recibo = ? " +
	    	" where recibo = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getCliente().getId());
	    preparedStatement.setLong(2, obj.getCliente().getId());
	    preparedStatement.setLong(3, obj.getFactura().getIdFactura());
	    preparedStatement.setDate(4, new java.sql.Date(obj.getFecRecibo().getTime()));
	    preparedStatement.setLong(5, obj.getConcepto().getConcepto());
	    preparedStatement.setString(6, obj.getTipoPago());
	    preparedStatement.setBigDecimal(7, obj.getMonto());
	    preparedStatement.setLong(8, obj.getRecibo());

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
    public Recibo read(Recibo obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    // "recibo, cliente, factura, fec_recibo, concepto, tipo_pago, monto, estado_recibo) " +

	    String sql = "select recibo, cliente, factura, fec_recibo, concepto, tipo_pago, monto, estado_recibo " +
		    "from recibo where recibo = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getRecibo());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setRecibo(resultSet.getLong("recibo"));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setFactura(Constantes.getFactura(resultSet.getLong("factura")));
		obj.setFecRecibo(resultSet.getDate("fec_recibo"));
		obj.setConcepto(Constantes.getConcepto(resultSet.getLong("concepto")));
		obj.setTipoPago(resultSet.getString("tipo_pago"));
		obj.setMonto(resultSet.getBigDecimal("monto"));
		obj.setEstadoRecibo(resultSet.getString("estado_recibo"));
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
    public boolean delete(Recibo obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from recibo where recibo = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getRecibo());

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
    public List<Recibo> getList() {
	List<Recibo> objList = new ArrayList<Recibo>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select recibo, cliente, factura, fec_recibo, concepto, tipo_pago, monto, estado_recibo " +
		    "from recibo";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // preparedStatement.setLong(1,obj.getIdRecibo());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		Recibo obj = new Recibo();

		obj.setRecibo(resultSet.getLong("recibo"));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setFactura(Constantes.getFactura(resultSet.getLong("factura")));
		obj.setFecRecibo(resultSet.getDate("fec_recibo"));
		obj.setConcepto(Constantes.getConcepto(resultSet.getLong("concepto")));
		obj.setTipoPago(resultSet.getString("tipo_pago"));
		obj.setMonto(resultSet.getBigDecimal("monto"));
		obj.setEstadoRecibo(resultSet.getString("estado_recibo"));

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