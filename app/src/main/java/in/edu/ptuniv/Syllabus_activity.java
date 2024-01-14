package in.edu.ptuniv;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class Syllabus_activity extends AppCompatActivity
{
    Button btn_sem12, btn_sem3, btn_sem4, btn_sem5, btn_sem6, btn_sem7, btn_sem8, btn_pec, btn_honours, btn_download, btn_overview;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_activity);
        btn_sem12 = findViewById(R.id.btn_sem1);
        btn_sem3 = findViewById(R.id.btn_sem3);
        btn_sem4 = findViewById(R.id.btn_sem4);
        btn_sem5 = findViewById(R.id.btn_sem5);
        btn_sem6 = findViewById(R.id.stn_sem6);
        btn_sem7 = findViewById(R.id.btn_sem7);
        btn_sem8 = findViewById(R.id.btn_sem8);
        btn_pec = findViewById(R.id.btn_pec);
        btn_honours = findViewById(R.id.btn_honours);
        btn_download = findViewById(R.id.btn_download);
        btn_overview = findViewById(R.id.btn_overview);
    }


}
