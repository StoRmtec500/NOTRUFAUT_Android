package at.co.kuenz.notrufaut;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
=======
>>>>>>> old

public class MainActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
<<<<<<< HEAD
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
	
	public void Test(View v) {
		Intent in = new Intent
	(
			MainActivity.this, InfoActivity.class
	);
	startActivity(in);
=======
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.action_settings:
			info();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void info() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_info);
>>>>>>> old
	}

	
	
}
