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

public class LeafBlight extends Fragment {
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
        return inflater.inflate(R.layout.fragment_leaf_blight, container, false);
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
        listDataParent.add("Symptoms");
        listDataParent.add("Preventative Measures");
        listDataParent.add("Causes");

        // Adding child data
        List<String> symptoms = new ArrayList<String>();
        symptoms.add("Small, dark purple to brown spots on the leaves");
        symptoms.add("Spots enlarge and become angular with a tan center and purple margin");
        symptoms.add("Defoliation of plant");
        symptoms.add("Weakening of plants");
        symptoms.add("Reduced Fruit quality and yeild");

        List<String> prevent = new ArrayList<String>();
        prevent.add("Well drained planting sites with good air circulation");
        prevent.add("Crop rotation");
        prevent.add("Removal and destruction of infected plant debris");
        prevent.add("Mulching");
        prevent.add("Fungicides such as azoxystrobin, captan, chlorothalonil, or mancozeb");
        prevent.add("Microorganisms such as bacillus subtilis or trichoderma spp");
        prevent.add("Monitor and scout the plantation for timely intervention of sprouting diseases");

        List<String> causes = new ArrayList<String>();
        causes.add("High humidity");
        causes.add("Caused by the Phomopsis obscurans fungus");

        listDataChild.put(listDataParent.get(0), symptoms); // Header, Child data
        listDataChild.put(listDataParent.get(1), prevent);
        listDataChild.put(listDataParent.get(2), causes);


        listAdapter = new ExpandableListAdapter(context, listDataParent, listDataChild);
        expListView.setAdapter(listAdapter);
    }
}