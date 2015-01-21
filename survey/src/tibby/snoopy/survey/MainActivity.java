package tibby.snoopy.survey;

import java.security.PublicKey;

import tibby.snoopy.survey.R.string;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private EditText mName;
		private EditText mEmail;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			mName = (EditText)rootView.findViewById(R.id.name);
			mEmail = (EditText)rootView.findViewById(R.id.email);
			
			
			ImageButton surveyB = (ImageButton)rootView.findViewById(R.id.survey);
			OnClickListener listener0 = null;
	        listener0 = new OnClickListener()
	        {
				@Override
				public void onClick(View v) 
				{
					String email = mEmail.getText().toString();
					final int pos = email.indexOf("@");
					// TODO Auto-generated method stub
					if (pos <= 0)
					{
						Toast.makeText(v.getContext(), "Invalid email address", Toast.LENGTH_LONG).show();
						mEmail.requestFocus();
					}
					else 
					{
						String username = email.substring(0, pos);
						v.setVisibility(View.INVISIBLE);
						String welcome = "thank you " + username;
						Toast.makeText(v.getContext(), welcome,Toast.LENGTH_LONG).show();
					}
				}
	        };
	        surveyB.setOnClickListener(listener0);
			return rootView;
		}
		
		/*public void formProcess(View submit)
		{
			submit.setVisibility(View.INVISIBLE);
		}*/
	}

}
