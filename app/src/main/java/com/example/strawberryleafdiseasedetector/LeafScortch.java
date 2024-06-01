package com.example.strawberryleafdiseasedetector;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class LeafScortch extends Fragment {
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
        return inflater.inflate(R.layout.fragment_leaf_scortch, container, false);
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

        listDataParent.add("Symptoms");
        listDataParent.add("Preventative Measures");
        listDataParent.add("Causes");

        // Adding child data
        List<String> symptoms = new ArrayList<String>();
        symptoms.add("Marginal leaf burn or scorching");
        symptoms.add("Affected areas become necrotic");
        symptoms.add("Development of reddish-brown or purple discoloration");
        symptoms.add("In severe cases, leaves develop a 'fernleaf' appearance");
        symptoms.add("Reduced fruit yeild and plant decline");

        List<String> prevent = new ArrayList<String>();
        prevent.add("Selecting disease-resistant strawberry cultivars");
        prevent.add("Removal and destruction of infected plants and debris");
        prevent.add("Leafhoppers must be controlled by using insecticides or introducing natural predators like ladybugs");
        prevent.add("Humidity must be reduced within the canopy using sufficient spacing");
        prevent.add("Copper-based fungicides");
        prevent.add("Antibiotics such as Streptomycin");
        prevent.add("Biocontrol agents, such as antagonistic bacterio or bacteriophages");


        List<String> causes = new ArrayList<String>();
        causes.add("Caused by bacterium known as Xylella fastidiosa");

        listDataChild.put(listDataParent.get(0), symptoms); // Header, Child data
        listDataChild.put(listDataParent.get(1), prevent);
        listDataChild.put(listDataParent.get(2), causes);


        listAdapter = new ExpandableListAdapter(context, listDataParent, listDataChild);
        expListView.setAdapter(listAdapter);
    }
}