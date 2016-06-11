package utn.tp.poi.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utn.tp.poi.RepoBancos;
import utn.tp.poi.Resources;
import utn.tp.poi.model.BancoDTO;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/banco")
public class BancoAPI {

    private RepoBancos repoBancos;

    /**
     * Constructor
     * Setups some initial data
     */
    public BancoAPI(){
//        // init default data
//        Set<BancoDTO> bancos = null;
//        try {
//            bancos = Resources.getInstance().getFactory().createBancosFromConfig(FILENAME);
//        } catch (IOException e) {
//            e.printStackTrace();
//            bancos = Collections.emptySet();
//        }
//        repoBancos = new RepoBancos(bancos);
        repoBancos = Resources.getInstance().getRepoBancos();
    }

    @RequestMapping(method = POST)
    public void crear(@RequestBody BancoDTO banco) {
        repoBancos.addBanco(banco);
    }

    @RequestMapping(method = GET)
    public Set<BancoDTO> buscar(@RequestParam(value = "banco") String banco, @RequestParam(value = "servicio") String servicio) {
        return repoBancos.buscar(banco, servicio);
    }
}
