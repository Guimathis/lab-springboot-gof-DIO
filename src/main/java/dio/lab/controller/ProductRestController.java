package dio.lab.controller;


import dio.lab.model.Product;
import dio.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> buscarTodos() {
        return ResponseEntity.ok(productService.buscarTodos());
    }

    @GetMapping("/{id}")
     public ResponseEntity<Product> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Product> inserir(@RequestBody Product product) {
        productService.inserir(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
        public ResponseEntity<Product> atualizar(@PathVariable Long id, @RequestBody Product product) {
        productService.alterar(id, product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        productService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
