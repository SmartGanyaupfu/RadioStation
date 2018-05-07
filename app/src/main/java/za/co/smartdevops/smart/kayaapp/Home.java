package za.co.smartdevops.smart.kayaapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

      drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

         navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //My Code here

        final ImageView animateImage = (ImageView) findViewById(R.id.imageLogo);
        //final ImageView rotateImage = (ImageView) findViewById(R.id.imageViewRotate);
        MediaPlayer myPlayer = MediaPlayer.create(this,R.raw.home_sound);

        animateImage.animate().scaleY(0.5f).scaleX(0.5f).alpha(0.1f).setDuration(4000).withEndAction(new Runnable() {
            @Override
            public void run() {
                animateImage.animate().scaleY(1f).scaleX(1f).alpha(1f).rotation(360f).setDuration(6000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        animateImage.animate().scaleY(1f).scaleX(1f).alpha(0f).setDuration(2000).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                Intent myIntent = new Intent(Home.this, Livestream.class);
                                //myIntent.putExtra("key", value); //Optional parameters
                                Home.this.startActivity(myIntent);
                            }
                        });
                        //rotateImage.animate().alpha(1f).setDuration(2000);
                    }
                });
            }
        });

        myPlayer.start();

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
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){

            case R.id.nav_home:
                Intent h= new Intent(Home.this,Home.class);
                startActivity(h);
                break;
            case R.id.nav_blog:
                Intent i= new Intent(Home.this,Blog.class);
                startActivity(i);
                break;
            case R.id.nav_podcast:
                Intent g= new Intent(Home.this,Podcasts.class);
                startActivity(g);
                break;
            case R.id.nav_live_stream:
                Intent s= new Intent(Home.this,Livestream.class);
                startActivity(s);
                break;
            // this is done, now let us go and intialise the home page.
            // after this lets start copying the above.
            // FOLLOW MEEEEE>>>
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
