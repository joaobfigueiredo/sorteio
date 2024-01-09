package br.com.joaofigueiredo.sorteio.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sorteio")
public class HomeController {
	

	@GetMapping()
	public String sorteio(Model model, Principal principal) {
		return "sorteio";
	}

	@GetMapping("home")
	public String home(Model model, Principal principal) {
		return "home";
	}

}
