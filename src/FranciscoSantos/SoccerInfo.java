package FranciscoSantos;

import javax.swing.ImageIcon;

//aplicar polimorfismo
public class SoccerInfo extends SportsInfo{	
	private int team1, team2;
	private int golos1, golos2;

	private String soccerTeams[] = {
			"Barcelona",
			"Benfica",
			"CDTondela",
			"Chelsea",
			"Juventus",
			"Manchester",
			"Porto",
			"RealMadrid",
			"SportingClubeDeBraga",
			"Sporting"
		};
	
	public int getTeam1() {
		return team1;
	}

	public String getSoccerTeams(int pos) {
		return soccerTeams[pos];
	}

	public int getTeam2() {
		return team2;
	}

	public int getGolos1() {
		return golos1;
	}

	public int getGolos2() {
		return golos2;
	}

	public void setTeam1(int team1) {
		this.team1 = team1;
	}

	public void setTeam2(int team2) {
		this.team2 = team2;
	}

	public void setGolos1(int golos1) {
		this.golos1 = golos1;
	}

	public void setGolos2(int golos2) {
		this.golos2 = golos2;
	}
	
	@Override
	public ImageIcon getImage(String image) {
		if(image.equals("Barcelona")) {
			return new ImageIcon("src/images/sports/SoccerTeams/BarcelonaIcon.png");
		}else if(image.equals("Benfica"))
			return new ImageIcon("src/images/sports/SoccerTeams/BenficaIcon.png");
		else if(image.equals("CDTondela"))
			return new ImageIcon("src/images/sports/SoccerTeams/CDTondela.png");
		else if(image.equals("Chelsea"))
			return new ImageIcon("src/images/sports/SoccerTeams/ChelseaIcon.png");
		else if(image.equals("Juventus"))
			return new ImageIcon("src/images/sports/SoccerTeams/JuventusIcon.png");
		else if(image.equals("Manchester"))
			return new ImageIcon("src/images/sports/SoccerTeams/ManchesterIcon.png");
		else if(image.equals("Porto"))
			return new ImageIcon("src/images/sports/SoccerTeams/PortoIcon.png");
		else if(image.equals("RealMadrid"))
			return new ImageIcon("src/images/sports/SoccerTeams/RealMadridIcon.png");
		else if(image.equals("SportingClubeDeBraga"))
			return new ImageIcon("src/images/sports/SoccerTeams/SportingClubeDeBragaIcon.png");
		else if(image.equals("Sporting"))
			return new ImageIcon("src/images/sports/SoccerTeams/SportingIcon.png");
		return null;
	}
	
	public void getTeam() {
		team1 = random(10);
		do {
			team2 = random(10);
		}while(team1 == team2);
	}
	
	public int WhoWon() {
		golos1 = random(5);
		golos2 = random(5);
		
		if(golos1 == golos2)
			return 0;
		else if(golos1 > golos2)
			return 1;
		else
			return 2;
	}
}
