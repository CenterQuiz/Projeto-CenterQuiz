package sd.api.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpUtils;
import javax.ws.rs.core.MediaType;
import net.minidev.json.JSONObject;
import org.apache.catalina.util.RequestUtil;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sd.api.rest.model.BancoDeQuestoes;
import sd.api.rest.model.Questionario;
import sd.api.rest.repository.BancoDeQuestoesRepository;
import sd.api.rest.repository.QuestionarioRepository;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import sd.api.rest.model.Questao;
import sd.api.rest.repository.QuestaoRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/api/banco-de-questoes")
public class BancoDeQuestoesController {

    @Autowired // se fosse CDI seria @Inject
    private BancoDeQuestoesRepository bancoDeQuestoesRepository;

    @Autowired
    private QuestionarioRepository questionarioRepository;

    @Autowired
    private QuestaoRepository questaoRepository;

    private DefaultHttpClient httpclient;

    private String url = "localhost:8080/centerquiz";

    @GetMapping(value = "/todos", produces = "application/json")
    public ResponseEntity<List<BancoDeQuestoes>> obterBancoDeQuestoes() {
        List<BancoDeQuestoes> bancoDeQuestoes
                = (List<BancoDeQuestoes>) bancoDeQuestoesRepository.findAll();

        return new ResponseEntity<List<BancoDeQuestoes>>(
                bancoDeQuestoes,
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public ResponseEntity<BancoDeQuestoes> obterBancoDeQuestoesId(@PathVariable(value = "id") Long id) {
        Optional<BancoDeQuestoes> bancoDeQuestoes = bancoDeQuestoesRepository.findById(id);

        return new ResponseEntity(bancoDeQuestoes.get(), HttpStatus.OK);
    }

    /**
     * Exemplo de requisição: { "questionario": { "id": 10, "nome": "Nome teste
     * 1", "tipoQuestionario": false, "dataInicio": null, "dataFim": null,
     * "duracao": 3, "bancoDeQuestoes": null }, "questoes": [ { "titulo": "teste
     * banco de questões 1", "texto": "teste banco de questões 1", "opcoes": [
     * "Opção 1", "Opção 2" ], "respostas": [ 1, 2 ], "vezesPerguntado": 5,
     * "bancoDeQuestoes": null } ] }
     *
     * @param bancoDeQuestoes
     * @return
     */
    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<BancoDeQuestoes> criarBancoDeQuestoes(
            @RequestBody BancoDeQuestoes bancoDeQuestoes
    ) {
        /*BancoDeQuestoes bancoDeQuestoesFinal = new BancoDeQuestoes();

        // 1. Criar questionário [OK]
        // 2. Retornar o JSON do questionário criado () [OK]
        // 2. Adicionar ao bancoDeQuestoesFinal
        bancoDeQuestoes.getQuestionario().setId(null);

        Questionario questionarioSalvo = questionarioRepository.save(bancoDeQuestoes.getQuestionario());

        System.out.println(questionarioSalvo);

        System.out.println("id = " + questionarioSalvo.getId());

        bancoDeQuestoesFinal.setQuestionario(questionarioSalvo);
        // 3. Criar cada questão passada via POST
        bancoDeQuestoesFinal.setQuestoes(bancoDeQuestoes.getQuestoes());
        for (Questao questao : bancoDeQuestoes.getQuestoes()) {
            questao.setId(null);
            questao.setBancoDeQuestoes(bancoDeQuestoes);
            Questao questaoSalva = questaoRepository.save(questao);
            System.out.println("Questão salva = " + questaoSalva);
        }
        
*/
        
        BancoDeQuestoes bancoDeQuestoesSalva = bancoDeQuestoesRepository.save(bancoDeQuestoes);

        return new ResponseEntity<BancoDeQuestoes>(bancoDeQuestoesSalva, HttpStatus.OK);
    }
}
