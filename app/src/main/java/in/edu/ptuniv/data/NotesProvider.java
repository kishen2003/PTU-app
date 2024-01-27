package in.edu.ptuniv.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import static in.edu.ptuniv.data.NotesContract.CONTENT_AUTHORITY;
import static in.edu.ptuniv.data.NotesContract.NotesEntry.TABLE_NAME;
import static in.edu.ptuniv.data.NotesContract.PATH_NOTES;

public class NotesProvider extends ContentProvider {

    private static final String TAG = NotesProvider.class.getSimpleName();

    private NotesDbHelper databaseHelper;

    //constants for the operation
    private static final int NOTES = 1;				// For whole table
    private static final int NOTES_ID = 2;			// For a specific row in a table identified by _ID
    private static final int NOTES_NOTE_NAME = 3;// For a specific row in a table identified by COUNTRY NAME

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_NOTES, NOTES);
        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_NOTES + "/#", NOTES_ID);
        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_NOTES + "/*", NOTES_NOTE_NAME);
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new NotesDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor;

        switch (uriMatcher.match(uri)) {

            case NOTES:
                cursor = database.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;

            case NOTES_ID:
                selection = NotesContract.NotesEntry._ID + " = ?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = database.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;

            default:
                throw new IllegalArgumentException(TAG + "Unknown URI: " + uri);
        }

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        switch (uriMatcher.match(uri)) {

            case NOTES:
                return insertRecord(uri, values, TABLE_NAME);
            default:
                throw new IllegalArgumentException(TAG + "Unknown URI: " + uri);
        }
    }

    private Uri insertRecord(Uri uri, ContentValues values, String tableName) {

        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        long rowId = database.insert(tableName, null, values);

        if (rowId == -1) {
            Log.e(TAG, "Insert error for URI " + uri);
            return null;
        }

        return ContentUris.withAppendedId(uri, rowId);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        switch (uriMatcher.match(uri)) {

            default:
                throw new IllegalArgumentException(TAG + "Unknown URI: " + uri);
        }
    }

    private int deleteRecord(String selection, String[] selectionArgs, String tableName) {
        return -1;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        switch (uriMatcher.match(uri)) {

            default:
                throw new IllegalArgumentException(TAG + "Unknown URI: " + uri);
        }
    }

    private int updateRecord(ContentValues values, String selection, String[] selectionArgs, String tableName) {
        return -1;
    }
}
