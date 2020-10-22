package org.websparrow.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.websparrow.entity.OPERATIONLOG;
import org.websparrow.entity.STOCK;
import org.websparrow.repository.OPERATIONLOGRepository;
import org.websparrow.entity.Product;
import org.websparrow.repository.ProductRepository;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository productrepository;

	// insert new category into database
	@PostMapping("/add")
	public Product addproduct(@RequestBody Product product) {

		return   productrepository.save(product);
	}

	// fetch all category list from database
	@GetMapping("/all")
	public Iterable<Product> allProduct() {

		return productrepository.findAll();
	}

	// fetch specific category by their ID
	@GetMapping("/{operationId}")
	public Optional<Product> ProductById(@PathVariable("ProductId") int ProductId) {

		return productrepository.findById(ProductId);
	}

	// update existing category
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {

		return productrepository.save(product);
	}

	// delete category from database
	@DeleteMapping("/{ProductId}")
	public void  deleteProduct(@PathVariable("ProductId") int ProductId) {

		productrepository.deleteById(ProductId);
	}

	 @Test
	    public void whenFindByCreatDate_thenProducts1And2Returned() throws ParseException {
	        List<Product> result = productrepository.findAllBycreateDate(
	          new SimpleDateFormat("DD-MM-YYYY ").parse(""));
	 
	        assertEquals(2, result.size());
	        assertTrue(result.stream()
	          .map(Product::getProductId)
	          .allMatch(id -> Arrays.asList(1, 2).contains(id)));
	    }
	 
	    private void assertTrue(boolean allMatch) {
		// TODO Auto-generated method stub
		
	}

		private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}
	
		
		@Test
	    public void whenFindByupdateDate_thenProducts1And2Returned() throws ParseException {
	        List<Product> result = productrepository.findAllByupdateDate(
	          new SimpleDateFormat("DD-MM-YYYY ").parse(""));
	 
	        assertEquals(2, result.size());
	        assertTrue(result.stream()
	          .map(Product::getProductId)
	          .allMatch(id -> Arrays.asList(1, 2).contains(id)));
	    }
	 

}
