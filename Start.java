package com.example.rmayo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by rmayo on 31/10/2016.
 */
public class Start extends Activity{

    DbHelper helper = new DbHelper(this);

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        EditText user = (EditText) findViewById(R.id.username);
        user.setText(null);
        EditText pass = (EditText) findViewById(R.id.password);
        user.setText(null);
    }

    public void onButtonClick(View v){
        if(v.getId()==R.id.login){

            EditText a = (EditText)findViewById(R.id.username);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.password);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);

            if(pass.equals(password)){
                Intent i = new Intent(Start.this,MainActivity.class);
                startActivity(i);
            }
            else{
                Toast temp = Toast.makeText(Start.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
        else if(v.getId()==R.id.signup){
            Intent i = new Intent(this,Signup.class);
            startActivity(i);
        }
    }
}
