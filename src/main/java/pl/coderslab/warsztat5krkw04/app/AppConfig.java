package pl.coderslab.warsztat5krkw04.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("pl.coderslab.warsztat5krkw04")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

}
