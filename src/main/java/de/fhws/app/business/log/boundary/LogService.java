package de.fhws.app.business.log.boundary;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

import de.fhws.app.business.log.boundary.LoggerProducerType.LoggerType;
import de.fhws.app.business.log.enitity.LogMessage;

@Stateless
public class LogService {

	@Inject
	@LoggerProducerType(LoggerType.DB)
	Logger logger;

	@Asynchronous
	public void log(String message) {
		LogMessage lm = new LogMessage();
		lm.setMessage(message);

		logger.log(lm);

	}

}
