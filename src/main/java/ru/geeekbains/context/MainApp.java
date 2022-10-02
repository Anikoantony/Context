package ru.geeekbains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // определяем контекс в package
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geeekbains.context");

        // подтягиваем бин Продуктсервиса
        Cart cart =context.getBean(Cart.class);

        System.out.println(cart.gettitleById(1L));

        cart.getProducts();

        cart.addProduct(new Product(6l,"Banana",45));
        cart.getProducts();

        Cart cart2 =context.getBean(Cart.class);
        cart2.getProducts();


        //context берется из packages
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geeekbains.context");

        // инициализируем коробку из контекста из бина Box'а.
        Box box=context.getBean(Box.class);
        System.out.println(box);
        box.setColor("red");
        System.out.println(box);
        Box box2 = context.getBean(Box.class);
        box2.setColor("Red");
        System.out.println(box2);

        box.setColor("Green");
        System.out.println(box);
        System.out.println(box2);*/

    }
}
