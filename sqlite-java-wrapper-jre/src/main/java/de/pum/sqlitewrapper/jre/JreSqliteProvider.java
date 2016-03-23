package de.pum.sqlitewrapper.jre;

import de.pum.sqlitewrapper.SqliteDatabase;
import de.pum.sqlitewrapper.SqliteException;
import de.pum.sqlitewrapper.SqliteProvider;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pum on 16.11.2015.
 */
public class JreSqliteProvider implements SqliteProvider {

    private File dataDirectory;

    public JreSqliteProvider(File dataDirectory) {
        this.dataDirectory = dataDirectory;
    }

    public Set<String> getAvailableDatabaseNames() {
        Set<String> dbNames = new HashSet<String>();
        String[] fileNamesInDataDir = dataDirectory.list();
        for(String fileName : fileNamesInDataDir) {
            if(fileName.endsWith(".db")) {
                dbNames.add(fileName.substring(0, fileName.length() - 3));
            }
        }
        return dbNames;
    }

    public SqliteDatabase openOrCreateDatabase(String databaseName) throws SqliteException {
        try {
            if(!dataDirectory.exists()) {
                dataDirectory.mkdirs();
            }
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dataDirectory.toString() + File.separator + databaseName + ".db");
            return new JreSqliteDatabase(connection);
        } catch (SQLException e) {
            throw new SqliteException("Failed to connect to database.", e);
        }
    }
}
