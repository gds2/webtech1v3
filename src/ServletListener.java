import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext sc = sce.getServletContext();
        Model model = Model.getInstance();
        sc.setAttribute("Model", model);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
