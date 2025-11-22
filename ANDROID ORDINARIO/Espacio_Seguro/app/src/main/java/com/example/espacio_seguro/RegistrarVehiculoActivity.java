package com.example.espacio_seguro;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
// Ya no necesitamos las importaciones de Firebase por ahora
// import com.google.firebase.database.DatabaseReference;
// import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistrarVehiculoActivity extends AppCompatActivity {

    // Vistas del layout (esto no cambia)
    private TextInputEditText etNombre, etApellido, etMatricula, etPlaca, etMarca, etModelo;
    private AutoCompleteTextView spAreaCarrera, spTipo;
    private MaterialButton btnRegistrar;
    private ImageButton btnClose; // <-- Declara la variable para el botón de cerrar
    // La referencia a Firebase Database se desactiva temporalmente
    // private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_vehiculo);

        // Se desactiva la inicialización de Firebase
        // mDatabase = FirebaseDatabase.getInstance().getReference();

        // El resto de la inicialización sigue igual
        initViews();
        setupSpinners();
        btnRegistrar.setOnClickListener(v -> registrarVehiculo());
    }

    private void initViews() {
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etMatricula = findViewById(R.id.etMatricula);
        etPlaca = findViewById(R.id.etPlaca);
        etMarca = findViewById(R.id.etMarca);
        etModelo = findViewById(R.id.etModelo);
        spAreaCarrera = findViewById(R.id.spAreaCarrera);
        spTipo = findViewById(R.id.spTipo);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnClose = findViewById(R.id.btnClose); // Vincula el botón de cerrar
        btnClose.setOnClickListener(v -> {
            finish(); // 'finish()' simplemente cierra la actividad actual
        });
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }

    private void setupSpinners() {
        String[] areas = new String[]{"Ingeniería", "Ciencias Sociales", "Artes", "Salud"};
        ArrayAdapter<String> areaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, areas);
        spAreaCarrera.setAdapter(areaAdapter);

        String[] tipos = new String[]{"Automóvil", "Motocicleta", "Bicicleta"};
        ArrayAdapter<String> tipoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, tipos);
        spTipo.setAdapter(tipoAdapter);
    }

    /**
     * Recopila los datos, los valida y SIMULA el registro exitoso.
     */
    private void registrarVehiculo() {
        String nombre = etNombre.getText().toString().trim();
        String apellido = etApellido.getText().toString().trim();
        String matricula = etMatricula.getText().toString().trim();
        String placa = etPlaca.getText().toString().trim().toUpperCase();
        String areaCarrera = spAreaCarrera.getText().toString();
        String tipo = spTipo.getText().toString();

        // La validación sigue siendo importante para probar la UI
        if (nombre.isEmpty() || apellido.isEmpty() || matricula.isEmpty() || placa.isEmpty() || areaCarrera.isEmpty() || tipo.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // --- LÓGICA DE FIREBASE DESACTIVADA ---
        /*
        DatabaseReference vehiculoRef = mDatabase.child("vehiculos").child(matricula);
        Map<String, Object> vehiculoData = new HashMap<>();
        // ... (aquí iría el .put de todos los datos)
        vehiculoRef.setValue(vehiculoData).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // ...
            } else {
                // ...
            }
        });
        */

        // --- SIMULACIÓN DE ÉXITO ---
        // Mostramos un mensaje de éxito y cerramos la pantalla,
        // como si se hubiera guardado correctamente.
        Toast.makeText(this, "Vehículo registrado (simulación)", Toast.LENGTH_LONG).show();
        finish(); // Cierra la actividad y vuelve al Dashboard
    }
}

