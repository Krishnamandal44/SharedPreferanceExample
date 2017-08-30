package com.example.krishna.sharedpreferanceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by KRISHNA on 20-04-2017.
 */

public class MainActivity2 extends AppCompatActivity {
    String name="";
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=(TextView)findViewById(R.id.tv);
        name=getPreferences("NAME","");
        tv.setText(name);
    }
    public String getPreferences(String key,String value){
        String pref_value="";
        SharedPreferences sp1=getSharedPreferences("PREF", Context.MODE_PRIVATE);
        pref_value=sp1.getString(key,value);
        return pref_value;
    }
}
