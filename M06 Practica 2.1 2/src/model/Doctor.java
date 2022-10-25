package model;

import java.util.Date;

public class Doctor {
	private int id; 
	private int codiHospital;
	private String especialitat;
	private String nom;
	public Doctor() {};
	public Doctor(int id, int codiHospital, String especialitat, String nom) {
		this.id = id;
		this.codiHospital = codiHospital;
		this.especialitat = especialitat;
		this.nom = nom;
	};
	public int GetId() { return id; }
	public int GetCodiHospital() { return codiHospital; }
	public String GetEspecialitat() { return especialitat; }
	public String GetNom() { return nom; }
}
