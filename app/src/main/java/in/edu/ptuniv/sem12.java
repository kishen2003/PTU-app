
package in.edu.ptuniv;
        import androidx.appcompat.app.AppCompatActivity;
        import com.github.barteksc.pdfviewer.PDFView;
        import android.os.Bundle;

public class sem12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem12);
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("Sem12.pdf").load();
    }
}