package za.co.smartdevops.smart.kayaapp;

import android.app.ProgressDialog;
import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by smart on 3/22/2018.
 */

public class LiveStreamService extends Service {


    private boolean playPause;
    private ImageView btn;
    private MediaPlayer player;
    private ProgressDialog progressDialog;
    private boolean initialStage = true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//("http://capeant.antfarm.co.za:8000/Kaya_MP3");
        player = MediaPlayer.create(this, Uri.parse("http://capeant.antfarm.co.za:8000/Kaya_MP3"));
        player.start();
        //return 1;

        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

}