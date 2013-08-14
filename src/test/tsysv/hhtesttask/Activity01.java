package test.tsysv.hhtesttask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity01 extends Activity {

	 Spinner spinner1;
	 Button send_res;
	 EditText ed_name, ed_dolzh, ed_zarpl, ed_phone, ed_mail;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity02);
		
		Toast.makeText(getApplicationContext(), getResources().getString(R.string.hello) , Toast.LENGTH_LONG).show();
		
		ed_name = (EditText) findViewById(R.id.fio01);
		
		
		spinner1 = (Spinner) findViewById(R.id.mafe);
		spinner1.setPrompt(getResources().getString(R.string.malefe_prompt));
		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		
		ed_dolzh = (EditText) findViewById(R.id.ed_dolzh);
		
		
		
		ed_zarpl = (EditText) findViewById(R.id.ed_zarpl);
		
		ed_phone = (EditText) findViewById(R.id.ph_number);
		
		ed_mail = (EditText) findViewById(R.id.ed_mail);
		
		send_res = (Button) findViewById(R.id.sendres);
		
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity01, menu);
		return true;
	}

}
