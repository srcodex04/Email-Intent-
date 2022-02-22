package com.srcodex.msa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etTo, etSub, etMessage;
    AppCompatButton btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTo = findViewById(R.id.etTo);
        etSub = findViewById(R.id.etSub);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to = etTo.getText().toString().trim();
                String sub = etSub.getText().toString().trim();
                String message = etMessage.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email client"));

            }
        });

    }
}