package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OlympicGames {
	
	private Map<String , Admin> admins = new HashMap<>();
	private List<Admin> loggedInUsers = new LinkedList<>();
	private Map<Integer , SportsVenue> sportsVenues = new HashMap<>();
	private List<OlympicSport> sports = new ArrayList<>();
	
	
	
	public void addAdmin(String firstName , String  lastName , String userName , String passWord) throws InputException{
		Admin admin = new Admin (firstName , lastName , userName , passWord);
		if(admins.containsKey(userName)) {
			throw new InputException("Username not available ");
		}else {
			admins.put(userName, admin);
			Terminal.printLine("OK");
		}
	}
	
	public void loginAdmin(String userName , String passWord) throws InputException{
		if(!admins.containsKey(userName)) {
			throw new InputException("User does not exist yet");
		}
		else if (!admins.get(userName).equals(admins.get(userName).getPassWord())) {
			throw new InputException("Incorrect password");
		}
		else {
			loggedInUsers.add(admins.get(userName));
			Terminal.printLine("OK");
		}
	}
	
	public void logoutAdmin() throws InputException{
		if(loggedInUsers.get(0).equals(null)) {
			throw new InputException("No logged in users");
		}else {
			loggedInUsers.clear();
			Terminal.printLine("OK");
		}
	}
	
	public void addSportsVenue(int id , String countryName , String location , String name , int openingYear , int seatsNumber) 
	       throws InputException{
		SportsVenue sportsVenue = new SportsVenue(id , countryName , location , name , openingYear , seatsNumber);
		if(sportsVenues.containsKey(id)) {
			throw new InputException ("Sports venue already exists");
		}
		else {
			sportsVenues.put(id, sportsVenue);
			Terminal.printLine("OK");
		}
		
	}
	
	public void listSportsVenues (String countryName) throws InputException{
		ArrayList<SportsVenue> sportsVenuesToList = new ArrayList<>();
		int n = 1;
		for(Map.Entry<Integer , SportsVenue> entry : sportsVenues.entrySet()) {
			if(entry.getValue().getCountryname().equals(countryName)) {
				sportsVenuesToList.add(entry.getValue());
			}
		}
		
		Collections.sort(sportsVenuesToList , SportsVenue.compareSportsVenues());
		for(SportsVenue sportsVenue : sportsVenuesToList) {
			Terminal.printLine(n + " " + sportsVenue);
			n++;
		}
		
	}
	
	public void addOlympicSport(String sportsType , String sportsDiscipline) throws InputException {
		OlympicSport olympicSport = new OlympicSport (sportsType , sportsDiscipline);
		for(OlympicSport sport : sports) {
			if(sport.equals(olympicSport)) {
				throw new InputException("Sport already added");
			}
			else {
				sports.add(olympicSport);
			}
		}
	}
	
	public void listOlympicSports() {
		Terminal.printLine(sports);
	}
	

}
