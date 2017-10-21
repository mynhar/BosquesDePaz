package org.bosque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.Persona;
import org.bosque.utils.Constantes;

public class PersonaDao {
    /**
     * 
     * @return
     */
    private Long getMaxIdPersona() {
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
	    String msgSQL = "select nvl(max(persona),0) + 1 id from persona";

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
    public Persona create(Persona obj) {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "insert into persona("
		    + "persona, tipo_persona, identificacion, razon_social, nombre_completo, primer_apellido, segundo_apellido, "
		    + "estado_civil, direccion, correo_principal, correo_secundario, telef_habitacion, telef_oficina, "
		    + "ext_oficina, telef_movil, ocupacion, fec_nacimiento, fec_defuncion, estado_persona) "
		    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    obj.setPersona(this.getMaxIdPersona());

	    preparedStatement.setLong(1, obj.getPersona());
	    preparedStatement.setString(2, obj.getTipoPersona());
	    preparedStatement.setString(3, obj.getIdentificacion());
	    preparedStatement.setString(4, obj.getRazonSocial());
	    preparedStatement.setString(5, obj.getNombreCompleto());
	    preparedStatement.setString(6, obj.getPrimerApellido());
	    preparedStatement.setString(7, obj.getSegundoApellido());
	    preparedStatement.setString(8, obj.getEstadoCivil());
	    preparedStatement.setString(9, obj.getDireccion());
	    preparedStatement.setString(10, obj.getCorreoPrincipal());
	    preparedStatement.setString(11, obj.getCorreoSecundario());
	    preparedStatement.setString(12, obj.getTelefHabitacion());
	    preparedStatement.setString(13, obj.getTelefOficina());
	    preparedStatement.setString(14, obj.getExtOficina());
	    preparedStatement.setString(15, obj.getTelefMovil());

	    if (obj.getOcupacion() == null) {
		preparedStatement.setNull(16, 0);
	    } else {
		preparedStatement.setLong(16, obj.getOcupacion().getOcupacion());
	    }
	    preparedStatement.setDate(17, new java.sql.Date(obj.getFecNacimiento().getTime()));
	    preparedStatement.setDate(18, new java.sql.Date(obj.getFecDefuncion().getTime()));
	    preparedStatement.setString(19, obj.getEstadoPersona());

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
    public Persona update(Persona obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "update persona " + "  set tipo_persona = ?, " + "      identificacion = ?,  "
		    + "      razon_social = ?,  " + "      nombre_completo = ?,  " + "      primer_apellido = ?,  "
		    + "      segundo_apellido = ?,  " + "      estado_civil = ?,  " + "      direccion = ?,  "
		    + "      correo_principal = ?,  " + "      correo_secundario = ?,  "
		    + "      telef_habitacion = ?,  " + "      telef_oficina = ?,  " + "      ext_oficina = ?,  "
		    + "      telef_movil = ?,  " + "      ocupacion = ?, " + "      fec_nacimiento = ?, "
		    + "      fec_defuncion = ?, " + "      estado_persona = ? " + " where Persona = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setString(1, obj.getTipoPersona());
	    preparedStatement.setString(2, obj.getIdentificacion());
	    preparedStatement.setString(3, obj.getRazonSocial());
	    preparedStatement.setString(4, obj.getNombreCompleto());
	    preparedStatement.setString(5, obj.getPrimerApellido());
	    preparedStatement.setString(6, obj.getSegundoApellido());
	    preparedStatement.setString(7, obj.getEstadoCivil());
	    preparedStatement.setString(8, obj.getDireccion());
	    preparedStatement.setString(9, obj.getCorreoPrincipal());
	    preparedStatement.setString(10, obj.getCorreoSecundario());
	    preparedStatement.setString(11, obj.getTelefHabitacion());
	    preparedStatement.setString(12, obj.getTelefOficina());
	    preparedStatement.setString(13, obj.getExtOficina());
	    preparedStatement.setString(14, obj.getTelefMovil());
	    preparedStatement.setLong(15, obj.getOcupacion().getOcupacion());
	    preparedStatement.setDate(16, new java.sql.Date(obj.getFecNacimiento().getTime()));
	    preparedStatement.setDate(17, new java.sql.Date(obj.getFecDefuncion().getTime()));
	    preparedStatement.setString(18, obj.getEstadoPersona());
	    preparedStatement.setLong(19, obj.getPersona());

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
    public Persona read(Persona obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select * from persona where persona = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getPersona());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		obj.setPersona(resultSet.getLong("persona"));
		obj.setTipoPersona(resultSet.getString("tipo_persona"));
		obj.setIdentificacion(resultSet.getString("identificacion"));
		obj.setRazonSocial(resultSet.getString("razon_social"));
		obj.setNombreCompleto(resultSet.getString("nombre_completo"));
		obj.setPrimerApellido(resultSet.getString("primer_apellido"));
		obj.setSegundoApellido(resultSet.getString("segundo_apellido"));
		obj.setEstadoCivil(resultSet.getString("estado_civil"));
		obj.setDireccion(resultSet.getString("direccion"));
		obj.setCorreoPrincipal(resultSet.getString("correo_principal"));
		obj.setCorreoSecundario(resultSet.getString("correo_secundario"));
		obj.setTelefHabitacion(resultSet.getString("telef_habitacion"));
		obj.setTelefOficina(resultSet.getString("telef_oficina"));
		obj.setExtOficina(resultSet.getString("ext_oficina"));
		obj.setTelefMovil(resultSet.getString("telef_movil"));
		//obj.setOcupacion(Constantes.getOcupacion(resultSet.getLong("ocupacion")));
		obj.setFecNacimiento(resultSet.getDate("fec_nacimiento"));
		obj.setFecDefuncion(resultSet.getDate("fec_defuncion"));
		obj.setEstadoPersona(resultSet.getString("estado_persona"));
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
    public boolean delete(Persona obj) {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "delete from Persona where Persona = ?";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    preparedStatement.setLong(1, obj.getPersona());

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
    public List<Persona> getList() {
	List<Persona> objList = new ArrayList<Persona>();
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	try {
	    // 1. Crear conexion
	    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bosques", "bosque123");

	    // 2. Crear objecto statement
	    String sql = "select * from persona";
	    preparedStatement = conexion.prepareStatement(sql);

	    // 3. Establecer parametros de consulta
	    // preparedStatement.setLong(1,obj.getIdPersona());

	    // 4. Ejecutar SQL
	    resultSet = preparedStatement.executeQuery();

	    // 5. Recorrer el ResultSet
	    while (resultSet.next()) {
		Persona obj = new Persona();
		obj.setPersona(resultSet.getLong("persona"));
		obj.setTipoPersona(resultSet.getString("tipo_persona"));
		obj.setIdentificacion(resultSet.getString("identificacion"));
		obj.setRazonSocial(resultSet.getString("razon_social"));
		obj.setNombreCompleto(resultSet.getString("nombre_completo"));
		obj.setPrimerApellido(resultSet.getString("primer_apellido"));
		obj.setSegundoApellido(resultSet.getString("segundo_apellido"));
		obj.setEstadoCivil(resultSet.getString("estado_civil"));
		obj.setDireccion(resultSet.getString("direccion"));
		obj.setCorreoPrincipal(resultSet.getString("correo_principal"));
		obj.setCorreoSecundario(resultSet.getString("correo_secundario"));
		obj.setTelefHabitacion(resultSet.getString("telef_habitacion"));
		obj.setTelefOficina(resultSet.getString("telef_oficina"));
		obj.setExtOficina(resultSet.getString("ext_oficina"));
		obj.setTelefMovil(resultSet.getString("telef_movil"));
		//obj.setOcupacion(Constantes.getOcupacion(resultSet.getLong("ocupacion")));
		obj.setFecNacimiento(resultSet.getDate("fec_nacimiento"));
		obj.setFecDefuncion(resultSet.getDate("fec_defuncion"));
		obj.setEstadoPersona(resultSet.getString("estado_persona"));

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
