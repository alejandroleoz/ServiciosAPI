package utn.tp.poi.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.MalformedURLException;
import java.net.URL;

public class InitHandler implements ServletContextListener {

    private DataInitializer dataInitializer = new DataInitializer();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        // init default data
        initBancosData(servletContextEvent);
        initCentrosData(servletContextEvent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void initBancosData(ServletContextEvent servletContextEvent) {
        try {
            URL configURL = null;
            configURL = servletContextEvent.getServletContext().getResource("/WEB-INF/resources/bancosConfig.json");
            this.dataInitializer.initBancosData(configURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void initCentrosData(ServletContextEvent servletContextEvent) {
        try {
            URL configURL = servletContextEvent.getServletContext().getResource("/WEB-INF/resources/centrosConfig.json");
            this.dataInitializer.initCentrosData(configURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
