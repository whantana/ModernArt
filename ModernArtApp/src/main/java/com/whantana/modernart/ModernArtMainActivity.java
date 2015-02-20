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
     * Two available menus {@see #com.whantana.modernart.R.menu.artist}
     *                     {@see #com.whantana.modernart.R.menu.about}
     */
    private final int[] AVAILABLE_MENU_IDS = { R.menu.about , R.menu.artist };
    private int menuIndex;

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
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(AVAILABLE_MENU_IDS[menuIndex], menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    /**
     * Implementation of <code>NavigationDrawerFragment.NavigationDrawerCallbacks</code> interface.
     *
     * @param position position
     */
    @Override
    public void onNavigationDrawerItemSelected(int position) {

        // update title & menu index
        menuIndex = 1;
        switch (position) {
            case 0:
                mTitle = getString(com.whantana.modernart.R.string.title_section1);
                menuIndex = 0;
                break;
            case 1:
                mTitle = getString(com.whantana.modernart.R.string.title_section2);
                break;
            case 2:
                mTitle = getString(com.whantana.modernart.R.string.title_section3);
                break;
            case 3:
                mTitle = getString(com.whantana.modernart.R.string.title_section4);
                break;
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
