package org.bosque.utils;

import java.util.ArrayList;
import java.util.List;

import org.bosque.controller.PersonaController;
import org.bosque.model.bean.Persona;

public class ComboPersona {
	private ArrayList<Persona> list = new ArrayList<Persona>();
	private PersonaController controller;

	public ComboPersona() {
		controller = new PersonaController();
		List lst = controller.getList();

		if (lst != null && lst.size()>0) {
			list = (ArrayList) lst;
		}
	}

	public ArrayList<Persona> getList() {
		return list;
	}

	public void setList(ArrayList<Persona> list) {
		this.list = list;
	}
}
