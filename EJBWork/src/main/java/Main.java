import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

/**
 * Created by skeep on 27.03.2016.
 */
public class Main {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        BookEJBRemote bookEJB = (BookEJBRemote)ctx.lookup("java:global/EJBWork/BookEJB!BookEJBRemote");
        List<Book> books = bookEJB.findBooks();
        for (Book aBook:books){
            System.out.println(aBook);
        }


    }
}
