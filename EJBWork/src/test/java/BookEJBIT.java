import junit.framework.Assert;
import org.junit.Test;


import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by skeep on 26.03.2016.
 */
public class BookEJBIT {
    @Test
    public void shouldCreateBook() throws NamingException {
        Map<String,Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES,new File("target/classes"));
        EJBContainer ec = EJBContainer.createEJBContainer(properties);
        try{

            Context ctx = ec.getContext();
            assertNotNull(ctx.lookup("java:global/jdbc/chapter08DS"));
            assertNotNull(ctx.lookup("java:global/classes/BookEJB!BookEJBRemote"));
            assertNotNull(ctx.lookup("java:global/classes/BookEJB!BookEJB"));
            BookEJB bookEJB = (BookEJB)ctx.lookup("java:global/classes/BookEJB!BookEJB");
            assertEquals(2,bookEJB.findBooks().size());

            Book book = new Book("H2G2",35F,"Научная фантастика","1-8763-9125-7",605,true);
            book=bookEJB.createBook(book);
            assertNotNull("ID не пусто",book.getId());
            assertEquals(3,bookEJB.findBooks().size());
            bookEJB.deleteBook(book);
            assertEquals(2,bookEJB.findBooks().size());


        }
        finally {
            ec.close();
        }

    }

}
