package br.com.senaicimatec.agualife;

import java.io.Serializable;
public class Atleta implements Serializable {

    private Integer id;
    private String nome,peso,idade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override public String toString(){
        return "Id: " + id + " Nome: " + nome + " Peso: " + peso + " Idade: " + idade;
    }

}
