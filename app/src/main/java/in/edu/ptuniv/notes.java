package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class notes extends AppCompatActivity {
    private RecyclerView NotesView;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        NotesView=findViewById(R.id.notes);

        ArrayList<Note> notess=new ArrayList<>();
        notess.add(new Note(1,"SEM1","dssdsds"));
        notess.add(new Note(2,"SEM2","dssdsds"));

        NotesViewAdapter adapter=new NotesViewAdapter();
        adapter.setNotess(notess);

        NotesView.setAdapter(adapter);
        NotesView.setLayoutManager(new LinearLayoutManager(this));

    }
}