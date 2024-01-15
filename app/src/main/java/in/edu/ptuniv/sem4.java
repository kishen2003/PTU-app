
package in.edu.ptuniv;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import android.os.Bundle;

public class sem4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem4);
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("Sem4.pdf").load();
    }
}