package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private Long id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime timeStamp;

    public Message(Long id, User author, Chatroom room, String text, LocalDateTime timeStamp) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.timeStamp = timeStamp;
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
        Message mes = (Message) obj;
        return (id == mes.id && timeStamp == mes.timeStamp && text.equals(mes.text));
    }

    @Override
    public String toString() {
        String result = "Message: {" +
				"\nid=" + id +
                ",\nauthor=" + author +
                ",\nroom=" + room +
                ",\ntext=\"" + text + "\"" +
                ",\ntimeStamp=" + timeStamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
				"\n}";
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) { this.text = text; }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
