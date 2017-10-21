package org.bosque.model.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.Agente;
import org.bosque.model.bean.Cliente;
import org.bosque.model.bean.Factura;
import org.bosque.utils.Constantes;

import oracle.jdbc.OracleTypes;

public class FacturaDao {

    protected CallableStatement proc_stmt = null;

    /**
     * 
     * @return
     */
    private Long getMaxIdFactura() {
	Long idFactura = new Long(0);
	ResultSet resultSet = null;
	Connection conexion = null;
	Statement objStatement = null;

	try {

	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // Transaccion!
	    conexion.setAutoCommit(false); // tratar todos los SQL como bloque.
	    
	    // 2. Crear objecto statment
	    objStatement = conexion.createStatement();

	    String msgSQL = "select max(FACTURA) idFactura from factura";

	    resultSet = objStatement.executeQuery(msgSQL);

	    while (resultSet.next()) {
		idFactura = resultSet.getLong("IDFACTURA");
	    }

	    if (idFactura != null && !idFactura.equals(new Long(0))) {

		idFactura = idFactura + 1;

	    } else if (idFactura <= new Long(0)) {
		idFactura = new Long(1);

	    } else {
		idFactura = new Long(1);

	    }
	    
	    conexion.commit();

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	    
	    try {
			conexion.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

	return idFactura;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Factura create(Factura obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");
	    
	    conexion.setAutoCommit(false);

	    // 2. Crear objecto statment
	    String sql = "insert into Factura(FACTURA,TIPO_FACTURA,CLIENTE,AGENTE,FEC_FACTURA,MESES_PLAZO,MONTO_FACTURA,ESTADO_FACTURA)values(?,?,?,?,?,?,?,?)";// sentencia
		 // preparada
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    obj.setIdFactura(this.getMaxIdFactura());

	    preparedStatement.setLong(1, obj.getIdFactura());
	    preparedStatement.setString(2, obj.getTipofactura());
	    preparedStatement.setLong(3, obj.getCliente().getId());
	    preparedStatement.setLong(4, obj.getAgente().getAgente());
	    preparedStatement.setDate(5, new java.sql.Date(obj.getFecFactura().getTime()));
	    preparedStatement.setLong(6, obj.getMesesPlazo());
	    preparedStatement.setBigDecimal(7, obj.getMontoFactura());
	    preparedStatement.setString(8, obj.getEstadoFactura());

	    // 4. Ejecutar SQL
	    int result = preparedStatement.executeUpdate();

	    conexion.commit();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	    
	    try {
			conexion.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
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
    public Factura update(Factura obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");
	    
	    conexion.setAutoCommit(false);

	    // 2. Crear objecto statment
	    String sql = "update factura " 
	    		+"set TIPO_FACTURA = ?"
	    		+", CLIENTE = ?"
	    		+", AGENTE = ?"
	    		+", FEC_FACTURA = ?"
	    		+", MESES_PLAZO = ?"
	    		+", MONTO_FACTURA = ?"
	    		+", ESTADO_FACTURA = ?"
	    		+" where FACTURA = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta	    
	    preparedStatement.setString(1, obj.getTipofactura());
	    preparedStatement.setLong(2, obj.getCliente().getId());
	    preparedStatement.setLong(3, obj.getAgente().getAgente());
	    preparedStatement.setDate(4, new java.sql.Date(obj.getFecFactura().getTime()));
	    preparedStatement.setLong(5, obj.getMesesPlazo());
	    preparedStatement.setBigDecimal(6, obj.getMontoFactura());
	    preparedStatement.setString(7, obj.getEstadoFactura());
	    preparedStatement.setLong(8, obj.getIdFactura());

	    // 4. Ejecutar SQL
	    int result = preparedStatement.executeUpdate();

	    conexion.commit();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	    
	    try {
			conexion.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
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
    public Factura read(Factura obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resulset = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statment
	    String sql = "select * from Factura where Factura = ?";// sentencia
								   // preparada
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getIdFactura());

	    // 4. Ejecutar SQL
	    resulset = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resulset.next()) {
	    	obj.setIdFactura(resulset.getLong("FACTURA"));
	    	obj.setTipofactura(resulset.getString("TIPO_FACTURA"));
	    	obj.setCliente(Constantes.getCliente(resulset.getLong("CLIENTE")));
	    	obj.setAgente(Constantes.getAgente(resulset.getLong("AGENTE")));
	    	obj.setFecFactura(resulset.getDate("FEC_FACTURA"));					
	    	obj.setMesesPlazo(resulset.getLong("MESES_PLAZO"));
	    	obj.setMontoFactura(resulset.getBigDecimal("MONTO_FACTURA"));
	    	obj.setEstadoFactura(resulset.getString("ESTADO_FACTURA"));		
	    }

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	} finally {
	    try {

		if (resulset != null) {
		    resulset.close();
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
    public boolean delete(Factura obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");
	    
	    conexion.setAutoCommit(false);

	    // 2. Crear objecto statment
	    String sql = "delete from Factura where Factura = ?";// sentencia
								 // preparada
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getIdFactura());

	    // 4. Ejecutar SQL
	    int result = preparedStatement.executeUpdate();
	    if (result > 0) {
		return true;
	    }
	    
	    conexion.commit();

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	    
	    try {
			conexion.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
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
    public List<Factura> getList() {
	List<Factura> objList = new ArrayList<Factura>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resulset = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statment
	    String sql = "select * from Factura";// sentencia preparada
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // preparedStatement.setLong(1,obj.getIdFactura());

	    // 4. Ejecutar SQL
	    resulset = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resulset.next()) {
		Factura obj = new Factura();
		obj.setIdFactura(resulset.getLong("FACTURA"));
    	obj.setTipofactura(resulset.getString("TIPO_FACTURA"));
    	obj.setCliente(Constantes.getCliente(resulset.getLong("CLIENTE")));
    	obj.setAgente(Constantes.getAgente(resulset.getLong("AGENTE")));
    	obj.setFecFactura(resulset.getDate("FEC_FACTURA"));					
    	obj.setMesesPlazo(resulset.getLong("MESES_PLAZO"));
    	obj.setMontoFactura(resulset.getBigDecimal("MONTO_FACTURA"));
    	obj.setEstadoFactura(resulset.getString("ESTADO_FACTURA"));
		objList.add(obj);
	    }

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	} finally {
	    try {

		if (resulset != null) {
		    resulset.close();
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