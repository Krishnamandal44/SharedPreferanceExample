package com.example.krishna.sharedpreferanceexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name;
    Button btn;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=(EditText)findViewById(R.id.et_name);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=et_name.getText().toString();
                if(name.equals("")){
                    Toast.makeText(MainActivity.this,"Enter The Value First",Toast.LENGTH_SHORT).show();
                }else {
                    savedPreference("NAME",name);
                    startActivity(new Intent(MainActivity.this,MainActivity2.class));
                }
            }
        });
    }
    public void savedPreference(String key,String value){
        SharedPreferences sp=getSharedPreferences("PREF", Context.MODE_PRIVATE);
    
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,value);
        editor.commit();

    }
    public String getPreferences(String key,String value){
        String pref_value="";
        SharedPreferences sp1=getSharedPreferences("PREF", Context.MODE_PRIVATE);
        pref_value=sp1.getString(key,value);
        return pref_value;
    }
}
