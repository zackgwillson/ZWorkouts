package com.zackwillson.zworkouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView title;
    Button workout, view, edit, Info;
    int on = 0;
    boolean important;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("FitData", Context.MODE_PRIVATE);
        String weightTest = sp.getString("weight", "");
        String feetTest = sp.getString("feet", "");
        String inchesTest = sp.getString("inches", "");
        String ageTest = sp.getString("age", "");
        String stretchTest = sp.getString("Stretch", "");
        String fitnessTest = sp.getString("fitnessString", "");
        weightTest = weightTest + "test";
        feetTest = feetTest + "test";
        inchesTest = inchesTest + "test";
        ageTest = ageTest + "test";
        stretchTest = stretchTest + "test";
        fitnessTest = fitnessTest + "test";
        if (weightTest.equals("test") || feetTest.equals("test") || inchesTest.equals("test") || stretchTest.equals("test") || fitnessTest.equals("test") || ageTest.equals("test"))
        {
            important = true;
        }
        else
        {
            important = false;
        }

        title = findViewById(R.id.textView2);
        title.setGravity(Gravity.CENTER);
        title.setBackground(getResources().getDrawable(R.drawable.round));
        workout = findViewById(R.id.button2);
        workout.setBackground(getResources().getDrawable(R.drawable.smallround));
        workout.setGravity(Gravity.CENTER);
        view = findViewById(R.id.button3);
        edit = findViewById(R.id.button4);
        view.setBackground(getResources().getDrawable(R.drawable.left));
        edit.setBackground(getResources().getDrawable(R.drawable.right));
        Info = findViewById(R.id.Info44);
        Info.setBackground(getResources().getDrawable(R.drawable.round));
        Info.setGravity(Gravity.CENTER);
    }

    public void sendMessage(View view) {
        if (!important)
        {
            Intent intent = new Intent(this, workoutSelect.class);
            startActivity(intent);
        }
        else
        {
            if (on == 0)
            {
                on = 1;
                Toast.makeText(MainActivity.this, "Go to EditInfo and input all your Fitness Info before you go Workout", Toast.LENGTH_SHORT).show();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    on = 0;
                }
            }, 2700);
        }
    }

    public void goToEdit(View view){
        Intent intent2 = new Intent(this, editInfo.class);
        startActivity(intent2);
    }
    public void goToView(View view){
        if (!important)
        {
            Intent intent3 = new Intent(this, viewInfo.class);
            startActivity(intent3);
        }
        else
        {
            if (on == 0)
            {
                on = 1;
                Toast.makeText(MainActivity.this, "Go to EditInfo and input all your Fitness Info before you go to ViewInfo", Toast.LENGTH_SHORT).show();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    on = 0;
                }
            }, 2700);
        }
    }
    public void goToCredits(View view){

        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
    }
    public void goToInfo(View view){
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }
}