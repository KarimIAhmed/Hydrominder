package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView display;
        display=(TextView)findViewById(R.id.textView);
        Spinner spinner=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.age,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        Spinner spinner2=findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adaper1=ArrayAdapter.createFromResource(this,R.array.gender, android.R.layout.simple_spinner_item);
        adaper1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adaper1);
        spinner2.setOnItemSelectedListener(this);


        Button button= findViewById(R.id.button);
        button.setOnClickListener(v ->{
            Intent intent= new Intent(this,SecondActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("spinner",R.id.spinner2);
        savedInstanceState.putInt("spinner1",R.id.spinner);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).equals("age") ||parent.getItemAtPosition(position).equals("gender"))
        {
            Toast.makeText(parent.getContext(), "Must select option first!", Toast.LENGTH_LONG).show();
            //do nothing until both options are selected
        }

        else {

            String text = parent.getItemAtPosition(position).toString();
            displayResult(text);
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void displayResult(String view){

    }
}