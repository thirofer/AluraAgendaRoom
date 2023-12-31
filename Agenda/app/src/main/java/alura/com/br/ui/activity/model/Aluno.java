package alura.com.br.ui.activity.model;

import androidx.annotation.NonNull;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Aluno implements Serializable {
    @PrimaryKey (autoGenerate = true)
    private int id = 0;
    private String nome;
    private String telefone;
    private String email;
//    private Calendar momentoDeCadastro = Calendar.getInstance();
//
//    public Calendar getMomentoDeCadastro() {
//        return momentoDeCadastro;
//    }
//
//    public void setMomentoDeCadastro(Calendar momentoDeCadastro) {
//        this.momentoDeCadastro = momentoDeCadastro;
//    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }



    //Esse construtor perde a referência
    @Ignore
    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Aluno() {

    }
    /*
        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNome() {
            return nome;
        }

        public String getTelefone() {
            return telefone;
        }

        public String getEmail() {
            return email;
        }
    */
    @NonNull
    @Override
    public String toString() {
        return nome + " - " + telefone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return id > 0;
    }

    public int getID() {
        return id;
    }
}
