package com.example.lab1_bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText txtX, txtY;
    private TextView tvResult;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnModulus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }
    private void initControl() {

        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnModulus = findViewById(R.id.btnModulus);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        btnModulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('%');
            }
        });
    }
    private void calculate(char operator) {
        int x = Integer.parseInt(txtX.getText().toString());
        int y = Integer.parseInt(txtY.getText().toString());
        int result = 0;
        boolean error = false;

        switch (operator) {
            case '+':
                result = x +  y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                if (y != 0) {
                    result = x / y;
                } else {
                    tvResult.setText("Lỗi: Chia cho 0");
                    error = true;
                }
                break;
            case '%':
                if (y != 0) {
                    result = x % y;
                } else {
                    tvResult.setText("Lỗi: Chia cho 0");
                    error = true;
                }
                break;
        }

        if (!error) {
            tvResult.setText("Kết quả: " + result);
        }
    }


}