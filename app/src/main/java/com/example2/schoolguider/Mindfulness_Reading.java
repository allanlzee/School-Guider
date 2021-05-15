package com.example2.schoolguider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mindfulness_Reading#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mindfulness_Reading extends Fragment {

    private RelativeLayout parent;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<String> books = new ArrayList<String>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Initialize the ListView
    ListView bookList;

    public Mindfulness_Reading() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mindfulness_Reading.
     */
    // TODO: Rename and change types and number of parameters
    public static Mindfulness_Reading newInstance(String param1, String param2) {
        Mindfulness_Reading fragment = new Mindfulness_Reading();
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
        return inflater.inflate(R.layout.mindfulness_reading_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton home = view.findViewById(R.id.fab);
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showSnackBar();
            }
        });
    }

    public AdapterView.OnItemClickListener bookAdapter = (parent, view, position, id) -> {
        ((TextView)view).setText("The Subtle Art of Not Giving a F*ck");
        books.set(position, "The Subtle Art of Not Giving a F*ck");
    };

    public void showSnackBar() {
        Snackbar.make(parent, "Back to Home", Snackbar.LENGTH_LONG)
                .setAction("Continue", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavHostFragment.findNavController(Mindfulness_Reading.this).navigate(R.id.action_mindfulness_Reading_to_mindfulnessActivity);
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.teal_200))
                .setTextColor(getResources().getColor(R.color.orange))
                .show();
    }
}