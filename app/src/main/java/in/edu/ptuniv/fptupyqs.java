package in.edu.ptuniv;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fptupyqs extends Fragment {

    private static final String TAG = fptupyqs.class.getSimpleName();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG,"onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView()");
        return inflater.inflate(R.layout.fragment_ptupyqs, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"onDetach()");
    }
}