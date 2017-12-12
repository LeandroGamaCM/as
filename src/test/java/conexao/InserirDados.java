package conexao;

import br.edu.ifba.as.entidades.analise.*;
import br.edu.ifba.as.entidades.formulario.*;
import br.edu.ifba.as.util.HibernateUtil;
import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InserirDados {
    Session sessao = null;

    public InserirDados(Session sessao) {
        this.sessao = sessao;
    }
    
    private BolsasAuxilio bolsasAuxilio = new BolsasAuxilio();
    
    public void CriarAluno(){
        Aluno aluno = new Aluno();
        aluno.setNome("João");
        aluno.setApelido("Jô");
        aluno.setCpf(155);
        aluno.setDataNascimento(new Date(System.currentTimeMillis()));
        aluno.setEmail("joao5@teste.com");
        aluno.setRg(155);
        aluno.setSenha("senha");
        aluno.setTelefone(111);
        
        aluno.setEndereco(criarEndereco(aluno));
        aluno.setConta(CriarConta(aluno));
        aluno.setBolsa(CriarBolsa(aluno));
        aluno.setCondicao_manutencao(CriarCondicaoManutencao(aluno));
//        List<Despesa> despesas = new ArrayList<Despesa>();
//        despesas.add(CriarDespesa(aluno));
//        aluno.setDespesas(despesas);
        CriarDespesa(aluno);
        
        sessao.save(aluno);
    }
    // O lado mais fraco puxa os dados
    public Bolsa CriarBolsa(Aluno aluno){
        Bolsa bolsa = new Bolsa();
        bolsa.setNome("Bolsa Alimentação");
        bolsa.setValor(100.00);
        sessao.save(bolsa);
        return bolsa;
    }
            
    public Endereco criarEndereco(Aluno aluno){
        Endereco endereco = new Endereco();
        endereco.setBairro("Bairrão");
        endereco.setCep(111111);
        endereco.setCidade("City");
        endereco.setEstado("Estadão");
        endereco.setNumero(0);
        endereco.setRua("dos bobos");
        endereco.setAluno(aluno);
        sessao.save(endereco);
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
        sessao.save(conta);
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
        sessao.save(cm);
        return cm;
    }
    
    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        InserirDados inserirDados = new InserirDados(sessao);
        Transaction transacao = sessao.beginTransaction();
        inserirDados.CriarAluno();
        
        transacao.commit();
        System.out.println("Cadastrou!");

    }
}
