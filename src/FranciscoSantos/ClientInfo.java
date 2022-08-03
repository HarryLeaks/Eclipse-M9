package FranciscoSantos;

public class ClientInfo extends Main{
	private String name;
	private String email;
	private String password;
	private String country;
	private int deposit;
	private int day;
	private int month;
	private int year;
	private Boolean isLogged;
	
	public Boolean getIsLogged() {
		return isLogged;
	}
	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public void setDay(int i) {
		this.day = i;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public int getDeposit() {
		return deposit;
	}
	public String getCountry() {
		return country;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getBirthday() {
		return day + "/" + (month+1) + "/" + year;
	}
}
