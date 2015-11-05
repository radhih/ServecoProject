package tn.esprit.serveco;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.PublicKey;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AskOtherCustomers extends Activity {
	Button btn;
	TextView textViewmessage;
	 private static final String SOAP_ACTION1 = ""; 
     private static final String NAMESPACE = "http://serveco.esprit.tn";
     private static String METHOD_NAME1 = "send";
     private static String URL = "http://10.0.3.2:8483/WebServeco/ServecoService/Authentication?wsdl";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.askothercustomers);
		textViewmessage=(TextView) findViewById(R.id.tvSendmsg);
		Button btn = (Button)findViewById(R.id.btnsendtheaskmessage);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				   AsyncCallWS task = new AsyncCallWS();
	                //Call execute 
	                task.execute();
			
				
				
			}
		});
		
	}
	private class AsyncCallWS extends AsyncTask<String, Void, Void> {

		@Override
		protected Void doInBackground(String... params) {
			
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
			request.addProperty("msg",textViewmessage.getText());
		 request.addProperty("login","med");

	        //Declare the version of the SOAP request
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	       
	        envelope.setOutputSoapObject(request);
	   
	    
	        try {
	              HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	             
	              //this is the actual part that will call the webservice
	            androidHttpTransport.call(SOAP_ACTION1, envelope);
	          
	             System.out.println(envelope.bodyIn);
	              // Get the SoapResult from the envelope body.
	              SoapObject result =(SoapObject) envelope.bodyIn;;	         
	        // 	 x= result.getProperty(0).toString();
	         	// System.out.println("resultat:"+x);
	          	
				
	              
	              
	              
	              
					}   catch (SocketTimeoutException t) {
	              t.printStackTrace();
	          } catch (IOException i) {
	              i.printStackTrace();
	          } catch (Exception q) {
	              q.printStackTrace();
	          }
	    
			
			
			return null;
		}
		
	
	
	}
	
}
