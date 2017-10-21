package org.bosque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.Mantenimiento;
import org.bosque.utils.Constantes;

public class MantenimientoDao {
    /**
     * 
     * @return
     */
    private Long getMaxIdMantenimiento() {
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
	    String msgSQL = "select nvl(max(mantenimiento),0) + 1 id from mantenimiento";

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
    public Mantenimiento create(Mantenimiento obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "insert into mantenimiento("
		    + "   mantenimiento, factura, cliente, agente, pre_solicitud, contrato, "
		    + "   fec_contratacion, fec_vence, dia_mes_pagar, meses_gracia, costo_mensual, " + "   lote)"
		    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    obj.setMantenimiento(this.getMaxIdMantenimiento());

	    preparedStatement.setLong(1, obj.getMantenimiento());
	    preparedStatement.setLong(2, obj.getFactura().getIdFactura());
	    preparedStatement.setLong(3, obj.getCliente().getId());
	    preparedStatement.setLong(4, obj.getAgente().getAgente());
	    preparedStatement.setInt(5, obj.getPreSolicitud());
	    preparedStatement.setInt(6, obj.getContrato());
	    preparedStatement.setDate(7, new java.sql.Date(obj.getFecContratacion().getTime()));
	    preparedStatement.setDate(8, new java.sql.Date(obj.getFecVence().getTime()));

	    preparedStatement.setString(9, obj.getDiaMesPagar());
	    preparedStatement.setInt(10, obj.getMesesGracia());
	    preparedStatement.setBigDecimal(11, obj.getCostoMensual());

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
    public Mantenimiento update(Mantenimiento obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "update mantenimiento " + "  set factura = ?, " + "      cliente = ?, " + "      agente = ?, "
		    + "      pre_solicitud = ?, " + "      contrato = ?, " + "      fec_contratacion = ?, "
		    + "      fec_vence = ?, " + "      dia_mes_pagar = ?, " + "      meses_gracia = ?, "
		    + "      costo_mensual = ? " + "where mantenimiento = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getFactura().getIdFactura());
	    preparedStatement.setLong(2, obj.getCliente().getId());
	    preparedStatement.setLong(3, obj.getAgente().getAgente());
	    preparedStatement.setLong(4, obj.getPreSolicitud());
	    preparedStatement.setLong(5, obj.getContrato());
	    preparedStatement.setDate(6, new java.sql.Date(obj.getFecContratacion().getTime()));
	    preparedStatement.setDate(7, new java.sql.Date(obj.getFecVence().getTime()));
	    preparedStatement.setString(8, obj.getDiaMesPagar());
	    preparedStatement.setInt(9, obj.getMesesGracia());
	    preparedStatement.setBigDecimal(10, obj.getCostoMensual());
	    preparedStatement.setLong(11, obj.getMantenimiento());

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
    public Mantenimiento read(Mantenimiento obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select mantenimiento, factura, cliente, agente, pre_solicitud, contrato, "
		    + "       fec_contratacion, fec_vence, dia_mes_pagar, meses_gracia, costo_mensual, lote "
		    + "from   mantenimiento " + "where  mantenimiento = ?";

	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getMantenimiento());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setMantenimiento(resultSet.getLong("mantenimiento"));
		obj.setFactura(Constantes.getFactura(resultSet.getLong("factura")));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("agente")));
		obj.setPreSolicitud(resultSet.getInt("pre_solicitud"));
		obj.setContrato(resultSet.getInt("contrato"));
		obj.setFecContratacion(resultSet.getDate("fec_contratacion"));
		obj.setFecVence(resultSet.getDate("fec_vence"));
		obj.setDiaMesPagar(resultSet.getString("dia_mes_pagar"));
		obj.setMesesGracia(resultSet.getInt("meses_gracia"));
		obj.setCostoMensual(resultSet.getBigDecimal("costo_mensual"));
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
    public boolean delete(Mantenimiento obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from mantenimiento where mantenimiento = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getMantenimiento());

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
    public List<Mantenimiento> getList() {
	List<Mantenimiento> objList = new ArrayList<Mantenimiento>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select * from mantenimiento";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // preparedStatement.setLong(1,obj.getIdMantenimiento());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		Mantenimiento obj = new Mantenimiento();

		obj.setMantenimiento(resultSet.getLong("mantenimiento"));
		obj.setFactura(Constantes.getFactura(resultSet.getLong("factura")));
		obj.setCliente(Constantes.getCliente(resultSet.getLong("cliente")));
		obj.setAgente(Constantes.getAgente(resultSet.getLong("agente")));
		obj.setPreSolicitud(resultSet.getInt("pre_solicitud"));
		obj.setContrato(resultSet.getInt("contrato"));
		obj.setFecContratacion(resultSet.getDate("fec_contratacion"));
		obj.setFecVence(resultSet.getDate("fec_vence"));
		obj.setDiaMesPagar(resultSet.getString("dia_mes_pagar"));
		obj.setMesesGracia(resultSet.getInt("meses_gracia"));
		obj.setCostoMensual(resultSet.getBigDecimal("costo_mensual"));
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