package FranciscoSantos;

import javax.swing.ImageIcon;

public class MinImageFootball extends SportsInfo{
	@Override
	public ImageIcon getImage(String image) {
		if(image.equals("Barcelona")) {
			return new ImageIcon("src/images/sports/minSoccerTeams/BarcelonaIcon.png");
		}else if(image.equals("Benfica"))
			return new ImageIcon("src/images/sports/minSoccerTeams/BenficaIcon.png");
		else if(image.equals("CDTondela"))
			return new ImageIcon("src/images/sports/minSoccerTeams/CDTondela.png");
		else if(image.equals("Chelsea"))
			return new ImageIcon("src/images/sports/minSoccerTeams/ChelseaIcon.png");
		else if(image.equals("Juventus"))
			return new ImageIcon("src/images/sports/minSoccerTeams/JuventusIcon.png");
		else if(image.equals("Manchester"))
			return new ImageIcon("src/images/sports/minSoccerTeams/ManchesterIcon.png");
		else if(image.equals("Porto"))
			return new ImageIcon("src/images/sports/minSoccerTeams/PortoIcon.png");
		else if(image.equals("RealMadrid"))
			return new ImageIcon("src/images/sports/minSoccerTeams/RealMadridIcon.png");
		else if(image.equals("SportingClubeDeBraga"))
			return new ImageIcon("src/images/sports/minSoccerTeams/SportingClubeDeBragaIcon.png");
		else if(image.equals("Sporting"))
			return new ImageIcon("src/images/sports/minSoccerTeams/SportingIcon.png");
		return null;
	}
}
