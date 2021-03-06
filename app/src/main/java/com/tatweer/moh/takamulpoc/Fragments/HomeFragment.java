package com.tatweer.moh.takamulpoc.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tatweer.moh.takamulpoc.Adapters.InventionsAdapter;
import com.tatweer.moh.takamulpoc.Models.Invention;
import com.tatweer.moh.takamulpoc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moh on 11/9/2016.
 */

// Instances of this class are fragments representing a single
// object in our collection.
public class HomeFragment extends Fragment {
    public static final String ARG_OBJECT = "object";
    View rootView;
    private RecyclerView recyclerView;
    private InventionsAdapter adapter;
    private List<Invention> inventionList;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        rootView = inflater.inflate(
                R.layout.fragment_collection_object, container, false);
        Bundle args = getArguments();
//        ((TextView) rootView.findViewById(R.id.textView)).setText(
//                Integer.toString(args.getInt(ARG_OBJECT)));

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        inventionList = new ArrayList<>();
        adapter = new InventionsAdapter(getActivity(), inventionList, getActivity());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        return rootView;
    }



    public int getRandomNumber(int bound1, int bound2) {
        //make sure bound2> bound1
        int min = Math.min(bound1, bound2);
        int max = Math.max(bound1, bound2);
        //math.random gives random number from 0 to 1
        return (int) (min + (Math.random() * (max - min)));
    }


    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.laser,
                R.drawable.shutterstock_sky,
                R.drawable.setalite,
                R.drawable.doctor,
                R.drawable.tower,
                R.drawable.machine,
                R.drawable.finger,
                R.drawable.polymers,
                R.drawable.liver,
                R.drawable.balls,
                R.drawable.phone};

        Invention a = new Invention("MOBILE LASER SCANNING AND INFRASTRUCTURE MONITORING SYSTEM", "Middle East and UAE in particular have experienced a tremendous boom in property and infrastructure development over the last decade. In other cities, the underlying infrastructure available to property developers is typically mapped and documented well before the developer begins his work.",
                covers[0], "Apps", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("HUB CONTEST DISTRIBUTED ALGORITHM", "  We typically take for granted the amount of work needed for a simple phone call to occur between two mobile phones. Behind the scenes, hundreds, if not thousands of messages are communicated between a mobile handset, radio tower, and countless servers to enable your phone call to go smoothly. ",
                covers[1], "Product Design", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("CLOCK SYNCHRONIZATION OVER COMMUNICATION ", " In real life, the communication paths from master to slave and reverse are not perfectly symmetric mainly due to dissimilar forward and reverse physical link delays and queuing delays. asymmetry, creates an error in the estimate of the slave clock’s offset from the master",
                covers[2], "Table Top Games", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("PATIENT-SPECIFIC SEIZURE CLASSIFICATION","The timely detection of an epileptic seizure to alert the patient is currently not available. The invention is a device that can classify specific seizures of patients. It is realized within a microchip (IC) and can be attached to the patient.",
                covers[3], "Software", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("ALTERNATIVE RENEWABLE ENERGY HARVESTING", "There has been increased demand to harvest energy from nontraditional alternative energy sources for self-powered sensors chipsets which are located in remote locations and that can operate at extremely low power levels.",
                covers[4], "Gadgets", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("TECHNIQUE FOR MOTOR CONTROL OVER PACKET NETWORKS", "Many industries rely on motor control systems to physically control automated machines in manufacturing, energy conservation, process control and other important functions. ",
                covers[5], "Software",getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("INDOOR WIRELESS FINGERPRINTING TECHNIQUE","  Location information has gained significant attention for a variety of outdoor applications thanks to the reliable and popular GPS system. ",
                covers[6], "Apps", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("POLYMERS AND PLASTICS FROM SULFUR COMPOUND", "Plastics are some of the most heavily used materials in our world. From plastic bags, to computer components - they are the back-bone material of our daily lives.",
                covers[7], "Video Games", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("FIBER-IN-FIBER BIOARTIFICIAL LIVER DEVICE", "Liver is a site for proteins and amino acids production. Once the liver fails, its function is very difficult to replicate. Up to date, there is no approved therapy but human liver transplant - bio artificial liver devices and incubating liver cells are only a short term solution to bridge the time for the patients to the ultimate liver transplant.",
                covers[8], "Gadgets", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("COMPACT SUFFIX TREE FOR BINARY PATTERN MATCHING", " While the “suffix tree” is an efficient structure to solve many string problems, especially in cloud storages, it requires a large memory space for building and storing the tree structure. ",
                covers[9], "Apps", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        adapter.notifyDataSetChanged();
    }
}

