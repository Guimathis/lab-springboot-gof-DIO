package dio.lab.service;

import dio.lab.model.Product;

public interface ProductService {
    Iterable<Product> buscarTodos();
    Product buscarPorId(Long id);
    void inserir(Product product);
    void alterar(Long id, Product product);
    void excluir(Long id);
}
