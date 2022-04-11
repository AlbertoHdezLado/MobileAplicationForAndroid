package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View showTextB = (View) findViewById(R.id.buttonShow);
        showTextB.setOnLongClickListener(new View.OnLongClickListener()
        {
            public boolean onLongClick(View v){
                sendMessageHold(v);
                return false;
            }
        }
        );

        View turnOffB = (View) findViewById(R.id.turnOffButton);
        turnOffB.setOnLongClickListener(new View.OnLongClickListener()
        {
            public boolean onLongClick(View v){
                finish();
                return false;
            }
        }
        );
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Hold the button to show the text";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void sendMessageHold(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void sendMessageTurnOff(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Hold the button to shout down the application";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void changeLeft(View view) {
        Intent intent = new Intent(this, Left.class);
        startActivity(intent);
    }

    public void changeRight(View view) {
        Intent intent = new Intent(this, Right.class);
        startActivity(intent);
    }
}

