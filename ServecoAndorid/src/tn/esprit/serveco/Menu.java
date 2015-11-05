package tn.esprit.serveco;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends Activity {
	 TextView tv1,tv2,tv3,tv4;
	 Button btn,btn2,btn4,btnMaz;
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
    	setContentView(R.layout.menu);   
    	btnMaz=(Button) findViewById(R.id.button3);
    	btnMaz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent t=new Intent("android.intent.action.maz");
            	startActivity(t);	
				
			}
		});
    	
    	btn = (Button)findViewById(R.id.button1);
btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent t=new Intent("android.intent.action.L");
            	startActivity(t);
			}
			});
btn2 = (Button)findViewById(R.id.button2);
btn2.setOnClickListener(new OnClickListener() {
	
	public void onClick(View v) {
		Intent t=new Intent("android.intent.action.LW");
    	startActivity(t);
	}
	});

		}
	
	 
}
