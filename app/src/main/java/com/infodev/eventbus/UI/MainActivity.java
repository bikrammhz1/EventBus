package com.infodev.eventbus.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.infodev.eventbus.R;
import com.infodev.eventbus.helper.BaseActivity;
import com.infodev.eventbus.pojo.CustomeMessageEvent;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity {

    Button btn;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShow = findViewById(R.id.tv_data);
        btn = findViewById(R.id.btn_act);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ChildActivity.class));
            }
        });
    }

    @Subscribe
    public void onEvent(CustomeMessageEvent customeMessageEvent){
        tvShow.setText(CustomeMessageEvent.getName());
    }
}
