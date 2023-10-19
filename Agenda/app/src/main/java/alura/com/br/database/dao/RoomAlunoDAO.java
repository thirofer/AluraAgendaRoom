package alura.com.br.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import alura.com.br.ui.activity.model.Aluno;

@Dao
public interface RoomAlunoDAO {
    @Insert
    void salva(Aluno aluno);
    @Query("SELECT * FROM aluno")
    List<Aluno> todos();
    @Delete
    void remove(Aluno aluno);
    @Update
    void edita(Aluno aluno);
}
