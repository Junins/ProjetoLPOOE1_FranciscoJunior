
import br.edu.ifsul.cc.lpoo.sistemacompeticaoesportiva.projetolpooe1_franciscojunior.dao.PersistenciaJPA;
import java.util.Arrays;
import java.util.Date;
import model.Funcionario;
import model.Projeto;
import model.Tarefa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestePersistencia {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistencia() {
    }
    
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }
    
        //@Test
        public void testePersistencia2() {
        Projeto p = new Projeto();
        p.setNome("Desenvolvimento de Sistema");
        p.setDescricao("Desenvolver sistema de gerenciamento de tarefas");
        
        Funcionario f1 = new Funcionario();
        f1.setNome("João");
        f1.setCargo("Dev");
        
        Funcionario f2 = new Funcionario();
        f2.setNome("Maria");
        f2.setCargo("Analista de Sistemas");
        
        p.setFuncionarios(Arrays.asList(f1,f2));
        
        Tarefa t1 = new Tarefa();
            t1.setDescricao("Desenvolvimento de Backend");
            t1.setProjeto(p);
            t1.setFuncionario(f1);
        
        
        Tarefa t2 = new Tarefa();
            t2.setDescricao("Análise de Requisitos");
            t2.setProjeto(p);
            t2.setFuncionario(f2);
                  
        try{
            jpa.persist(f1);
            jpa.persist(f2);
            jpa.persist(p);
            jpa.persist(t1);
            jpa.persist(t2);
            
            
        } catch(Exception e){
            System.err.println("Erro ao persistir modelo");
        }

    
}
}
