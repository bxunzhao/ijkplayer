package com.example.zhangyang.ijktest;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class MainActivity extends AppCompatActivity {
    IjkVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        setContentView(R.layout.activity_main);
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        videoView = (IjkVideoView) findViewById(R.id.ijkPlayer);
        AndroidMediaController controller = new AndroidMediaController(this, false);
        videoView.setMediaController(controller);
        String url = "https://wdl.wallstreetcn.com/41aae4d2-390a-48ff-9230-ee865552e72d";
        // String url = "http://o6wf52jln.bkt.clouddn.com/演员.mp3";
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IjkMediaPlayer.native_profileEnd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.resume();
    }
}
