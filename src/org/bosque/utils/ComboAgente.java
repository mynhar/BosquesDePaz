package org.bosque.utils;

import java.util.ArrayList;
import java.util.List;

import org.bosque.controller.AgenteController;
import org.bosque.model.bean.Agente;


public class ComboAgente {
	
	private ArrayList<Agente> list = new ArrayList<Agente>();
	private AgenteController controller;

	public ComboAgente() {
		controller = new AgenteController();
		List lst = controller.getList();

		if (lst != null && lst.size()>0) {
			list = (ArrayList) lst;
		}
	}

	public ArrayList<Agente> getList() {
		return list;
	}

	public void setList(ArrayList<Agente> list) {
		this.list = list;
	}
}
