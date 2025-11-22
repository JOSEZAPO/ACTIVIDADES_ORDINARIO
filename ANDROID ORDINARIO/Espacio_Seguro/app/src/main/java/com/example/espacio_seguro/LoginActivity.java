package com.example.espacio_seguro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextContrasena;
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ¡CAMBIO IMPORTANTE! Ahora carga el layout correcto.
        setContentView(R.layout.activity_login);

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextContrasena = findViewById(R.id.editTextContrasena);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(v -> {
            String usuario = editTextUsuario.getText().toString().trim();
            String password = editTextContrasena.getText().toString().trim();

            // Lógica de validación
            if (usuario.equals("admin_ucc") && password.equals("123")) {
                // Si es correcto, navega al Dashboard
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish(); // Cierra LoginActivity para no poder volver atrás
            } else {
                // Si es incorrecto, muestra un mensaje
                Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
