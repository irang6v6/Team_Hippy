package net.skhu.dto;

public class User {
	int userID;
	String userName;
	String userPassword;
	int preferCategory;
	int preferHashtag;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getPreferCategory() {
		return preferCategory;
	}

	public void setPreferCategory(int preferCategory) {
		this.preferCategory = preferCategory;
	}

	public int getPreferHashtag() {
		return preferHashtag;
	}

	public void setPreferHashtag(int preferHashtag) {
		this.preferHashtag = preferHashtag;
	}
}
