/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Autorizado;
import org.bosque.model.dao.AutorizadoDao;

/**
 * @author Trabajo_01 CRUD
 */
public class AutorizadoController {

    /**
     * 
     */
    public AutorizadoController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Autorizado create(Autorizado obj) {
	AutorizadoDao dao = new AutorizadoDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Autorizado update(Autorizado obj) {
	AutorizadoDao dao = new AutorizadoDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Autorizado read(Autorizado obj) {
	AutorizadoDao dao = new AutorizadoDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Autorizado obj) {
	AutorizadoDao dao = new AutorizadoDao();
	return dao.delete(obj);
    }

    public List<Autorizado> getList() {
	AutorizadoDao dao = new AutorizadoDao();
	return dao.getList();
    }

}
