package hello;

import java.util.ArrayList;

public class Users {
	private ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<User> getUser() {
		return users;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void setUserList(ArrayList<User> user) {
		this.users = user;
	}
}