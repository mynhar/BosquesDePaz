package org.bosque.utils;

import java.util.ArrayList;

import org.bosque.model.bean.EstadoCivil;

public class ComboEstadoCivil {
	private ArrayList<EstadoCivil> list = new ArrayList<EstadoCivil>();

	public ComboEstadoCivil() {
		list.add(new EstadoCivil("C", "Casado(a)"));
	    list.add(new EstadoCivil("S", "Soltero(a)"));
	    list.add(new EstadoCivil("D", "Divorciado(a)"));
	    list.add(new EstadoCivil("U", "Unión Libre"));
	    list.add(new EstadoCivil("V", "Viudo(a)"));
	}

	public ArrayList<EstadoCivil> getList() {
		return list;
	}

	public void setList(ArrayList<EstadoCivil> list) {
		this.list = list;
	}

}