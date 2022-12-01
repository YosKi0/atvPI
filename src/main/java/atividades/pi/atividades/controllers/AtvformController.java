package atividades.pi.atividades.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import atividades.pi.atividades.models.atv302;
import atividades.pi.atividades.repositories.EventoRepository;

@Controller
@RequestMapping("/atividades")
public class AtvformController {

	@Autowired
	private EventoRepository er;

	@GetMapping("/atividades/form")
	public String form() {
		return "eventos/formAtv";
	}

	@PostMapping
	public String adicionar(atv302 atv302) {

		System.out.println(atv302);
		er.save(atv302);

		return "eventos/atv-adicionado";
	}

	@GetMapping
	public ModelAndView listar() {

		List<atv302> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("eventos/lista");
		mv.addObject("eventos", eventos);
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		
		ModelAndView md = new ModelAndView();
		Optional<atv302> opt = er.findById(id);
		if(opt.isEmpty()) {
			md.setViewName("redirect:/eventos");
			return md;
		}
		md.setViewName("eventos/detalhes");
		atv302 evento = opt.get();
		md.addObject("evento", evento);
		
		return md;
	}
}
