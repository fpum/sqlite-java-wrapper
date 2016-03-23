package de.pum.sqlitewrapper.jre;

import de.pum.sqlitewrapper.SqliteCursor;
import de.pum.sqlitewrapper.SqliteDatabase;
import de.pum.sqlitewrapper.SqliteException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by pum on 16.11.2015.
 */
public class JreSqliteDatabase implements SqliteDatabase {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection connection;

    public JreSqliteDatabase(Connection connection) {
        this.connection = connection;
    }

    public void beginTransaction() throws SqliteException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new SqliteException("Failed to begin transaction.", e);
        }
    }

    public void commit() throws SqliteException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new SqliteException("Failed to commit transaction.", e);
        }
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
        }
    }

    public void rollback() throws SqliteException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new SqliteException("Failed to roll back transaction.", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
        }
    }

    public SqliteCursor executeQuery(String sql) throws SqliteException {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return new JreSqliteCursor(resultSet);
        } catch (SQLException e) {
            throw new SqliteException("Failed to execute query.", e);
        }
    }

    public void executeStatement(String sql) throws SqliteException {
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new SqliteException("Failed to execute statement.", e);
        }
    }

    public void close() throws SqliteException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new SqliteException("Failed to close connection.", e);
        }
    }
}
