package de.pum.sqlitewrapper;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by pum on 13.11.2015.
 */
public interface SqliteCursor {

    boolean next() throws SqliteException;

    String getString(String columnName) throws SqliteException;

    Integer getInteger(String columnName) throws SqliteException;

    Long getLong(String columnName) throws SqliteException;

    void close() throws SqliteException;

}
