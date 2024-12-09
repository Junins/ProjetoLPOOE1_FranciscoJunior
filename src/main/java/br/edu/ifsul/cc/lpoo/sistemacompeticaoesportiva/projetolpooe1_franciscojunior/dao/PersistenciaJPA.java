package br.edu.ifsul.cc.lpoo.sistemacompeticaoesportiva.projetolpooe1_franciscojunior.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Departamento;
import model.Funcionario;
import model.Projeto;
import model.Tarefa;

public class PersistenciaJPA implements InterfaceBD {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory
                = Persistence.createEntityManagerFactory("pu_projetolpooe1_franciscojunior");
        //conecta no bd e executa a estratégia de geração.
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {

        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            }
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao persistir a entidade: " + o.getClass().getSimpleName(), e);
            e.printStackTrace(); // Isso imprimirá o erro completo no console
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o); // Garantir que o objeto está no contexto de persistência
            }
            entity.remove(o); // Remover o objeto
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao remover entidade: " + o.getClass().getSimpleName());
            e.printStackTrace();
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    /*
    Todos os métodos agora chamam getEntityManager() 
    para garantir que o EntityManager esteja sempre aberto e 
    pronto para uso.
     */
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    public List<Funcionario> getFuncionarios() {
        entity = getEntityManager();

        try {
            TypedQuery<Funcionario> query
                    = entity.createQuery("Select f from Funcionario f", Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionarios: " + e);
            return null;
        }

    }

    public List<Funcionario> getFuncionarios(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Funcionario> query
                    = entity.createQuery("Select f from Funcionario f where lower(f.nome) LIKE :n",
                            Funcionario.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionarios: " + e);
            return null;
        }

    }
    
    public List<Projeto> getProjetos() {
        entity = getEntityManager();

        try {
            TypedQuery<Projeto> query
                    = entity.createQuery("Select p from Projeto p", Projeto.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Projetos: " + e);
            return null;
        }

    }

    public List<Projeto> getProjetos(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Projeto> query
                    = entity.createQuery("Select p from Projeto p where lower(p.nome) LIKE :n",
                            Projeto.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Projetos: " + e);
            return null;
        }

    }
    
    public List<Tarefa> getTarefas() {
        entity = getEntityManager();

        try {
            TypedQuery<Tarefa> query
                    = entity.createQuery("Select t from Tarefa t", Tarefa.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Tarefas: " + e);
            return null;
        }

    }

    public List<Tarefa> getTarefas(String descricao) {
        entity = getEntityManager();

        try {
            TypedQuery<Tarefa> query
                    = entity.createQuery("Select t from Tarefa t where lower(t.descricao) LIKE :d",
                            Tarefa.class);
            query.setParameter("d", "%" + descricao.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Tarefas: " + e);
            return null;
        }

    }
        
    public List<Departamento> getDepartamentos() {
        entity = getEntityManager();

        try {
            TypedQuery<Departamento> query
                    = entity.createQuery("Select d from Departamento d", Departamento.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Departamento: " + e);
            return null;
        }

    }

    public List<Departamento> getDepartamentos(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Departamento> query
                    = entity.createQuery("Select d from Departamento d where lower(d.nome) LIKE :n",
                            Departamento.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Departamento: " + e);
            return null;
        }

    }
    
}
