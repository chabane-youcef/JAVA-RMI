package app;

import java.io.Serializable;

public class Equipe implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String equipe;
	private int classement;
	
	public Equipe() {
		
	}
	
	public Equipe(String equipe, int classement) {
		super();
		this.equipe = equipe;
		this.classement = classement;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	public int getClassement() {
		return classement;
	}

	public void setClassement(int classement) {
		this.classement = classement;
	}
	
	
	
	
}
