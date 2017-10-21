/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Mantenimiento;
import org.bosque.model.dao.MantenimientoDao;

/**
 * @author Trabajo_01 CRUD
 */
public class MantenimientoController {

    /**
     * 
     */
    public MantenimientoController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Mantenimiento create(Mantenimiento obj) {
	MantenimientoDao dao = new MantenimientoDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Mantenimiento update(Mantenimiento obj) {
	MantenimientoDao dao = new MantenimientoDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Mantenimiento read(Mantenimiento obj) {
	MantenimientoDao dao = new MantenimientoDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Mantenimiento obj) {
	MantenimientoDao dao = new MantenimientoDao();
	return dao.delete(obj);
    }

    public List<Mantenimiento> getList() {
	MantenimientoDao dao = new MantenimientoDao();
	return dao.getList();
    }

}
