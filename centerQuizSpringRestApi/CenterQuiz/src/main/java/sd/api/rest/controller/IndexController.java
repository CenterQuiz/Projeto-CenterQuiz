package sd.api.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.api.rest.model.Questionario;

@RestController
@RequestMapping(value="/api")
public class IndexController {
	
	
	@GetMapping(value="/questionario", produces="application/json")
	public ResponseEntity init() {
		Questionario questionario = new Questionario();
		
		questionario.setId(1L);
		questionario.setTitulo("A logo do Java");
		questionario.setTexto("O que está declarado no logotipo Java");
		
		List<String> listaOpcoes = new ArrayList<String>();
		listaOpcoes.add("Robô");
		listaOpcoes.add("Folha de chá");
		listaOpcoes.add("Xícara de café");
		listaOpcoes.add("Bug");
		
		questionario.setOpcoes(listaOpcoes);
		
		return new ResponseEntity(questionario, HttpStatus.OK);
	}
}
