package css.participation9activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Hey Study Partner");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Snackbar.make(getWindow().getDecorView(), "Add study mates not available yet.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        if (id == R.id.action_delete) {
            Snackbar.make(getWindow().getDecorView(), "Deleting a study mate not available yet.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        if (id == R.id.action_settings) {
            Intent settingsactivity = new Intent(this, SettingsActivity.class);
            startActivity(settingsactivity);
            return true;
        }

        if (id == R.id.action_email) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hey Study Partner");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;
        }

        if (id == R.id.action_sms) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            String message = "Hi";
            intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
            intent.putExtra("address", "6126003637");
            intent.putExtra("sms_body", message);
            intent.setType("text/plain");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.actionDrawer_add) {
            Snackbar.make(getWindow().getDecorView(), "Add study mates not available yet.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;

        } else if (id == R.id.actionDrawer_delete) {
            Snackbar.make(getWindow().getDecorView(), "Deleting a study mate not available yet.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;

        } else if (id == R.id.actionDrawer_settings) {
            Intent settingsactivity = new Intent(this, SettingsActivity.class);
            startActivity(settingsactivity);
            return true;

        } else if (id == R.id.actionDrawer_email) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hey Study Partner");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;

        } else if (id == R.id.actionDrawer_sms) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            String message = "Hi";
            intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
            intent.putExtra("address", "6126003637");
            intent.putExtra("sms_body", message);
            intent.setType("text/plain");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
