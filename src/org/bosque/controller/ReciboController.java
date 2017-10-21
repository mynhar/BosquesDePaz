/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Recibo;
import org.bosque.model.dao.ReciboDao;

/**
 * @author Trabajo_01 CRUD
 */
public class ReciboController {

    /**
     * 
     */
    public ReciboController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Recibo create(Recibo obj) {
	ReciboDao dao = new ReciboDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Recibo update(Recibo obj) {
	ReciboDao dao = new ReciboDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Recibo read(Recibo obj) {
	ReciboDao dao = new ReciboDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Recibo obj) {
	ReciboDao dao = new ReciboDao();
	return dao.delete(obj);
    }

    public List<Recibo> getList() {
	ReciboDao dao = new ReciboDao();
	return dao.getList();
    }

}
