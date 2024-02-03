package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.Spinner;
public class csem3 extends AppCompatActivity implements csem3Fragment.OnItemSelectedListener{

    private static final String TAG = csem3.class.getSimpleName();
    private boolean ishonours;
    private String grade8;
    private Spinner spinner,spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7;
    private CheckBox checkBox;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csem3);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);
        spinner6 = findViewById(R.id.spinner6);
        spinner7 = findViewById(R.id.spinner7);
        checkBox = findViewById(R.id.checkBox);
        fragmentContainer =findViewById(R.id.frame_container);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new csem3Fragment())
                    .commitNow();
            fragmentContainer.setVisibility(View.GONE); // Initially hide the fragment
        }
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                fragmentContainer.setVisibility(View.VISIBLE);
                ishonours = true;
            } else {
                fragmentContainer.setVisibility(View.GONE);
                ishonours = false;
            }
        });
    }

    public void calgpa(View view) {
        String grade0 = spinner.getSelectedItem().toString();
        String grade1 = spinner1.getSelectedItem().toString();
        String grade2 = spinner2.getSelectedItem().toString();
        String grade3 = spinner3.getSelectedItem().toString();
        String grade4 = spinner4.getSelectedItem().toString();
        String grade5 = spinner5.getSelectedItem().toString();
        String grade6 = spinner6.getSelectedItem().toString();
        String grade7 = spinner7.getSelectedItem().toString();
        double gpa;
        if(!ishonours) {
             gpa = (calgp(grade0, 2)
                    + calgp(grade1, 3)
                    + calgp(grade2, 4)
                    + calgp(grade3, 3)
                    + calgp(grade4, 3)
                    + calgp(grade5, 1.5)
                    + calgp(grade6, 1.5)
                    + calgp(grade7, 1.5))
                    / 19.5;
        }
        else{
            gpa = (calgp(grade0, 2)
                    + calgp(grade1, 3)
                    + calgp(grade2, 4)
                    + calgp(grade3, 3)
                    + calgp(grade4, 3)
                    + calgp(grade5, 1.5)
                    + calgp(grade6, 1.5)
                    + calgp(grade7, 1.5)
                    + calgp(grade8, 4))
                    / 23.5;
        }
        Intent intent = new Intent(csem3.this,Displaygpa.class);
        intent.putExtra("GPA_RESULT",gpa);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public double calgp(String grade, double credit)
    {
        double gp;
        switch(grade)
        {
            case "S":
                gp=credit*10;
                break;
            case "A":
                gp=credit*9;
                break;
            case "B":
                gp=credit*8;
                break;
            case "C":
                gp=credit*7;
                break;
            case "D":
                gp=credit*6;
                break;
            case "E":
                gp=credit*5;
                break;
            case "F":
                gp=credit*0;
                break;
            default:
                gp=0;
                break;
        }
        return gp;
    }

    @Override
    public void onItemSelected(String selected) {
        // Handle the selected item here
        Log.d(TAG, "Selected item: " + selected);
        grade8 = selected;
    }

}

