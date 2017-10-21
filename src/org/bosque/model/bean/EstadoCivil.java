package org.bosque.model.bean;

public class EstadoCivil {
	
	public EstadoCivil(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String toString() {
        return desc;
    }

    private String id;
    private String desc;
}