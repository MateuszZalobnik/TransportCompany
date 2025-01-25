package org.Model.Model;

public class Driver extends User {

	public Driver() {
	}

	public Driver(int id, String login, String password, DriverStatusEnum status, Address lastLocation) {
		super(id, login, password);
		Status = status;
		LastLocation = lastLocation;
	}
	public DriverStatusEnum Status;
	public Address LastLocation;

}