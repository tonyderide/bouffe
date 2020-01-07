package fr.tony.bouffe.modele;

import java.io.Serializable;

public class Semaine implements Serializable{
	private int id ;
	private String jour;
	/**
	 * @param jour
	 * @param id
	 */
	public Semaine(String jour, int id) {
		super();
		this.jour = jour;
		this.id = id;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Semaine [id=" + id + ", jour=" + jour + "]";
	}
	
	
}
