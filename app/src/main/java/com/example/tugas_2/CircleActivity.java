package com.example.tugas_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CircleActivity extends AppCompatActivity {

    private EditText etRadius;
    private TextView tvResultCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        etRadius = findViewById(R.id.et_radius);
        tvResultCircle = findViewById(R.id.tv_result_circle);

        Button btnCalculateArea = findViewById(R.id.btn_calculate_area_circle);
        Button btnCalculatePerimeter = findViewById(R.id.btn_calculate_perimeter_circle);
        Button btnExit = findViewById(R.id.btn_exit_circle);

        btnCalculateArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea();
            }
        });

        btnCalculatePerimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePerimeter();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menutup Activity
            }
        });
    }

    private void calculateArea() {
        String radiusStr = etRadius.getText().toString();
        if (!radiusStr.isEmpty()) {
            double radius = Double.parseDouble(radiusStr);
            double area = Math.PI * radius * radius;
            tvResultCircle.setText("Luas: " + area);
        }
    }

    private void calculatePerimeter() {
        String radiusStr = etRadius.getText().toString();
        if (!radiusStr.isEmpty()) {
            double radius = Double.parseDouble(radiusStr);
            double perimeter = 2 * Math.PI * radius;
            tvResultCircle.setText("Keliling: " + perimeter);
        }
    }
}
