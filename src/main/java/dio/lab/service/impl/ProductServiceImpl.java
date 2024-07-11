package dio.lab.service.impl;

import dio.lab.model.Product;
import dio.lab.model.ProductRepository;
import dio.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.CommonsClientAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CommonsClientAutoConfiguration commonsClientAutoConfiguration;


    @Override
    public Iterable<Product> buscarTodos() {
        // buscar todos os produtos
        return productRepository.findAll();
    }

    @Override
    public Product buscarPorId(Long id) {
        // buscar produto por id
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    @Override
    public void inserir(Product product) {
          productRepository.save(product);
    }

    @Override
    public void alterar(Long id, Product product) {
        Optional<Product> productbd = productRepository.findById(id);
        if(productbd.isPresent()) {
            productRepository.save(product);
        }
    }

    @Override
    public void excluir(Long id) {
        productRepository.deleteById(id);
    }

}
