package in.edu.ptuniv.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import in.edu.ptuniv.data.NotesContract.NotesEntry;

public class NotesDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;

    private final String SQL_CREATE_NOTES_TABLE
            = "CREATE TABLE " + NotesContract.NotesEntry.TABLE_NAME
            + " (" + NotesContract.NotesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NotesContract.NotesEntry.COLUMN_NAME + " TEXT, "
            + NotesContract.NotesEntry.COLUMN_LINK + " TEXT NOT NULL);";

    public NotesDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_NOTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ NotesContract.NotesEntry.TABLE_NAME);
        onCreate(db);
    }
}
