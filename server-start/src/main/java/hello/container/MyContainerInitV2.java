package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@HandlesTypes(AppInit.class)
public class MyContainerInitV2 implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyContainerInitV2.onStartup");
        System.out.println("c = " + c);
        for (Class<?> aClass : c) {
            try {
                AppInit instance = (AppInit) aClass.getDeclaredConstructor().newInstance();
                instance.onStartUp(ctx);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } 
        }
    }
}
