package utn.tp.poi.servlet;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utn.tp.poi.RepoBancos;
import utn.tp.poi.Resources;
import utn.tp.poi.model.BancoDTO;

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
        repoBancos = Resources.getInstance().getRepoBancos();
    }

    @RequestMapping(method = POST)
    public void crear(@RequestBody BancoDTO banco) {
        repoBancos.addItem(banco);
    }

    @RequestMapping(method = GET)
    public Set<BancoDTO> buscar(@RequestParam(value = "banco", defaultValue = "", required = false) String banco, @RequestParam(value = "servicio", defaultValue = "", required = false) String servicio) {
        return repoBancos.buscar(banco, servicio);
    }
}
