/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Ocupacion;
import org.bosque.model.dao.OcupacionDao;

/**
 * @author Trabajo_01 CRUD
 */
public class OcupacionController {

    /**
     * 
     */
    public OcupacionController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Ocupacion create(Ocupacion obj) {
	OcupacionDao dao = new OcupacionDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Ocupacion update(Ocupacion obj) {
	OcupacionDao dao = new OcupacionDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Ocupacion read(Ocupacion obj) {
	OcupacionDao dao = new OcupacionDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Ocupacion obj) {
	OcupacionDao dao = new OcupacionDao();
	return dao.delete(obj);
    }

    public List<Ocupacion> getList() {
	OcupacionDao dao = new OcupacionDao();
	return dao.getList();
    }

}
