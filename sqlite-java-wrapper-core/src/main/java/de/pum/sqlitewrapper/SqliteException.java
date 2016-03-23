package de.pum.sqlitewrapper;

/**
 * Created by pum on 13.11.2015.
 */
public class SqliteException extends Exception {

    public SqliteException() {
    }

    public SqliteException(String s) {
        super(s);
    }

    public SqliteException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public SqliteException(Throwable throwable) {
        super(throwable);
    }

    public SqliteException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }

}
