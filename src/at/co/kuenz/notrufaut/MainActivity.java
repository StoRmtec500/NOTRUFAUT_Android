package at.co.kuenz.notrufaut;

import com.google.analytics.tracking.android.EasyTracker;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

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
	
		Button btnPolizei = (Button)findViewById(R.id.btnPolizei);
		Button btnFeuerwehr = (Button)findViewById(R.id.btnFeuerwehr);
		Button btnRettung = (Button)findViewById(R.id.btnRettung);
		
		
		btnPolizei.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
				alertDialog.setTitle("Polizei");
				alertDialog.setMessage("Wirklich 133 wählen?");
				alertDialog.setPositiveButton("JA 133 wählen", new DialogInterface.OnClickListener() {	
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
				alertDialog.setMessage("Wirklich 122 wählen?");
				alertDialog.setPositiveButton("JA 122 wählen", new DialogInterface.OnClickListener() {	
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
				alertDialog.setMessage("Wirklich 144 wählen?");
				alertDialog.setPositiveButton("JA 144 wählen", new DialogInterface.OnClickListener() {	
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
}
