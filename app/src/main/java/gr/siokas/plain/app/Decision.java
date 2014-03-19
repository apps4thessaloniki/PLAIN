package gr.siokas.plain.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Decision extends ActionBarActivity {

    Button choise1, choise2, choise3;
    MediaPlayer mp;
    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        choise1 = (Button) findViewById(R.id.choise1);
        choise2 = (Button) findViewById(R.id.choise2);
        choise3 = (Button) findViewById(R.id.choise3);

        alert = new AlertDialog.Builder(Decision.this);
        alert.setTitle("Τελική Επιλογή");
        alert.setMessage("Είστε σίγουροι ότι θέλετε να οριστικοποιήσετε αυτήν την επιλογή;");
        alert.setPositiveButton("Ναι!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Decision.this, Quiz.class));
            }
        });
        alert.setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        choise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(1);
                alert.show();
            }
        });

        choise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(2);
                alert.show();
            }
        });

        choise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(3);
                alert.show();
            }
        });
    }

    void saveScore(String x) {
        SharedPreferences settings = getSharedPreferences("score", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("score", x);
        editor.commit();
    }

    int getScore() {
        SharedPreferences settings = getSharedPreferences("score", 0);
        final String theScore = settings.getString("score", "0");

        return (Integer.parseInt(theScore));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.decision, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void playSound(int x) {
        if (x == 1) {
            mp = MediaPlayer.create(this, R.raw.zoo_stratigiki_3_anakoinosi_sta_megafona);
        }
        if (x == 2) {
            mp = MediaPlayer.create(this, R.raw.zoo_stratigiki_2_erotisi_sto_filaka);
        }
        if (x == 3)
            mp = MediaPlayer.create(this, R.raw.zoo_stratigiki_1_psaksimo);

        mp.start();
    }

}