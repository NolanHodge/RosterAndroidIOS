package com.example.nolanhodge.roster;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        options=getResources().getStringArray(R.array.options);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        listView = (ListView) findViewById(R.id.drawerlist);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selected_option = options[position];
        switch (selected_option)
        {
            case "Schedule":
            {
                Intent intent = new Intent(this, Schedule.class);
                startActivity(intent);
                break;
            }
            case "Teams":
            {
                Intent intent = new Intent(this, ViewTeams.class);
                startActivity(intent);
                break;
            }
            case "Create A Team":
            {
                Intent intent = new Intent(this, CreateNewTeam.class);
                startActivity(intent);
                break;
            }
            case "Test":
            {
                Intent intent = new Intent(this, PlayerView.class);
                startActivity(intent);
                break;
            }

            default:
                break;
        }
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


}
