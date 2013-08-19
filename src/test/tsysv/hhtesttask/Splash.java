package test.tsysv.hhtesttask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class Splash extends Activity {
	
	 private static int SPLASH_TIME_OUT = 3000;
	 RelativeLayout ll;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.splash);
		

		Bitmap b = BitmapFactory.decodeStream(getResources().openRawResource(R.drawable.f01));
		 Drawable d = new BitmapDrawable(Resources.getSystem(),b);
		 
		
		ll = (RelativeLayout) findViewById(R.id.f01);
		ll.setBackgroundDrawable(d);
		
		new Handler().postDelayed(new Runnable() {
			 
 
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(), Activity01.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
		
		
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		
		overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		ll.destroyDrawingCache();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.activity01, menu);
		return true;
	}

}
