import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by skeep on 26.03.2016.
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.h2.Driver",
        name="java:global/jdbc/chapter08DS",
        databaseName = "chapter08DB",
        properties = {"connectionAttributes=;create=true"},
        url = "jdbc:h2:mem:"
)
public class DatabasePopulator {

    @Inject
    private BookEJB bookEJB;
    private Book h2g2;
    private Book lord;

    @PostConstruct
    private void populateDB(){
        h2g2 = new Book("Изучаем Java EE 7",35F,"Великая книга","1-8763-9125-7",605,true);
        lord = new Book("Властелин колец",50.4F,"Фэнтэзи","1-8793-9195-7",1216,true);
        bookEJB.createBook(h2g2);
        bookEJB.createBook(lord);
    }
    @PreDestroy
    private void clearDB(){
        bookEJB.deleteBook(h2g2);
        bookEJB.deleteBook(lord);
    }
}
