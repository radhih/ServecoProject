package tn.esprit.serveco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class SignUp extends Activity{
Button btn;
private static final String SOAP_ACTION1 = ""; 
private static final String NAMESPACE = "http://serveco.esprit.tn";
private static String METHOD_NAME1 = "sign";
private static String URL = "http://10.0.3.2:8483/WebServeco/ServecoService/Authentication?wsdl";
private String login;
private String passwd;
private String mail;
private String first;
private String last;
private String phone;
private String age;
private String TAG = "PGGURU";
static String url ;
TextView tv;
private static String x;


EditText e1,e2,e3,e4,e5,e6,e7;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subsclient);
		e1=(EditText) findViewById(R.id.editText1);
		e2=(EditText) findViewById(R.id.EditText01);
		e3=(EditText) findViewById(R.id.EditText02);
		e4=(EditText)findViewById(R.id.EditText03);
		e5=(EditText)findViewById(R.id.EditText04);
		e6=(EditText)findViewById(R.id.EditText05);
		e7=(EditText)findViewById(R.id.EditText06);
		btn=(Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.textView1);

		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			first = e1.getText().toString();
			last = e2.getText().toString();	 
			mail = e7.getText().toString();
			login = e4.getText().toString();
	                passwd = e3.getText().toString();
	            phone = e5.getText().toString();
	            age = e6.getText().toString();
	                
				if (e3.getText().toString().equals("") || e4.getText().toString().equals(""))
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
	request.addProperty("last",last);
	request.addProperty("first",first);
	request.addProperty("mail",mail);
 request.addProperty("passwd",passwd);
 request.addProperty("phone",phone);
 request.addProperty("age",age);
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
        {Intent t=new Intent("android.intent.action.S");
        	startActivity(t);
        }
        else{
        	tv.setText("Please try again");
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
