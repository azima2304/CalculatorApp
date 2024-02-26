package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView number1TextView, actionTextView, number2TextView, resultTextView;
    private Button button_0,button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9;
    private Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEquals, buttonClear;

    private static final String error = "Error";


    private StringBuilder inputStringBuilder = new StringBuilder();
    private double num1, num2;
    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1TextView = findViewById(R.id.number1);
        actionTextView = findViewById(R.id.action);
        number2TextView = findViewById(R.id.number2);
        resultTextView = findViewById(R.id.result_text);




        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiply = findViewById(R.id.button_doppeln);
        buttonDivide = findViewById(R.id.button_divide);
        buttonEquals = findViewById(R.id.button_rechnen);
        buttonClear = findViewById(R.id.button_c);



        button_0=findViewById(R.id.button_0);
        button_1=findViewById(R.id.button_1);
        button_2=findViewById(R.id.button_2);
        button_3=findViewById(R.id.button_3);
        button_4=findViewById(R.id.button_4);
        button_5=findViewById(R.id.button_5);
        button_6=findViewById(R.id.button_6);
        button_7=findViewById(R.id.button_7);
        button_8=findViewById(R.id.button_8);
        button_9=findViewById(R.id.button_9);

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("0");
                updateResult();
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("1");
                updateResult();
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("2");
                updateResult();
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("3");
                updateResult();
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("4");
                updateResult();
            }
        });
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("5");
                updateResult();
            }
        });
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("6");
                updateResult();
            }
        });
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("7");
                updateResult();
            }
        });
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("8");
                updateResult();
            }
        });
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInput("9");
                updateResult();
            }
        });


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction("+");
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction("-");
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction("x");
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction("/");
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInput();
                updateResult();
            }
        });


    }

    private void appendToInput(String value) {
        inputStringBuilder.append(value);
        updateResult();
    }

    private void setAction(String operator) {
        if (!inputStringBuilder.toString().isEmpty()) {
            num1 = Double.parseDouble(inputStringBuilder.toString());
            action = operator;
            clearInput();
            updateResult();
        }
    }

    private void calculateResult() {
        if (!inputStringBuilder.toString().isEmpty() && action != null) {
            num2 = Double.parseDouble(inputStringBuilder.toString());
            double result = 0;

            switch (action) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "x":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultTextView.setText(error);
                        return;
                    }
                    break;
            }

            clearInput();
            inputStringBuilder.append(result);
            updateResult();
        }
    }

    private void clearInput() {
        inputStringBuilder.setLength(0);
//        number1TextView.setText("0");
//        number2TextView.setText("0");
    }

    private void updateResult() {
        resultTextView.setText(inputStringBuilder.toString());
        number1TextView.setText(String.valueOf(num1));
        actionTextView.setText(action);
        number2TextView.setText(String.valueOf(num2));
    }




    }
