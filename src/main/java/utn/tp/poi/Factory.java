package utn.tp.poi;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import utn.tp.poi.model.BancoDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Factory {

    /**
     * Creates "BancoDTO" entries for given file in JSON format
     * @param filename
     * @return
     * @throws IOException
     */
    public Set<BancoDTO> createBancosFromConfig(String filename) throws IOException {
        Set<BancoDTO> result = new HashSet<>();

        final int BUFFER_SIZE = 1024;
        byte[] buffer = new byte[BUFFER_SIZE];
        int count;
        StringBuilder str = new StringBuilder();
        InputStream fis = null;

        try {
            fis = new FileInputStream(filename);
            count = fis.read(buffer);
            while (count > 0) {
                str.append(new String(buffer));
                count = fis.read(buffer);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        String json = str.toString();
        JsonParser parser = JsonParserFactory.getJsonParser();
        List<Map> map = (List) parser.parseList(json);

        for (Map bancoMap : map) {
            BancoDTO banco = new BancoDTO();
            banco.setBanco((String) bancoMap.get("banco"));
            banco.setSucursal((String) bancoMap.get("sucursal"));
            banco.setX(((Integer) bancoMap.get("x")).doubleValue());
            banco.setY(((Integer) bancoMap.get("x")).doubleValue());
            banco.setGerente((String) bancoMap.get("gerente"));
            Set servicios = new HashSet<>();
            servicios.addAll((Collection) bancoMap.get("servicios"));
            banco.setServicios(servicios);
            result.add(banco);
        }

        return result;
    }


}
