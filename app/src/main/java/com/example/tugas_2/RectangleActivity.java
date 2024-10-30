package com.example.tugas_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RectangleActivity extends AppCompatActivity {

    private EditText etLength, etWidth;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        etLength = findViewById(R.id.et_length);
        etWidth = findViewById(R.id.et_width);
        tvResult = findViewById(R.id.tv_result_rectangle);
        Button btnCalculateArea = findViewById(R.id.btn_calculate_area_rectangle);
        Button btnCalculatePerimeter = findViewById(R.id.btn_calculate_perimeter_rectangle);

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

        // Tombol Exit menggunakan Intent
        Button btnExitRectangle = findViewById(R.id.btn_exit_rectangle);
        btnExitRectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RectangleActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Menutup RectangleActivity setelah kembali ke MainActivity
            }
        });
    }

    private boolean validateInput() {
        String lengthInput = etLength.getText().toString().trim();
        String widthInput = etWidth.getText().toString().trim();

        if (lengthInput.isEmpty() || widthInput.isEmpty()) {
            Toast.makeText(this, "Masukkan panjang dan lebar", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            Double.parseDouble(lengthInput);
            Double.parseDouble(widthInput);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void calculateArea() {
        double length = Double.parseDouble(etLength.getText().toString());
        double width = Double.parseDouble(etWidth.getText().toString());
        double area = length * width;
        tvResult.setText("Luas: " + area);
    }

    private void calculatePerimeter() {
        double length = Double.parseDouble(etLength.getText().toString());
        double width = Double.parseDouble(etWidth.getText().toString());
        double perimeter = 2 * (length + width);
        tvResult.setText("Keliling: " + perimeter);
    }
}
