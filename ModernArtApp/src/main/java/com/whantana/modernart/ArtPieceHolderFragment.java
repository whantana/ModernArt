package com.whantana.modernart;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * An art piece holder fragment containing different interchangeable views.
 */
public class ArtPieceHolderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * A tag :)
     */
    private static final String TAG = "ArtPieceHolderFragment";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ArtPieceHolderFragment newInstance(int sectionNumber) {
        Log.d(TAG, "newInstance(" + sectionNumber + "):");
        ArtPieceHolderFragment fragment = new ArtPieceHolderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(TAG, "onAttach():");
        super.onAttach(activity);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate():");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart():");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume():");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause():");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop():");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy():");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach():");
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView():");
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView():");
        final int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        switch (sectionNumber) {
            case 0:
                return inflater.inflate(com.whantana.modernart.R.layout.about, container, false);
            case 1:
                return inflater.inflate(com.whantana.modernart.R.layout.piet_mondrian, container, false);
            case 2:
                return inflater.inflate(com.whantana.modernart.R.layout.daniel_buren, container, false);
            case 3:
                return inflater.inflate(com.whantana.modernart.R.layout.sol_lewitt, container, false);
            default:
                Log.e(TAG, "onCreateView(): should not be here" );
                throw new IllegalStateException();

        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated():");

        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // if the item of visit_moma
        if (id == R.id.visit_moma) {
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    "http://www.moma.org/", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.artist_bio) {

            final int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);

            Toast.makeText(
                    getActivity().getApplicationContext(),
                    "Artist Bio " + sectionNumber, Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
