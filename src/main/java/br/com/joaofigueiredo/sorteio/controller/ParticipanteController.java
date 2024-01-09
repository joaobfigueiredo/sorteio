package br.com.joaofigueiredo.sorteio.controller;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.joaofigueiredo.sorteio.model.Participante;
import br.com.joaofigueiredo.sorteio.service.ParticipanteService;

@Controller
@RequestMapping("participante")
public class ParticipanteController {

	@Autowired
	private ParticipanteService service;
	
	@GetMapping("/sortear")
	public String sortear(Model model) {
		List<Participante> participantes = service.buscarTodos();
		Random rand = new Random();
		Participante vencedor = participantes.get(rand.nextInt(participantes.size()));
		model.addAttribute("participante", vencedor);
	    return "exibirVencedor";
	}
	
	@GetMapping("/cadastro")
	public String cadastro(Participante participante) {
	    return "cadastro";
	}

	@PostMapping("/novo")
	public String novo(@Valid Participante participante, BindingResult result, Model model) {

		if (participante != null) {
			service.salvar(participante);
		}
		
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		
        if (authentication != null && authentication.getPrincipal().equals("anonymousUser")) {
        	return "agradecimento";
        } else {
    		return "redirect:/participante/listar";
        }
		
		
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		List<Participante> participantes = service.buscarTodos();
		model.addAttribute("participantes", participantes);
		return "participante/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		Participante participante = service.buscarPorId(id)
				.orElseThrow(() -> new IllegalArgumentException("ID do participante é inválido:" + id));
		model.addAttribute("participante", participante);
		return "participante/editar";
	}

	@PostMapping("/atualizar")
	public String atualizar(@Valid Participante participante, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "atualizar-participante";
		}

		service.salvar(participante);
		return "redirect:/participante/listar";
	}

	@GetMapping("/remover/{id}")
	public String removerParticipante(@PathVariable("id") int id, Model model) {
		Participante participante = service.buscarPorId(id)
				.orElseThrow(() -> new IllegalArgumentException("ID do participante é inválido:" + id));
		service.remover(participante);
		return "redirect:/participante/listar";
	}

}
