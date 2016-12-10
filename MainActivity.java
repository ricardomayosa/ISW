package com.example.rmayo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.rmayo.myapplication.mFragments.AvatarFragment;
import com.example.rmayo.myapplication.mFragments.CalendarioFragment;
import com.example.rmayo.myapplication.mFragments.ConfigFragment;
import com.example.rmayo.myapplication.mFragments.RecordatoriosFragment;
import com.example.rmayo.myapplication.mFragments.TrofeosFragment;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener{

    AHBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        bottomNavigation=(AHBottomNavigation) findViewById(R.id.myBottomNavigation_ID);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();

        //DB
        DbHelper helper = new DbHelper(this);
        //SQLiteDatabase db = helper.getWritableDatabase();

    }

    private void createNavItems(){
        //CRETE ITEMS
        AHBottomNavigationItem avatar       = new AHBottomNavigationItem("Avatar",R.drawable.avatar);
        AHBottomNavigationItem record       = new AHBottomNavigationItem("Recordatorios",R.drawable.recordatorio);
        AHBottomNavigationItem calendario   = new AHBottomNavigationItem("Calendario",R.drawable.calendario);
        AHBottomNavigationItem trofeos      = new AHBottomNavigationItem("Trofeos",R.drawable.trofeos);
        AHBottomNavigationItem configuracion= new AHBottomNavigationItem("Configuración",R.drawable.config);
        //ADD THEM
        bottomNavigation.addItem(avatar);
        bottomNavigation.addItem(record);
        bottomNavigation.addItem(calendario);
        bottomNavigation.addItem(trofeos);
        bottomNavigation.addItem(configuracion);

        //SET PROPERTIES
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        bottomNavigation.setAccentColor(Color.RED);
        bottomNavigation.setInactiveColor(Color.BLUE);
        bottomNavigation.setForceTitlesDisplay(true);
        //SET CURRENT ITEM
        bottomNavigation.setCurrentItem(2);
        //bottomNavigation.setCurrentItem(1);



    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        //show fragment
        if(position == 0){
            //show fragment
            AvatarFragment avatarFragment = new AvatarFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,avatarFragment).commit();
        }
        else if(position == 1){
            RecordatoriosFragment recordatoriosFragment = new RecordatoriosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,recordatoriosFragment).commit();
        }
        else if(position == 2){
            CalendarioFragment calendarioFragment = new CalendarioFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,calendarioFragment).commit();
        }
        else if(position == 3){
            TrofeosFragment trofeosFragment = new TrofeosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,trofeosFragment).commit();
        }
        else if(position == 4){
            ConfigFragment configFragment = new ConfigFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,configFragment).commit();
        }

        return true;
    }

    @Override
    public void onBackPressed() {

    }

}
