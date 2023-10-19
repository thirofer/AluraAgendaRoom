package alura.com.br;

import android.app.Application;
import android.arch.persistence.room.Room;


import alura.com.br.dao.AlunoDAO;
import alura.com.br.database.AgendaDatabase;
import alura.com.br.database.dao.RoomAlunoDAO;
import alura.com.br.ui.activity.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void criaAlunosDeTeste() {
        //Uso do Room
        AgendaDatabase database = Room
                .databaseBuilder(this, AgendaDatabase.class, "agenda.db")
                .allowMainThreadQueries()
                .build();
        RoomAlunoDAO dao = database.getRoomAlunoDAO();
        // Uso sem DAO, manual
        //AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Thiago", "22222222", "abc@abc.com"));
        dao.salva(new Aluno("Aluno 2", "33333333", "def@abc.com"));
        dao.salva(new Aluno("Alex", "1122223333", "alex@alura.com.br"));
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}
