package utn.tp.poi.servlet;

import utn.tp.poi.Factory;
import utn.tp.poi.Resources;
import utn.tp.poi.model.BancoDTO;
import utn.tp.poi.model.CentroDTO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;
import java.util.Collections;
import java.util.Set;

public class InitHandler implements ServletContextListener {

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
        Set<BancoDTO> bancos = null;
        try {
            URL configURL = servletContextEvent.getServletContext().getResource("/WEB-INF/resources/bancosConfig.json");
            String filename = configURL.getFile();
            bancos = Resources.getInstance().getFactory().createBancosFromConfig(filename);
        } catch (Exception e) {
            e.printStackTrace();
            bancos = Collections.emptySet();
        }
        Resources.getInstance().createRepoBancos(bancos);
    }

    private void initCentrosData(ServletContextEvent servletContextEvent) {
        Set<CentroDTO> centros = null;
        try {
            URL configURL = servletContextEvent.getServletContext().getResource("/WEB-INF/resources/centrosConfig.json");
            String filename = configURL.getFile();
            centros = Resources.getInstance().getFactory().createCentrosFromConfig(filename);
        } catch (Exception e) {
            e.printStackTrace();
            centros = Collections.emptySet();
        }
        Resources.getInstance().createRepoCentros(centros);
    }


}
