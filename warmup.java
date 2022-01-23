package com.zackwillson.zworkouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import static com.zackwillson.zworkouts.workoutSelect.EXTRA_MESSAGE;

public class warmup extends AppCompatActivity {
    int warmup;
    int workout;
    TextView title, a1, a2, a3, a4, a5, a6, a7, a8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warmup);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        workout = Integer.parseInt(message);
        title = findViewById(R.id.textView15);
        title.setBackground(getResources().getDrawable(R.drawable.round));
        title.setGravity(Gravity.CENTER);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a9);
        if (workout>=1 && workout<=3){
            warmup = 1;
        }
        else if (workout>=4 && workout<=7)
        {
            warmup = 2;
        }
        else
        {
            warmup = 3;
        }
        SharedPreferences sp = getApplicationContext().getSharedPreferences("FitData", Context.MODE_PRIVATE);
        String stretch = sp.getString("Stretch", "");
        String solution = "";
        if (stretch.equals("Quads"))
        {
            solution = "Foam roll quads";
        }
        else if (stretch.equals("Glutes"))
        {
            solution = "Sitting glute stretch";
        }
        else if (stretch.equals("Hip"))
        {
            solution = "Lying down knee hug";
        }
        else if (stretch.equals("Back"))
        {
            solution = "Downward dog";
        }
        else if (stretch.equals("Core"))
        {
            solution = "Child's pose";
        }
        else if (stretch.equals("Calf"))
        {
            solution = "Calf stretch on stair";
        }
        else if (stretch.equals("Wrist"))
        {
            solution = "Extended arm stretch";
        }
        else if (stretch.equals("Neck"))
        {
            solution = "Neck tilts";
        }
        else if (stretch.equals("Hamstring"))
        {
            solution = "Standing hamstring stretch";
        }
        else if (stretch.equals("Chest"))
        {
            solution = "Pectoral stretch with straight arm";
        }
        if (warmup == 1)
        {
            a1.setText("100m jog");
            a2.setText("Lunges");
            a3.setText("Sweeps");
            a4.setText("Airplanes");
            a5.setText("High knees");
            a6.setText("Butt kicks");
            a7.setText("Side shuffles");
            a8.setText(solution);
        }
        else if (warmup == 2)
        {
            a1.setText("200m jog");
            a2.setText("Side shuffles");
            a3.setText("Crossovers");
            a4.setText("Bear crawls");
            a5.setText("Inchworms");
            a6.setText("Lunge and twists");
            a7.setText("3x10m Sprints");
            a8.setText(solution);
        }
        else
        {
            a1.setText("5x10m Sprints");
            a2.setText("Front and back jumps over a line");
            a3.setText("Side to side jumps over a line");
            a4.setText("Pushups, 2 sets of 5");
            a5.setText("Arm swings, 30s");
            a6.setText("Hip circles, 30s");
            a7.setText(solution);
            a8.setText("");
        }
    }

    public void back(View view)
    {
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(workout));
        startActivity(intent);
    }
}