package sd.api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sd.api.rest.model.BancoDeQuestoes;

@Repository
public interface BancoDeQuestoesRepository extends CrudRepository<BancoDeQuestoes, Long>{

}