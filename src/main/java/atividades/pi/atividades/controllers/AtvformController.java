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
import atividades.pi.atividades.models.convidado;
import atividades.pi.atividades.repositories.ConvidadoRepository;
import atividades.pi.atividades.repositories.EventoRepository;

@Controller
@RequestMapping("/atividades")
public class AtvformController {

	@Autowired
	private EventoRepository er;
	@Autowired
	private ConvidadoRepository cr;

	@GetMapping("/atividades/form")
	public String form(atv302 evento) {
		return "eventos/formAtv";
	}

	@PostMapping
	public String salvar(atv302 atv302) {

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
		
		List<convidado> convidados = cr.findByEvento(evento);
		md.addObject("convidados", convidados);
		
		return md;
	}
	
	@PostMapping("/{idEvento}")
	public String salvarConvidado(@PathVariable Long idEvento, convidado convidado) {
		
		System.out.println("Id do evento: " + idEvento);
		System.out.println(convidado);
		
		Optional<atv302> opt = er.findById(idEvento);
		if(opt.isEmpty()) {
			return "redirect:/eventos";
		}
		
		atv302 evento = opt.get();
		convidado.setEvento(evento);
		
		cr.save(convidado);
		
		return "redirect:/eventos/{idEvento}";
	}
	
	@GetMapping("/{id}/selecionar")
	public ModelAndView selecionarEvento(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<atv302> opt = er.findById(id);
		if(opt.isEmpty()) {
			md.setViewName("redirect:/eventos");
			return md;
		}
		
		atv302 evento = opt.get();
		md.setViewName("eventos/formAtv");
		md.addObject("evento", evento);
		
		return md;
	}
	
	@GetMapping("/{idEvento}/convidados/{idConvidado}/selecionar")
	public ModelAndView selecionarConvidado(@PathVariable Long idEvento, @PathVariable Long idConvidado ) {
		ModelAndView md = new ModelAndView();
		Optional<atv302> optEvento = er.findById(idEvento);
		Optional<atv302> optConvidado = er.findById(idConvidado);

		if(optEvento.isEmpty() || optConvidado.isEmpty()) {
			md.setViewName("redirect:/eventos");
			return md;
		}
		
		atv302 evento = optEvento.get();
		atv302 convidado = optConvidado.get();
		
		if(evento.getId() != convidado.getId()) {
			md.setViewName("redirect:/eventos");
			
			return md;
		}
		
		md.setViewName("eventos/detalhes");
		md.addObject("convidado", convidado);
		md.addObject("evento", evento);
		md.addObject("convidados", cr.findByEvento(evento));
		
		return md;
	}
	
	@GetMapping("/{id}/remover")
	public String apagarEvento(@PathVariable Long id) {
		
		Optional<atv302> opt = er.findById(id);
		
		if(!opt.isEmpty()) {
			atv302 evento = opt.get();
			
			List<convidado> convidados = cr.findByEvento(evento);
			
			cr.deleteAll(convidados);
			er.delete(evento);
		}
		
		return "redirect:/atividades";
	}
	
}
