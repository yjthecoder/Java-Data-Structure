package stormPath;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;

import javax.xml.transform.sax.SAXTransformerFactory;

public class City {
	private String name;
	private ArrayList<Storm> storms;

	public City(String name) {
		this.name = name;
		this.storms = new ArrayList<Storm>();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public boolean wasHit(Storm s) {
		// TODO Auto-generated method stub
		return this.storms.contains(s);
	}

	public void addStorm(Storm s) {
		if (!this.storms.contains(s)){
			this.storms.add(s);
		}
		if (!s.getCities().contains(this)){
			s.addCity(this);
		}
	}

	public boolean onSamePath(City c2) {
		for (Storm s:this.storms){
			if (c2.wasHit(s)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		String result = this.getName() + " (";
		
		if (this.storms.size() != 0){
			for (Storm s : this.storms){
				result += s.getName() + ", ";
			}
		}else{
			return result += ")";
		}

		return result.substring(0, result.length() - 2) + ")";		
	}
	

	public boolean equals(City otherCity){
		boolean sameName = this.getName().equals(otherCity.getName());
		boolean sameSize = this.storms.size() == otherCity.storms.size();
		if (!(sameName && sameSize)){
			return false;
		}
		
		for (Storm s:this.storms){
			if (!otherCity.wasHit(s)){
				return false;
			}
		}		
		
		return true;
	}

}
