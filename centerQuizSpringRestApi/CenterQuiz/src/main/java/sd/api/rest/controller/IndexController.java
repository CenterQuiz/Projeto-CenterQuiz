package sd.api.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.api.rest.model.Questionario;
import sd.api.rest.model.repository.QuestionarioRepository;

@RestController
@RequestMapping(value="/api")
public class IndexController {
	@Autowired // se fosse CDI seria @Inject
	private QuestionarioRepository questionarioRepository;
	
	@GetMapping(value="/questionario", produces="application/json")
	public ResponseEntity<Questionario> init() {
		Questionario questionario = new Questionario();
		
		questionario.setDataFim(new Date());
		questionario.setDataInicio(new Date());
		questionario.setDuracao(3L);
		questionario.setNome("Teste");
		questionario.setTipoQuestionario(false);
		
		Questionario questionarioSalvo = questionarioRepository.save(questionario);
		
		return new ResponseEntity<Questionario>(questionarioSalvo, HttpStatus.OK);
	}
}
