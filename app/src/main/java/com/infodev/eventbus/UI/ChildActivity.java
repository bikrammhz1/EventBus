package com.infodev.eventbus.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.infodev.eventbus.R;
import com.infodev.eventbus.helper.BaseActivity;
import com.infodev.eventbus.pojo.CustomeMessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ChildActivity extends BaseActivity {

    EditText ed_text;
    Button btnSend;
    CustomeMessageEvent customeMessageEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        ed_text = findViewById(R.id.ed_text);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passData = ed_text.getText().toString();
                customeMessageEvent = new CustomeMessageEvent();
                customeMessageEvent.setName(passData);
                EventBus.getDefault().post(customeMessageEvent);
                finish();
            }
        });

    }

    @Subscribe
    public void onEvent(String s){
        Log.d("onEvent","onEvent"+s);
    }

}
