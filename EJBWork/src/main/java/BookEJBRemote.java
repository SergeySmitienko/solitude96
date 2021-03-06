

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by skeep on 26.03.2016.
 */

@Remote
public interface BookEJBRemote {
    List<Book> findBooks();
   @NotNull
   Book createBook(@NotNull Book book);
    void deleteBook(@NotNull Book book);
    @NotNull Book updateBook(@NotNull Book book);

}
