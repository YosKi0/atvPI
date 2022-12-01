package atividades.pi.atividades.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControllers {

	@RequestMapping("/")
	public String index() {
		System.out.println("chamou o método");
		return "redirect: /atividades";
	}
}
