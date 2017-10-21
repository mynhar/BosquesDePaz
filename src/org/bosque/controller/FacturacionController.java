/**
 * 
 */
package org.bosque.controller;

import java.util.List;

import org.bosque.model.bean.Factura;
import org.bosque.model.bean.Servicio;
import org.bosque.model.dao.FacturaDao;

/**
 * @author Trabajo_01
 * CRUD
 */
public class FacturacionController {
	
	ServicioController servicioController;

	/**
	 * 
	 */
	public FacturacionController() {
		servicioController = new ServicioController();
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public Factura create(Factura obj){
		FacturaDao dao = new FacturaDao();		
		obj = dao.create(obj);
		return obj;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public Factura update(Factura obj){
		FacturaDao dao = new FacturaDao();		
		obj = dao.update(obj);
		return obj;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public Factura read(Factura obj){
		FacturaDao dao = new FacturaDao();		
		obj = dao.read(obj);
		return obj;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public boolean delete(Factura obj){
		FacturaDao dao = new FacturaDao();		
		return dao.delete(obj);		
	}
	
	public List<Factura> getList(){
		FacturaDao dao = new FacturaDao();		
		return dao.getList();
	}
	
	/**
     * 
     * @param obj
     * @return
     */
    public Servicio create(Servicio obj) {
    	FacturaDao facturaDao = new FacturaDao();		
		Factura factura = facturaDao.create(obj.getFactura());
		if(factura != null && factura.getIdFactura() != null){			
			obj = servicioController.create(obj);
			
		}
		return obj;
    }
    
    /**
	 * 
	 * @param obj
	 * @return
	 */
	public Servicio update(Servicio obj){
		FacturaDao facturaDao = new FacturaDao();		
		Factura factura = facturaDao.update(obj.getFactura());
		if(factura != null && factura.getIdFactura() != null){			
			obj = servicioController.update(obj);
		}
		
		return obj;
	}
	
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public boolean delete(Servicio obj){
		FacturaDao facturaDao = new FacturaDao();		
		boolean isDelete = facturaDao.delete(obj.getFactura());
		if(isDelete){
			isDelete = servicioController.delete(obj);
			if(isDelete){
				return isDelete;
			}			
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Servicio> getListServicio(){
		List<Servicio> objList = servicioController.getList();		
		return objList;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public Servicio read(Servicio obj){				
		obj = servicioController.read(obj);
		return obj;
	}

}
