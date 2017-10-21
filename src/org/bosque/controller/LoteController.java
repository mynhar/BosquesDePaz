/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Lote;
import org.bosque.model.dao.LoteDao;

/**
 * @author Trabajo_01 CRUD
 */
public class LoteController {

    /**
     * 
     */
    public LoteController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Lote create(Lote obj) {
	LoteDao dao = new LoteDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Lote update(Lote obj) {
	LoteDao dao = new LoteDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Lote read(Lote obj) {
	LoteDao dao = new LoteDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Lote obj) {
	LoteDao dao = new LoteDao();
	return dao.delete(obj);
    }

    public List<Lote> getList() {
	LoteDao dao = new LoteDao();
	return dao.getList();
    }

}
