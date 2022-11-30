package sd.api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sd.api.rest.model.Questao;

@Repository
public interface QuestaoRepository extends CrudRepository<Questao, Long>{

}
