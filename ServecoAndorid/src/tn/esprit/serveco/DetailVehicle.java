package tn.esprit.serveco;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DetailVehicle extends Activity {
	Button buttonfeedback;Button buttonreserve;
	TextView textViewname;
	TextView textViewtype;
	Button btn4;
	static String url = "http://10.0.3.2:8483/WebServeco/reservation/add/";
	private String msg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_vehicle);
		btn4 = (Button)findViewById(R.id.button4);
	    btn4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent t=new Intent("android.intent.action.mail");
	        	startActivity(t);
				
			}
		});
		Intent intent = getIntent();
		final String value = intent.getStringExtra("name");
		textViewname =(TextView)findViewById(R.id.detail_textview_name);
		textViewname.setText(value);
		String value2 = intent.getStringExtra("type");
		textViewtype =(TextView)findViewById(R.id.detail_textview_type);
		textViewtype.setText(value2);
		
		 buttonreserve = (Button) findViewById(R.id.detail_button_reserve);
		 buttonreserve.setOnClickListener(new OnClickListener() {

			    public void onClick(View v) {
			        // TODO Auto-generated method stub

					//////////////
					
					
					new AlertDialog.Builder(DetailVehicle.this)  
					.setMessage(getResources().getString(R.string.are_you_sure_you_want_to_reserve))  
					.setCancelable(false)  
					.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {  
					    public void onClick(DialogInterface dialog, int which)   
					    {
//reserve(value);
					    	Intent intent = null;
					    	  intent = new Intent(Intent.ACTION_DIAL);
								intent.setData(Uri.parse("tel:+21624883557"));
							
									startActivity(intent);			    
					    }

						 
					})    
					.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {  
					      public void onClick(DialogInterface dialog, int which)   
					      {  
					     // Perform Your Task Here--When No is pressed    
					         dialog.cancel();  
					      }  
					}).show();  
					
					
					
				 	
			    }
			 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void reserve(String value) {
		// reserve v avec nom value 
		
	} 
}
