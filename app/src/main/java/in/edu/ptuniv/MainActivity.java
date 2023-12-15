package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
    }
    public void syll_button(View view)
    {
        Intent intent = new Intent(MainActivity.this, syllabus.class);
        startActivity(intent);
    }
    public void notes_button(View view)
    {
        Intent intent = new Intent(MainActivity.this, notes.class);
        startActivity(intent);
    }
    public void pyq_button(View view)
    {
        Intent intent = new Intent(MainActivity.this, previousyearquestionpaper.class);
        startActivity(intent);
    }
    public void cgpa_button(View view)
    {
        Intent intent = new Intent(MainActivity.this, cgpacalculator.class);
        startActivity(intent);
    }
    public void fav_button(View view)
    {
        Intent intent = new Intent(MainActivity.this, favourites.class);
        startActivity(intent);
    }
    public void about_button(View view)
    {
        Intent intent = new Intent(MainActivity.this, about.class);
        startActivity(intent);
    }
}
