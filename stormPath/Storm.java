package stormPath;

import java.util.ArrayList;

public class Storm {
	private String name;
	private ArrayList<City> cities;
	private int year;

	public Storm(String name, int year) {
		this.setName(name);
		this.year = year;
		this.cities = new ArrayList<City>();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public int getYear() {
		// TODO Auto-generated method stub
		return year;
	}

	public void addCity(City c) {
		if (!this.cities.contains(c)){
			this.cities.add(c);
		}
		if (!c.wasHit(this)){
			c.addStorm(this);
		}		
	}

	public ArrayList<City> getCities() {
		// TODO Auto-generated method stub
		return cities;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		String result = this.getName() + ", " + this.getYear();
		String citiesText = "";
		if (this.getCities().size() != 0){
			for (City c : this.getCities()){
				citiesText += System.lineSeparator() + c.getName();
			}
		}
		result += citiesText;
		return result; 
	}
	
	public boolean equals(Storm otherStorm){
		return this.getName() == otherStorm.getName() && this.getYear() == otherStorm.getYear();
	}
}
