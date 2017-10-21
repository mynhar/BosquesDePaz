/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.LoteDetalle;
import org.bosque.model.dao.LoteDetalleDao;

/**
 * @author Trabajo_01 CRUD
 */
public class LoteDetalleController {

    /**
     * 
     */
    public LoteDetalleController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public LoteDetalle create(LoteDetalle obj) {
	LoteDetalleDao dao = new LoteDetalleDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public LoteDetalle update(LoteDetalle obj) {
	LoteDetalleDao dao = new LoteDetalleDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public LoteDetalle read(LoteDetalle obj) {
	LoteDetalleDao dao = new LoteDetalleDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(LoteDetalle obj) {
	LoteDetalleDao dao = new LoteDetalleDao();
	return dao.delete(obj);
    }

    public List<LoteDetalle> getList(LoteDetalle obj) {
	LoteDetalleDao dao = new LoteDetalleDao();
	return dao.getList(obj);
    }

}
