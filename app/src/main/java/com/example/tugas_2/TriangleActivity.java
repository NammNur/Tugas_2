package com.example.tugas_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TriangleActivity extends AppCompatActivity {

    private EditText etBase, etHeight, etSideA, etSideB, etSideC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        etBase = findViewById(R.id.et_base);
        etHeight = findViewById(R.id.et_height);
        etSideA = findViewById(R.id.et_side_a);
        etSideB = findViewById(R.id.et_side_b);
        etSideC = findViewById(R.id.et_side_c);
        Button btnCalculateArea = findViewById(R.id.btn_calculate_area_triangle);
        Button btnCalculatePerimeter = findViewById(R.id.btn_calculate_perimeter_triangle);

        btnCalculateArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateAreaInput()) {
                    calculateArea();
                }
            }
        });

        btnCalculatePerimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validatePerimeterInput()) {
                    calculatePerimeter();
                }
            }
        });

        Button btnExitTriangle = findViewById(R.id.btn_exit_triangle);
        btnExitTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menutup aktivitas saat ini
            }
        });
    }

    private boolean validateAreaInput() {
        String baseInput = etBase.getText().toString().trim();
        String heightInput = etHeight.getText().toString().trim();

        if (baseInput.isEmpty() || heightInput.isEmpty()) {
            Toast.makeText(this, "Masukkan alas dan tinggi", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            Double.parseDouble(baseInput);
            Double.parseDouble(heightInput);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validatePerimeterInput() {
        String sideAInput = etSideA.getText().toString().trim();
        String sideBInput = etSideB.getText().toString().trim();
        String sideCInput = etSideC.getText().toString().trim();

        if (sideAInput.isEmpty() || sideBInput.isEmpty() || sideCInput.isEmpty()) {
            Toast.makeText(this, "Masukkan ketiga sisi", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            Double.parseDouble(sideAInput);
            Double.parseDouble(sideBInput);
            Double.parseDouble(sideCInput);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void calculateArea() {
        double base = Double.parseDouble(etBase.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        double area = 0.5 * base * height;

        // Start ResultActivity and pass the area result
        Intent intent = new Intent(TriangleActivity.this, MainActivity.class);
        intent.putExtra("RESULT", "Luas: " + area);
        startActivity(intent);
    }

    private void calculatePerimeter() {
        double sideA = Double.parseDouble(etSideA.getText().toString());
        double sideB = Double.parseDouble(etSideB.getText().toString());
        double sideC = Double.parseDouble(etSideC.getText().toString());
        double perimeter = sideA + sideB + sideC;

        // Start ResultActivity and pass the perimeter result
        Intent intent = new Intent(TriangleActivity.this, MainActivity.class);
        intent.putExtra("RESULT", "Keliling: " + perimeter);
        startActivity(intent);
    }
}
