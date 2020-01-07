package fr.tony.bouffe.modele;

import java.io.Serializable;

public class Repas implements Serializable {
	private int id;
	private String platDuMidi;
	private String platDuSoir;
	/**
	 * @param id
	 * @param platDuMidi
	 * @param platDuSoir
	 */
	public Repas(int id, String platDuMidi, String platDuSoir) {
		super();
		this.id = id;
		this.platDuMidi = platDuMidi;
		this.platDuSoir = platDuSoir;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlatDuMidi() {
		return platDuMidi;
	}
	public void setPlatDuMidi(String platDuMidi) {
		this.platDuMidi = platDuMidi;
	}
	public String getPlatDuSoir() {
		return platDuSoir;
	}
	public void setPlatDuSoir(String platDuSoir) {
		this.platDuSoir = platDuSoir;
	}
	
	@Override
	public String toString() {
		return "Repas [id=" + id + ", platDuMidi=" + platDuMidi + ", platDuSoir=" + platDuSoir + "]";
	}
	

	
	
	
}
