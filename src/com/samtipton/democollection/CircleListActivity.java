package com.samtipton.democollection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
 
public class CircleListActivity extends FragmentActivity implements
        CircleListFragment.Callbacks {
 
    private boolean mTwoPane;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_list);
 
        if (findViewById(R.id.circle_detail_container) != null) {
            mTwoPane = true;
 
            ((CircleListFragment) getSupportFragmentManager().findFragmentById(
                    R.id.circle_list)).setActivateOnItemClick(true);
        }
 
        // TODO: If exposing deep links into your app, handle intents here.
    }
 
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putString(CircleDetailFragment.ARG_ITEM_ID, id);
            CircleDetailFragment fragment = new CircleDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.circle_detail_container, fragment).commit();
 
        } else {
            Intent detailIntent = new Intent(this, CircleDetailActivity.class);
            detailIntent.putExtra(CircleDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}