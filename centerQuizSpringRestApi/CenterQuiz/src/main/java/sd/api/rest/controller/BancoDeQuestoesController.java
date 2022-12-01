package sd.api.rest.controller;

import java.util.List;
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
import sd.api.rest.model.Questao;
import sd.api.rest.repository.BancoDeQuestoesRepository;
import sd.api.rest.repository.QuestaoRepository;
import sd.api.rest.repository.QuestionarioRepository;

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

    @GetMapping(value = "/todos", produces = "application/json")
    public ResponseEntity<List<BancoDeQuestoes>> obterBancoDeQuestoes() {
        List<BancoDeQuestoes> bancoDeQuestoes = (List<BancoDeQuestoes>) bancoDeQuestoesRepository.findAll();

        int x = 0;
        System.err.println(x);
        return new ResponseEntity<List<BancoDeQuestoes>>(bancoDeQuestoes, HttpStatus.OK);
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
    public ResponseEntity<BancoDeQuestoes> criarBancoDeQuestoes(@RequestBody BancoDeQuestoes bancoDeQuestoes) {
        /*
        Questionario questionario = new Questionario();

        questionario.setId(null);
        questionario.setNome(bancoDeQuestoes.getQuestionario().getNome());
        questionario.setTipoQuestionario(bancoDeQuestoes.getQuestionario().isTipoQuestionario());
        questionario.setDataInicio(bancoDeQuestoes.getQuestionario().getDataInicio());
        questionario.setDataFim(bancoDeQuestoes.getQuestionario().getDataFim());
        questionario.setDuracao(bancoDeQuestoes.getQuestionario().getDuracao());
        questionario.setBancoDeQuestoes(bancoDeQuestoes.getQuestionario().getBancoDeQuestoes());
        
        Questionario questionarioSalvo = questionarioRepository.save(questionario);
        bancoDeQuestoes.getQuestionario().setId(questionarioSalvo.getId());

        int i = 0;
        for (Questao questao : bancoDeQuestoes.getQuestoes()) {
//id, titulo, texto, opcoes, respostas, vezesPerguntado, bancoDeQuestoes
            Questao questaoTemp = new Questao();
            questaoTemp.setId(null);
            questaoTemp.setTitulo(questao.getTitulo());
            questaoTemp.setTexto(questao.getTexto());
            questaoTemp.setOpcoes(questao.getOpcoes());
            questaoTemp.setRespostas(questao.getRespostas());
            questaoTemp.setVezesPerguntado(questao.getVezesPerguntado());
            questaoTemp.setBancoDeQuestoes(questao.getBancoDeQuestoes());

            Questao questaoSalva = questaoRepository.save(questaoTemp);
            bancoDeQuestoes.getQuestoes().get(i).setId(questaoSalva.getId());
            i++;
        }
        
        

        return new ResponseEntity<BancoDeQuestoes>(bancoDeQuestoesSalvo, HttpStatus.OK);
    }
}
