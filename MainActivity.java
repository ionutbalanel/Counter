package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Integer counter = 0;

    private TextView incrementButton;
    private TextView counterLabel;
    private TextView decrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViews();

        displayCounterValue(counter);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               counter = counter + 1;
               displayCounterValue(counter);
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = counter - 1;
                displayCounterValue(counter);
            }
        });

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("count");
            counterLabel.setText(String.valueOf(counter));
        }
    }

    private void displayCounterValue(Integer counterValue) {
        counterLabel.setText("" + counterValue);
    }

    private void setUpViews() {
        incrementButton = findViewById(R.id.increment_button);
        counterLabel = findViewById(R.id.counter_label);
        decrementButton = findViewById(R.id.decrement_button);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count", counter);
    }
}