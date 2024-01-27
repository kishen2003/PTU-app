package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import in.edu.ptuniv.data.NotesContract;
import in.edu.ptuniv.data.NotesProvider;
import in.edu.ptuniv.data.NotesDbHelper;

public class notes extends AppCompatActivity {
    private static final String TAG = notes.class.getSimpleName();
    private RecyclerView NotesView;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ContentResolver resolver = getContentResolver();
        Log.i(TAG, "Notes after content resolver call");

        NotesDbHelper dbHelper = new NotesDbHelper(this); // Use 'this' instead of 'getContext()'

        NotesView = findViewById(R.id.notes);

        ArrayList<Note> notess = new ArrayList<>();
        notess.add(new Note(1, "SEM1", "https://drive.google.com/file/d/1uA-QOpAFnc18vjQw9V1Wy0fe_HeYEVeJ/view?usp=sharing"));
        notess.add(new Note(2, "SEM2", "https://drive.google.com/file/d/1uA-QOpAFnc18vjQw9V1Wy0fe_HeYEVeJ/view?usp=sharing"));
        Log.i(TAG, "Notes after array list");

        for (Note note : notess) {
            ContentValues values = new ContentValues();
            Log.i(TAG, "Notes after content values");

            values.put(NotesContract.NotesEntry.COLUMN_NAME, note.getName());
            values.put(NotesContract.NotesEntry.COLUMN_LINK, note.getLink());
            Log.i(TAG, "Notes after values put");
            try {
                // Use the ContentResolver to insert the values into the database
                Uri uri = resolver.insert(NotesContract.NotesEntry.CONTENT_URI, values);
                Log.i(TAG, "Notes after uri resolver insert");

                if (uri != null) {
                    long id = ContentUris.parseId(uri);
                    Log.d(TAG, "Inserted note with ID: " + id);
                } else {
                    Log.e(TAG, "Failed to insert note");
                }
            }
            catch (Exception e)
            {
                Log.e(TAG,"Error message: "+e.getMessage());
            }
        }

        NotesViewAdapter adapter = new NotesViewAdapter();
        adapter.setNotess(notess);

        NotesView.setAdapter(adapter);
        NotesView.setLayoutManager(new LinearLayoutManager(this));
    }
}