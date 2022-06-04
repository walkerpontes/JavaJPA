package ProdutoDAO;

import com.walker.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {
    private EntityManager em;
    public ProdutoDAO(EntityManager em){
        this.em=em;
    }
    public void cadastra(Produto produto){
        this.em.persist(produto);
    }
     public Produto buscarPorId(Long id){
       return em.find(Produto.class, id);
     }
     public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p";
       return em.createQuery(jpql, Produto.class).getResultList();
     }























































}
