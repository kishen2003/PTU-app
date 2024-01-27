package in.edu.ptuniv.data;
import android.net.Uri;
import android.provider.BaseColumns;

public class NotesContract {

    public static final String CONTENT_AUTHORITY = "in.edu.ptuniv.data.NotesProvider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_NOTES = "notes";
    public static final class NotesEntry implements BaseColumns
    {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_NOTES);

        public static final String TABLE_NAME = "notes";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_LINK = "link";

    }
}
