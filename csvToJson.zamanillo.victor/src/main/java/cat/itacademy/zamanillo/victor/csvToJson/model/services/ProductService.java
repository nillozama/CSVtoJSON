package cat.itacademy.zamanillo.victor.csvToJson.model.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cat.itacademy.zamanillo.victor.csvToJson.model.domain.Product;

public interface ProductService {
	
	public List<Product> getAllProducts(String csvFile) throws IOException;
	
	public void save(MultipartFile file) throws Exception;
}
