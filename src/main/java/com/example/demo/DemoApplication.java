package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Controller
	@RequestMapping("user")
	public class GreetingController{

		private final IPocitadloService IpocitaciService;

		public GreetingController(@Qualifier("superPocitadloService") IPocitadloService IpocitaciService) {
			this.IpocitaciService = IpocitaciService;
		}

		@RequestMapping(value = "greeting", method = {RequestMethod.POST, RequestMethod.GET})
		public String requestGreeting(@RequestParam(name = "name", required = false,defaultValue = "World")String name, Model model){
			IpocitaciService.add();
			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
			model.addAttribute("pocitac", IpocitaciService.getPocitac());
			return "greeting";
		}
		@GetMapping(value = "greeting2")
		public String requestGreeting2(@RequestParam(name = "name", required = false,defaultValue = "World")String name, Model model){
			IpocitaciService.add();
			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
			model.addAttribute("pocitac", IpocitaciService.getPocitac());
			return "greeting";
		}
		@PostMapping(value = "greeting3")
		public String requestGreeting3(@RequestParam(name = "name", required = false,defaultValue = "World")String name, Model model){
			IpocitaciService.add();
			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
			model.addAttribute("pocitac", IpocitaciService.getPocitac());
			return "greeting";
		}
		@RequestMapping(value = "greeting4/{jmeno}", method = RequestMethod.GET)
		public String testReq(@PathVariable(name = "jmeno")String name, Model model){
			IpocitaciService.add();
			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
			model.addAttribute("pocitac", IpocitaciService.getPocitac());
			return "greeting";
		}
	}

}
