package tn.esprit.serveco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.rentme.adapter.VehiculeAdapter;
import com.rentme.entity.Vehicule;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivityL extends Activity {

	ArrayList<Vehicule> listVehicules;
	private VehiculeAdapter mAdapter;
	private JSONArray jsonArray;
	private String input1;
	private InputStream input;
	final List<String> prop = new ArrayList<String>();
final List<String> prop2 = new ArrayList<String>();
	 private String msg;
	static String url = "http://10.0.3.2:8483/WebServeco/vehicule/list/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehiculs);
	
		final Intent intent = getIntent();
	     msg = intent.getStringExtra(ButtonAdapter.EXTRA_MESSAGE);
	     System.out.println("name:"+msg);
		url=url+msg;
	     StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
	   
		
		
		mAdapter=new VehiculeAdapter(this, R.layout.master_listview_vehicule_row);
		
		ListView listViewToDo = (ListView) findViewById(R.id.listViewVehicule);
		 listViewToDo.setAdapter(mAdapter);
	 	 
	 	listViewToDo.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int arg2, long arg3) {

				TextView titledb = (TextView) view
						.findViewById(R.id.textview_vehicule_name);
				String namev = ((TextView) titledb).getText().toString();

				TextView typedb = (TextView) view
						.findViewById(R.id.textview_vehicule_type);
				String typev = ((TextView) typedb).getText().toString();

				Intent myIntent = new Intent("android.intent.action.sd");
				myIntent.putExtra("name", namev); // Optional parameters
				myIntent.putExtra("type", typev); // Optional parameters
				MainActivityL.this.startActivity(myIntent);
				return false;
			}

		});
		remplirlist();		
	}
	
	
	public String getjson()
    {
        HttpClient client=new DefaultHttpClient();
        StringBuilder builder = new StringBuilder();
        try {
        	
            HttpResponse response=client.execute(new HttpGet(url));
            input=response.getEntity().getContent();
            BufferedReader reader=new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line=reader.readLine())!=null)
            {
                builder.append(line);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  builder.toString();
    }

	

	private void refreshlist(List<String> mylist) {

		//listVehicules.clear();
		//mAdapter.clear();
		
		// Get the items that weren't marked as completed and add them in the
		// adapterContext mContext = null;
		final ProgressDialog mProgressDialog = new ProgressDialog(this);
		mProgressDialog.setTitle("please_wait");
		mProgressDialog.setIndeterminate(true);
		mProgressDialog.setCancelable(true);
		mProgressDialog.setIcon(android.R.drawable.stat_sys_download);
		mProgressDialog.setIcon(android.R.drawable.stat_sys_download);

		mProgressDialog.setMessage("getting Reader");
		mProgressDialog.show();

		for (int i = 0; i < prop.size(); i++) {
			AddInListe(i);
		}
		mProgressDialog.dismiss();

		mAdapter.notifyDataSetChanged();

	}

	 

	 
public  void remplirlist()
{
	input1=getjson();
	   try {
         jsonArray=new JSONArray(input1);



     } catch (JSONException e) {
         e.printStackTrace();
     }

	   List<JSONObject> list= new ArrayList<JSONObject>();
     for(int i=0;i<jsonArray.length();i++)
     {
         try {
             list.add(jsonArray.getJSONObject(i));
         } catch (JSONException e) {
             e.printStackTrace();
         }
     }
     for (int i=0;i<list.size();i++)
     {
         JSONObject jsonObject=list.get(i);

         try {
             String nom=jsonObject.getString("nomsupplier");
             String prenom=jsonObject.getString("type");
           
             prop.add(nom);
             prop2.add( prenom);
            
         
         } catch (JSONException e) {
             e.printStackTrace();
         }
}
  
     refreshlist(prop);
}
	private void AddInListe(int i1) {
		
		String a= prop.get(i1);
		Vehicule v=new Vehicule();
		 v.setNomsupplier(a);
		 String b= prop2.get(i1);
	 v.setType( b);
		mAdapter.add(v);

	}
	@Override
	public void onSaveInstanceState(Bundle savedState) {
		super.onSaveInstanceState(savedState);
		int values = mAdapter.getCount(); 
	    savedState.putInt("myKey", values);
	}

}
