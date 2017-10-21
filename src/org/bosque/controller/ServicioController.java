/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Servicio;
import org.bosque.model.dao.ServicioDao;

/**
 * @author Trabajo_01 CRUD
 */
public class ServicioController {

    /**
     * 
     */
    public ServicioController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Servicio create(Servicio obj) {
	ServicioDao dao = new ServicioDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Servicio update(Servicio obj) {
	ServicioDao dao = new ServicioDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Servicio read(Servicio obj) {
	ServicioDao dao = new ServicioDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Servicio obj) {
	ServicioDao dao = new ServicioDao();
	return dao.delete(obj);
    }

    public List<Servicio> getList() {
	ServicioDao dao = new ServicioDao();
	return dao.getList();
    }

}
