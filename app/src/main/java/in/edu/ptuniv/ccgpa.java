package in.edu.ptuniv;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;

public class ccgpa extends AppCompatActivity {

    private LinearLayout textViewsContainer;
    private Button calculateButton;
    private int numberOfSemesters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccgpa);

        Spinner semesterSpinner = findViewById(R.id.semesterSpinner);
        textViewsContainer = findViewById(R.id.textViewsContainer);
        calculateButton = findViewById(R.id.calculateButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.semester_numbers,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the calculation logic here
                calculateCGPA();
            }
        });

        // Set up a listener for the spinner to dynamically create TextViews and EditTexts
        semesterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                numberOfSemesters = Integer.parseInt(adapterView.getItemAtPosition(position).toString());
                createTextViewsAndEditTexts(numberOfSemesters);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing here
            }
        });
    }

    private void createTextViewsAndEditTexts(int numberOfSemesters) {
        // Clear the existing views
        textViewsContainer.removeAllViews();

        for (int i = 1; i <= numberOfSemesters; i++) {
            TextView textView = new TextView(this);
            textView.setText("Semester " + i);
            textViewsContainer.addView(textView);

            EditText editText = new EditText(this);
            editText.setHint("Enter GPA for Semester " + i);
            editText.setInputType(android.text.InputType.TYPE_CLASS_NUMBER | android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL);
            textViewsContainer.addView(editText);
        }
    }


    private void calculateCGPA() {
        String[] senteredGPA= new String[8];
        double[] enteredGPA = new double[8];
        for(int i=0;i<numberOfSemesters;i++)
        {
            View view = textViewsContainer.getChildAt(i * 2 + 1); // Skip TextViews, get EditTexts
            if (view instanceof EditText) {
                senteredGPA[i] = ((EditText) view).getText().toString();
                enteredGPA[i] = Double.parseDouble(senteredGPA[i]);
            }
        }
        double totalgpa = 0;
        double totalcredits = 0;
        switch(numberOfSemesters)
        {
            case 8:
                totalgpa += enteredGPA[7]*15;
                totalcredits += 15;
            case 7:
                totalgpa += enteredGPA[6]*19.5;
                totalcredits += 19.5;
            case 6:
                totalgpa += enteredGPA[5]*24;
                totalcredits += 24;
            case 5:
                totalgpa += enteredGPA[4]*22;
                totalcredits += 22;
            case 4:
                totalgpa += enteredGPA[3]*21.5;
                totalcredits += 21.5;
            case 3:
                totalgpa += enteredGPA[2]*19.5;
                totalcredits += 19.5;
            case 2:
                totalgpa += enteredGPA[1]*17;
                totalcredits += 17;
            case 1:
                totalgpa += enteredGPA[0]*19.5;
                totalcredits += 19.5;
                break;
            default:
                totalgpa += 0;
                totalcredits += 0;
                break;
        }
        double cgpa = totalgpa/totalcredits;
        Intent intent = new Intent(ccgpa.this,Displaycgpa.class);
        intent.putExtra("CGPA_RESULT",cgpa);
        startActivity(intent);
    }
}
