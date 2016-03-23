package de.pum.sqlitewrapper.android;

import android.database.Cursor;
import de.pum.sqlitewrapper.SqliteCursor;
import de.pum.sqlitewrapper.SqliteException;

/**
 * Created by pum on 13.11.2015.
 */
public class AndroidSqliteCursor implements SqliteCursor {

    private Cursor systemCursor = null;

    public AndroidSqliteCursor(Cursor systemCursor) {
        this.systemCursor = systemCursor;
    }

    public boolean next() throws SqliteException {
        return systemCursor.moveToNext();
    }

    public String getString(String columnName) throws SqliteException {
        return systemCursor.getString(systemCursor.getColumnIndex(columnName));
    }

    public Integer getInteger(String columnName) throws SqliteException {
        return systemCursor.getInt(systemCursor.getColumnIndex(columnName));
    }

    public Long getLong(String columnName) throws SqliteException {
        return systemCursor.getLong(systemCursor.getColumnIndex(columnName));
    }

    public void close() throws SqliteException {
        systemCursor.close();
    }

}
