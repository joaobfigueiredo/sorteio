package br.com.joaofigueiredo.sorteio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.joaofigueiredo.sorteio.model.Participante;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String cadastro(Participante participante) {
	    return "cadastro";
	}

	@GetMapping
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
