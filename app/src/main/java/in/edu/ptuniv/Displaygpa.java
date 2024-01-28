package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Displaygpa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaygpa);
        double gpaResult = getIntent().getDoubleExtra("GPA_RESULT", 0.0);
        gpaResult = (double) Math.round(gpaResult * 100) /100;
        String gpa = Double.toString(gpaResult);
        TextView gpaResultTextView = findViewById(R.id.gpaResultTextView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gpaResultTextView.setText(String.format("Your GPA is: %s", gpa));
                ObjectAnimator animator = ObjectAnimator.ofFloat(gpaResultTextView, "alpha", 0f, 1f);
                animator.setDuration(3000);
                animator.start();
            }
        }, 500);
    }
}