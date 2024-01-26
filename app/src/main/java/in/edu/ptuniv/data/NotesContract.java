package in.edu.ptuniv.data;

import android.provider.BaseColumns;

public class NotesContract {
    public static final class NotesEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "notes";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_LINK = "link";

    }
}
