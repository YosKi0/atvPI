package atividades.pi.atividades.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AtvformController {

	@RequestMapping("/atividades/form")
	public String form() {
		return "formAtv";
	}
}
