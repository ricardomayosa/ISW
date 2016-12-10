package com.example.rmayo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by rmayo on 31/10/2016.
 */
public class Signup extends Activity {

    DbHelper helper = new DbHelper(this);

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    @Override
    public void onBackPressed()
    {

        // super.onBackPressed(); // Comment this super call to avoid calling finish()
    }

    public void onButtonClick1(View v){
        if(v.getId()==R.id.createAccount){
            EditText  name = (EditText)findViewById(R.id.name);
            EditText  user = (EditText)findViewById(R.id.user);
            EditText email = (EditText)findViewById(R.id.mail);
            EditText pass1 = (EditText) findViewById(R.id.pass1);
            EditText pass2 = (EditText) findViewById(R.id.pass2);

            String namestr  = name.getText().toString();
            String userstr  = user.getText().toString();
            String emailstr = email.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();
            if("".equals(namestr)||"".equals(userstr)||"".equals(emailstr)||"".equals(pass1str)||"".equals(pass2str)){
                Toast passEmpt = Toast.makeText(Signup.this, "Llena todo el formulario", Toast.LENGTH_SHORT);
                passEmpt.show();
            }

            else if(!emailstr.contains("@")){
                Toast pass = Toast.makeText(Signup.this, "Dirección de correo electrónico no válida", Toast.LENGTH_SHORT);
                pass.show();
            }

            else if(!pass1str.equals(pass2str)){
                Toast pass = Toast.makeText(Signup.this, "Contraseña equivocada", Toast.LENGTH_SHORT);
                pass.show();
            }

            else {
                //insert details in db
                Contact c = new Contact();
                c.setName(namestr);
                c.setUname(userstr);
                c.setEmail(emailstr);
                c.setPass(pass1str);

                helper.insertContact(c);

                Intent k = new Intent(Signup.this,Start.class);
                startActivity(k);
            }

        }
        if(v.getId()==R.id.sLogin){
            Intent l = new Intent(Signup.this,Start.class);
            startActivity(l);
        }
    }
}
