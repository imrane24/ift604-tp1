package Classe;

import java.util.Date;

public class Match {
	
	private Date date;
	private Equipe equipe1;
	private Equipe equipe2;
	private int butEquipe1;
	private int butEquipe2;
	private int penaliteEquipe1; //nombre de joueur penalise en temps reel
	private int penaliteEquipe2;
	private int tiersTemps; //seule;ent 1, 2 ou 3
	private etat etat;
	
	public enum etat{
		JEU, SUSPENDU, FINI
	}
	
	//methode pour le jeu
	public void equipe1Marque(){
		butEquipe1 = butEquipe1 ++;
	}
	
	public void equipe2Marque(){
		butEquipe2 = butEquipe2 ++;
	}
	
	public void equipe1penalise(){
		penaliteEquipe1 = penaliteEquipe1 ++;
	}
	
	public void equipe2penalise(){
		penaliteEquipe2 = penaliteEquipe2 ++;
	}
	
	public void equipe1FinPenalise(){
		penaliteEquipe1 = penaliteEquipe1 --;
	}
	
	public void equipe2FinPenalise(){
		penaliteEquipe2 = penaliteEquipe2 --;
	}
	
	public void tiersTempsSuivant(){
		if(tiersTemps<=3){
			tiersTemps = tiersTemps ++;
		}else{
			System.out.println("Fin du match");
			this.etat = etat.FINI;
		}
		
	}
	
	public void suspendre(){
		this.etat = etat.SUSPENDU;
	}
	
	public void reprendre(){
		this.etat = etat.JEU;
	}
	

	//Getter et setter
	public int getButEquipe1() {
		return butEquipe1;
	}

	public void setButEquipe1(int butEquipe1) {
		this.butEquipe1 = butEquipe1;
	}

	public int getButEquipe2() {
		return butEquipe2;
	}

	public void setButEquipe2(int butEquipe2) {
		this.butEquipe2 = butEquipe2;
	}

	public int getPenaliteEquipe1() {
		return penaliteEquipe1;
	}

	public void setPenaliteEquipe1(int penaliteEquipe1) {
		this.penaliteEquipe1 = penaliteEquipe1;
	}

	public int getPenaliteEquipe2() {
		return penaliteEquipe2;
	}

	public void setPenaliteEquipe2(int penaliteEquipe2) {
		this.penaliteEquipe2 = penaliteEquipe2;
	}

	public int getTiersTemps() {
		return tiersTemps;
	}

	public void setTiersTemps(int tiersTemps) {
		this.tiersTemps = tiersTemps;
	}

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
