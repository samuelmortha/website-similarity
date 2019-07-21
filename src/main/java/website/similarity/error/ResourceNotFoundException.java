package website.similarity.error;

import java.util.logging.Logger;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ResourceNotFoundException.class.getName());

	public ResourceNotFoundException(String message) {
		super(message);
		LOGGER.warning(message);
	}
}
