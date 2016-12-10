package com.example.rmayo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rmayo.myapplication.mFragments.CalendarioFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FormRecordatorio.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FormRecordatorio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormRecordatorio extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    DbHelper2 helper = new DbHelper2(this.getContext());
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private OnFragmentInteractionListener mListener;


    public FormRecordatorio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FormRecordatorio.
     */
    // TODO: Rename and change types and number of parameters
    public static FormRecordatorio newInstance(String param1, String param2) {
        FormRecordatorio fragment = new FormRecordatorio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form_recordatorio, container, false);
        final Button guardarRecordatorio = (Button) view.findViewById(R.id.guardarRecordatorio);
        guardarRecordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarRecordatorio(v);
            }
        });
        return view;
    }

    public void guardarRecordatorio(View v){

        EditText titulo = (EditText)v.findViewById(R.id.titulo);
        EditText fecha = (EditText)v.findViewById(R.id.fecha);
        EditText hora = (EditText)v.findViewById(R.id.hora);
        EditText urgencia = (EditText) v.findViewById(R.id.urgencia);

        String titulostr  = titulo.getText().toString();
        String fechastr = fecha.getText().toString();
        String horastr = hora.getText().toString();
        String urgenciastr = urgencia.getText().toString();

        if("".equals(titulostr)||"".equals(fechastr)||"".equals(horastr)||"".equals(urgenciastr)){
            Toast passEmpt = Toast.makeText(getActivity().getBaseContext(), "Llena todo el formulario", Toast.LENGTH_SHORT);
            passEmpt.show();
        }

        else {
            //insert details in db
            Contact2 c2 = new Contact2();
            c2.setTitulo(titulostr);
            c2.setFecha(fechastr);
            c2.setHora(horastr);
            c2.setUrgencia(urgenciastr);

            helper.insertContact2(c2);

            Toast temp = Toast.makeText(getActivity().getBaseContext(), "Recordatorio guardado con éxito", Toast.LENGTH_SHORT);
            temp.show();

        }

        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_id, new CalendarioFragment(), "NewFragmentTag");
        ft.addToBackStack(null);
        ft.commit();


    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
