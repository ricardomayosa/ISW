package com.example.rmayo.myapplication.mFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.rmayo.myapplication.R;
import com.example.rmayo.myapplication.Start;

/**
 * Created by rmayo on 23/10/2016.
 */
public class ConfigFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_configuracion,container,false);
        Button button = (Button) rootView.findViewById(R.id.cerrarSesion);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast temp = Toast.makeText(getActivity().getBaseContext(), "Sesión cerrada con éxito", Toast.LENGTH_SHORT);
                temp.show();
                Intent intent = new Intent(getActivity(), Start.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
