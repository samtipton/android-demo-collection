package com.samtipton.democollection;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * An activity representing a single Circle detail screen. This activity is only
 * used on handset devices. On tablet-size devices, item details are presented
 * side-by-side with a list of items in a {@link CircleListActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than
 * a {@link CircleDetailFragment}.
 */
public class CircleDetailActivity extends FragmentActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_circle_detail);

                if (savedInstanceState == null) {
                        // Create the detail fragment and add it to the activity
                        // using a fragment transaction.
                        Bundle arguments = new Bundle();
                        arguments.putString(CircleDetailFragment.ARG_ITEM_ID, getIntent()
                                        .getStringExtra(CircleDetailFragment.ARG_ITEM_ID));
                        CircleDetailFragment fragment = new CircleDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                        .add(R.id.circle_detail_container, fragment).commit();
                }
        }

}
