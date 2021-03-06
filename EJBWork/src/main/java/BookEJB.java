

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by skeep on 26.03.2016.
 */
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

    @Inject
    private EntityManager em;
    public List<Book> findBooks() {
        TypedQuery<Book> query = em.createNamedQuery("Book.findAllBooks",Book.class);
        return query.getResultList();
    }

    public @NotNull Book createBook(@NotNull Book book) {
        em.persist(book);
        return book;
    }

    public void deleteBook(@NotNull Book book) {
        em.remove(em.merge(book));
    }

    public @NotNull Book updateBook(@NotNull Book book) {
        return em.merge(book);
    }
}
