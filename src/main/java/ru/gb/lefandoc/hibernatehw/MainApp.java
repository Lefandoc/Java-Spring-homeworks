package ru.gb.lefandoc.hibernatehw;

public class MainApp {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
        productDao.saveOrUpdate(new Product("Eggs", 94));
        productDao.findAll().forEach(System.out::println);
        productDao.saveOrUpdate(new Product(4L,"Eggs", 999));
        productDao.findAll().forEach(System.out::println);
        productDao.deleteById(4L);
        productDao.findAll().forEach(System.out::println);
    }

}
