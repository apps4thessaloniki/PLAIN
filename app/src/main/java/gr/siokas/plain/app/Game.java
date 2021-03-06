package gr.siokas.plain.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Game extends Activity {

    // Declare the variables
    Button next, previous;
    ImageView image;
    int step = 1;
    MediaPlayer mp;
    //String allMonuments = "";
    //int img4 = 0, img5 = 0, img6 = 0, img7 = 0, img8 = 0, img9 = 0, img10 = 0, img11 = 0, img12 = 0, img13 = 0, img14 = 0, img15 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        // Associate the variables with the corresponding id's
        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);
        image = (ImageView) findViewById(R.id.image);


        playSound(1);
        changeImg();

        if (getScore() == 0 || getScore() == 3 || getScore() == 6 || getScore() == 9 || getScore() == 12 || getScore() == 15 || getScore() == 18) {
            previous.setVisibility(View.INVISIBLE); // Set the 'previous' button to be invisible
        } else {
            previous.setVisibility(View.VISIBLE); // Set the 'previous' button to be visible
            update(true);
        }


        // Call this method if the 'next' button is pressed
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (step) {
                    case 1: // If it is the first step do the following
                        mp.pause();
                        update(true); // Update the image
                        playSound(getScore() + 1);
                        step++; // Increase the step by one
                        break;
                    case 2: // Again if it is the second step do the following
                        mp.pause();
                        update(true); // Update the image
                        playSound(getScore() + 1);
                        step++; // Increase the step by one
                        break;
                    case 3: // Finally if it is the third step do the following
                        mp.pause();
                        update(true); // Update the image
                        break;
                }
            }
        });

        // Call this method if the 'previous' button is pressed
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (step) {
                    case 1: // If it is the first step do the following
                        mp.pause();
                        update(false); // Update the image
                        playSound(getScore());
                        step--; // Decrease the step by one
                        break;
                    case 2: // If it is the SECOND step do the following
                        mp.pause();
                        update(false); // Update the image
                        playSound(getScore());
                        step--; // Decrease the step by one
                        break;
                    case 3: // If it is the THIRD step do the following
                        mp.pause();
                        update(false); // Update the image
                        playSound(getScore());
                        step--; // Decrease the step by one
                        break;

                }
            }
        });
    }

    void update(boolean x) {

        if (x) saveScore((getScore() + 1) + ""); // At first increase or decrease the score value
        else saveScore((getScore() - 1) + "");


        if (getScore() == 0 || getScore() == 3 || getScore() == 6 || getScore() == 9 || getScore() == 12 || getScore() == 15 || getScore() == 18)
            previous.setVisibility(View.INVISIBLE); // Set the 'previous' button to be visible
        else
            previous.setVisibility(View.VISIBLE); // Set the 'previous' button to be visible

        if (getScore() == 3 || getScore() == 6 || getScore() == 9 || getScore() == 12 || getScore() == 15 || getScore() == 18) { // To every third step do the following
            if (x) {
                startActivity(new Intent(Game.this, Decision.class)); // Start the Decision Activity
                finish();
            } else changeImg();
        } else {
            changeImg();
        }

    }

    void changeImg() {
        if (getScore() == 0)
            changeBack(R.drawable.sketch1); // Change the source of the image
        if (getScore() == 1)
            changeBack(R.drawable.sketch2); // Change the source of the image
        if (getScore() == 2)
            changeBack(R.drawable.sketch3); // Change the source of the image
        if (getScore() == 3)
            changeBack(R.drawable.sketch4); // Change the source of the image
        if (getScore() == 4)
            changeBack(R.drawable.sketch5); // Change the source of the image
        if (getScore() == 5)
            changeBack(R.drawable.sketch6); // Change the source of the image
        if (getScore() == 6)
            changeBack(R.drawable.sketch7); // Change the source of the image
        if (getScore() == 7)
            changeBack(R.drawable.sketch8); // Change the source of the image
        if (getScore() == 8)
            changeBack(R.drawable.sketch9); // Change the source of the image
        if (getScore() == 9)
            changeBack(R.drawable.sketch10); // Change the source of the image
        if (getScore() == 10)
            changeBack(R.drawable.sketch11); // Change the source of the image
        if (getScore() == 11)
            changeBack(R.drawable.sketch12); // Change the source of the image
        if (getScore() == 12)
            changeBack(R.drawable.sketch13); // Change the source of the image
        if (getScore() == 13)
            changeBack(R.drawable.sketch14); // Change the source of the image
        if (getScore() == 14)
            changeBack(R.drawable.sketch15); // Change the source of the image
        if (getScore() == 15)
            changeBack(R.drawable.sketch16); // Change the source of the image
        if (getScore() == 16)
            changeBack(R.drawable.sketch17); // Change the source of the image
        if (getScore() == 17)
            changeBack(R.drawable.sketch18); // Change the source of the image
    }

    void playSound(int x) {
        if (x == 1)
            mp = MediaPlayer.create(this, R.raw.zoo_kartela_1_pili);

        if (x == 2)
            mp = MediaPlayer.create(this, R.raw.zoo_kartela_2_arkoudes);

        if (x == 3)
            mp = MediaPlayer.create(this, R.raw.zoo_kartela_3_pili);

        if (x == 4)
            mp = MediaPlayer.create(this, R.raw.kastra_katrela_1);

        if (x == 5)
            mp = MediaPlayer.create(this, R.raw.kastra_katrela_1);

        if (x == 6)
            mp = MediaPlayer.create(this, R.raw.kastra_katrela_1);

        if (x == 7)
            mp = MediaPlayer.create(this, R.raw.dimitrios_kartela_1);

        if (x == 8)
            mp = MediaPlayer.create(this, R.raw.dimitrios_kartela_2);

        if (x == 9)
            mp = MediaPlayer.create(this, R.raw.dimitrios_kartela_2);

        if (x == 10)
            mp = MediaPlayer.create(this, R.raw.rotonda_kartela_1);

        if (x == 11)
            mp = MediaPlayer.create(this, R.raw.rotonda_kartela_2);

        if (x == 12)
            mp = MediaPlayer.create(this, R.raw.rotonda_kartela_2);

        if (x == 13)
            mp = MediaPlayer.create(this, R.raw.leukos_kartela_1);

        if (x == 14)
            mp = MediaPlayer.create(this, R.raw.leukos_kartela_2);

        if (x == 15)
            mp = MediaPlayer.create(this, R.raw.leukos_kartela_2);

        if (x == 16)
            mp = MediaPlayer.create(this, R.raw.alexandros_kartela_1);

        if (x == 17)
            mp = MediaPlayer.create(this, R.raw.alexandros_kartela_2);

        if (x == 18)
            mp = MediaPlayer.create(this, R.raw.alexandros_kartela_2);

        mp.start();
    }

    void changeBack(int img) {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.game_layout);
        layout.setBackgroundResource(img);
    }

    // Call this method to save score
    void saveScore(String x) {
        SharedPreferences settings = getSharedPreferences("score", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("score", x);
        editor.commit();
    }

    // Call this method to get current the score value
    int getScore() {
        SharedPreferences settings = getSharedPreferences("score", 0);
        final String theScore = settings.getString("score", "0");
        return (Integer.parseInt(theScore));
    }

    // Call this method to save monuments
    void saveMonument(String x) {
        SharedPreferences settings = getSharedPreferences("monuments", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("monuments", x);
        editor.commit();
    }


    // Call this method to get current the monuments so far
    String getMonuments() {
        SharedPreferences settings = getSharedPreferences("monuments", 0);
        final String theMonuments = settings.getString("monuments", "0");
        return theMonuments;
    }

    // Call this method if the back button is pressed (for lower apis)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(Game.this, MainActivity.class)); // Go to the Main Activity
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // Call this method if the back button is pressed (for higher apis)
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Game.this, MainActivity.class));
        finish();
    }


}
