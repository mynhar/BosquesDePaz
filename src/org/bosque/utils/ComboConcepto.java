package org.bosque.utils;

import java.util.ArrayList;
import java.util.List;

import org.bosque.controller.ConceptoController;
import org.bosque.model.bean.Concepto;


public class ComboConcepto {
	
	private ArrayList<Concepto> list = new ArrayList<Concepto>();
	private ConceptoController controller;

	public ComboConcepto() {
		controller = new ConceptoController();
		List lst = controller.getList();

		if (lst != null && lst.size()>0) {
			list = (ArrayList) lst;
		}
	}

	public ArrayList<Concepto> getList() {
		return list;
	}

	public void setList(ArrayList<Concepto> list) {
		this.list = list;
	}
}
