package tn.esprit.serveco;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


public class ListService extends Activity 
 {
	 private static final String SOAP_ACTION1 = ""; 
     private static final String NAMESPACE = "http://serveco.esprit.tn";
     private static String METHOD_NAME1 = "AllServices";
     private static String URL = "http://10.0.3.2:8483/WebServeco/ServecoService/Authentication?wsdl";
	List<Object> imgList=null;
	String[] f={"","","","","","","","","","","","","",""};
	 public final static String EXTRA_MESSAGE =
		      "com.ltm.ltmactionbar.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);  
		  android.widget.GridView maListViewPerso = (android.widget.GridView) findViewById(R.id.gridView1);
		  maListViewPerso.setAdapter(new ButtonAdapter(this,f));	  
		  AsyncCallWS task = new AsyncCallWS();
		    //Call execute 
		    task.execute();
		    
	                //imgList=new ArrayList<>();
	      
	    		
	    			       
	        System.out.println("longeur"+f.length);
	            
	 	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 private class AsyncCallWS extends AsyncTask<String, Void, Void> {

			@Override
			protected Void doInBackground(String... params) {
				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
    			

		        //Declare the version of the SOAP request
		        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		       
		        envelope.setOutputSoapObject(request);
		      //  envelope.dotNet = true;
		       // envelope.implicitTypes = true;
		        //envelope.setAddAdornments(false);
		    
		        try {
		              HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		             
		              //this is the actual part that will call the webservice
		            androidHttpTransport.call(SOAP_ACTION1, envelope);
		          
		             System.out.println(envelope.bodyIn);
		              // Get the SoapResult from the envelope body.
		              SoapObject result =(SoapObject) envelope.bodyIn;	         
		        	        
		        	  
		              imgList=  (List<Object>) envelope.getResponse();
		    System.out.println("hdsqd"+result.getProperty(0).toString());
		for(int i=0;i<imgList.size();i++)
		{
	 f[i]=result.getProperty(i).toString();	    			
			
		        //    System.out.println("http://google.com/"+imgList.get(i));
		        }
		System.out.println("SIZE:"+imgList.size());
		             
		         	 System.out.println("resultat:"+imgList);
		          } catch (SocketTimeoutException t) {
		              t.printStackTrace();
		          } catch (IOException i) {
		              i.printStackTrace();
		          } catch (Exception q) {
		              q.printStackTrace();
		          }
		        				
				return null;
			}
			@Override
		    protected void onPostExecute(Void result) {
				
		    }


     	
     }

	}