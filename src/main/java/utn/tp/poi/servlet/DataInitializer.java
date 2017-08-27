package utn.tp.poi.servlet;

import utn.tp.poi.Resources;
import utn.tp.poi.model.BancoDTO;
import utn.tp.poi.model.CentroDTO;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Set;

public class DataInitializer {

    public void initCentrosData(URL configURL) {
        Set<CentroDTO> centros = null;
        try {
            String filename = configURL.getFile();
            centros = Resources.getInstance().getFactory().createCentrosFromConfig(filename);
        } catch (Exception e) {
            e.printStackTrace();
            centros = Collections.emptySet();
        }
        Resources.getInstance().createRepoCentros(centros);
    }

    public void initBancosData(URL configURL) {
        Set<BancoDTO> bancos = null;
        String filename = configURL.getFile();
        try {
            bancos = Resources.getInstance().getFactory().createBancosFromConfig(filename);
        } catch (IOException e) {
            e.printStackTrace();
            bancos = Collections.emptySet();
        }
        Resources.getInstance().createRepoBancos(bancos);
    }
}
