package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
        btn2 = findViewById(R.id.stn_sem2);
        btn3 = findViewById(R.id.btn_sem3);
        btn4 = findViewById(R.id.btn_sem4);
        btn5 = findViewById(R.id.btn_sem5);
        btn6 = findViewById(R.id.btn_sem6);
        btn7 = findViewById(R.id.btn_sem7);
        btn8 = findViewById(R.id.sem8);
        btn9 = findViewById(R.id.cgpacalculator9);
    }

    public void fsem1(View view)
    {
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn5.setVisibility(View.GONE);
        btn6.setVisibility(View.GONE);
        btn7.setVisibility(View.GONE);
        btn8.setVisibility(View.GONE);
        btn9.setVisibility(View.GONE);
        FragmentManager manager = getFragmentManager();
        fsem1 fsem1o = new fsem1();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.cgpacalc,fsem1o,"fsem1");
        transaction.commit();
    }

}