package org.bosque.utils;

import java.util.ArrayList;
import java.util.List;

import org.bosque.controller.ClienteController;
import org.bosque.controller.LoteController;
import org.bosque.model.bean.Cliente;
import org.bosque.model.bean.Lote;


public class ComboLote {
	
	private ArrayList<Lote> list = new ArrayList<Lote>();
	private LoteController controller;

	public ComboLote() {
		controller = new LoteController();
		List lst = controller.getList();

		if (lst != null && lst.size()>0) {
			list = (ArrayList) lst;
		}
	}

	public ArrayList<Lote> getList() {
		return list;
	}

	public void setList(ArrayList<Lote> list) {
		this.list = list;
	}
}
