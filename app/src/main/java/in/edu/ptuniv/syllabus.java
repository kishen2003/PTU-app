package in.edu.ptuniv;

import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import android.os.Bundle;

public class syllabus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("syllabus.pdf").load();
    }
}