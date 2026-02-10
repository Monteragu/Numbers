package com.example.numbers;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;  // правильный импорт
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int secretNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNumber = findViewById(R.id.editTextNumber);
        TextView textResult = findViewById(R.id.textResult);
        Button buttonGuess = findViewById(R.id.buttonGuess);


        secretNumber = new Random().nextInt(5) + 1;

        buttonGuess.setOnClickListener(v -> {
            String input = editTextNumber.getText().toString();
            if (!input.isEmpty()) {
                int guess = Integer.parseInt(input);
                if (guess == secretNumber) {
                    textResult.setText("Вы угадали!");
                } else if (guess < secretNumber) {
                    textResult.setText("Загаданное число больше");
                } else {
                    textResult.setText("Загаданное число меньше");
                }
            } else {
                textResult.setText("Введите число!");
            }
        });
    }
}