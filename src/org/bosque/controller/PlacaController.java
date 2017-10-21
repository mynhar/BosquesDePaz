/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Placa;
import org.bosque.model.dao.PlacaDao;

/**
 * @author Trabajo_01 CRUD
 */
public class PlacaController {

    /**
     * 
     */
    public PlacaController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Placa create(Placa obj) {
	PlacaDao dao = new PlacaDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Placa update(Placa obj) {
	PlacaDao dao = new PlacaDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Placa read(Placa obj) {
	PlacaDao dao = new PlacaDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Placa obj) {
	PlacaDao dao = new PlacaDao();
	return dao.delete(obj);
    }

    public List<Placa> getList() {
	PlacaDao dao = new PlacaDao();
	return dao.getList();
    }

}
