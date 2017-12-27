package conexao;

import br.edu.ifba.as.entidades.analise.*;
import br.edu.ifba.as.entidades.formulario.*;
import br.edu.ifba.as.rn.AlunoRN;
import java.sql.Date;

public class InserirDados {
 
    private BolsasAuxilio bolsasAuxilio = new BolsasAuxilio();
    
    public void CriarAluno(){
        Aluno aluno = new Aluno();
        aluno.setNome("João");
        aluno.setApelido("Jô");
        aluno.setCpf(155);
        aluno.setDataNascimento(new Date(System.currentTimeMillis()));
        aluno.setEmail("joao5@teste.com");
        aluno.setRg(155);
        aluno.setTelefone(111);
        
        aluno.setEndereco(criarEndereco(aluno));
//        aluno.setConta(CriarConta(aluno));
//        aluno.setBolsa(CriarBolsa(aluno));
//        aluno.setCondicao_manutencao(CriarCondicaoManutencao(aluno));
//        List<Despesa> despesas = new ArrayList<Despesa>();
//        despesas.add(CriarDespesa(aluno));
//        aluno.setDespesas(despesas);
//        CriarDespesa(aluno);
        AlunoRN alunoRN = new AlunoRN();
        alunoRN.salvar(aluno);
    }
    // O lado mais fraco puxa os dados
    public Bolsa CriarBolsa(Aluno aluno){
        Bolsa bolsa = new Bolsa();
        bolsa.setNome("Bolsa Alimentação");
        bolsa.setValor(100.00);
        return bolsa;
    }
            
    public Endereco criarEndereco(Aluno aluno){
        Endereco endereco = new Endereco();
        endereco.setBairro("Bairrão");
        endereco.setCep(111);
        endereco.setCidade("City");
        endereco.setEstado("Estadão");
        endereco.setNumero(0);
        endereco.setRua("dos bobos");
        endereco.setAluno(aluno);
        return endereco;
    }

    public Conta CriarConta(Aluno aluno){
        Conta conta = new Conta();
        conta.setPossuiConta(true);
        conta.setAgencia("bb agency");
        conta.setAluno(aluno);
        conta.setContaCorrente(123);
        conta.setNomeBanco("bb");
        conta.setOperacao("Lava jato");
        conta.setAluno(aluno);
        return conta;
    }
    
    public Despesa CriarDespesa(Aluno aluno){
        Despesa despesa = new Despesa();      
        return despesa;
    }
    
    public CondicaoManutencao CriarCondicaoManutencao(Aluno aluno){
        CondicaoManutencao cm = new CondicaoManutencao();
        
        cm.setAluno(aluno);
        cm.setAmbosPais(true);
        cm.setApenasMae(false);
        cm.setApenasPai(false);
        cm.setAvos(false);
        cm.setOutrosParentes(false);
        return cm;
    }
    
    public static void main(String[] args) {
        InserirDados inserirDados = new InserirDados();
        inserirDados.CriarAluno();
        
        System.out.println("Cadastrou!");

    }
}
