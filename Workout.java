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

import static com.zackwillson.zworkouts.workoutSelect.EXTRA_MESSAGE;

public class Workout extends AppCompatActivity {

    TextView showWorkout, One, Two, Three, Four, Five, Six, Seven;
    int workout;
    Button info;
    int on = 0;
    int BMIPositive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        showWorkout = findViewById(R.id.showWorkout);
        showWorkout.setBackground(getResources().getDrawable(R.drawable.round));
        showWorkout.setGravity(Gravity.CENTER);
        One = findViewById(R.id.One);
        Two = findViewById(R.id.Two);
        Three = findViewById(R.id.Three);
        Four = findViewById(R.id.Four);
        Five = findViewById(R.id.Five);
        Six = findViewById(R.id.Six);
        Seven = findViewById(R.id.Seven);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        showWorkout.setText(message);
        workout = Integer.parseInt(message);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("FitData", Context.MODE_PRIVATE);
        String weight = sp.getString("weight", "");
        String feet = sp.getString("feet", "");
        String inches = sp.getString("inches", "");
        String age = sp.getString("age", "");
        float fitLevel = sp.getFloat("Fitness", 0.0f);
        int FitLevel = (int)(fitLevel+.5);
        double unathletic = 0;
        if (FitLevel == 1){
            unathletic = .5;
        }
        int Inches = Integer.parseInt(feet)*12 + Integer.parseInt(inches);
        float BMI = (float) (703.0*Integer.parseInt(weight)/(Math.pow(Inches, 2)));
        float TrueBMI = (int) (.5+BMI);
        if (TrueBMI>=19 && TrueBMI<=25)
        {
            BMIPositive = 2;
        }
        else
        {
            BMIPositive = 1;
        }
        double FF = BMIPositive + FitLevel/2.0;
        int Age = Integer.parseInt(age);
        double ageMeter = 0.0;
        if (Age>55)
        {
            ageMeter = .25;
            if (Age>59)
            {
                ageMeter = .5;
            }
        }
        if (workout == 1)
        {
            showWorkout.setText("Run: Exercises");
            One.setText("Run for:");
            Two.setText(FF-ageMeter+" km");
            Three.setText("At your own pace");
            Four.setText("");
            Five.setText("");
            Six.setText("");
            Seven.setText("");
        }
        else if (workout == 2)
        {
            double FF2 = FF-2*ageMeter-unathletic;
            showWorkout.setText("Circuits: Exercises");
            One.setText("3 sets, 30s rest between each exercise:");
            Two.setText("Mountain Climbers, "+(int)(15+10*FF2)+"s");
            if (ageMeter>.25)
            {
                Three.setText("Plank to lunge, " + (int) (15 + 10 * FF2) + "s");
                Four.setText("Squats, " + (int) (15 + 10 * FF2) + "s");
            }
            else{
                Three.setText("Burpees, " + (int) (15 + 10 * FF2) + "s");
                Four.setText("Jump squats, " + (int) (15 + 10 * FF2) + "s");
            }
            Five.setText("Pushups, "+(int)(15+10*FF2)+"s");
            Six.setText("Plank, "+(int)(15+10*FF2)+"s");
            Seven.setText("Superman, "+(int)(15+10*FF2)+"s");
        }
        else if (workout == 3)
        {
            double FF3 = FF-ageMeter;
            showWorkout.setText("HIIT: Exercises");
            One.setText("15 sets of Sprints");
            Two.setText("Each Sprint is "+(int)(4.5+3*FF3+.5)+"s");
            Three.setText("Rest in between sets for "+3*((int)(4.5+3*FF3+.5)));
            Four.setText("");
            Five.setText("");
            Six.setText("");
            Seven.setText("");
        }
        else if (workout == 4)
        {
            showWorkout.setText("Upper Body: Exercises");
            One.setText("3 sets:");
            Two.setText("Pushups, "+(int)(4*FF));
            Three.setText("Tricep dips, "+(int)(3+2*FF));
            Four.setText("Rows, "+(int)(3+2*FF));
            Five.setText("Lateral raises|W|, "+(int)(5+2*FF));
            Six.setText("Bicep curls|W|, "+(int)(5+2*FF));
            Seven.setText("");
        }
        else if (workout == 5)
        {
            showWorkout.setText("Lower Body: Exercises");
            One.setText("3 sets:");
            Two.setText("Squats|W|, "+(int)(3+2*FF));
            Three.setText("Romanian deadlifts|W|, "+(int)(3+2*FF));
            Four.setText("Reverse lunges, "+(int)(3+2*FF));
            Five.setText("Calf raises, "+(int)(5+2*FF));
            Six.setText("Hamstring curls, "+(int)(5+2*FF));
            Seven.setText("");
        }
        else if (workout == 6)
        {
            double FF6 = FF- unathletic;
            showWorkout.setText("Core: Exercises");
            One.setText("3 sets:");
            Two.setText("Side plank, e.s. "+(int)(10*FF)+"s");
            Three.setText("Deadbug w/ bosu, e.s. "+(int)(3+2*FF6));
            Four.setText("Plank, "+(int)(10*FF)+"s");
            Five.setText("Bird dog, "+(int)(22.5+5*FF)+"s");
            Six.setText("Pushup to plank, "+(int)(22.5+5*FF)+"s");
            Seven.setText("Leg raises, "+(int)(7.5+5*FF)+"s");
        }
        else if (workout == 7)
        {
            double FF7 = FF -unathletic;
            showWorkout.setText("S+S Fullbody: Exercises");
            Two.setText("Squats|W|, 10");
            if (ageMeter>0.0) {
                Three.setText("Pushups, " + (int) (3 + 2 * FF7));
            }
            else{
                Three.setText("Clap pushups, "+(int)(3+2*FF7));
            }
            Four.setText("Bent over rows|W|, 10");
            Five.setText("Lateral raises|W|, 12");
            Six.setText("Deadbugs w/ bosu, e.s. "+(int)(3+2*FF));
            One.setText("3 sets:");
            Seven.setText("");
        }
        else if (workout == 8)
        {
            showWorkout.setText("Fullbody: Exercises");
            Two.setText("Reverse Lunges, "+(int)(10.5+FF));
            Three.setText("Lat pulldown|W15|, "+15);
            Four.setText("Incline press|W15|, "+15);
            Five.setText("Leg raises, "+(int)(12+2*FF));
            Six.setText("Shoulder press, "+(int)(10.5+FF));
            One.setText("3 sets:");
            Seven.setText("");
        }
        else if (workout == 9)
        {
            double FF9 = FF-ageMeter-unathletic;
            showWorkout.setText("Timed Fullbody 1: Exercises");
            One.setText("3 sets:");
            if (ageMeter>.25){
                Two.setText("Plank to lunge, " + (int) (22.5 + 5 * FF9) + "s");
                Four.setText("Reverse lunges, " + (int) (22.5 + 5 * FF9) + "s");
            }
            else{
                Two.setText("Burpees, " + (int) (22.5 + 5 * FF9) + "s");
                Four.setText("Jump lunges, " + (int) (22.5 + 5 * FF9) + "s");
            }
            Three.setText("Spiderman pushups, "+(int)(22.5+5*FF9)+"s");
            Five.setText("Glute bridges, "+(int)(22.5+5*FF9)+"s");
            Six.setText("Front to lateral raise|W45|, "+(int)(22.5+5*FF9)+"s");
            Seven.setText("Inchworm, "+(int)(22.5+5*FF9)+"s");
        }
        else
        {
            double FF10 = FF -ageMeter - unathletic;
            showWorkout.setText("Timed Fullbody 2: Exercises");
            One.setText("3 sets:");
            Two.setText("90% Sprints, "+(int)(7.5+5*FF10)+"s x3");
            Three.setText("Kettlebell swings|W45|, "+(int)(22.5+5*FF10)+"s");
            Four.setText("Mountain climbers, "+(int)(22.5+5*FF10)+"s");
            Five.setText("Pushup to plank, "+(int)(22.5+5*FF10)+"s");
            Six.setText("Frog jumps, "+(int)(22.5+5*FF10)+"s");
            Seven.setText("");
        }
        if (workout == 1 || workout == 2 || workout == 3 || workout == 6)
        {
            info = findViewById(R.id.button11);
            info.setVisibility(View.INVISIBLE);
        }
    }

    public void warmup(View view)
    {
        Intent intent = new Intent(this, warmup.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(workout));
        startActivity(intent);
    }

    public void cooldown(View view)
    {
        Intent intent = new Intent(this, cooldown.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(workout));
        startActivity(intent);
    }

    public void info(View view) throws InterruptedException {
        if (on == 0)
        {
            if (workout == 4 || workout == 5 || workout == 7)
            {
                Toast.makeText(Workout.this, "|W| means choose a weight in which you can do 8-12 reps of, if you improve go slightly heavier", Toast.LENGTH_SHORT).show();
            }
            else if (workout == 8)
            {
                Toast.makeText(Workout.this, "|W15| means choose a weight in which you can do 12-15 reps of, if you improve go slightly heavier", Toast.LENGTH_SHORT).show();
            }
            else if (workout == 9 || workout == 10)
            {
                Toast.makeText(Workout.this, "|W45| means choose a weight in which you can do 30-45s reps of, if you improve go slightly heavier", Toast.LENGTH_SHORT).show();
            }
        }
        on = 1;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                on = 0;
            }
        }, 2700);
    }

}