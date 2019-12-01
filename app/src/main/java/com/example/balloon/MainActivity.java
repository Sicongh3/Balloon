package com.example.balloon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText maxtapnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.start);
        TextView instruction = findViewById(R.id.Instruction);
        maxtapnumber = findViewById(R.id.tapnumber);

        /*int random = new Random().nextInt(maxnumber) + 1;
        System.out.println(random);*/
        start.setOnClickListener(unused -> startAct());



    }
    private TextWatcher filterTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // DO THE CALCULATIONS HERE AND SHOW THE RESULT AS PER YOUR CALCULATIONS


        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private void startAct() {
        String maxtapnumberString = maxtapnumber.getText().toString();
        if (maxtapnumberString.equals("")) {
            dialog();
        }
        Intent startgame = new Intent(this, GameActivity.class);

        int maxnumber = Integer.parseInt(maxtapnumberString);
        int output =(int) (Math.random()*maxnumber) + 1;
        //maxtapnumber.addTextChangedListener(filterTextWatcher);
        if (maxnumber < 1) {
            dialog();
        } else {
            startgame.putExtra("maxnumber", maxnumber);
            startgame.putExtra("random", output);
            startActivity(startgame);
            //dialogS();
        }
    }

    private void dialog() {
        final String dialog_invalid_number = "The number should be greater than 0";
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
    private void dialogS() {
        final String dialog_invalid_number = "SSSSSSSSSSSSSSSS";
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

