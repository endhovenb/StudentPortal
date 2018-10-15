package nl.endhoven.bart.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PortalItemAdapter.OnClickListener {

    public static final int CODE = 1;
    public static final String PORTAL = "Portal";
    public static final String URL = "Url";
    public static final String TITLE = "Title";

    private RecyclerView mRecyclerView;
    private List<PortalItem> mPortalItems;
    private PortalItemAdapter mPortalItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize.
        mRecyclerView = findViewById(R.id.recycler_view);
        mPortalItems = new ArrayList<>();

        //Add Items to List.
        mPortalItems.add(new PortalItem("Resultaten", "https://sis.hva.nl"));
        mPortalItems.add(new PortalItem("Facebook", "https://www.Facebook.com"));

        //Create layout manager.
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(3,
                LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mPortalItemAdapter = new PortalItemAdapter(mPortalItems,this);
        mRecyclerView.setAdapter(mPortalItemAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open AddPortalActivity
                Intent intent = new Intent(MainActivity.this, AddPortalActivity.class);
                startActivityForResult(intent, CODE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnClickListener(int position) {
        PortalItem portalObject = mPortalItems.get(position);
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(MainActivity.URL, portalObject.getUrl());
        intent.putExtra(MainActivity.TITLE, portalObject.getTitle());
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE) {
            if (resultCode == RESULT_OK) {
                PortalItem newPortalObject = data.getParcelableExtra(MainActivity.PORTAL);
                mPortalItems.add(newPortalObject);
                mPortalItemAdapter.notifyDataSetChanged();
            }
        }
    }
}
