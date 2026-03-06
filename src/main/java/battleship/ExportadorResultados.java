package battleship;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExportadorResultados {

    public static void guardarResultado(ResultadoJogo resultado) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("resultado.json"), resultado);
            System.out.println("Resultado guardado em resultado.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}