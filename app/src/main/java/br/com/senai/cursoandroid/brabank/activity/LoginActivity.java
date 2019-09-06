package br.com.senai.cursoandroid.brabank.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import br.com.senai.cursoandroid.brabank.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNovoUsuario;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnNovoUsuario = findViewById(R.id.btnNovoUsuario);
        btnNovoUsuario.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NovoUsuarioActivity.class);
        startActivity(intent);
    }
}
