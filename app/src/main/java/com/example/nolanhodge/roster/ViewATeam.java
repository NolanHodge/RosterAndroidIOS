package com.example.nolanhodge.roster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.*;
import android.view.View;

import java.util.ArrayList;

public class ViewATeam extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView sportLabel;
    TextView teamNameLabel;
    TextView nextGameLabel;
    TextView gamePreview;
    ListView playersList;
    EditText updateText;
    Button sendUpdateButton;
    Button addPlayerButton;
    ImageView teamLogoImage;

    ArrayList<String> players;
    ArrayAdapter<String> player_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ateam);

        // Home button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sportLabel = (TextView) findViewById(R.id.sport_label);
        teamNameLabel = (TextView) findViewById(R.id.team_name_label);
        nextGameLabel = (TextView) findViewById(R.id.next_game_label);
        gamePreview = (TextView) findViewById(R.id.game_preview_label);
        addPlayerButton = (Button) findViewById(R.id.add_player_button);
        playersList = (ListView) findViewById(R.id.player_listview);
        updateText = (EditText) findViewById(R.id.update_multiline);
        sendUpdateButton = (Button) findViewById(R.id.update_button);
        teamLogoImage = (ImageView) findViewById(R.id.team_logo_image);

        players = new ArrayList<String>();
        player_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, players);
        playersList.setAdapter(player_adapter);

        players.add("Nolan Hodge");
        players.add("Julian Clayton");
        players.add("Joel Scarfone");
        players.add("Brandon Hodge");

        player_adapter.notifyDataSetChanged();

        playersList.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Get the name of the selected player
        String selected_player = players.get(position);

        // TODO
        // prompt user to remove player from team or view the player
    }

    public void addGame(View button)
    {
        //TODO
        // Prompt user to add a new game, get values
        // Datetime of game
        // Location
        // Opponent
    }

    public void addPlayer(View button)
    {
        //TODO
        // Prompt User to find players to add.
    }

    public void sendUpdate(View button)
    {
        //TODO
        // Send update to Team
    }
}
