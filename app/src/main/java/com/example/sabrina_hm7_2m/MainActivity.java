package com.example.sabrina_hm7_2m;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second;
    private Boolean isOperationClick;
    private String currentOperator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            textView.setText("0");
            first = 0;
            second = 0;
            currentOperator = null;
        } else {
            String textButton = ((Button) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(textButton);
            } else {
                textView.append(textButton);
            }
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        String textButton = ((Button) view).getText().toString();
        if (currentOperator != null) {
            calculate();
        }
        currentOperator = textButton;

        first = Integer.valueOf(textView.getText().toString());
        isOperationClick = true;
    }

    public void onEqualsClick(View view) {
        if (currentOperator != null) {
            calculate();
            currentOperator = null;
        }
    }

    private void calculate() {
        second = Integer.valueOf(textView.getText().toString());
        if (currentOperator.equals("+")) {
            int sum = first + second;
            textView.setText(String.valueOf(sum));
        } else if (currentOperator.equals("−")) {
            int result = first - second;
            textView.setText(String.valueOf(result));
        } else if (currentOperator.equals("×")) {
            int product = first * second;
            textView.setText(String.valueOf(product));
        } else if (currentOperator.equals("÷")) {
            if (second != 0) {
                int dif = first / second;
                textView.setText(String.valueOf(dif));
            } else {
                textView.setText("На ноль делить нельзя");
            }
        }
        else if (currentOperator.equals("%")) {
            int modulo = first % second;
            textView.setText(String.valueOf(modulo));
        }
    }
}


