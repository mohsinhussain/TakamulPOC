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
                R.drawable.album7,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album1,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Invention a = new Invention("True Romance", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ",
                covers[0], "Apps", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("Xscpae", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.",
                covers[1], "Product Design", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("Maroon 5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
                covers[2], "Table Top Games", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("Born to Die","Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                covers[3], "Software", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("Honeymoon", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",
                covers[4], "Gadgets", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("I Need a Doctor", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do.",
                covers[5], "Software",getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("Loud","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                covers[6], "Apps", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("Legend", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.",
                covers[7], "Video Games", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("Hello", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.",
                covers[8], "Gadgets", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        a = new Invention("Greatest Hits", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                covers[9], "Apps", getRandomNumber(1, 30), getRandomNumber(1, 100), getRandomNumber(1, 3000));
        inventionList.add(a);

        adapter.notifyDataSetChanged();
    }
}

