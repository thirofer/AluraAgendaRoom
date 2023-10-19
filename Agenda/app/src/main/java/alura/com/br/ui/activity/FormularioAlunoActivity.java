package alura.com.br.ui.activity;

import static alura.com.br.ui.activity.ConstantesActivities.CHAVE_ALUNO;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import alura.com.br.R;
import alura.com.br.dao.AlunoDAO;
import alura.com.br.database.AgendaDatabase;
import alura.com.br.database.dao.RoomAlunoDAO;
import alura.com.br.ui.activity.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private RoomAlunoDAO dao;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        AgendaDatabase database = AgendaDatabase.getInstance(this);
                dao = database.getRoomAlunoDAO();
        inicializacaoDosCampos();
        carregaAluno();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.activity_formulario_aluno_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_formulario_aluno_menu_salvar){
            finalizaFormulario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if (dados.hasExtra("aluno")) {
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
            preencheCampos();
        } else{
            aluno = new Aluno();
        }
    }

    private void preencheCampos() {
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }

    private void finalizaFormulario() {
        preencheAluno();
        if(aluno.temIdValido()){
            setTitle("EDITA ALUNO");
            dao.edita(aluno);
        } else {
            setTitle("CRIA ALUNO");
            dao.salva(aluno);
        }
        finish();
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

// --Commented out by Inspection START (22/11/2022 15:40):
//    private void salva(Aluno alunoCriado) {
//        dao.salva(alunoCriado);
//        startActivity(new Intent(FormularioAlunoActivity.this,
//                ListaAlunosActivity.class));
//        finish();
//    }
// --Commented out by Inspection STOP (22/11/2022 15:40)

    private void preencheAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }
}