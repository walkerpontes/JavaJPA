import CategoriaDAO.CategoriaDAO;
import ProdutoDAO.ProdutoDAO;
import com.walker.Categoria;
import com.walker.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrar();

        EntityManager em = JPAUtil.getEntityManager();


        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        List<Produto> buscarTodo = produtoDAO.buscarTodos();
        buscarTodo.forEach(p -> System.out.println(p.getNome()));




    }

    private static void cadastrar() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Samsung Galaxy", "Pika",new BigDecimal("1500"),celulares);

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        em.getTransaction().begin();

        categoriaDAO.cadastrar(celulares);
        produtoDAO.cadastra(celular);

        em.getTransaction().commit();
        em.close();

    }
}
