/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Concepto;
import org.bosque.model.dao.ConceptoDao;

/**
 * @author Trabajo_01 CRUD
 */
public class ConceptoController {

    /**
     * 
     */
    public ConceptoController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Concepto create(Concepto obj) {
	ConceptoDao dao = new ConceptoDao();
	obj = dao.create(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Concepto update(Concepto obj) {
	ConceptoDao dao = new ConceptoDao();
	obj = dao.update(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public Concepto read(Concepto obj) {
	ConceptoDao dao = new ConceptoDao();
	obj = dao.read(obj);
	return obj;
    }

    /**
     * 
     * @param obj
     * @return
     */
    public boolean delete(Concepto obj) {
	ConceptoDao dao = new ConceptoDao();
	return dao.delete(obj);
    }

    public List<Concepto> getList() {
	ConceptoDao dao = new ConceptoDao();
	return dao.getList();
    }

}
