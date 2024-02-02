package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cgpacalculator extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpacalculator);
        btn1 = findViewById(R.id.btn_sem1);
        btn2 = findViewById(R.id.btn_sem2);
        btn3 = findViewById(R.id.btn_sem3);
        btn4 = findViewById(R.id.btn_sem4);
        btn5 = findViewById(R.id.btn_sem5);
        btn6 = findViewById(R.id.btn_sem6);
        btn7 = findViewById(R.id.btn_sem7);
        btn8 = findViewById(R.id.sem8);
        btn9 = findViewById(R.id.cgpacalculator9);
    }

    public void csem1(View view)
    {
        Intent intent = new Intent(cgpacalculator.this, csem1.class);
        startActivity(intent);
    }

    public void ccgpa(View view)
    {
        Intent intent = new Intent(cgpacalculator.this,ccgpa.class);
        startActivity(intent);
    }

    public void csem3(View view)
    {
        Intent intent = new Intent(cgpacalculator.this,csem3.class);
        startActivity(intent);
    }



}