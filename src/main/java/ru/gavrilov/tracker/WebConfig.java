package ru.gavrilov.tracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/items/all").setViewName("listItems");
//        registry.addViewController("/items/add").setViewName("addItem");
//        //registry.addViewController("/items/{id}").setViewName("showItem");
//        registry.addViewController("/items/search").setViewName("search");
    }
}
