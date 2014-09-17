package Classe;

public class But {

	private Match match;
	private Equipe equipe;
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	public But(Match match, Equipe equipe) {
		super();
		this.match = match;
		this.equipe = equipe;
	}
	
}
