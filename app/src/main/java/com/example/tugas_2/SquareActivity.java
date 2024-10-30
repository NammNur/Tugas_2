package com.example.tugas_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SquareActivity extends AppCompatActivity {

    private EditText etSide;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        etSide = findViewById(R.id.et_side);
        tvResult = findViewById(R.id.tv_result_square);
        Button btnCalculateArea = findViewById(R.id.btn_calculate_area_square);
        Button btnCalculatePerimeter = findViewById(R.id.btn_calculate_perimeter_square);

        btnCalculateArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    calculateArea();
                }
            }
        });

        btnCalculatePerimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    calculatePerimeter();
                }
            }
        });

        // Tombol Exit dengan Intent
        Button btnExit = findViewById(R.id.btn_exit_square);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Menutup SquareActivity setelah kembali ke MainActivity
            }
        });
    }

    private boolean validateInput() {
        String input = etSide.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Masukkan panjang sisi", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void calculateArea() {
        double side = Double.parseDouble(etSide.getText().toString());
        double area = side * side;
        tvResult.setText("Luas: " + area);
    }

    private void calculatePerimeter() {
        double side = Double.parseDouble(etSide.getText().toString());
        double perimeter = 4 * side;
        tvResult.setText("Keliling: " + perimeter);
    }
}
