package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Spinner spinner=findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.time,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



        Button button= findViewById(R.id.button2);
        button.setOnClickListener(v ->{
            Intent intent= new Intent(this,ThirdActivity.class);
            startActivity(intent);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotif(){
       //if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.0){
            CharSequence name="charname";
            String description="desc";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
           // NotificationChannel channel=new NotificationChannel("notify");

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            //notificationManager.createNotificationChannel(channel);
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}