package com.example.sound_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.os.RecoverySystem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sound_app.R;
import com.example.sound_app.databinding.ContentRecycleviewLayoutBinding;
import com.example.sound_app.objects.sounds;
import com.example.sound_app.recycleViewAdapters.content_recycleView_adapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link content_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class content_fragment extends Fragment {
    ArrayList<sounds> soundsList=new ArrayList<>();
    RecyclerView RCVSounds;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_Sounds = "Sounds";

    // TODO: Rename and change types of parameters
    private ArrayList<sounds> msounds;
    private String mParam2;

    public content_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param soundsList Parameter 1.
     * @return A new instance of fragment content_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static content_fragment newInstance(ArrayList<sounds> soundsList) {
        content_fragment fragment = new content_fragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_Sounds, (ArrayList<? extends sounds>) soundsList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            msounds = (ArrayList<sounds>) getArguments().getSerializable(ARG_Sounds);
            Toast.makeText(getActivity(), "test " + msounds.get(0).getTitle(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_content_fragment, container, false);
        RCVSounds=v.findViewById(R.id.RCVContentSounds);
        content_recycleView_adapter newAdapter=new content_recycleView_adapter("content", msounds);
        RCVSounds.setAdapter(newAdapter);
        return  v;
    }
}