package cat.itacademy.zamanillo.victor.csvToJson.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cat.itacademy.zamanillo.victor.csvToJson.model.domain.Product;
import cat.itacademy.zamanillo.victor.csvToJson.model.services.ProductServiceImpl;

@RestController
@RequestMapping("/file")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping("/convert/{csvFile}")
	@ResponseBody
	public ResponseEntity<List<Product>> getAllProducts(@PathVariable("csvFile") String file) {

		ResponseEntity<List<Product>> responseEntity;

		try {
			List<Product> products = new ArrayList<Product>();
			products = productServiceImpl.getAllProducts(file);

			if (products.isEmpty()) {

				responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFiles(@RequestParam("file") MultipartFile file) {

		ResponseEntity<String> responseEntity;
		try {
			
			productServiceImpl.save(file);
			
			responseEntity=ResponseEntity.status(HttpStatus.OK).body("Archivo cargado correctamente");
			

		} catch (Exception e) {
			responseEntity= ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archive");
		}
		return responseEntity;
	}
}
