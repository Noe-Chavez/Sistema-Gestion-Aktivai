package mx.com.uacm.aktivai.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UtileriaImagenesAvatar {

    static Logger logger = LoggerFactory.getLogger(UtileriaImagenesAvatar.class);

    public static String guardarArchivo(MultipartFile multipartFile, String uri) {

        String nombreOriginal = multipartFile.getOriginalFilename();

        try {
            File archivoImagen = new File(uri + nombreOriginal);
            logger.info("Archivo: " + archivoImagen.getAbsolutePath());
            // Guardar archivo en el sistema de almacenamiento permanente (HDD, SDD, etc)
            multipartFile.transferTo(archivoImagen);
            logger.info("multiPArtFile: " + multipartFile.getOriginalFilename());
            return nombreOriginal;
        } catch (IOException e) {
            logger.error("ERROR --> " + e.getMessage());
            return null;
        }

    }

}
