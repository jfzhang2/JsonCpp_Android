package com.kevin.tutorial.jsoncpp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ToUseJsoncppActivity extends Activity {
	
	private static final String TAG = "ToUseJsoncppActivity.java";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnOk = (Button)findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int id = 1001;
				String name = "Kevin";
				String result = toBuildJson(id, name);
				Log.i(TAG,String.format("Id:%1$d,Name:%2$s,The json formated string:%3$s", id,name,result));
			}
		});
    }
    
    private static native String toBuildJson(int id,String name);
    
	static {
		System.loadLibrary("jsoncpp");
		System.loadLibrary("main");
	}
}