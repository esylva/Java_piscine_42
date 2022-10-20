package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
	
	private Long 	id;
	private String 	login;
	private String	password;
	private List<ChatRoom> createdChatRooms;
	private List<ChatRoom> roomsOfUser;

	public User() {
		this.id = null;
		this.login = null;
		this.password = null;
		this.createdChatRooms = null;
		this.roomsOfUser = null;
	}

	public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdChatRooms = null;
        this.roomsOfUser = null;
    }

	public User(Long id, String login, String password, List<ChatRoom> createdChatRooms, List<ChatRoom> roomsOfUser) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.createdChatRooms = createdChatRooms;
		this.roomsOfUser = roomsOfUser;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getRooms() {
        return rooms;
    }

    public void setRooms(List<Chatroom> rooms) {
        this.rooms = rooms;
    }
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
		}
        if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
        User user = (User) obj;
        return id == user.id;
    }

    @Override
    public int hashCode() {
		return id;
    }

    @Override
    public String toString() {
        return "User : {" +
                "\nid= " + id +
                ",\nlogin= \"" + login + "\"" +
                ",\npassword= \"" + password + "\"" +
                ",\ncreatedRooms= " + createdRooms +
                ",\nrooms= " + rooms +
                "\n}"; 
    }
}