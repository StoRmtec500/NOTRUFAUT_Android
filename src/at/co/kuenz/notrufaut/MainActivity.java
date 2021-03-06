package at.co.kuenz.notrufaut;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


import com.google.analytics.tracking.android.EasyTracker;
import at.co.kuenz.notrufaut.MyLocationListener;

public class MainActivity extends Activity {
	
	private static final String LOG_TAG = "debugger";
	public EditText textEdit;
	final Context context = this;
	
	@Override
	  public void onStart() {
	    super.onStart();
	    // The rest of your onStart() code.
	    EasyTracker.getInstance().activityStart(this); // Add this method.
	  }

	  @Override
	  public void onStop() {
	    super.onStop();
	    // The rest of your onStop() code.
	    EasyTracker.getInstance().activityStop(this); // Add this method.
	  }
	  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             /*  final Intent mainIntent = new Intent(MainActivity.this, MainActivity.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();  */ 
            	getAddress();
        		LocationManager mlocManager=null;
        		LocationListener mlocListener;
        		mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        		mlocListener = new MyLocationListener();
        		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, mlocListener);
            }
        }, 5000);
		
		Button btnPolizei = (Button)findViewById(R.id.btnPolizei);
		Button btnFeuerwehr = (Button)findViewById(R.id.btnFeuerwehr);
		Button btnRettung = (Button)findViewById(R.id.btnRettung);
		
		textEdit = (EditText)findViewById(R.id.location);
		
	
		LocationManager mlocManager=null;
		LocationListener mlocListener;
		mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		mlocListener = new MyLocationListener();
		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, mlocListener);
		
		if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER) == false){
			/*Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		    startActivity(intent);*/
			Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
			alertDialog.setTitle("GPS ist nicht aktiviert!");
			alertDialog.setMessage("Wollen Sie GPS aktivieren?");
			alertDialog.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				    startActivity(intent);
				}
			});
			alertDialog.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			alertDialog.show();
		}
		
	btnPolizei.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
			alertDialog.setTitle("Polizei");
			alertDialog.setMessage("Wirklich 133 w�hlen?");
			alertDialog.setPositiveButton("JA 133 w�hlen", new DialogInterface.OnClickListener() {	
			//	@Override
				public void onClick(final DialogInterface dialog, final int which) {
					final Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData(Uri.parse("tel:133"));
					startActivity(callIntent);	
				}
			});
			alertDialog.setNegativeButton("NEIN", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			alertDialog.setIcon(R.drawable.btn_polizei);
			alertDialog.show();
		}
	});
	
	btnFeuerwehr.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
			alertDialog.setTitle("Feuerwehr");
			alertDialog.setMessage("Wirklich 122 w�hlen?");
			alertDialog.setPositiveButton("JA 122 w�hlen", new DialogInterface.OnClickListener() {	
			//	@Override
				public void onClick(final DialogInterface dialog, final int which) {
					final Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData(Uri.parse("tel:122"));
					startActivity(callIntent);	
				}
			});
			alertDialog.setNegativeButton("NEIN", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			alertDialog.setIcon(R.drawable.btn_feuerwehr);
			alertDialog.show();
		}
	});
	
	btnRettung.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
			alertDialog.setTitle("Rettung");
			alertDialog.setMessage("Wirklich 144 w�hlen?");
			alertDialog.setPositiveButton("JA 144 w�hlen", new DialogInterface.OnClickListener() {	
			//	@Override
				public void onClick(final DialogInterface dialog, final int which) {
					final Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData(Uri.parse("tel:144"));
					startActivity(callIntent);	
				}
			});
			alertDialog.setNegativeButton("NEIN", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			alertDialog.setIcon(R.drawable.btn_rettung);
			alertDialog.show();
		}
	});	
	
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()) {
		case R.id.info_click:
			View v = null;
			Test(v);
			break;

		default:
			break;
		}
		return true;
	}

	public void Test(View v)
	{
		Intent in = new Intent
				(MainActivity.this, InfoActivity.class);
		startActivity(in);
	}
	
	public void getAddress(){
	        try{
	            Geocoder gcd = new Geocoder(this, Locale.getDefault());
	            List<Address> addresses = gcd.getFromLocation(MyLocationListener.latitude, MyLocationListener.longitude,1);
	            if (addresses.size() > 0) {
	                StringBuilder result = new StringBuilder();
	                for(int i = 0; i < addresses.size(); i++){
	                    Address address =  addresses.get(i);
	                  //  int maxIndex = address.getMaxAddressLineIndex();
	                   /* for (int x = 0; x <= maxIndex; x++ ){
	                    	textEdit.setText("");
		                    result.append(address.getPostalCode());
		                    result.append(" ");
		                    result.append(address.getLocality());
		                    result.append(", ");
		                    result.append(address.getThoroughfare());
		                    result.append(" ");
		                    result.append(address.getSubThoroughfare());
	                    }  */
	            		textEdit.setText("");
	                    result.append(address.getPostalCode());
	                    result.append(" ");
	                    result.append(address.getLocality());
	                    result.append(", ");
	                    result.append(address.getThoroughfare());
	                    result.append(" ");
	                    result.append(address.getSubThoroughfare());
	                    Log.i(LOG_TAG, "Test");
	                    textEdit.setText(result.toString());
	                }
	              //  textEdit.setText(result.toString());
	            }
	        }
	        catch(IOException ex){
	            textEdit.setText(ex.getMessage().toString());
	        }
	    }
}