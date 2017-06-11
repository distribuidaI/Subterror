package ar.edu.undav.subterror;

/**
 * Created by leo on 6/11/17.
 */

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SubterrorApplication.class);
    }

}
