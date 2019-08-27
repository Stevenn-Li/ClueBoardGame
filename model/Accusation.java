package model;

public class Accusation {
	
	private String _person;
	private String _weapon;
	private String _room;
	
	public Accusation(String person, String weapon, String room) {
		_person = person;
		_weapon = weapon;
		_room = room;
	}
	
	public boolean equals(Accusation a) {
		return (a.getPerson().equals(_person) 
				&& a.getWeapon().equals(_weapon)
				&& a.getRoom().equals(_room));
	}
	
	public String getPerson() { return _person;	}
	public String getWeapon() { return _weapon; }
	public String getRoom() { return _room; }
	
}
