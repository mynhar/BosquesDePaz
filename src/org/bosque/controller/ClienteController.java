package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Cliente;
import org.bosque.model.dao.ClienteDao;

public class ClienteController {
	
	public ClienteController(){}
	
	public Cliente create(Cliente obj) {
		ClienteDao dao = new ClienteDao();
		obj = dao.create(obj);
		return obj;
	}

	    /**
	     * 
	     * @param obj
	     * @return
	     */
	public Cliente update(Cliente obj) {
		ClienteDao dao = new ClienteDao();
		obj = dao.update(obj);
		return obj;
	}

	    /**
	     * 
	     * @param obj
	     * @return
	     */
	public Cliente read(Cliente obj) {
		ClienteDao dao = new ClienteDao();
		obj = dao.read(obj);
		return obj;
	}

	    /**
	     * 
	     * @param obj
	     * @return
	     */
	public boolean delete(Cliente obj) {
		ClienteDao dao = new ClienteDao();
		return dao.delete(obj);
	}

	/**
	 * 
	 * @return
	 */
	public List<Cliente> getList() {
		ClienteDao dao = new ClienteDao();
		return dao.getList();
	}

}
