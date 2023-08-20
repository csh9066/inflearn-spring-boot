package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class AppIntV1Servlet implements AppInit {
    @Override
    public void onStartUp(ServletContext servletContext) {
        System.out.println("AppIntV1Servlet.onStartUp");

        ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet", new HelloServlet());
        helloServlet.addMapping("/hello-servlet");
    }
}
