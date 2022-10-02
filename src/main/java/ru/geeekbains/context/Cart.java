package ru.geeekbains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository productRepository;

    @Autowired // заинжектили репосзиторий, т.е. добавили получается
    public void setRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String gettitleById (Long id)
    {
        return productRepository.findById(id).getTitle();
    }

    public void getProducts()
    {
        //productRepository.getProducts();
        //List<Product> products = productService.getProducts();
        System.out.println();
        for (Product product:productRepository.getProducts()
        ) {
            System.out.print(product.getTitle() + " ");
        }
    }

    public void addProduct(Product product)
    {
        productRepository.adProduct(product);
    }


}
