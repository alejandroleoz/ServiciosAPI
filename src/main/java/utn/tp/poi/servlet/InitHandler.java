package utn.tp.poi.servlet;

import utn.tp.poi.Factory;
import utn.tp.poi.Resources;
import utn.tp.poi.model.BancoDTO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;
import java.util.Collections;
import java.util.Set;

public class InitHandler implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        // init default data
        Set<BancoDTO> bancos = null;
        try {
            URL configURL = servletContextEvent.getServletContext().getResource("/WEB-INF/resources/bancosConfig.json");
            String filename = configURL.getFile();
            bancos = Factory.getInstance().createBancosFromConfig(filename);
        } catch (Exception e) {
            e.printStackTrace();
            bancos = Collections.emptySet();
        }
        Resources.getInstance().createRepoBancos(bancos);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
