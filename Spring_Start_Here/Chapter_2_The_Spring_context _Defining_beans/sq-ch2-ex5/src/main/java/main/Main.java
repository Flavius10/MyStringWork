package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot x = new Parrot();

        x.setName("Kiki");

        Supplier<Parrot> parrotSupplier = () -> x;

        context.registerBean("parrot1", Parrot.class, parrotSupplier);

        Parrot p_programmatic = context.getBean("parrot1", Parrot.class);
        System.out.println(p_programmatic.getName());

        Parrot p_bean = context.getBean("parrot2",Parrot.class);
        System.out.println(p_bean.getName());
    }
}
