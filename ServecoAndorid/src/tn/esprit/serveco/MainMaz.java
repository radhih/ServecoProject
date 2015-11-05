package tn.esprit.serveco;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainMaz extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maaz);
	}

	public void performevent(View v)
	{
		Intent intent = null , chooser = null;
		switch (v.getId()) {
		case R.id.btnEmergency:			
		    intent = new Intent(Intent.ACTION_DIAL);
			intent.setData(Uri.parse("tel:+21671473424"));
			if(intent.resolveActivity(getPackageManager())!=null)
			{
				startActivity(intent);
			}
			break;

		case R.id.btnAsk:
			Intent t=new Intent("android.intent.action.AskOther");
	    	startActivity(t);
			break;
			
		case R.id.btnViewWebsite:
			intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://10.0.3.2:8483/WebServeco/"));
			chooser = Intent.createChooser(intent, "Open Website With... ");
			if(intent.resolveActivity(getPackageManager())!=null)
			{
				startActivity(chooser);
			}
			
		case R.id.btnShareDeal:
			intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, "Hey check Serveco application it's cool!!!");
			chooser = Intent.createChooser(intent, "Share using ..");
			if(intent.resolveActivity(getPackageManager())!=null)
			{
				startActivity(chooser);
			}
		}
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
}
