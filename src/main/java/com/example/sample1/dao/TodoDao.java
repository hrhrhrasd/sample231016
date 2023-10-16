package com.example.sample1.dao;
import com.example.sample1.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TodoDao {

    @Autowired
    private DataSource dataSource;
    
    public List<Todo> list() throws SQLException {
        String sql = "select * from todo ordet by id desc";
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Todo> list = new ArrayList<>();
        try (connection;statement;resultSet) {
            while (resultSet.next()) {
                Todo todo = new Todo();
                todo.setId(resultSet.getInt("id"));
                todo.setTodo(resultSet.getString("todo"));
                todo.setInserted(resultSet.getTimestamp("inserted").toLocalDateTime());
            }
        }

    }

    public boolean insert(Todo todo) throws SQLException {
        String sql = """
                insert into todo (todo)
                value (?)
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection;statement){
            statement.setString(1,todo.getTodo());
            int row = statement.executeUpdate();

            return row == 1;

            }
        }
    }
}
