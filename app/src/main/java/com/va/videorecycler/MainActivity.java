package com.va.videorecycler;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import im.ene.toro.exoplayer.ExoPlayerViewHelper;
import im.ene.toro.widget.Container;

public class MainActivity extends AppCompatActivity {

    ExoPlayerViewHelper helper;
    Uri mediaUri;
    Container recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_fancy_videos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new ToroAdapter(this, getData()));


    }

    private ArrayList<String> getData() {
        ArrayList<String> list = new ArrayList<>();

        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4");
        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4");
        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4");
        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4");
        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4");
        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4");
        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4");
        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4");
        list.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4");

        return list;

    }
}
