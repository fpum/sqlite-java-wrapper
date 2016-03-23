package de.pum.sqlitewrapper;

import java.util.Set;

/**
 * Created by pum on 13.11.2015.
 */
public interface SqliteProvider {

    Set<String> getAvailableDatabaseNames();

    SqliteDatabase openOrCreateDatabase(String databaseName) throws SqliteException;

}
