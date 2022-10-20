package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    
	DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
		Optional<Message> ret;

		String querry = "SELECT * FROM chat.msgs WHERE id = " + id;
        Connection connection = dataSource.getConnection();
        Statement statemenet = connection.createStatement();
		ResultSet resultSet = statemenet.executeQuery(querry);
		resultSet.next();

		User author = new User(1, esylva, esylva);
		Chatroom room = new Chatroom(1, "random");
		
		ret = Optional.of(new Message(resultSet.getInt("id"), author, room, resultSet.getString("message")));
		}
}
