package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private Long id;
    private String name;
    private User creator;
    private List<Message> messages;

    public Chatroom(Long id, String name) {
        this.id = id;
        this.name = name;
        this.creator = null;
        this.messages = null;
    }
    
    public Chatroom(Long id, String name, User creator, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.messages = messages;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
        if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
        Chatroom chtrm = (Chatroom) obj;
        return (id == chtrm.id && name.equals(chtrm.name) && creator.equals(chtrm.creator));
    }

    @Override
    public String toString() {
        return "Chatroom: {" +
				"\nid=" + id +
                ",\nname=\"" + name + "\"" +
                ",\ncreator=" + creator +
                ",\nmessages=" + messages + "\n}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
