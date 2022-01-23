package com.zackwillson.zworkouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class viewInfo extends AppCompatActivity {

    public static String weight;
    public String feet;
    public String inches;
    public String age;
    public String stretch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);

        TextView showWeight, showFeet, showInches, showAge, showStretch, showFitLevel, showBMI;

        showWeight = findViewById(R.id.weightView);
        showFeet = findViewById(R.id.viewFeet);
        showInches = findViewById(R.id.viewInches);
        showAge = findViewById(R.id.ageView);
        showStretch = findViewById(R.id.stretchView);
        showFitLevel = findViewById(R.id.fitnessView);
        showBMI = findViewById(R.id.BMIView);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("FitData", Context.MODE_PRIVATE);
        weight = sp.getString("weight", "");
        feet = sp.getString("feet", "");
        inches = sp.getString("inches", "");
        age = sp.getString("age", "");
        stretch = sp.getString("Stretch", "");
        float fitLevel = sp.getFloat("Fitness", 0.0f);
        int Inches = Integer.parseInt(feet)*12 + Integer.parseInt(inches);
        float BMI = (float) (703.0*Integer.parseInt(weight)/(Math.pow(Inches, 2)));

        showWeight.setText("Weight: "+weight);
        showFeet.setText("Height: "+feet+"'");
        showInches.setText(inches+'"');
        showAge.setText("Age: "+age);
        showStretch.setText("Stretch: "+stretch);
        showFitLevel.setText("Fitness Rating: "+(int)fitLevel);
        showBMI.setText("Body Mass Index: "+BMI);


    }
    public void goToEdit(View view){

        Intent intent = new Intent(this, editInfo.class);
        startActivity(intent);
    }
}
