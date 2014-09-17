package Classe;

import java.util.Date;

public class Match {
	
	private Date date;
	private Equipe equipe1;
	private Equipe equipe2;
	

	public Equipe getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Match(Date date) {
		this.date = date;
	}
	
}
