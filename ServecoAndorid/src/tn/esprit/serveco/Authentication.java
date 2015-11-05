package tn.esprit.serveco;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;

import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class Authentication extends Activity {

	
	 private static final String SOAP_ACTION1 = ""; 
     private static final String NAMESPACE = "http://serveco.esprit.tn";
     private static String METHOD_NAME1 = "Authentication";
     private static String URL = "http://10.0.3.2:8483/WebServeco/ServecoService/Authentication?wsdl";
     private String login;
     private String passwd;
     private String TAG = "PGGURU";
     private static String x;
     Button btn,btn2,bf;
     EditText e1,e2;
     TextView tv;
     @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		bf=(Button) findViewById(R.id.btnFacebook);
        bf.setOnClickListener (new Button.OnClickListener(){
        	//action bouton facebook
			@Override
			public void onClick(View v) {
				String myFacebook = "https://www.facebook.com/pages/fitnesscom/423287857815424?skip_nax_wizard=true";
        		Intent myIntent = new Intent(Intent.ACTION_VIEW,
        				Uri.parse(myFacebook));
        		startActivity(myIntent);
				
			}
        	                     
        });

		btn = (Button)findViewById(R.id.buttonConnect);
		e1=(EditText)findViewById(R.id.editTextmail);
		tv = (TextView) findViewById(R.id.textView1);
		btn2=(Button) findViewById(R.id.buttonC);
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent t=new Intent("android.intent.action.Sign");
            	startActivity(t);
			}
		});
		e2=(EditText)findViewById(R.id.editTextpass);
	
		btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				//Get the text control value
				 login = e1.getText().toString();
	                passwd = e2.getText().toString();
	                System.out.println(login+passwd);
			 //Initialize soap request + add parameters
			if (e1.getText().toString().equals("") || e2.getText().toString().equals(""))
			{
				tv.setText("Please enter Login|password");
                
            } else {
            	//Create instance for AsyncCallWS
                AsyncCallWS task = new AsyncCallWS();
                //Call execute 
                task.execute();
            //If text control is empty
            }
					
			
			}
		});
		
		    }   
	
     private class AsyncCallWS extends AsyncTask<String, Void, Void> {
	        @Override
	        protected Void doInBackground(String... params) {
			Log.i(TAG, "doInBackground");
			
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
			request.addProperty("login",login);
		 request.addProperty("password",passwd);
System.out.println("final"+login+passwd);
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
	              SoapObject result =(SoapObject) envelope.bodyIn;;	         
	         	 x= result.getProperty(0).toString();
	         	 System.out.println("resultat:"+x);
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
	            Log.i(TAG, "onPostExecute");
	          
	            if(x.equals("true"))
	            {Intent t=new Intent("android.intent.action.Menu1");
	            	startActivity(t);
	            }
	            else{
	            	tv.setText("Invalid login|password");
	            }
	        }

	        @Override
	        protected void onPreExecute() {
	            Log.i(TAG, "onPreExecute");
	            tv.setText("Loading...");
	        }

	        @Override
	        protected void onProgressUpdate(Void... values) {
	            Log.i(TAG, "onProgress");
	        }
		
	}
     }