package org.bosque.utils;

import java.util.ArrayList;
import java.util.List;

import org.bosque.controller.ClienteController;
import org.bosque.model.bean.Cliente;


public class ComboCliente {
	
	private ArrayList<Cliente> list = new ArrayList<Cliente>();
	private ClienteController controller;

	public ComboCliente() {
		controller = new ClienteController();
		List lst = controller.getList();

		if (lst != null && lst.size()>0) {
			list = (ArrayList) lst;
		}
	}

	public ArrayList<Cliente> getList() {
		return list;
	}

	public void setList(ArrayList<Cliente> list) {
		this.list = list;
	}
}
