package com.example.nolanhodge.roster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewTeams extends AppCompatActivity implements AdapterView.OnItemClickListener{


    ListView teamList;

    ArrayList<String> teams;
    ArrayAdapter<String> team_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teams);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        teamList = (ListView) findViewById(R.id.team_listview);
        teams = new ArrayList<String>();
        team_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teams);
        teamList.setAdapter(team_adapter);

        teams.add("The Broncos");
        teams.add("The Yankees");
        teams.add("Ottawa Senators");
        teams.add("The Bent Shafts");

        team_adapter.notifyDataSetChanged();

        //TODO
        // SQL QUERY FOR ALL OF THE USERS TEAMS
        // FILL LIST VIEW WITH THE TEAMS
        // KEEP ALL TID'S IN A SEPARATE ARRAY HIDDEN FROM UI
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Get the name of the selected team
        String selected_team = teams.get(position);

        // TODO
        // Check if user is captain of the team
        // bring User to proper ViewTeam Page
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
