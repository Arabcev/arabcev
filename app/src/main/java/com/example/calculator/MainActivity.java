package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button add, subtract, divide, multiply, clear;
    private TextView operation, result;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        clear = (Button) findViewById(R.id.clear);
        operation = (TextView) findViewById(R.id.operation);
        result = (TextView) findViewById(R.id.result);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        float num1 = 0;
        float num2 = 0;
        float res = 0;
        boolean n = false;

        num1 = Float.parseFloat(number1.getText().toString());
        num2 = Float.parseFloat(number2.getText().toString());

        switch (view.getId()) {
            case R.id.add:
                operation.setText("+");
                res = num1 + num2;
                break;
            case R.id.subtract:
                operation.setText("-");
                res = num1 - num2;
                break;
            case R.id.divide:
                operation.setText("/");
                if (num2 == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Ошибка! На ноль делить нельзя!", Toast.LENGTH_LONG);
                    toast.show();
                    n = true;
                    break;
                } else {
                    res = num1 / num2;
                    break;
                }
            case R.id.multiply:
                operation.setText("*");
                res = num1 * num2;
                break;
            case R.id.clear:
                number1.setText("");
                number2.setText("");
                operation.setText("");
                result.setText("");
                break;
            default:
                break;
        }
        if (n == true) {
            result.setTextColor(Color.RED);
            result.setText("ERROR");
        } else {
            result.setTextColor(Color.BLACK);
            result.setText(res + "");
        }
        n = false;
    }
}