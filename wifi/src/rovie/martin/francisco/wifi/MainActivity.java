package rovie.martin.francisco.wifi;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public TextView txt;
    public WifiManager wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        Switch sw = (Switch) findViewById(R.id.sw);
        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                if (isChecked) {
                    wifiON();
                }
                else {
                    wifiOFF();
                }
            }
        });
    }

    public void wifiON() {
        wifi.setWifiEnabled(true);
        txt.setText("Wifi is ON");
        Toast.makeText(getApplicationContext(), "Wifi is ON", Toast.LENGTH_SHORT).show();
    }
    public void wifiOFF() {
        wifi.setWifiEnabled(false);
        txt.setText("Wifi is OFF");
        Toast.makeText(getApplicationContext(), "Wifi is OFF", Toast.LENGTH_SHORT).show();
    }
}