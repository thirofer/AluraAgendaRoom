package alura.com.br.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import alura.com.br.database.dao.RoomAlunoDAO;
import alura.com.br.ui.activity.model.Aluno;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";

    public abstract RoomAlunoDAO getRoomAlunoDAO(Context context);
    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                .allowMainThreadQueries()
                .build();
    }

}
