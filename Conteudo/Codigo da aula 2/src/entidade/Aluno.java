package entidade;

import util.Data; //importa a classe Data do pacote util (criada por nos)

public class Aluno {
  
    private String nome, rg, cpf;
    private char sexo;

    //quando for chamar o construtor é necessario chamar o construtor de Data e Endereço dentro do construtor de Aluno
    private Data nascimentoData;
    private Endereço alunoEndereço;
   
   //metodo construtor de Aluno inicializa todos os campos
    public Aluno(String nome, String rg, String cpf, Data nascimentoData, char sexo, Endereço alunoEndereço) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.nascimentoData = nascimentoData;
        this.sexo = sexo;
        this.alunoEndereço = alunoEndereço;
    }

    public String getNome() {
      return nome;
    }

    public String getRg() {
      return rg;
    }

    public String getCpf() {
      return cpf;
    }

    public Data getDataNascimento() {
      return nascimentoData;
    }

    public char getSexo() {
      return sexo;
    }

    public Endereço getEndereço() {
      return alunoEndereço;
    }

    public void setEndereço(Endereço alunoEndereço) {
      this.alunoEndereço = alunoEndereço;
    }
    //converte os char (intuitivo) para uma string (visualmente mais apresentavel)
    public String toStringSexo() {
        if ((sexo == 'M') || (sexo == 'm')) return "masculino";
        if ((sexo == 'F') || (sexo == 'f')) return "feminino";
        return "indefinido";
    }
    
    public String toString() {
        return nome + " - RG:" + rg + " - CPF:" + cpf + " - nascimento:" + nascimentoData + " - sexo:" + toStringSexo() + "\n" + alunoEndereço.toString(); //na classe Endereço ha o metodo que converte o endereco em string
    }
}