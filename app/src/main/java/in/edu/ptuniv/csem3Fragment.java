package in.edu.ptuniv;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class csem3Fragment extends Fragment {

    private Spinner spinner8;
    private OnItemSelectedListener listener;

    public csem3Fragment() {
        // Required empty public constructor
    }

    public interface OnItemSelectedListener {
        void onItemSelected(String selected);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_csem3, container, false);
        spinner8 = view.findViewById(R.id.spinner8);
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected = (String) parentView.getItemAtPosition(position);
                if (listener != null) {
                    listener.onItemSelected(selected);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Your code here
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
