package edu.school21.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmbeddedDataSourceTest {
	private EmbeddedDatabase dataSource;

	@BeforeEach
	public void init() {
		dataSource = new EmbeddedDatabaseBuilder()
				.addScript("schema.sql")
				.addScript("data.sql")
				.build();
	}

	@Test
	void connectionDbTest() throws SQLException {
		assertNotNull(dataSource.getConnection());
	}

	@AfterEach
	void close() {
		dataSource.shutdown();
	}
}
