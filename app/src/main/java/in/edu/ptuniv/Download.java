package in.edu.ptuniv;
import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;


public class Download extends IntentService {

    public Download() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            String fileUrl = intent.getStringExtra("fileUrl");
            if (fileUrl != null) {
                downloadFile(fileUrl);
            }
        }
    }

    private void downloadFile(String fileUrl) {
        try {
            Uri uri = Uri.parse(fileUrl);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            String title = URLUtil.guessFileName(fileUrl,null,"application/pdf");
            request.setTitle(title);
            request.setDescription("Download in progress");

            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "title");

            DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

            long downloadId = downloadManager.enqueue(request);
            Log.d("DownloadService", "File download enqueued with ID: " + downloadId);
        } catch (Exception e) {
            Log.e("DownloadService", "Error downloading file: " + e.getMessage());
        }
    }
}
