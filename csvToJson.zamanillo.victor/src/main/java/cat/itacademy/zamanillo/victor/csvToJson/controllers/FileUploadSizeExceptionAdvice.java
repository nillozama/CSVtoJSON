package cat.itacademy.zamanillo.victor.csvToJson.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class FileUploadSizeExceptionAdvice{
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<String> handleMaxSizeException(MaxUploadSizeExceededException ex){
		
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha excedido el tamño de los archivos");
	}
}
