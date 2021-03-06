package info.sagemcom.conDiag.control_diagnostic;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.eftimoff.androipathview.PathView;

import info.sagemcom.conDiag.R;
import info.sagemcom.conDiag.history.HistoryActivity;
import info.sagemcom.conDiag.control_diagnostic.control.ControlActivity;
import info.sagemcom.conDiag.control_diagnostic.diagnostic.DiagnosticActivity;
import info.sagemcom.conDiag.settings.SettingsActivity;

/**
 * Created by slim on 3/18/17.
 */

public class ControlDiagnostic extends AppCompatActivity {
    private RelativeLayout buttonDiagnostic;
    private RelativeLayout buttonControl;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ActionBar actionBar;
    private TabLayout tabLayout;

    private ImageView imageView;
    private ImageButton imageButton;
    private PathView pathView_diagnostic;
    private PathView pathView_control;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_diagnostic);
        pathView_diagnostic = (PathView) findViewById(R.id.pathView_diagnostic);
        pathView_control = (PathView) findViewById(R.id.pathView_control);


                pathView_diagnostic.getPathAnimator().
                        //pathView.getSequentialPathAnimator().
                                delay(100).
                        duration(1500).
                        interpolator(new AccelerateDecelerateInterpolator()).
                        start();


                pathView_control.getPathAnimator().
                        //pathView.getSequentialPathAnimator().
                                delay(100).
                        duration(1500).
                        interpolator(new AccelerateDecelerateInterpolator()).
                        start();


        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout_choice);
        toolbar = (Toolbar) findViewById(R.id.toolbar_choice);
        setSupportActionBar(toolbar);
        Log.i("TEST","1");
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.home_toolbar);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Log.i("TEST","4");
        viewPager = (ViewPager) findViewById(R.id.viewpager_choice);
        tabLayout = (TabLayout) findViewById(R.id.tabs_choice);

        buttonDiagnostic = (RelativeLayout) findViewById(R.id.buttonDiagnostic);
        buttonControl = (RelativeLayout) findViewById(R.id.buttonControl);

        Log.i("TEST","5");
        tabLayout.setupWithViewPager(viewPager);


        Log.i("TEST","6");
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view_choice);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }
        setupNavigationDrawerContent(navigationView);


        buttonDiagnostic.setOnTouchListener( new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        //buttonDiagnostic.setBackgroundColor(Color.RED);

                        break;
                    case MotionEvent.ACTION_UP:

                        //set color back to default
                        //buttonDiagnostic.setBackgroundColor(R.color.md_deep_orange_50);
                        Intent intent = new Intent(ControlDiagnostic.this, DiagnosticActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        buttonControl.setOnTouchListener( new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                       // buttonControl.setBackgroundColor(Color.RED);

                        break;
                    case MotionEvent.ACTION_UP:

                        //set color back to default
                       // buttonControl.setBackgroundColor(R.color.md_amber_200);
                        Intent intent = new Intent(ControlDiagnostic.this, ControlActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            //noinspection SimplifiableIfStatement
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_discovery:
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_notifications:
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_history:
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Intent intent1 = new Intent(ControlDiagnostic.this, HistoryActivity.class);
                                startActivity(intent1);
                                return true;
                            case R.id.item_navigation_drawer_settings:
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Intent intent = new Intent(ControlDiagnostic.this, SettingsActivity.class);



                                // Intent for the activity to open when user selects the notification

                                // Use TaskStackBuilder to build the back stack and get the PendingIntent
                                PendingIntent pendingIntent =
                                        TaskStackBuilder.create(ControlDiagnostic.this)
                                                // add all of DetailsActivity's parents to the stack,
                                                // followed by DetailsActivity itself
                                                .addNextIntentWithParentStack(intent)
                                                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                                NotificationCompat.Builder builder = new NotificationCompat.Builder(ControlDiagnostic.this);
                                builder.setContentIntent(pendingIntent);
                                startActivity(intent);

                                return true;
                            case R.id.item_navigation_drawer_logOut:
                                menuItem.setChecked(true);
                                logout();
                                drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        return true;
                    }
                });
    }
    private void logout(){
        //Creating an alert dialog to confirm logout
        Log.i("HHH","disconnect");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to log out ?");
        alertDialogBuilder.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent1 = new Intent(ControlDiagnostic.this, HistoryActivity.class);
                        startActivity(intent1);
                        //Getting out sharedpreferences
                        //SharedPreferences preferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                        //Getting editor
                       /* SharedPreferences.Editor editor = preferences.edit();

                        //Puting the value false for loggedin
                        editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, false);

                        //Putting blank value to email
                        editor.putString(Config.KEY_USER_EMAIL, "");

                        //Saving the sharedpreferences
                        editor.commit();*/

                        //Starting login activity
                        // Intent intent = new Intent(NavigationActivity.this, Login.class);
                        // startActivity(intent);
                    }
                });

        alertDialogBuilder.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

}


