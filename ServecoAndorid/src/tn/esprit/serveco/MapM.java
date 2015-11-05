package tn.esprit.serveco;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.SocketTimeoutException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xml.sax.helpers.ParserFactory;



import android.R.xml;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapM extends Activity {
	 private static final String SOAP_ACTION1 = ""; 
     private static final String NAMESPACE = "http://serveco.esprit.tn";
     private static String METHOD_NAME1 = "long";
     private static String METHOD_NAME2 = "lat";  
     private static String URL = "http://10.0.3.2:8483/WebServeco/ServecoService/Authentication?wsdl";
     private static String METHOD_NAME3 = "info";  
  static final LatLng HAMBURG = new LatLng(33.7932, 9.927);
  static final LatLng KIEL = new LatLng(53.551, 9.993);
  private GoogleMap map;
  List<Object>x;    
  List<Object>y; 
	
	double value[]={1,2,0,0,0},value2[]={2,2,0,0};
	String infos[]={"","","",""};
	
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.map);
    AsyncCallWS task = new AsyncCallWS();
    //Call execute 
    task.execute();
    
    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
            .getMap();
      // Move the camera instantly to hamburg with a zoom of 15.
        
       
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));

        // Zoom in, animating the camera.
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
  private class AsyncCallWS extends AsyncTask<String, Void, Void> {

	@Override
	protected Void doInBackground(String... params) {

		
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
		SoapObject request2 = new SoapObject(NAMESPACE, METHOD_NAME2);
		SoapObject request3 = new SoapObject(NAMESPACE, METHOD_NAME3);
		//Declare the version of the SOAP request
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        SoapSerializationEnvelope envelope2 = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope2.setOutputSoapObject(request2);
        SoapSerializationEnvelope envelope3 = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope3.setOutputSoapObject(request3);    
        envelope.setOutputSoapObject(request);
     
        //  envelope.dotNet = true;
       // envelope.implicitTypes = true;
        //envelope.setAddAdornments(false);
    
        try {
              HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
             
              //this is the actual part that will call the webservice
            androidHttpTransport.call(SOAP_ACTION1, envelope);
            androidHttpTransport.call(SOAP_ACTION1, envelope3);
            
            androidHttpTransport.call(SOAP_ACTION1, envelope2);
             System.out.println(envelope.bodyIn);
           
              // Get the SoapResult from the envelope body.
              SoapObject result =(SoapObject) envelope.bodyIn;;	         
              SoapObject result2 =(SoapObject) envelope2.bodyIn;;	 
              SoapObject result3 =(SoapObject) envelope3.bodyIn;;	
              x=  (List<Object>) envelope.getResponse();
        y=  (List<Object>) envelope2.getResponse();
        for(int i=0;i<x.size();i++)
        {
       	
       	  infos[i] = result3.getProperty(i).toString();
        }     
        for(int i=0;i<x.size();i++)
             {
            	
            	  value[i] = Double.parseDouble(result.getProperty(i).toString());
             }
             for(int i=0;i<y.size();i++)
             {
            	
            	  value2[i] = Double.parseDouble(result2.getProperty(i).toString());
             }
    System.out.println(result.getProperty(1).toString());
   
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
		for(int i=0;i<x.size();i++)
		{    map.addMarker(new MarkerOptions().position(new LatLng(value2[i],value[i])).title(infos[i]).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.car)));
		}
    }

  }
} 

