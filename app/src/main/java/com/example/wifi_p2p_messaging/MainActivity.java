package com.example.wifi_p2p_messaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView connectionStatus,receivedMessages;
    ListView userList;
    EditText sendMessages;
    ImageButton sendBtn;
    Button wifiBtn,discoverBtn;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        explistener();
    }

    private void explistener() {
        wifiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wifiManager.isWifiEnabled()){
                    wifiManager.setWifiEnabled(false);
                    wifiBtn.setText("WIFI ON");
                }else {
                    wifiManager.setWifiEnabled(true);
                    wifiBtn.setText("WIFI OFF");
                }
            }
        });
    }

    void init(){
        connectionStatus=findViewById(R.id.connection_status);
        receivedMessages=findViewById(R.id.message_received);
        userList=findViewById(R.id.list_of_users);
        sendMessages=findViewById(R.id.sendmessage);
        sendBtn=findViewById(R.id.send);
        wifiBtn=findViewById(R.id.wifi_on_btn);
        discoverBtn=findViewById(R.id.discover_btn);
         wifiManager= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }
}
