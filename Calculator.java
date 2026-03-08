package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputFirstNumber;
    private EditText inputSecondNumber;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivide;
    private TextView textResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        textResult = findViewById(R.id.textResult);

        buttonPlus.setOnClickListener(v -> calculate("+"));
        buttonMinus.setOnClickListener(v -> calculate("-"));
        buttonMultiply.setOnClickListener(v -> calculate("*"));
        buttonDivide.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operation) {
        String first = inputFirstNumber.getText().toString();
        String second = inputSecondNumber.getText().toString();

        if (first.isEmpty() || second.isEmpty()) {
            textResult.setText("Please enter both numbers");
            return;
        }

        double a = Double.parseDouble(first);
        double b = Double.parseDouble(second);
        double result = 0;

        switch (operation) {
            case "+":
                result = a + b;
                break;

            case "-":
                result = a - b;
                break;

            case "*":
                result = a * b;
                break;

            case "/":
                if (b == 0) {
                    textResult.setText("Cannot divide by zero");
                    return;
                }
                result = a / b;
                break;
        }

        textResult.setText("Result: " + result);
    }
}
