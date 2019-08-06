package sg.edu.rp.c346.anotherreceiverapp;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        br = new AnotherBroadcastReceiver();

        IntentFilter filter= new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("com.example.broadcast.MY_BROADCAST");
        //sender and receiver package name must same
        //Intent intent = new Intent("com.example.broadcast.hello");
        this.registerReceiver(br,filter);

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        this.unregisterReceiver(br);
    }
}
