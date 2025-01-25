package org.Model.Model;

public abstract class User {

	public User() {
	}

	public User(int id, String login, String password) {
		Id = id;
		Login = login;
		Password = password;
	}

	public String Login;
	public String Password;
	public int Role;
	public int Id;

}