package tn.esprit.serveco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DriversMenu extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list2);  
		TextView v1=(TextView) findViewById(R.id.textView1);
		
		 final Intent intent = getIntent();
	      String message = intent.getStringExtra(ButtonAdapter.EXTRA_MESSAGE);
	    v1.setText(message);
	}

}
