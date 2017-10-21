/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Persona;
import org.bosque.model.dao.PersonaDao;

/**
 * @author Trabajo_01 CRUD
 */
public class PersonaController {

    /**
     * 
     */
    public PersonaController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Persona create(Persona obj) {
	PersonaDao dao = new PersonaDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Persona update(Persona obj) {
	PersonaDao dao = new PersonaDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Persona read(Persona obj) {
	PersonaDao dao = new PersonaDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Persona obj) {
	PersonaDao dao = new PersonaDao();
	return dao.delete(obj);
    }

    public List<Persona> getList() {
	PersonaDao dao = new PersonaDao();
	return dao.getList();
    }

}
