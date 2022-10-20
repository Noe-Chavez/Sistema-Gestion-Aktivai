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

        if (nombreOriginal != null)
            nombreOriginal = nombreOriginal.replace(" ", "-");// Remplazando espacios por guiones medios en caso de que se suba una imagen con espacios en el nombre.

        String nombreFinal = alfaNumericoAleatorio(8) + nombreOriginal;

        try {
            File archivoImagen = new File(uri + nombreFinal);
            logger.info("Archivo: " + archivoImagen.getAbsolutePath());
            // Guardar archivo en el sistema de almacenamiento permanente (HDD, SDD, etc)
            multipartFile.transferTo(archivoImagen);
            logger.info("multiPArtFile: " + multipartFile.getOriginalFilename());
            return nombreFinal;
        } catch (IOException e) {
            logger.error("ERROR --> " + e.getMessage());
            return null;
        }

    }

    public static String alfaNumericoAleatorio(int cantidadCaracteresAlfaNumericos) {
        final String CARACTERES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        while (cantidadCaracteresAlfaNumericos-- != 0) {
            int caracter = (int) (Math.random() * CARACTERES.length());
            stringBuilder.append(CARACTERES.charAt(caracter));
        }
        return stringBuilder.toString();
    }

}
