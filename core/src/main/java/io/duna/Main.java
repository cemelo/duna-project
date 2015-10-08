package io.duna;

import io.duna.server.Application;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletInfo;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;

import javax.servlet.ServletException;

/**
 * Created by carlos on 29/09/15.
 */
public class Main {
    public static void main(String[] args) throws ServletException {
        ServletInfo servletInfo = Servlets.servlet(Application.class.getName(), ServletContainer.class)
                .setLoadOnStartup(0)
                .setAsyncSupported(true)
                .setEnabled(true)
                .addMapping("/*")
                .addInitParam(ServletProperties.JAXRS_APPLICATION_CLASS, Application.class.getName());

        DeploymentInfo servletBuilder = Servlets.deployment()
                .setClassLoader(Main.class.getClassLoader())
                .setResourceManager(new ClassPathResourceManager(Main.class.getClassLoader()))
                .setContextPath("/")
                .setDeploymentName("test.war")
                .addServlet(servletInfo);

        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();

        HttpHandler servletHandler = manager.start();
        PathHandler path = Handlers.path(Handlers.redirect("/")).addPrefixPath("/", servletHandler);
        Undertow server = Undertow.builder().addHttpListener(8080, "localhost").setHandler(path).build();
        server.start();
    }
}
