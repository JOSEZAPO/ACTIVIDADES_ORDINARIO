package com.example.espacio_seguro;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

// Si decides usar Firebase, descomenta estas líneas
// import com.google.firebase.auth.FirebaseAuth;
// import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {

    // 1. Declaración de todos los botones
    private Button btnNuevoVehiculo, btnEntrada, btnSalida, btnCerrarSesion, btnVerVehiculos;

    // Si decides usar Firebase, descomenta esta línea
    // private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Si decides usar Firebase, descomenta este bloque
        /*
        mAuth = FirebaseAuth.getInstance();
        FirebaseAuth.AuthStateListener mAuthListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user == null) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        };
        mAuth.addAuthStateListener(mAuthListener);
        */

        // 2. Vinculación de TODOS los botones con sus IDs del layout
        btnNuevoVehiculo = findViewById(R.id.btnNuevoVehiculo);
        btnEntrada = findViewById(R.id.btnEntrada);
        btnSalida = findViewById(R.id.btnSalida);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        btnVerVehiculos = findViewById(R.id.btnVerVehiculos); // Importante: Asegúrate de tener este ID en tu XML.

        // --- Asignación de Listeners (acciones) a cada botón ---

        // Listener para "Nuevo Vehículo"
        btnNuevoVehiculo.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, RegistrarVehiculoActivity.class);
            startActivity(intent);
        });

        // Listener para "Entrada" (AHORA FUNCIONARÁ)
        btnEntrada.setOnClickListener(v -> {
            // Inicia la actividad para verificar la placa, indicando que es una "Entrada"
            Intent intent = new Intent(DashboardActivity.this, VerificarPlacaActivity.class);
            intent.putExtra("TIPO_ACCION", "Entrada");
            startActivity(intent);
        });

        // Listener para "Salida" (AHORA FUNCIONARÁ)
        btnSalida.setOnClickListener(v -> {
            // Inicia la actividad para verificar la placa, indicando que es una "Salida"
            Intent intent = new Intent(DashboardActivity.this, VerificarPlacaActivity.class);
            intent.putExtra("TIPO_ACCION", "Salida");
            startActivity(intent);
        });

        // Listener para "Ver Vehículos"
        btnVerVehiculos.setOnClickListener(v -> {
            // Aquí irá la lógica para ver los vehículos.
            Toast.makeText(DashboardActivity.this, "Función 'Ver Vehículos' no implementada.", Toast.LENGTH_SHORT).show();
        });


        // Listener para "Cerrar Sesión" CON DIÁLOGO DE CONFIRMACIÓN (AHORA FUNCIONARÁ)
        btnCerrarSesion.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
            builder.setTitle("Confirmar Cierre de Sesión");
            builder.setMessage("¿Estás seguro de que deseas cerrar sesión?");
            // Opcional: añade un ícono. Asegúrate de tener 'ic_warning' en 'res/drawable'.
            // builder.setIcon(R.drawable.ic_warning);

            builder.setPositiveButton("Sí", (dialog, which) -> {
                // Si decides usar Firebase, descomenta la siguiente línea
                // if (mAuth != null) { mAuth.signOut(); }

                Toast.makeText(DashboardActivity.this, "Sesión cerrada", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            });

            builder.setNegativeButton("No", (dialog, which) -> {
                dialog.dismiss(); // Cierra el diálogo si el usuario dice "No"
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    // Los métodos onStart y onStop solo son necesarios si usas el AuthStateListener de Firebase.
    // Si no lo usas, puedes mantenerlos comentados o eliminarlos.
    /*
    @Override
    protected void onStart() {
        super.onStart();
        // Si usas el listener, necesitas la variable mAuthListener a nivel de clase
        // mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // if (mAuthListener != null) {
        //     mAuth.removeAuthStateListener(mAuthListener);
        // }
    }
    */
}
