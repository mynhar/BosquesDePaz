/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Transaccion;
import org.bosque.model.dao.TransaccionDao;

/**
 * @author Trabajo_01 CRUD
 */
public class TransaccionController {

    /**
     * 
     */
    public TransaccionController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Transaccion create(Transaccion obj) {
	TransaccionDao dao = new TransaccionDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Transaccion update(Transaccion obj) {
	TransaccionDao dao = new TransaccionDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Transaccion read(Transaccion obj) {
	TransaccionDao dao = new TransaccionDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Transaccion obj) {
	TransaccionDao dao = new TransaccionDao();
	return dao.delete(obj);
    }

    public List<Transaccion> getList(Transaccion obj) {
	TransaccionDao dao = new TransaccionDao();
	return dao.getList(obj);
    }

}
