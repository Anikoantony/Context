package ru.geeekbains.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope("prototype")
public class ProductRepository {

    private List<Product> products;



    @PostConstruct
    public void init()
    {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L,"Bread",50),
                new Product(2L,"Milk",80),
                new Product(3L,"Orange",110),
                new Product(4L,"Milk",90),
                new Product(5L,"Orange",100)
        ));
    }

    public Product findById (Long id)
    {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void adProduct (Product product)
    {
        products.add(product);
    }

    public void removeProductbyId (Long id)
    {
        products.remove(products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow());
    }


}
