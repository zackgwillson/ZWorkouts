package com.zackwillson.zworkouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class workoutSelect extends AppCompatActivity {

    TextView title;
    public final static String EXTRA_MESSAGE = "com.example.zworkouts.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_select);
        title = findViewById(R.id.textView19);
        title.setGravity(Gravity.CENTER);
        title.setBackground(getResources().getDrawable(R.drawable.round));
    }
    public void Run(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "1");
        startActivity(intent);
    }
    public void Circuit(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "2");
        startActivity(intent);
    }
    public void HIIT(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "3");
        startActivity(intent);
    }
    public void Upper(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "4");
        startActivity(intent);
    }
    public void Lower(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "5");
        startActivity(intent);
    }
    public void Core(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "6");
        startActivity(intent);
    }
    public void SSFullbody(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "7");
        startActivity(intent);
    }
    public void Fullbody(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "8");
        startActivity(intent);
    }
    public void Fullbody1(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "9");
        startActivity(intent);
    }
    public void Fullbody2(View view){
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, "10");
        startActivity(intent);
    }
}