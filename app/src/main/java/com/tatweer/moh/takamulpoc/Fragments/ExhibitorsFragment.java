package com.tatweer.moh.takamulpoc.Fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tatweer.moh.takamulpoc.Adapters.ExhibitorsAdapter;
import com.tatweer.moh.takamulpoc.Models.Exhibitor;
import com.tatweer.moh.takamulpoc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moh on 11/9/2016.
 */

// Instances of this class are fragments representing a single
// object in our collection.
public class ExhibitorsFragment extends Fragment {
    public static final String ARG_OBJECT = "object";
    View rootView;
    private RecyclerView recyclerView;
    private ExhibitorsAdapter adapter;
    private List<Exhibitor> exhibitorList;

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

        exhibitorList = new ArrayList<>();
        adapter = new ExhibitorsAdapter(getActivity(), exhibitorList, getActivity());

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        return rootView;
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
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
                R.drawable.acasc,
                R.drawable.energynternational,
                R.drawable.enshige_logo,
                R.drawable.exhi_1,
                R.drawable.exhi_logo_,
                R.drawable.exhi_logo_hp,
                R.drawable.redspeed,
                R.drawable.scheidt,
                R.drawable.sharjah,
                R.drawable.wleye,
                R.drawable.phone};

        Exhibitor a = new Exhibitor("Adbruf Ltd.", covers[0],"United Kingdom", "Z2.F30");
        exhibitorList.add(a);

        a = new Exhibitor("Borum A/S", covers[1],"China", "Z2.F30");
        exhibitorList.add(a);

        a = new Exhibitor("Basler Lacke AG", covers[2],"UAE", "Z2.F30");
        exhibitorList.add(a);

        a = new Exhibitor("ORAFOL Europe GmbH", covers[3],"China", "Z2.F30");
        exhibitorList.add(a);

        a = new Exhibitor("Shenzhen YDM Reflector Co. Ltd", covers[4],"China", "Z2.F30");
        exhibitorList.add(a);

        a = new Exhibitor("Zehntner Gmbh Testing Instruments", covers[5],"Switzerlan", "Z2.F30");
        exhibitorList.add(a);

        a = new Exhibitor("REEF", covers[6],"UAE", "Z2.F30");
        exhibitorList.add(a);

        a = new Exhibitor("Polycon Gulf Limited", covers[7],"UAE", "Z2.F30");
        exhibitorList.add(a);

        a = new Exhibitor("Midsign Ltd.", covers[8],"Cyprus", "Z2.F30");
        exhibitorList.add(a);

        adapter.notifyDataSetChanged();


//        Invention a = new Invention("MOBILE LASER SCANNING AND INFRASTRUCTURE MONITORING SYSTEM", covers[0],
//                "Apps", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);
//
//        a = new Invention("HUB CONTEST DISTRIBUTED ALGORITHM", "  We typically take for granted the amount of work needed for a simple phone call to occur between two mobile phones. Behind the scenes, hundreds, if not thousands of messages are communicated between a mobile handset, radio tower, and countless servers to enable your phone call to go smoothly. ",
//                covers[1], "Product Design", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);
//
//        a = new Invention("CLOCK SYNCHRONIZATION OVER COMMUNICATION ", " In real life, the communication paths from master to slave and reverse are not perfectly symmetric mainly due to dissimilar forward and reverse physical link delays and queuing delays. asymmetry, creates an error in the estimate of the slave clock’s offset from the master",
//                covers[2], "Table Top Games", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);
//
//        a = new Invention("PATIENT-SPECIFIC SEIZURE CLASSIFICATION","The timely detection of an epileptic seizure to alert the patient is currently not available. The invention is a device that can classify specific seizures of patients. It is realized within a microchip (IC) and can be attached to the patient.",
//                covers[3], "Software", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);
//
//        a = new Invention("ALTERNATIVE RENEWABLE ENERGY HARVESTING", "There has been increased demand to harvest energy from nontraditional alternative energy sources for self-powered sensors chipsets which are located in remote locations and that can operate at extremely low power levels.",
//                covers[4], "Gadgets", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);
//
//        a = new Invention("TECHNIQUE FOR MOTOR CONTROL OVER PACKET NETWORKS", "Many industries rely on motor control systems to physically control automated machines in manufacturing, energy conservation, process control and other important functions. ",
//                covers[5], "Software",getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);
//
//        a = new Invention("INDOOR WIRELESS FINGERPRINTING TECHNIQUE","  Location information has gained significant attention for a variety of outdoor applications thanks to the reliable and popular GPS system. ",
//                covers[6], "Apps", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);
//
//        a = new Invention("POLYMERS AND PLASTICS FROM SULFUR COMPOUND", "Plastics are some of the most heavily used materials in our world. From plastic bags, to computer components - they are the back-bone material of our daily lives.",
//                covers[7], "Video Games", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);
//
//        a = new Invention("FIBER-IN-FIBER BIOARTIFICIAL LIVER DEVICE", "Liver is a site for proteins and amino acids production. Once the liver fails, its function is very difficult to replicate. Up to date, there is no approved therapy but human liver transplant - bio artificial liver devices and incubating liver cells are only a short term solution to bridge the time for the patients to the ultimate liver transplant.",
//                covers[8], "Gadgets", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);
//
//        a = new Invention("COMPACT SUFFIX TREE FOR BINARY PATTERN MATCHING", " While the “suffix tree” is an efficient structure to solve many string problems, especially in cloud storages, it requires a large memory space for building and storing the tree structure. ",
//                covers[9], "Apps", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
//        exhibitorList.add(a);


    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
}

