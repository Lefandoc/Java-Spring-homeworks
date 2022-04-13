package ru.gb.lefandoc.springintrohw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.lefandoc.springintrohw.configuration.AppConfig;
import ru.gb.lefandoc.springintrohw.model.Product;
import ru.gb.lefandoc.springintrohw.service.ProductService;

import java.util.List;
import java.util.Scanner;

import static ru.gb.lefandoc.springintrohw.utils.CommandsUtil.*;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean(ProductService.class);
        Cart cart = context.getBean(Cart.class);

        boolean isWorking = true;
        try {
            printHelp();
            Scanner scanner = new Scanner(System.in);
            while (isWorking) {
                String read = scanner.nextLine();
                if (read.startsWith(LIST)) {
                    List<Product> products = productService.getProducts();
                    products.forEach(System.out::println);
                }
                if (read.startsWith(CART)) {
                    List<Product> cartProducts = cart.lookInCart();
                    if (cartProducts.isEmpty()) {
                        System.out.println("Oops! В корзине пусто");
                        continue;
                    }
                    cartProducts.forEach(System.out::println);
                }
                if (read.startsWith(PUT)) {
                    String id = read.split(".*\\s*[^0-9]")[1]; // любое кол-во пробелов
                    if (!cart.putProduct(Integer.parseInt(id))) {
                        System.err.println("Неверный ID продукта");
                    }
                }
                if (read.startsWith(DEL)) {
                    String id = read.split(".*\\s*[^0-9]")[1]; // любое кол-во пробелов
                    if (!cart.removeProduct(Integer.parseInt(id))) {
                        System.err.println("Неверный ID продукта");
                    }
                }
                if (read.startsWith(EXIT)) {
                    System.out.println("Завершение работы приложения...");
                    isWorking = false;
                }
                if (read.startsWith(HELP)) {
                    printHelp();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printHelp() {
        System.out.println("Выберите команду:");
        System.out.println("/list - Просмотр списка продуктов");
        System.out.println("/cart - Просмотр корзины");
        System.out.println("/put id - Положить продукт в корзину");
        System.out.println("/del id - Убрать продукт из корзины");
        System.out.println("/exit - Завершить работу");
        System.out.println("/help - Отобразить список команд\n");
    }

}
