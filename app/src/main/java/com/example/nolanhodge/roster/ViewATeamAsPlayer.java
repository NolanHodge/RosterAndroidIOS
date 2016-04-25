package com.example.nolanhodge.roster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewATeamAsPlayer extends AppCompatActivity implements AdapterView.OnItemClickListener{

    TextView sportLabel;
    TextView teamNameLabel;
    TextView nextGameLabel;
    TextView gamePreview;
    ListView playersList;
    ImageView teamLogoImage;

    ArrayList<String> players;
    ArrayAdapter<String> player_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ateam_as_player);

        // Home button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sportLabel = (TextView) findViewById(R.id.sport_label);
        teamNameLabel = (TextView) findViewById(R.id.team_name_label);
        nextGameLabel = (TextView) findViewById(R.id.next_game_label);
        gamePreview = (TextView) findViewById(R.id.game_preview_label);
        playersList = (ListView) findViewById(R.id.player_listview);
        teamLogoImage = (ImageView) findViewById(R.id.team_logo_image);

        players = new ArrayList<String>();
        player_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, players);
        playersList.setAdapter(player_adapter);

        players.add("Nolan Hodge");
        players.add("Julian Clayton");
        players.add("Joel Scarfone");
        players.add("Brandon Hodge");

        player_adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Get the name of the selected player
        String selected_player = players.get(position);

        // TODO
        // bring User to playerView Page
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            // Set homr button to bring User to main page
            case android.R.id.home:

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
