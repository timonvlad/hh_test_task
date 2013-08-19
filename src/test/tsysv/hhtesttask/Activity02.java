package test.tsysv.hhtesttask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity02 extends Activity {

	EditText ed_name2, ed_data2, ed_male2, ed_dolzh2, ed_zarpl2, ed_letter;
	TextView  ed_phone2, ed_mail2;
	 String name, data, male, dolzh, zarpl, phone, mail;
	 Button send;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.act02);
		
		
		
		ed_name2 = (EditText) findViewById(R.id.fio012);
		
		ed_data2 = (EditText) findViewById(R.id.data2);
		
		ed_male2 = (EditText) findViewById(R.id.pol2);
		
		ed_dolzh2 = (EditText) findViewById(R.id.ed_dolzh2);

		ed_zarpl2 = (EditText) findViewById(R.id.ed_zarpl2);
		
		ed_phone2 = (TextView) findViewById(R.id.ph_number2);
		
		ed_mail2 = (TextView) findViewById(R.id.ed_mail2);
		
		ed_letter = (EditText) findViewById(R.id.letter);
		
		Intent i = getIntent();
		
		name = i.getStringExtra("tname");
		data = i.getStringExtra("tdata");
		male = i.getStringExtra("tpol");
		dolzh = i.getStringExtra("tdol");
		zarpl = i.getStringExtra("tzarp");
		phone = i.getStringExtra("tphone");
		mail = i.getStringExtra("tmail");
		
		ed_name2.setText(getResources().getString(R.string.fio) + " - " + name);
		ed_data2.setText(getResources().getString(R.string.date) + " " + data);
		ed_male2.setText(getResources().getString(R.string.malefemale) + " " + male);
		ed_dolzh2.setText(getResources().getString(R.string.dolzh) + " - " + dolzh);
		ed_zarpl2.setText(getResources().getString(R.string.zarpl) + " - " + zarpl);
		ed_phone2.setText(getResources().getString(R.string.ph_number) + " - " + phone);
		ed_mail2.setText(getResources().getString(R.string.email) + " - " + mail);
		
		
		send = (Button) findViewById(R.id.sendres);
		send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent returnIntent = new Intent();
				
				if (!ed_letter.getText().toString().equals(""))
				{
				 returnIntent.putExtra("result", ed_letter.getText().toString());
				}else{
				 returnIntent.putExtra("result", getResources().getString(R.string.error2act));
				}
				 setResult(RESULT_OK,returnIntent);  

				 finish();
			}
		});
		
	}

	
	@Override
	protected void onPause() {
		super.onPause();
		
		overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
		
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
