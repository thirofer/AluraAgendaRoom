package alura.com.br.ui;

import android.app.AlertDialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import alura.com.br.dao.AlunoDAO;
import alura.com.br.database.AgendaDatabase;
import alura.com.br.database.dao.RoomAlunoDAO;
import alura.com.br.ui.activity.model.Aluno;
import alura.com.br.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de pessoas";
    private ListaAlunosView adapter;
    private final RoomAlunoDAO dao;
    private Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunosView(context);
        dao = AgendaDatabase.getInstance(context)
                .getRoomAlunoDAO();
    }

        public void confirmaRemocao(final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo Aluno")
                .setMessage("Tem certeza que quer remover?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AdapterView.AdapterContextMenuInfo menuInfo =
                                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                        Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                        remove(alunoEscolhido);
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter((ListAdapter) adapter);
    }

    public void atualizaAlunos() {
    }
}
