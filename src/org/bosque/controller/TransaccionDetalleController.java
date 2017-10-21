/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.TransaccionDetalle;
import org.bosque.model.dao.TransaccionDetalleDao;

/**
 * @author Trabajo_01 CRUD
 */
public class TransaccionDetalleController {

    /**
     * 
     */
    public TransaccionDetalleController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public TransaccionDetalle create(TransaccionDetalle obj) {
	TransaccionDetalleDao dao = new TransaccionDetalleDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public TransaccionDetalle update(TransaccionDetalle obj) {
	TransaccionDetalleDao dao = new TransaccionDetalleDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public TransaccionDetalle read(TransaccionDetalle obj) {
	TransaccionDetalleDao dao = new TransaccionDetalleDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(TransaccionDetalle obj) {
	TransaccionDetalleDao dao = new TransaccionDetalleDao();
	return dao.delete(obj);
    }

    public List<TransaccionDetalle> getList(TransaccionDetalle obj) {
	TransaccionDetalleDao dao = new TransaccionDetalleDao();
	return dao.getList(obj);
    }

}
