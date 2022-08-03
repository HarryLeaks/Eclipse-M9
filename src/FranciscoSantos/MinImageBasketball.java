package FranciscoSantos;

import javax.swing.ImageIcon;

public class MinImageBasketball extends SportsInfo{
	@Override
	public ImageIcon getImage(String image) {
		if(image.equals("Los Angeles Lakers")) {
			return new ImageIcon("src/images/sports/minBasketTeams/LosAngelesLakers.png");
		}else if(image.equals("Golden State Warriors"))
			return new ImageIcon("src/images/sports/minBasketTeams/GoldenStateWarriors.png");
		else if(image.equals("Chicago Bulls"))
			return new ImageIcon("src/images/sports/minBasketTeams/ChicagoBulls.png");
		else if(image.equals("Miami Heat"))
			return new ImageIcon("src/images/sports/minBasketTeams/MiamiHeat.png");
		else if(image.equals("Houston Rockets"))
			return new ImageIcon("src/images/sports/minBasketTeams/HoustonRockets.png");
		else if(image.equals("Boston Celtics"))
			return new ImageIcon("src/images/sports/minBasketTeams/BostonCeltics.png");
		return null;
	}
}
