import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by skeep on 26.03.2016.
 */
public class DatabaseProducer {

    @Produces
    @PersistenceContext(unitName = "chapter08PU")
    private EntityManager em;




}
