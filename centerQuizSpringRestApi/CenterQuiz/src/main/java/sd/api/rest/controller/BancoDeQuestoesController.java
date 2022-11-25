package sd.api.rest.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import sd.api.rest.model.BancoDeQuestoes;
import sd.api.rest.model.Questionario;
import sd.api.rest.model.repository.BancoDeQuestoesRepository;
import sd.api.rest.model.repository.QuestionarioRepository;

@RestController
@RequestMapping(value = "/api/banco-de-questoes")
public class BancoDeQuestoesController {
	@Autowired // se fosse CDI seria @Inject
	private BancoDeQuestoesRepository bancoDeQuestoesRepository;
	
	@Autowired
	private QuestionarioRepository questionarioRepository;
	
	private DefaultHttpClient httpclient;

	@GetMapping(value="/todos", produces="application/json")
	public ResponseEntity<List<BancoDeQuestoes>> obterBancoDeQuestoes() {
		List<BancoDeQuestoes> bancoDeQuestoes = (List<BancoDeQuestoes>) bancoDeQuestoesRepository.findAll();

		return new ResponseEntity<List<BancoDeQuestoes>>(bancoDeQuestoes, HttpStatus.OK);
	}
	
	/**
	 Exemplo de requisição:
		 {
		    "questionario": {
		        "id": 10,
		        "nome": "Nome teste 1",
		        "tipoQuestionario": false,
		        "dataInicio": null,
		        "dataFim": null,
		        "duracao": 3,
		        "bancoDeQuestoes": null
		    },
		    "questoes": [
		        {
		            "titulo": "teste banco de questões 1",
		            "texto": "teste banco de questões 1",
		            "opcoes": [
		                "Opção 1",
		                "Opção 2"
		            ],
		            "respostas": [
		                1,
		                2
		            ],
		            "vezesPerguntado": 5,
		            "bancoDeQuestoes": null
		        }
		    ]
		}
	 
	 * @param bancoDeQuestoes
	 * @return
	 */
	@PostMapping(value = "", produces = "application/json")
	public ResponseEntity<BancoDeQuestoes> criarBancoDeQuestoes(@RequestBody BancoDeQuestoes bancoDeQuestoes) {
		BancoDeQuestoes bancoDeQuestoesFinal = new BancoDeQuestoes();
		
		Questionario questionario = new Questionario();
		
		questionario.setId(bancoDeQuestoes.getQuestionario().getId());
		questionario.setNome(bancoDeQuestoes.getQuestionario().getNome());
		questionario.setTipoQuestionario(bancoDeQuestoes.getQuestionario().isTipoQuestionario());
		questionario.setDataInicio(bancoDeQuestoes.getQuestionario().getDataInicio());
		questionario.setDataFim(bancoDeQuestoes.getQuestionario().getDataFim());
		questionario.setDuracao(bancoDeQuestoes.getQuestionario().getDuracao());
		questionario.setBancoDeQuestoes(bancoDeQuestoes.getQuestionario().getBancoDeQuestoes());
		Questionario questionarioSalvo = questionarioRepository.save(questionario);

		/*
		JSONObject jsonObject = new JSONObject();

		HttpGet httpGet = new HttpGet("localhost:8080/api/questionario/id/" + questionario.getId());
        HttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = (HttpEntity) response.getEntity();
        String ret = EntityUtils.toString((org.apache.http.HttpEntity) entity);

        JSONObject jsonObjectQuestionario = new JSONObject(ret);

        JSONArray pessoaEnderecoArray = pessoaEndereco.getJSONArray("pessoaEnderecoWs");
		

		
        if (retorno.has("usuario") && retorno.getJSONObject("usuario").has("jwt_token")) {
            token = retorno.getJSONObject("usuario").getString("jwt_token");
        }
        */
		
		BancoDeQuestoes bancoDeQuestoesSalvo = bancoDeQuestoesRepository.save(bancoDeQuestoes);

		return new ResponseEntity<BancoDeQuestoes>(bancoDeQuestoesSalvo, HttpStatus.OK);
	}
}
