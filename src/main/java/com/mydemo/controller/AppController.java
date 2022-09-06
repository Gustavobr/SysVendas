package com.mydemo.controller;

import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.apache.logging.log4j.*;

@Controller
@EnableAsync
@EnableSpringDataWebSupport
@RequestMapping(value = "/")
public class AppController {

	private static final Logger log = LogManager.getLogger(AppController.class);

	@RequestMapping(value = "/")
	public ModelAndView home() {

		return new ModelAndView("home");

	}

	@PostMapping(value = "/select")
	public ModelAndView selectApi(@RequestParam String api) {
		try {
			if (api.equalsIgnoreCase("cliente")) {
				log.debug("Verifying the api selected");
				return new ModelAndView("/cliente");
			} else {
				return new ModelAndView("/servico");
			}
		} catch (Exception ex) {
			throw new RuntimeException();
		}

	}

}
