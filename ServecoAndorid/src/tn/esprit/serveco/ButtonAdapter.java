package tn.esprit.serveco;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class ButtonAdapter extends BaseAdapter  {
	 public final static String EXTRA_MESSAGE =
		      "tn.esprit.serveco.MESSAGE";
	private Context mContext;  
	public String[] filesnames; 
	
	public ButtonAdapter(Context c, String[] f) {  
		  mContext = c;  
		  filesnames=f;
		
		 }  
	@Override
	public int getCount() {
		int x=filesnames.length;
		for(int i=0;i<filesnames.length;i++)
		{
			if(filesnames[i].equals(""))
			{
				x--;
			}
		}
		
		 return x;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		Button btn;
		
		  if (convertView == null) {    
		   // if it's not recycled, initialize some attributes  
		   btn = new Button(mContext);
		 
		   btn.setLayoutParams(new GridView.LayoutParams(200, 155));  
		   btn.setPadding(8, 8, 8, 8);  
		   
		  }   
		  else {  
		   btn = (Button) convertView;  
		  } 
		
		 // btn.setBackgroundResource(R.drawable.ic_launcher); 
		  btn.setText(filesnames[position]);   
		  // filenames is an array of strings  
		  btn.setTextColor(Color.BLUE); 
		  btn.setTextSize(40);
	
		//  btn.setBackgroundResource(R.drawable.button);  
		  btn.setId(position);  
		 btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			System.out.println("qsdsqsqqqqqqqqqqqqqqqqqq"+position);
			Intent t=new Intent(mContext,MainActivityL.class);
			t.putExtra(EXTRA_MESSAGE,filesnames[position]);
			mContext.startActivity(t);
			}
		});
		 
		  return btn; 

	}	
	
}
