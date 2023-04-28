package activator;

import io.swagger.jaxrs.config.BeanConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class EmployeActivator extends Application {
    public EmployeActivator(){
        super();
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8089");
        beanConfig.setBasePath("JAX_RS_Swagger/api");
        beanConfig.setResourcePackage("ressources");
        beanConfig.setScan(true);
    }

}

