package com.example.nolanhodge.roster;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateNewTeam extends AppCompatActivity {

    EditText teamname_et;
    Spinner typeofsport ;
    ImageView teamlogo_iv;

    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_team);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        teamname_et = (EditText) findViewById(R.id.EditTextTeamName);
        typeofsport = (Spinner) findViewById(R.id.SpinnerSportType);
        teamlogo_iv = (ImageView) findViewById(R.id.select_team_image);
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

    public void selectLogo(View button)
    {
        Intent i = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            // String picturePath contains the path of selected Image
            teamlogo_iv.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }

    public void createTeam(View button) {
        // TODO
        String field_empty = "Please fill in the fields:";
        Toast t;

        boolean check = true;

        String teamname = teamname_et.getText().toString();
        String sportType = typeofsport.getSelectedItem().toString();

        // Verify fields
        if (teamname.equals("")) {
            field_empty += " Team Name";
            check = false;
        }
        if (!check)
        {
            t = Toast.makeText(getApplicationContext(), field_empty, Toast.LENGTH_LONG);
            t.show();
        }
        else
        {
            // Send SQL data off to DB.
            // Send user to edit view team page
            Intent intent = new Intent(this, ViewATeam.class);
            startActivity(intent);
        }

    }

}
