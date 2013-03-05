package at.co.kuenz.notrufaut;

import com.google.analytics.tracking.android.EasyTracker;

import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;


//import android.view.Menu;

public class InfoActivity extends Activity {

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
		setContentView(R.layout.activity_info);	
	}
	
	
	public void bewertenOnClick(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("market://details?id=at.co.kuenz.notrufaut"));
		startActivity(intent);
	}
	
	public void empfehlen(View v){
		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("text/html");
		i.putExtra(Intent.EXTRA_EMAIL  , "recipient@example.com");
		i.putExtra(Intent.EXTRA_BCC, new String[]{"martin@kuenz.co.at"});
		i.putExtra(Intent.EXTRA_SUBJECT, "Notruf-App weiterempfehlen");
		i.putExtra(Intent.EXTRA_TEXT   , Html.fromHtml(new StringBuilder()
	    .append("<p><b>Notruf APP</b></p>")
	    .append("<small><p>schau Dir mal die App an. Ist sehr hilfreich. <br><br>Du kannst die App hier downloaden.<br>https://play.google.com/store/apps/details?id=at.co.kuenz.notrufaut</p></small>")
	    .toString()));
		try {
		    startActivity(Intent.createChooser(i, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(InfoActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void feedback(View v){
		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("text/html");
		i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"martin@kuenz.co.at"});
		i.putExtra(Intent.EXTRA_BCC, "martin@kuenz.co.at");
		i.putExtra(Intent.EXTRA_SUBJECT, "Notruf-App Feedback");
		i.putExtra(Intent.EXTRA_TEXT   , Html.fromHtml(new StringBuilder()
	    .append("<h2>Notruf-App</h2> schreiben Sie uns einfach ein Feedback, für Verbesserungen, Neuerungen, ....")
	    .toString()));
		try {
		    startActivity(Intent.createChooser(i, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(InfoActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void spendenClick(View v){
	Intent intent = new Intent(Intent.ACTION_VIEW);
	intent.setData(Uri.parse("http://cms.kuenz.co.at/fileadmin/templates/paypal/paypal_notruf.html"));
	startActivity(intent);
	};
}
