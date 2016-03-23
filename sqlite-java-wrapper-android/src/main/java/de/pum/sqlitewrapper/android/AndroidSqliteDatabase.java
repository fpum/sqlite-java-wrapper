package de.pum.sqlitewrapper.android;

import android.database.sqlite.SQLiteDatabase;
import de.pum.sqlitewrapper.SqliteCursor;
import de.pum.sqlitewrapper.SqliteDatabase;
import de.pum.sqlitewrapper.SqliteException;

/**
 * Created by pum on 13.11.2015.
 */
public class AndroidSqliteDatabase implements SqliteDatabase {

    private SQLiteDatabase systemDatabase;

    public AndroidSqliteDatabase(SQLiteDatabase systemDatabase) {
        this.systemDatabase = systemDatabase;
    }

    public void beginTransaction() throws SqliteException {
        systemDatabase.beginTransaction();
    }

    public void commit() throws SqliteException {
        systemDatabase.setTransactionSuccessful();
        systemDatabase.endTransaction();
    }

    public void rollback() throws SqliteException {
        systemDatabase.endTransaction();
    }

    public SqliteCursor executeQuery(String sql) throws SqliteException {
        return new AndroidSqliteCursor(systemDatabase.rawQuery(sql, new String[]{}));
    }

    public void executeStatement(String sql) throws SqliteException {
        systemDatabase.execSQL(sql);
    }

    public void close() throws SqliteException {
        systemDatabase.close();
    }

}
