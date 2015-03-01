package com.example.broadcastdemo;

import android.os.Bundle;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.amit.ss");
				sendBroadcast(i);
				
			}
		});
        IntentFilter f = new IntentFilter("com.amit.ss");
        registerReceiver(mR, f);
        Account account = new Account("Title", "com.example.broadcastdemo");
        String password = "password";
        AccountManager accountManager = AccountManager.get(getApplicationContext());
        accountManager.addAccountExplicitly(account, password, null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    BroadcastReceiver mR = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context arg0, Intent arg1) {
		
			
		}
	};
    
}
