package org.bosque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bosque.model.bean.Autorizado;
import org.bosque.model.bean.Cliente;
import org.bosque.model.bean.Ocupacion;
import org.bosque.model.bean.Persona;
import org.bosque.model.bean.Agente;

public class AutorizadoDao {

	/**
	 * 
	 * @param obj
	 * @return
	 */
	 public Autorizado create(Autorizado obj) {
		 
		 Connection conexion = null;
		 PreparedStatement preparedStatement = null;
			
		 try{			
			// 1. Crear conexion
			    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bosques", "bosque123");				
				
				// 2. Crear objecto statement			
				String sql = "insert into autorizado(" +
						   "cliente, persona, parentezco)" +
                           "values(?, ?, ?)";
				preparedStatement = conexion.prepareStatement(sql);
				
				preparedStatement.setLong(1,obj.getCliente().getId());
				preparedStatement.setLong(2,obj.getPersona().getPersona());
				preparedStatement.setString(3, obj.getParentezco());
				
				// 4. Ejecutar SQL
				int result = preparedStatement.executeUpdate();
		 } catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
		} finally {
				try {
					if(preparedStatement != null){
						preparedStatement.close();
					}
					
					if(conexion != null){
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
	public Autorizado update(Autorizado obj) {
		Connection conexion = null;
		PreparedStatement preparedStatement = null;

		 try {
			// 1. Crear conexion
			    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bosques", "bosque123");

				// 2. Crear objecto statement
				String sql = 
						"update autorizado " +
						"set    parentezco = ? " +
                        "where  cliente = ? " +
						"and    persona = ?";
				preparedStatement = conexion.prepareStatement(sql);

				// 3. Establecer parametros de consulta
				preparedStatement.setString(1, obj.getParentezco());
				preparedStatement.setLong(2, obj.getCliente().getId());
				preparedStatement.setLong(3, obj.getPersona().getPersona());

				// 4. Ejecutar SQL
				int result = preparedStatement.executeUpdate();
				
				
		 } catch(Exception e) {
			 System.out.println(e.getMessage());
			 e.printStackTrace();
		 } finally {
			 try {
				 if(preparedStatement != null) {
					 preparedStatement.close();
				 }
				 if(conexion != null){
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
	public Autorizado read(Autorizado obj) {
		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 1. Crear conexion
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bosques", "bosque123");

			// 2. Crear objecto statement
			String sql = "select cliente, persona, parentezco from autorizado where cliente = ? and persona = ?";
			preparedStatement = conexion.prepareStatement(sql);

			// 3. Establecer parametros de consulta
			preparedStatement.setLong(1, obj.getCliente().getId());
			preparedStatement.setLong(2, obj.getPersona().getPersona());

			// 4. Ejecutar SQL
			resultSet = preparedStatement.executeQuery();

			// 5. Recorrer el ResultSet
			while(resultSet.next()) {
				obj.setCliente(this.getCliente(resultSet.getLong("cliente")));
				obj.setPersona(this.getPersona(resultSet.getLong("persona")));
				obj.setParentezco(resultSet.getString("parentezco"));
			}			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(conexion != null) {
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
	public boolean delete(Autorizado obj) {
		Connection conexion = null;
		PreparedStatement preparedStatement = null;

		 try {
			// 1. Crear conexion
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bosques", "bosque123");

			// 2. Crear objecto statement
			String sql = "delete from autorizado where cliente = ? and persona = ?";
			preparedStatement = conexion.prepareStatement(sql);

			// 3. Establecer parametros de consulta
			preparedStatement.setLong(1, obj.getCliente().getId());
			preparedStatement.setLong(2, obj.getPersona().getPersona());

			// 4. Ejecutar SQL
			int result = preparedStatement.executeUpdate();
			if(result > 0) {
				return true;
			}				
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(conexion != null) {
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
	public List<Autorizado> getList() {
		List<Autorizado> objList = new ArrayList<Autorizado>();
		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		 try {
			// 1. Crear conexion
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bosques", "bosque123");

			// 2. Crear objecto statement
			String sql = "select cliente, persona, parentezco from autorizado";
			preparedStatement = conexion.prepareStatement(sql);

			// 3. Establecer parametros de consulta
			// preparedStatement.setLong(1,obj.getIdAutorizado());

			// 4. Ejecutar SQL
			resultSet = preparedStatement.executeQuery();

			// 5. Recorrer el ResultSet
			while(resultSet.next()) {
				Autorizado obj = new Autorizado();

				obj.setCliente(this.getCliente(resultSet.getLong("cliente")));
				obj.setPersona(this.getPersona(resultSet.getLong("persona")));
				obj.setParentezco(resultSet.getString("parentezco"));

				objList.add(obj);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {				
				if(resultSet != null) {
					resultSet.close();					
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return objList;
	}	

	/*
	 * Obtiene el objeto persona desde el Dao respectivo
	 */
	private Cliente getCliente(Long id) {
		Cliente obj = new Cliente();

		obj.setId(id);

		ClienteDao dao = new ClienteDao();
		obj = dao.read(obj);

		return obj;
	}

	/*
	 * Obtiene el objeto persona desde el Dao respectivo
	 */
	private Persona getPersona(Long id) {
		Persona obj = new Persona();

		obj.setPersona(id);

		PersonaDao dao = new PersonaDao();
		obj = dao.read(obj);

		return obj;
	}

	/*
	 * Obtiene el objeto agente desde el Dao respectivo
	 */
	private Agente getAgente(Long id) {
		Agente obj = new Agente();

		obj.setAgente(id);

		AgenteDao dao = new AgenteDao();
		obj = dao.read(obj);

		return obj;
	}
}