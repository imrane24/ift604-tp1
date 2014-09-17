package Classe;

public class Paris {

	private Match match;
	private Utilisateur utilisateur;
	private int montant;
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public Paris(Match match, Utilisateur utilisateur, int montant) {
		super();
		this.match = match;
		this.utilisateur = utilisateur;
		this.montant = montant;
	}
	
}
