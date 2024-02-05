// WifiStateReceiver.java
package in.edu.ptuniv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

public class WifiStateReceiver extends BroadcastReceiver {

    private favourites activity;

    public WifiStateReceiver(favourites activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN);

        switch (wifiStateExtra) {
            case WifiManager.WIFI_STATE_ENABLED:
                activity.setWifiSwitchChecked(true);
                activity.setWifiSwitchText("WiFi is ON");
                activity.displayNotification("Keep the wifi on to use services like download");
                break;
            case WifiManager.WIFI_STATE_DISABLED:
                activity.setWifiSwitchChecked(false);
                activity.setWifiSwitchText("WiFi is OFF");
                activity.displayNotification("Enable wifi to download syllabus and view notes");
                break;
        }
    }
}
