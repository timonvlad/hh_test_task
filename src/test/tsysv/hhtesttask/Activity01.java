package test.tsysv.hhtesttask;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity01 extends Activity {

	 Spinner spinner1;
	 Button send_res;
	 EditText ed_name, ed_dolzh, ed_zarpl, ed_phone, ed_mail;
	 DatePicker datepc;
	 ScrollView scr;
	 TextView tv1,tv2,tv3;
	 String name, data, male, dolzh, zarpl, phone, mail;
	 Dialog dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.act01);

		scr = (ScrollView) findViewById(R.id.scrollView1);
		
		tv1 = (TextView) findViewById(R.id.textView1);
		
		ed_name = (EditText) findViewById(R.id.fio01);
		
		datepc = (DatePicker) findViewById(R.id.datePicker1);
		
		tv2 = (TextView) findViewById(R.id.textView2);
		
		spinner1 = (Spinner) findViewById(R.id.mafe);
		spinner1.setPrompt(getResources().getString(R.string.malefe_prompt));
		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		
		tv3 = (TextView) findViewById(R.id.TextView01);
		
		ed_dolzh = (EditText) findViewById(R.id.ed_dolzh);

		ed_zarpl = (EditText) findViewById(R.id.ed_zarpl);
		
		ed_phone = (EditText) findViewById(R.id.ph_number);
		
		ed_mail = (EditText) findViewById(R.id.ed_mail);
		
		send_res = (Button) findViewById(R.id.sendres);
		send_res.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				int temp_month = datepc.getMonth() + 1;
				
				name = ed_name.getText().toString();
				data = datepc.getDayOfMonth() + "." + temp_month + "." + datepc.getYear();
				male = String.valueOf(spinner1.getSelectedItem());
				dolzh = ed_dolzh.getText().toString();
				zarpl = ed_zarpl.getText().toString();
				phone = ed_phone.getText().toString();
				mail = ed_mail.getText().toString();
				
				if(!name.equals("") && !dolzh.equals("") && !zarpl.equals("") && !phone.equals("") && !mail.equals("") && phone.length()>4){
					Intent myIntent = new Intent(getApplicationContext(), Activity02.class);
					myIntent.putExtra("tname",name);
					myIntent.putExtra("tdata",data);
					myIntent.putExtra("tpol",male);
					myIntent.putExtra("tdol",dolzh);
					myIntent.putExtra("tzarp",zarpl);
					myIntent.putExtra("tphone",phone);
					myIntent.putExtra("tmail",mail);
					startActivityForResult(myIntent, 1);
					overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
				}else if(phone.length()<5 && !phone.equals(""))
				{
					ShakeEd();
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.error3act) , Toast.LENGTH_LONG).show();
				}
				
				else{
					ShakeEd();
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.error1act) , Toast.LENGTH_LONG).show();
				}
				
				
			}
		});
		
		ShakeEd();
		
		
		
		
	}
	
	
	protected void ShakeEd(){
		
		Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
		 

		scr.startAnimation(shake);
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		  if (requestCode == 1) {

		     if(resultCode == RESULT_OK){      
		         String result=data.getStringExtra("result");     
		      //   Toast.makeText(getApplicationContext(), result , Toast.LENGTH_LONG).show();
		         showCustomDialog(result);
		        
		         
		         
		     }
		     if (resultCode == RESULT_CANCELED) {    
		         
		     }
		  }
		}
	protected void showCustomDialog(String result) {

		dialog = new Dialog(Activity01.this,
				android.R.style.Theme_Translucent);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

		dialog.setCancelable(true);
		dialog.setContentView(R.layout.dialog);

		TextView tv = (TextView) dialog.findViewById(R.id.tv);
		tv.setText(result);
		
		Button btnOK = (Button) dialog.findViewById(R.id.btnok);
		btnOK.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				
			}
		});


		dialog.show();
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
