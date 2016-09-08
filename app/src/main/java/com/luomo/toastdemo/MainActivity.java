package com.luomo.toastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.tv_one:
                ToastUtils.show(this,getString(R.string.hello1));
                break;
            case R.id.tv_two:
                ToastUtils.show(this,R.string.hello2);
                break;
            case R.id.tv_three:
                ToastUtils.show(this,R.string.hello3,ToastUtils.ICON_NORMAL);
                break;
            case R.id.tv_four:
                ToastUtils.show(this,R.string.hello4,ToastUtils.ICON_LAUGH);
                break;
            case R.id.tv_five:
                ToastUtils.show(this,R.string.hello5,ToastUtils.ICON_WINK);
                break;
        }
    }
}
