package com.vndevpro.android53_day2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    private static final String TAG = "ActivityB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d(TAG, "onCreate: B");

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
//            int phoneNumber = intent.getIntExtra("PHONE_NUMBER", -1);
//            String name = intent.getStringExtra("NAME2");
            int phoneNumber = bundle.getInt("PHONE_NUMBER", -1);
            String name = bundle.getString("NAME", "Default");
            Log.d(TAG, "onCreate: " + phoneNumber + " | name : " + name);
        }

        UserModel userModel = (UserModel) intent.getSerializableExtra("USER_DATA");
        Log.d(TAG, "onCreate: " + userModel.toString());


        findViewById(R.id.tvActivityB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("HI","HI IM ACTIVITY B");
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: B");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: B");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: B");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: B");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: B");
    }
}