package com.simonscrape.scrapetut;

public class TeamStats {
	
	
	/*
	 * TODO
	 * place
	 * team
	 * games
	 * winrate
	 * streak
	 * */
	
	private int place;
	private String team;
	private String games;
	private String winrate;
	private String streak;
	
	
	public TeamStats() {
		
	}
	
	public TeamStats(int place, String team, String games, String winrate, String streak) {
		super();
		this.place = place;
		this.team = team;
		this.games = games;
		this.winrate = winrate;
		this.streak = streak;
	}
	
	
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getGames() {
		return games;
	}
	public void setGames(String games) {
		this.games = games;
	}
	public String getWinrate() {
		return winrate;
	}
	public void setWinrate(String winrate) {
		this.winrate = winrate;
	}
	public String getStreak() {
		return streak;
	}
	public void setStreak(String streak) {
		this.streak = streak;
	}
	
	
	

}
