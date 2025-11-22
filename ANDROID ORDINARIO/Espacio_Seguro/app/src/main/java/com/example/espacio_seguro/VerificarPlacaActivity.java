package com.example.espacio_seguro;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VerificarPlacaActivity extends AppCompatActivity {

    TextView txtTituloVerificacion;
    EditText etPlaca;
    Button btnVerificar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_placa);

        // Enlazar componentes de la UI
        txtTituloVerificacion = findViewById(R.id.txtTituloVerificacion);
        etPlaca = findViewById(R.id.etPlaca);
        btnVerificar = findViewById(R.id.btnVerificar);
        btnCancelar = findViewById(R.id.btnCancelar);

        // Obtener el tipo de acción (Entrada o Salida) del Intent
        String tipoAccion = getIntent().getStringExtra("TIPO_ACCION");
        if (tipoAccion != null) {
            txtTituloVerificacion.setText("Registrar " + tipoAccion);
        }

        // ===== INICIO DE LA LÓGICA DE FORMATO AUTOMÁTICO =====
        etPlaca.addTextChangedListener(new TextWatcher() {
            private boolean isFormatting; // Para evitar bucles infinitos
            private int deletingHyphen; // Para manejar el borrado de guiones
            private int hyphenStart;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Si estamos a punto de borrar un guión, necesitamos saberlo
                if (!isFormatting) {
                    final int deletedChar = start + count;
                    if (deletedChar == 4 || deletedChar == 8) {
                        deletingHyphen = deletedChar;
                        hyphenStart = start;
                    } else {
                        deletingHyphen = 0;
                    }
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No hace falta implementar nada aquí para este caso
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (isFormatting) {
                    return; // Si ya estamos formateando, salimos para evitar un bucle
                }
                isFormatting = true;

                // Si borramos un guión, también borramos el caracter anterior
                if (deletingHyphen > 0 && hyphenStart > 0 && s.length() == hyphenStart) {
                    s.delete(hyphenStart - 1, hyphenStart);
                }

                // Añadir guiones en las posiciones 3 y 7 (índices)
                if (s.length() == 3 || s.length() == 7) {
                    s.append('-');
                }

                isFormatting = false;
            }
        });
        // ===== FIN DE LA LÓGICA DE FORMATO AUTOMÁTICO =====

        // Configurar el botón "Verificar"
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placa = etPlaca.getText().toString().trim();

                // Validar que la placa tenga el formato completo
                if (placa.length() != 9) { // "XXX-XXX-X" tiene 9 caracteres
                    Toast.makeText(VerificarPlacaActivity.this, "El formato de la matrícula es incorrecto", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(VerificarPlacaActivity.this, "Verificando matrícula: " + placa, Toast.LENGTH_SHORT).show();
                    finish(); // Volver al Dashboard
                }
            }
        });

        // Configurar el botón "Cancelar"
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad y regresa al dashboard
            }
        });
    }
}
