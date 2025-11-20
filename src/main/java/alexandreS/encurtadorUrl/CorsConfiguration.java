package alexandreS.encurtadorUrl;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // Aplica a todos os endpoints
        .allowedOrigins("*")
        .allowedMethods("GET", "POST")
        .allowedHeaders("*")
        .allowCredentials(false);
  }
}
