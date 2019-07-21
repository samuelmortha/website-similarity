package website.similarity.error;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public void letSpringHandleNotFoundException(HttpServletResponse response) throws IOException {
		LOGGER.warning("ResourceNotFoundException : " + HttpStatus.NOT_FOUND.value());
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
}
