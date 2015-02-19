package com.whantana.modernart;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

/**
 * Main Activity
 */
public class ModernArtMainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Navigation Drawer fragment {@see #com.whantana.modernart.NavigationDrawerFragment}.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Art piece holder fragment {@see #com.whantana.modernart.ArtPieceHolderFragment}.
     */
    private ArtPieceHolderFragment mArtPieceHolderFragment;

    /**
     * Control panel fragment {@see #com.whantana.modernart.ControlPanelFragment}.
     */
    private ControlPanelFragment mControlPanelFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    /**
     * A tag :)
     */
    private static final String TAG = "ModernArtMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate():");
        super.onCreate(savedInstanceState);

        // set content view for this activity
        setContentView(com.whantana.modernart.R.layout.activity_modern_art_main);

        // find navigation drawer fragment
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(com.whantana.modernart.R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                com.whantana.modernart.R.id.navigation_drawer,
                (DrawerLayout) findViewById(com.whantana.modernart.R.id.drawer_layout));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart():");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart():");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume():");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause():");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop():");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy():");
    }

    /**
     * Restore action bar.
     */
    public void restoreActionBar() {
        Log.d(TAG,"restoreActionBar(title : " +  mTitle + "):");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    /**
     * Overriding <code>ActionBarActivity</code>.
     *
     * @param menu menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG,"onCreateOptionsMenu():");
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(com.whantana.modernart.R.menu.global, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Overriding <code>ActionBarActivity</code>.
     *
     * @param item item
     * @return true true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected():");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.whantana.modernart.R.id.visit_moma) {
            Toast.makeText(this, "Activity http://www.moma.org/", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Implementation of <code>NavigationDrawerFragment.NavigationDrawerCallbacks</code> interface.
     *
     * @param position position
     */
    @Override
    public void onNavigationDrawerItemSelected(int position) {

        // update title
        switch (position + 1) {
            case 1:
                mTitle = getString(com.whantana.modernart.R.string.title_section1);
                break;
            case 2:
                mTitle = getString(com.whantana.modernart.R.string.title_section2);
                break;
            case 3:
                mTitle = getString(com.whantana.modernart.R.string.title_section3);
                break;
            case 4:
                mTitle = getString(com.whantana.modernart.R.string.title_section4);
        }

        // update the replace the art piece holder
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(com.whantana.modernart.R.id.artpiece_holder,
                        ArtPieceHolderFragment.newInstance(position))
                .commit();

        // TODO update the replace the control panel

    }
 }
