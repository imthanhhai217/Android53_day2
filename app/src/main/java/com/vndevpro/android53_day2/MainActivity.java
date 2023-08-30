package com.vndevpro.android53_day2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.btnGotoB)
    Button btnGotoB;

//    @BindView(R.id.tvMain)
//    TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: A");
        ButterKnife.bind(this);
//        ActivityMainBinding activityMainBinding;
//        activityMainBinding.btnGotoB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        btnGotoB = findViewById(R.id.btnGotoB);
//        tvMain = findViewById(R.id.tvMain);

//        tvMain.setText("MainActivity");
//
        btnGotoB.setOnClickListener(this);
//
//        tvMain.setOnClickListener(this);

        FragmentA fragmentA = FragmentA.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.containerA, fragmentA).commit();
        FragmentB fragmentB = FragmentB.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.containerB, fragmentB).commit();

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGotoB:
                Intent intent = new Intent(this, ActivityB.class);
//                intent.putExtra("PHONE_NUMBER",123456);
//                intent.putExtra("NAME","Hải");

                UserModel userModel = new UserModel("Hai", "HN");
                intent.putExtra("USER_DATA", userModel);

//                Bundle bundle = new Bundle();
//                bundle.putString("NAME","Hải");
//                bundle.putInt("PHONE_NUMBER",123456);

//                intent.putExtras(bundle);
//                startActivity(intent);
//                startActivityForResult(intent, REQUEST_2_B);
                gotoBLauncher.launch(intent);
                break;
//            case R.id.tvMain:
//                Intent intent2 = new Intent(this, ActivityC.class);
//                startActivity(intent2);
//                break;
        }
    }

    ActivityResultLauncher<Intent> gotoBLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                String sayHi = intent.getStringExtra("HI");
                if (sayHi != null) {
                    Toast.makeText(MainActivity.this, sayHi, Toast.LENGTH_SHORT).show();
                }
            }
            if (result.getResultCode() == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "USER CANCEL", Toast.LENGTH_SHORT).show();
            }
        }
    });


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_2_B) {
//            if (resultCode == RESULT_OK) {
//                Intent intent = data;
//                String sayHi = intent.getStringExtra("HI");
//                if (sayHi != null) {
//                    Toast.makeText(this, sayHi, Toast.LENGTH_SHORT).show();
//                }
//            }
//            if (resultCode == RESULT_CANCELED) {
//                Toast.makeText(this, "USER CANCEL", Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (requestCode == REQUEST_2_C) {
//
//        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: A");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: A");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: A");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: A");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: A");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: A");
    }

}