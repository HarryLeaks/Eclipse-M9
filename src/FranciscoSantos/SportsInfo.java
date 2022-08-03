package FranciscoSantos;

import java.util.Random;

import javax.swing.ImageIcon;

public abstract class SportsInfo{
	private Random randIndex = new Random();
	
	public int random(int range) {
		return randIndex.nextInt(range);
	}
	
	public void getTeam() {
		System.out.println("getTeam");
	}
	
	public int WhoWon() {
		System.out.println("Who won?");
		return 0;
	}
	
	public abstract ImageIcon getImage(String image);
}
