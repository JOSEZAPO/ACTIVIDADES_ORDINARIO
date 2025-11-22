package com.example.espacio_seguro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Importante: Añadir esta línea

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1. Declara el botón como una variable de la clase
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 2. Conecta la variable con el botón del diseño usando su ID
        btnLogin = findViewById(R.id.btnLogin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 3. ¡LA PARTE CLAVE! Asigna la acción al botón
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea una intención para abrir LoginActivity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                // Inicia la nueva actividad
                startActivity(intent);
            }
        });
    }
}
