package org.bosque.utils;

import java.util.ArrayList;
import java.util.List;

import org.bosque.controller.OcupacionController;
import org.bosque.model.bean.Ocupacion;

public class ComboOcupacion {

	private ArrayList<Ocupacion> list = new ArrayList<Ocupacion>();
	private OcupacionController controller;

	public ComboOcupacion() {
		controller = new OcupacionController();
		List lst = controller.getList();

		if (lst != null && lst.size()>0) {
			list = (ArrayList) lst;
		}
	}

	public ArrayList<Ocupacion> getList() {
		return list;
	}

	public void setList(ArrayList<Ocupacion> list) {
		this.list = list;
	}

}