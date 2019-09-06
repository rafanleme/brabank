package br.com.senai.cursoandroid.brabank.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;

import br.com.senai.cursoandroid.brabank.R;
import br.com.senai.cursoandroid.brabank.model.UsuarioDAO;
import br.com.senai.cursoandroid.brabank.model.entity.Usuario;

public class NovoUsuarioActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText edtNome, edtCpf, edtEmail, edtSenha, edtConfSenha;
    RadioGroup rgSexo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        edtNome = findViewById(R.id.edtNome);
        edtCpf = findViewById(R.id.edtCpf);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfSenha = findViewById(R.id.edtConfirmarSenha);
        rgSexo = findViewById(R.id.rgSexo);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Novo Usuário");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //método responsável por inflar o menu na actionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.btnMenuSalvar:
                salvar();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void salvar(){
        if(validar()){
            Random random = new Random();
            Integer id = random.nextInt();
            String sexo;
            if(rgSexo.getCheckedRadioButtonId() == R.id.rbMasculino)
                sexo = "M";
            else
                sexo = "F";

            Usuario u = new Usuario(
                    id,
                    edtNome.getText().toString(),
                    edtCpf.getText().toString(),
                    edtEmail.getText().toString(),
                    edtSenha.getText().toString(),
                    sexo
            );

            UsuarioDAO uDao = new UsuarioDAO();
            if(uDao.inserir(u)) {
                Toast.makeText(this, "Usuário inserido com sucesso!",
                        Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, "Algo deu errado",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean validar(){
        boolean validado = true;
        if(edtNome.getText().toString().equals("")){
            edtNome.setError("Campo obrigatório");
            validado = false;
        }
        if(edtCpf.getText().toString().equals("")){
            edtCpf.setError("Campo obrigatório");
            validado = false;
        }
        if(edtEmail.getText().toString().equals("")){
            edtEmail.setError("Campo obrigatório");
            validado = false;
        }
        if(edtSenha.getText().toString().equals("")){
            edtSenha.setError("Campo obrigatório");
            validado = false;
        }
        if(edtConfSenha.getText().toString().equals("")){
            edtConfSenha.setError("Campo obrigatório");
            validado = false;
        }

        //validação confirmar senha
        if(validado){
            String senha = edtSenha.getText().toString();
            String confSenha = edtConfSenha.getText().toString();
            if(!senha.equals(confSenha)){
                edtConfSenha.setError("As senhas devem ser iguais");
                validado = false;
            }
        }

        return validado;
    }
}
