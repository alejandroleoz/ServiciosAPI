package utn.tp.poi.servlet;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utn.tp.poi.RepoCentros;
import utn.tp.poi.Resources;
import utn.tp.poi.model.CentroDTO;

import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/centro")
public class CentroAPI {

    private RepoCentros repoCentros;

    /**
     * Constructor
     * Setups some initial data
     */
    public CentroAPI(){
        repoCentros = Resources.getInstance().getRepoCentros();
    }

    @RequestMapping(method = POST)
    public void crear(@RequestBody CentroDTO centro) {
        repoCentros.addItem(centro);
    }

    @RequestMapping(method = GET)
    public Set<CentroDTO> buscar(@RequestParam(value = "zona") String zona) {
        return repoCentros.buscar(zona);
    }
}
