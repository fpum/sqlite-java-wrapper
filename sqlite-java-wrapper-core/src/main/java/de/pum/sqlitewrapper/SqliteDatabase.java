package de.pum.sqlitewrapper;

/**
 * Created by pum on 13.11.2015.
 */
public interface SqliteDatabase {

    void beginTransaction() throws SqliteException;

    void commit() throws SqliteException;

    void rollback() throws SqliteException;

    SqliteCursor executeQuery(String sql) throws SqliteException;

    void executeStatement(String sql) throws SqliteException;

    void close() throws SqliteException;

}
