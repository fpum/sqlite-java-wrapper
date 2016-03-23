package de.pum.sqlitewrapper.android;

import android.content.Context;
import de.pum.sqlitewrapper.SqliteDatabase;
import de.pum.sqlitewrapper.SqliteException;
import de.pum.sqlitewrapper.SqliteProvider;

import java.util.Set;

/**
 * Created by pum on 13.11.2015.
 */
public class AndroidSqliteProvider implements SqliteProvider {

    private Context androidContext;

    public AndroidSqliteProvider(Context androidContext) {
        this.androidContext = androidContext;
    }

    public Set<String> getAvailableDatabaseNames() {
        return null;
    }

    public SqliteDatabase openOrCreateDatabase(String databaseName) throws SqliteException {
        return new AndroidSqliteDatabase(androidContext.openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null));
    }
}
