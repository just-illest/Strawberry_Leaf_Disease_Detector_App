package com.example.strawberryleafdiseasedetector;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CommonLeafSpot extends Fragment {
    private Context context;
    private ExpandableListView expListView;
    ExpandableListAdapter listAdapter;

    List<String> listDataParent;
    HashMap<String, List<String>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.context=this.getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_common_leaf_spot, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expListView = (ExpandableListView) view.findViewById(R.id.expandableMenu);

        createListData();

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // TODO GroupClickListener work
                return false;
            }
        });

        // Expandable Listview Group Expanded Listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO GroupExpandListener work
            }
        });

        // Expandable Listview Group Collapsed listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                // TODO GroupCollapseListener work
            }
        });

        // Expandable Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
//                Toast.makeText( context,
//                        "Awesome, I clicked:  "+ Objects.requireNonNull(listDataChild.get(listDataParent.get(groupPosition))).get(childPosition),
//                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void createListData() {
        listDataParent = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataParent.add("Preventative Measures");
        listDataParent.add("Causes");

        // Adding child data
        List<String> prevent = new ArrayList<String>();
        prevent.add("Grow resistant varieties like Earliglow, Glooscap, Ogallala and Ozark Beauty");
        prevent.add("Plant in full sunlight");
        prevent.add("Soil must be well drained");
        prevent.add("Avoid watering overhead");

        List<String> causes = new ArrayList<String>();
        causes.add("Mycospharella Fragarie fungus");
        causes.add("Spreads from splashing water on leaves");
        causes.add("Fungus thrives at temperatures of 18C to 25C");

        listDataChild.put(listDataParent.get(0), prevent); // Header, Child data
        listDataChild.put(listDataParent.get(1), causes);


        listAdapter = new ExpandableListAdapter(context, listDataParent, listDataChild);
        expListView.setAdapter(listAdapter);
    }
}