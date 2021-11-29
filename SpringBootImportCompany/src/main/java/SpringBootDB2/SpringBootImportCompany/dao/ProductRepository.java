package SpringBootDB2.SpringBootImportCompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBootDB2.SpringBootImportCompany.beans.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    public Product findByName(String name);
}
