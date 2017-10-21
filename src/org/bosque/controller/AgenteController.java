/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Agente;
import org.bosque.model.dao.AgenteDao;

/**
 * @author Trabajo_01 CRUD
 */
public class AgenteController {

    /**
     * 
     */
    public AgenteController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Agente create(Agente obj) {
	AgenteDao dao = new AgenteDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Agente update(Agente obj) {
	AgenteDao dao = new AgenteDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Agente read(Agente obj) {
	AgenteDao dao = new AgenteDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Agente obj) {
	AgenteDao dao = new AgenteDao();
	return dao.delete(obj);
    }

    public List<Agente> getList() {
	AgenteDao dao = new AgenteDao();
	return dao.getList();
    }

}
