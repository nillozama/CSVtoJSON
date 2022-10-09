package cat.itacademy.zamanillo.victor.csvToJson.model.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cat.itacademy.zamanillo.victor.csvToJson.model.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final Path rootFolder=Paths.get("src/main/resources/");

	@Override
	public List<Product> getAllProducts(String csvFile) throws IOException {

		
		List<Product> products = new ArrayList<Product>();

		FileReader fr = new FileReader(new File("src/main/resources/"+csvFile));
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String[] parts;
		Product product;
		String name;
		String brand;
		float price;
		int stock;

		while (line != null) {

			parts = line.split(";");

			try {
				name = parts[0].trim();
			} catch(Exception e) {
				
				name="Unknown";
			
			}
			try {

				brand = parts[1].trim();
			} catch (Exception e) {

				brand = "Unknown";
			}

			try {

				price = Float.valueOf(parts[2].trim());
			} catch (Exception e){

				price = 0.0f;
			}
			
			try {

				stock = Integer.valueOf(parts[3].trim());
			} catch (Exception e){

				stock = 0;
			}

			product = new Product(name, brand, price, stock);

			products.add(product);

			line = br.readLine();
		}

		br.close();
		fr.close();

		return products;
	}

	@Override
	public void save(MultipartFile file) throws Exception {

		Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename()));
	}
}
