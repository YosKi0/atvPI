package atividades.pi.atividades.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import atividades.pi.atividades.models.atv302;
import atividades.pi.atividades.repositories.EventoRepository;

@Controller
public class AtvformController {

	@Autowired
	private  EventoRepository er;
	
	@RequestMapping("/atividades/form")
	public String form() {
		return "formAtv";
	}
	
	@PostMapping("/atividades")
	public String adicionar(atv302 atv302) {
		/*Para utilizar dados que vem das requisições basta colocar parâmetros com
		 *o mesmo nome se eu colocar todos esses dados, todos vão ser carregados
		 *e vão ser vinculados essas variavéis automaticamente*/
		
		/*Se eu colocar para ele receber um objeto já montado, ele vai criar esse objeto
		 *e vincular os dados dentro dele*/
		
		System.out.println(atv302);
		er.save(atv302);
		
		return "atv-adicionado";
	}
	
}
