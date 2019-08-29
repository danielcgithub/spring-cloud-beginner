package com.example.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @author Ryan Baxter
 * 
 *         root endpoint tries to resolve locale from the accept language header
 *         of request call to greeting service with locale to get greeting call
 *         to name service to get name append together and return that
 * 
 */
@RestController
public class WebController {

	private static final Logger LOG = Logger.getLogger(WebController.class.getName());

	private NameService nameService;
	private GreetingService greetingService;

	public WebController(NameService nameService, GreetingService greetingService) {
		this.nameService = nameService;
		this.greetingService = greetingService;
	}

	@RequestMapping
	public String index(HttpServletRequest request) {
		String locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request).toLanguageTag();
		String greeting = new StringBuilder().append(greetingService.getGreeting(locale)).append(" ")
				.append(nameService.getName()).toString();
		LOG.info("Greeting: " + greeting);
		LOG.info("Locale: " + locale);
		return greeting;
	}
}
