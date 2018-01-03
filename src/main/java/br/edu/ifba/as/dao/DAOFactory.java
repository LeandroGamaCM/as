package br.edu.ifba.as.dao;

import br.edu.ifba.as.util.HibernateUtil;

public class DAOFactory {
    public static AlunoDAO criarAlunoDAO(){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return alunoDAO;
    }
    public static UsuarioDAO criarUsuarioDAO(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDAO;
    }
    public static EnderecoDAO criarEnderecoDAO(){
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return enderecoDAO;
    }
    public static EntrevistaDAO criarEntrevistaDAO(){
        EntrevistaDAO entrevistaDAO = new EntrevistaDAO();
        entrevistaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return entrevistaDAO;
    }
    public static BolsasAuxilioDAO criarBolsasAuxilioDAO(){
        BolsasAuxilioDAO bolsasAuxilioDAO = new BolsasAuxilioDAO();
        bolsasAuxilioDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return bolsasAuxilioDAO;
    }
    public static CondicaoManutencaoDAO criarCondicaoManutencaoDAO(){
        CondicaoManutencaoDAO condicaoManutencaoDAO = new CondicaoManutencaoDAO();
        condicaoManutencaoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return condicaoManutencaoDAO;
    }
    public static ContaDAO criarContaDAO(){
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return contaDAO;
    }
    public static DependentesDAO criarDependentesDAO(){
        DependentesDAO dependentesDAO = new DependentesDAO();
        dependentesDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return dependentesDAO;
    }
    public static FamiliaDAO criarFamiliaDAO(){
        FamiliaDAO familiaDAO = new FamiliaDAO();
        familiaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return familiaDAO;
    }
    public static FormularioDAO criarFormularioDAO(){
        FormularioDAO formularioDAO = new FormularioDAO();
        formularioDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return formularioDAO;
    }
    public static ImovelDAO criarImovelDAO(){
        ImovelDAO imovelDAO = new ImovelDAO();
        imovelDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return imovelDAO;
    }
    public static DespesaDAO criarDespesaDAO(){
        DespesaDAO despesaDAO = new DespesaDAO();
        despesaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return despesaDAO;
    }
    public static DespesasCampusDAO criarDespesasCampusDAO(){
        DespesasCampusDAO despesasCampusDAO = new DespesasCampusDAO();
        despesasCampusDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return despesasCampusDAO;
    }
    public static InformacoesCurricularesDAO criarInformacoesCurricularesDAO(){
        InformacoesCurricularesDAO informacoesCurricularesDAO = new InformacoesCurricularesDAO();
        informacoesCurricularesDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return informacoesCurricularesDAO;
    }
    public static OcupacaoDAO criarOcupacaoDAO(){
        OcupacaoDAO ocupacaoDAO = new OcupacaoDAO();
        ocupacaoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return ocupacaoDAO;
    }
    public static ResidenciaDAO criarResidenciaDAO(){
        ResidenciaDAO residenciaDAO = new ResidenciaDAO();
        residenciaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return residenciaDAO;
    }
    public static SituacaoResidencialDAO criarSituacaoResidencialDAO(){
        SituacaoResidencialDAO situacaoResidencialDAO = new SituacaoResidencialDAO();
        situacaoResidencialDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return situacaoResidencialDAO;
    }
    public static ResidenciaFamiliaDAO criarResidenciaFamiliaDAO(){
        ResidenciaFamiliaDAO residenciaFamiliaDAO = new ResidenciaFamiliaDAO();
        residenciaFamiliaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return residenciaFamiliaDAO;
    }
    public static MembroFamiliarDAO criarMembroFamiliarDAO(){
        MembroFamiliarDAO membroFamiliarDAO = new MembroFamiliarDAO();
        membroFamiliarDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return membroFamiliarDAO;
    }
    public static RendaDAO criarRendaDAO(){
        RendaDAO rendaDAO = new RendaDAO();
        rendaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return rendaDAO;
    }
    public static DoencaDAO criarDoencaDAO(){
        DoencaDAO doencaDAO = new DoencaDAO();
        doencaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return doencaDAO;
    }
    public static TurmaDAO criarTurmaDAO(){
        TurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return turmaDAO;
    }
}
