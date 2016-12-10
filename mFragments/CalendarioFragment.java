package com.example.rmayo.myapplication.mFragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.rmayo.myapplication.FormRecordatorio;
import com.example.rmayo.myapplication.R;
import com.example.rmayo.myapplication.Start;

/**
 * Created by rmayo on 23/10/2016.
 */
public class CalendarioFragment extends Fragment implements FormRecordatorio.OnFragmentInteractionListener{

    //CompactCalendarView compactCalendar;
    //private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendario,container,false);
        //compactCalendar = (CompactCalendarView) findView
        Button button = (Button) rootView.findViewById(R.id.recordatorio);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*

                Toast temp2 = Toast.makeText(getActivity().getBaseContext(), "Nombraseña incorrectos", Toast.LENGTH_SHORT);
                temp2.show();*/

                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_id, new FormRecordatorio(), "NewFragmentTag");
                ft.commit();


            }
        });
        return rootView;
    }

    public CalendarioFragment(){

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
