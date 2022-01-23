package com.zackwillson.zworkouts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class editInfo extends AppCompatActivity {

    Spinner sapinner, lbs, f, i, a;
    Button button;
    RatingBar ratingBar;
    SharedPreferences sp;
    String weightStr;
    String feetStr;
    String inchesStr;
    String ageStr;
    float fitness;
    TextView info;
    int on = 0;
    int on2 = 0;
    List<String> stretching = new ArrayList<>();
    List<String> Feets = new ArrayList<>();
    List<String> Inches = new ArrayList<>();
    List<String> Ages = new ArrayList<>();
    List<String> Weights = new ArrayList<>();
    boolean important; //If important is true, then the data is not all complete.
    String chosenWeight, chosenFeet, chosenInch, chosenAge, chosenStretch, chosenFitness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("FitData", Context.MODE_PRIVATE);
        String weightTest = sp.getString("weight", "");
        String feetTest = sp.getString("feet", "");
        String inchesTest = sp.getString("inches", "");
        String ageTest = sp.getString("age", "");
        String stretchTest = sp.getString("Stretch", "");
        String fitnessTest = sp.getString("fitnessString", "");
        String realw = weightTest;
        String realf = feetTest;
        String reali = inchesTest;
        String reala = ageTest;
        String reals = stretchTest;
        float realF = sp.getFloat("Fitness", 0.0f);
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

        info = findViewById(R.id.button9);
        info.setGravity(Gravity.CENTER);
        info.setBackground(getResources().getDrawable(R.drawable.round));

        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setBackground(getResources().getDrawable(R.drawable.white_round));

        if (!important)
        {
            ratingBar.setRating(realF);
        }


        if (!important)
        {
            stretching.add(reals);
        }
        stretching.add("");
        stretching.add("Quads");
        stretching.add("Glutes");
        stretching.add("Hip");
        stretching.add("Back");
        stretching.add("Core");
        stretching.add("Calf");
        stretching.add("Wrist");
        stretching.add("Neck");
        stretching.add("Hamstring");
        stretching.add("Chest");

        if (!important)
        {
            Feets.add(realf);
        }
        Feets.add("");
        for (int i = 1; i<8; i++)
        {
            Feets.add(Integer.toString(i));
        }

        if (!important)
        {
            Inches.add(reali);
        }
        Inches.add("");
        for (int i = 0; i<12; i++)
        {
            Inches.add(Integer.toString(i));
        }


        if (!important)
        {
            Ages.add(reala);
        }
        Ages.add("");
        for (int i = 1; i<101; i++)
        {
            Ages.add(Integer.toString(i));
        }


        if (!important)
        {
            Weights.add(realw);
        }
        Weights.add("");
        for (int i = 1; i<301; i++)
        {
            Weights.add(Integer.toString(i));
        }

        sapinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stretching);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sapinner.setAdapter(adapter);
        sapinner.setBackground(getResources().getDrawable(R.drawable.white_round));



        f = (Spinner) findViewById(R.id.feet4);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Feets);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        f.setAdapter(adapter2);
        f.setBackground(getResources().getDrawable(R.drawable.white_round));


        i = (Spinner) findViewById(R.id.inches4);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Inches);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        i.setAdapter(adapter3);
        i.setBackground(getResources().getDrawable(R.drawable.white_round));


        a = (Spinner) findViewById(R.id.age4);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Ages);

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        a.setAdapter(adapter4);
        a.setBackground(getResources().getDrawable(R.drawable.white_round));


        lbs = (Spinner) findViewById(R.id.weight4);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Weights);

        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        lbs.setAdapter(adapter5);
        lbs.setBackground(getResources().getDrawable(R.drawable.white_round));

    }
    public void save(View view){
        sp = getSharedPreferences("FitData", Context.MODE_PRIVATE);

        Spinner lbs = (Spinner) findViewById(R.id.weight4);
        Spinner a = (Spinner) findViewById(R.id.age4);
        Spinner f = (Spinner) findViewById(R.id.feet4);
        Spinner i = (Spinner) findViewById(R.id.inches4);
        weightStr = lbs.getSelectedItem().toString();
        feetStr = f.getSelectedItem().toString();
        inchesStr = i.getSelectedItem().toString();
        ageStr = a.getSelectedItem().toString();
        Spinner sapinner = (Spinner) findViewById(R.id.spinner);
        String spinnerText = sapinner.getSelectedItem().toString();
        ratingBar = findViewById(R.id.ratingBar);
        fitness = ratingBar.getRating();
        if (fitness == 0 || fitness == 0.5)
        {
            fitness = 1;
        }
        SharedPreferences.Editor editor = sp.edit();

        if (!weightStr.equals(""))
        {
            editor.putString("weight", weightStr);
        }
        if (!feetStr.equals(""))
        {
            editor.putString("feet", feetStr);
        }
        if (!inchesStr.equals(""))
        {
            editor.putString("inches", inchesStr);
        }
        if (!ageStr.equals(""))
        {
            editor.putString("age", ageStr);
        }
        if (!spinnerText.equals(""))
        {
            editor.putString("Stretch", spinnerText);
        }
        editor.putFloat("Fitness", fitness);
        String Fitastring = String.valueOf(fitness);
        editor.putString("fitnessString", Fitastring);


        editor.commit();
        if (on2 == 0)
        {
            Toast.makeText(editInfo.this, "Information Saved.", Toast.LENGTH_LONG).show();
        }
        on2 = 1;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                on2 = 0;
            }
        }, 4500);
    }
    public void goToView(View view){
        boolean important;
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
                Toast.makeText(editInfo.this, "Input all your Fitness Info before you go to ViewInfo", Toast.LENGTH_SHORT).show();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    on = 0;
                }
            }, 2700);
        }
    }
    public void Info(View view) {
        if (on == 0)
        {
            Toast.makeText(editInfo.this, "You must enter all your information before you can View or Workout.", Toast.LENGTH_LONG).show();
        }
        on = 1;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                on = 0;
            }
        }, 4500);
    }
}