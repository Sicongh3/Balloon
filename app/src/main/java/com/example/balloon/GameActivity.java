package com.example.balloon;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public final class GameActivity extends AppCompatActivity {
    private int counter = 0;
    private int explosiontap;
    private int maxTap;
    private ImageButton balloonB;
    private TextView tap;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        TextView max = findViewById(R.id.MaxLabel);
        TextView MaxNum = findViewById(R.id.maxnum);
        tap = findViewById(R.id.Taps);
        Button restart = findViewById(R.id.Restart);
        Button reset = findViewById(R.id.Reset);
        Intent intent = getIntent();
        balloonB = findViewById(R.id.balloon);
        maxTap = intent.getIntExtra("maxnumber", 0);
        max.setText(String.valueOf(maxTap));

        Intent returnstartpage = new Intent(this, MainActivity.class);
        explosiontap = intent.getIntExtra("random",0);
        restart.setOnClickListener(unused -> cleaner(tap));
        reset.setOnClickListener(unused -> back(returnstartpage));
        balloonB.setOnClickListener(unused -> count());
    }
    private void count() {
        counter++;
        if (counter > explosiontap) {
            dialogS();
            return;
        }
        tap.setText(String.valueOf(counter));

        if (counter == explosiontap) {
            balloonB.setImageResource(R.drawable.ic_explosion);
        }
    }
    private void cleaner(TextView a) {
        counter = 0;
        explosiontap = (int) (Math.random()*maxTap) + 1;
        a.setText("0");
        balloonB.setImageResource(R.drawable.ic_balloon);
    }
    private void back(Intent a) {
        startActivity(a);
    }
    private void dialogS() {
        final String dialog_invalid_number = "The balloon has exploded, tap RESTART to replay, or tap RESET to change the possible maximum taps ";
        final String resume = "RESUME";
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(dialog_invalid_number);
        builder.setNegativeButton(resume, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
            // User cancelled the dialog
        });
        // Create the AlertDialog object and return it
        builder.create().show();
    }
}
