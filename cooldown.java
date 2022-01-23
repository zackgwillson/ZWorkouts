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

public class cooldown extends AppCompatActivity {

    int workout;
    int cooldown;
    TextView title, b1, b2, b3, b4, b5, b6, b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooldown);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        workout = Integer.parseInt(message);
        title = findViewById(R.id.textView20);
        title.setBackground(getResources().getDrawable(R.drawable.round));
        title.setGravity(Gravity.CENTER);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        if (workout>=1 && workout<=3){
            cooldown = 1;
        }
        else if (workout>=4 && workout<=7)
        {
            cooldown = 2;
        }
        else
        {
            cooldown = 3;
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
        if (cooldown == 1)
        {
            b1.setText("Quad stretch");
            b2.setText("Pigeon stretch");
            b3.setText("Sitting hamstring stretch");
            b4.setText("Kneeling hip flexor stretch");
            b5.setText("Calf stretch against wall");
            b6.setText(solution);
            b7.setText("");
        }
        else if (cooldown == 2)
        {
            b1.setText("Light jog");
            b2.setText("Tricep stretch behind head");
            b3.setText("Pectoral stretch");
            b4.setText("Sitting hamstring stretch");
            b5.setText("Pigeon stretch");
            b6.setText(solution);
            b7.setText("");
        }
        else
        {
            b1.setText("Pectoral stretch");
            b2.setText("Hip flexor stretch");
            b3.setText("Calf stretch against wall");
            b4.setText("Cobra stretch");
            b5.setText("Cross-body shoulder stretch");
            b6.setText("Tricep stretch");
            b7.setText(solution);
        }
    }

    public void back(View view)
    {
        Intent intent = new Intent(this, Workout.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(workout));
        startActivity(intent);
    }
}