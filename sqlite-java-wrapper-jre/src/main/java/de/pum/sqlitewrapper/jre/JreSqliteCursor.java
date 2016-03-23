package de.pum.sqlitewrapper.jre;

import de.pum.sqlitewrapper.SqliteCursor;
import de.pum.sqlitewrapper.SqliteException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pum on 16.11.2015.
 */
public class JreSqliteCursor implements SqliteCursor {

    private ResultSet resultSet;

    public JreSqliteCursor(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public boolean next() throws SqliteException {
        try {
            return resultSet.next();
        } catch (SQLException e) {
            throw new SqliteException("Failed to move cursor.", e);
        }
    }

    public String getString(String columnName) throws SqliteException {
        try {
            return resultSet.getString(columnName);
        } catch (SQLException e) {
            throw new SqliteException("Failed to get column " + columnName + ".", e);
        }
    }

    public Integer getInteger(String columnName) throws SqliteException {
        try {
            return resultSet.getInt(columnName);
        } catch (SQLException e) {
            throw new SqliteException("Failed to get column " + columnName + ".", e);
        }
    }

    public Long getLong(String columnName) throws SqliteException {
        try {
            return resultSet.getLong(columnName);
        } catch (SQLException e) {
            throw new SqliteException("Failed to get column " + columnName + ".", e);
        }
    }

    public void close() throws SqliteException {
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new SqliteException("Failed to close result set.", e);
        }
    }
}
