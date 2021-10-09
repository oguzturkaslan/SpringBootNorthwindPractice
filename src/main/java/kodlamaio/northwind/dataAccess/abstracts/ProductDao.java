/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author oguz.turkaslan
 */
public interface ProductDao extends JpaRepository<Product, Integer> {

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("FROM Product where productName=:productName and category.categoryId = :categoryId")// iki nokta metoddaki belirlenen parametreyi aldığını gösterir.
    List<Product> GetByNameAndCategory(String productName, int categoryId);       //  Burda yazılan query veritabanına değil veritabanının örneklendiği entity class ı olarak düşünülür.

    @Query("SELECT new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
            + "(p.id,p.productName,c.categoryName) "
            + "FROM Category c INNER JOIN c.products p")//JPA da INNER JOIN de "on" koşulunu belirtmeye gerek yok
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
