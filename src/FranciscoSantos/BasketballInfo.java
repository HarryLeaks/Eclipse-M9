package FranciscoSantos;

import javax.swing.ImageIcon;

public class BasketballInfo extends SportsInfo{
	int team1, team2;
	int points1, points2;
	
	private String basketTeams[] = {
			"Los Angeles Lakers",
			"Golden State Warriors",
			"Chicago Bulls",
			"Miami Heat",
			"Houston Rockets",
			"Boston Celtics"
		};
	
	@Override
	public ImageIcon getImage(String image) {
		if(image.equals("Los Angeles Lakers")) {
			return new ImageIcon("src/images/sports/BasketballTeams/LosAngelesLakers.png");
		}else if(image.equals("Golden State Warriors"))
			return new ImageIcon("src/images/sports/BasketballTeams/GoldenStateWarriors.png");
		else if(image.equals("Chicago Bulls"))
			return new ImageIcon("src/images/sports/BasketballTeams/ChicagoBulls.png");
		else if(image.equals("Miami Heat"))
			return new ImageIcon("src/images/sports/BasketballTeams/MiamiHeat.png");
		else if(image.equals("Houston Rockets"))
			return new ImageIcon("src/images/sports/BasketballTeams/HoustonRockets.png");
		else if(image.equals("Boston Celtics"))
			return new ImageIcon("src/images/sports/BasketballTeams/BostonCeltics.png");
		return null;
	}
	
	public String getBasketTeams(int pos) {
		return basketTeams[pos];
	}
	
	
	public void getTeam() {
		team1 = random(6);
		do {
			team2 = random(6);
		}while(team1 == team2);
	}
	
	public int WhoWon() {
		points1 = random(100) + 50;
		points2 = points1 + random(15) - 10;
		
		if(points1 == points2) {
			return 0;
		}else if(points1 > points2) {
			return 1;
		}else {
			return 2;
		}
	}

	public int getTeam1() {
		return team1;
	}

	public int getTeam2() {
		return team2;
	}

	public int getPoints1() {
		return points1;
	}

	public int getPoints2() {
		return points2;
	}

	public void setTeam1(int team1) {
		this.team1 = team1;
	}

	public void setTeam2(int team2) {
		this.team2 = team2;
	}

	public void setPoints1(int points1) {
		this.points1 = points1;
	}

	public void setPoints2(int points2) {
		this.points2 = points2;
	}
}
