package com.example.valentin.valentintestinglabs.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.valentin.valentintestinglabs.R;
import com.example.valentin.valentintestinglabs.view.objectboxview.ObjectBoxActivity;
import com.example.valentin.valentintestinglabs.view.objectboxview.ObjectBoxActivity_;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv = (ListView) findViewById(R.id.listview_activity);

        ArrayList<String> activityList = new ArrayList<>();
        activityList.add("ExoPlayer");
        activityList.add("ObjectBoxSavingData");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, activityList);


        // Assign adapter to ListView
        lv.setAdapter(adapter);

        // ListView Item Click Listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position){
                    case 0 :
                        launchExoplayerActivity();
                        break;
                    case 1 :
                        launchObjectBoxActivity();
                        break;
                }
            }

        });
    }

    private void launchExoplayerActivity(){
        Intent intent = new Intent(this, ExoPlayerActivity.class);
        startActivity(intent);
    }

    private void launchObjectBoxActivity(){
        //Intent intent = new Intent(this, ObjectBoxActivity.class);
        //startActivity(intent);
        ObjectBoxActivity_.intent(this).start();
    }

}
