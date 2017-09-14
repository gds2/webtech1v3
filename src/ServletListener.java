import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Haal de ServletContext op
        ServletContext sc = sce.getServletContext();
        //Stop de model als attribuut in de serverContext
        Model model = Model.getInstance();
        sc.setAttribute("Model", model);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
