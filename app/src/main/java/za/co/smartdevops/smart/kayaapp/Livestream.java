package za.co.smartdevops.smart.kayaapp;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Livestream extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener{

    private ImageView btnPlay, btnPause;


    private ProgressDialog progressDialog;
    private boolean initialStage = true;

    @Override
    protected void onResume() {
        super.onResume();
        //if ()

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btnPlay = (ImageView) findViewById(R.id.playView);
        btnPause=findViewById(R.id.pauseView);

        progressDialog = new ProgressDialog(this);
        btnPause.setVisibility(btnPause.GONE);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);





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
                Intent h= new Intent(Livestream.this,Home.class);
                startActivity(h);
                break;
            case R.id.nav_blog:
                Intent i= new Intent(Livestream.this,Blog.class);
                startActivity(i);
                break;
            case R.id.nav_podcast:
                Intent g= new Intent(Livestream.this,Podcasts.class);
                startActivity(g);
                break;
            case R.id.nav_live_stream:
                Intent s= new Intent(Livestream.this,Livestream.class);
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

    @Override
    public void onClick(View v) {

        if (v == btnPlay) {
            //starting service
            Intent svc=new Intent(this, LiveStreamService.class);
            startService(svc);
            btnPlay.setVisibility(btnPlay.GONE);
            btnPause.setVisibility(btnPause.VISIBLE);

           // btnPlay.setImageResource(R.drawable.pause);

        }else if (v == btnPause){

            Intent svc=new Intent(this, LiveStreamService.class);
            stopService(svc);
            btnPause.setVisibility(btnPause.GONE);
            btnPlay.setVisibility(btnPlay.VISIBLE);
        }

    }
}


