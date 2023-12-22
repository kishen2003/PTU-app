package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class about extends AppCompatActivity {
    private static final String TAG = about.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        FragmentManager manager = getFragmentManager();
        fptupyqs frptupyqs = new fptupyqs();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.aboutActivity,frptupyqs,"fpyps");
        transaction.commit();
    }

}