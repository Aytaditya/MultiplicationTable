package com.aditya.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


   // if declared inside onCreate() class these will not be accessible to populate() method hence declared here
    TextView textView;
    ListView listView;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         textView=findViewById(R.id.textView);
         listView=findViewById(R.id.listView);
        seekbar=findViewById(R.id.seekBar);

        //Setting Maximum Value of Seekbar
        seekbar.setMax(20);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // This method is called when the progress of the SeekBar changes.

                //The makeText method creates a Toast object, but you need to call the show() method to actually display it.
                Toast.makeText(MainActivity.this," Multiplication Table of "+progress,Toast.LENGTH_SHORT).show();
                populate(progress);
                //calling out populate method with value of progress

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // This method is called when the user starts interacting with the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // This method is called when the user stops interacting with the SeekBar
            }
        });


    }

    //You should move the populate method outside the onCreate method.
    public void populate(int table){

        ArrayList<String> mulTable=new ArrayList<>();
        for (int i = 1; i <=10; i++) {
            //adding elements to string arraylist and then we will push the arraylist to listView
          mulTable.add(table + " x "+i+" = "+table*i);

        }

        //ArrayAdapter is a class that provides a convenient way to bind a data source (like an array or a list) to the user interface components, such as ListView, GridView

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mulTable);
        listView.setAdapter(arrayAdapter);



    };
}