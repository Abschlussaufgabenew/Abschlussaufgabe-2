package edu.kit.informatik;

public class OlympicSport {
	private String sportsType;
	private String sportsDiscipline;
	
	
	public OlympicSport(String sportsType , String sportsDiscipline) {
		this.sportsDiscipline = sportsDiscipline;
		this.sportsType = sportsType;
	}


	@Override
	public String toString() {
		return sportsType + " " + sportsDiscipline;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sportsDiscipline == null) ? 0 : sportsDiscipline.hashCode());
		result = prime * result + ((sportsType == null) ? 0 : sportsType.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OlympicSport other = (OlympicSport) obj;
		if (sportsDiscipline == null) {
			if (other.sportsDiscipline != null)
				return false;
		} else if (!sportsDiscipline.equals(other.sportsDiscipline))
			return false;
		if (sportsType == null) {
			if (other.sportsType != null)
				return false;
		} else if (!sportsType.equals(other.sportsType))
			return false;
		return true;
	}
	
	
	
	

}
