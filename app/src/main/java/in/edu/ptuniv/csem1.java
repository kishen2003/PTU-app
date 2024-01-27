package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
public class csem1 extends AppCompatActivity {
    private Spinner spinner,spinner1, spinner2, spinner3, spinner4, spinner5, spinner6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csem1);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);
        spinner6 = findViewById(R.id.spinner6);
    }

    public void calgpa(View view) {
        String grade0 = spinner.getSelectedItem().toString();
        String grade1 = spinner1.getSelectedItem().toString();
        String grade2 = spinner2.getSelectedItem().toString();
        String grade3 = spinner3.getSelectedItem().toString();
        String grade4 = spinner4.getSelectedItem().toString();
        String grade5 = spinner5.getSelectedItem().toString();
        String grade6 = spinner6.getSelectedItem().toString();
        double gpa = (calgp(grade0,4)
                +calgp(grade1,4)
                +calgp(grade2,4)
                +calgp(grade3,3)
                +calgp(grade4,1.5)
                +calgp(grade5,1.5)
                +calgp(grade6,1.5))
                /19.5;
        Intent intent = new Intent(csem1.this,Displaycgpa.class);
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

}

