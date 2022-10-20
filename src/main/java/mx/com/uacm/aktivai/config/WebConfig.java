package mx.com.uacm.aktivai.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${aktivai.ruta.avatars}")
    private String rutaAvatars;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/avatars/**").addResourceLocations("file:" + rutaAvatars);
        //registry.addResourceHandler("/avatars/**").addResourceLocations("file:/aktivai/img-avatars/"); // Linux
        //registry.addResourceHandler("/avatars/**").addResourceLocations("file:c:/aktivai/img-avatars/"); // Windows
    }

}
