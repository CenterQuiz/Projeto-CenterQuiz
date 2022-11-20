package sd.api.rest.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sd.api.rest.model.Questionario;

@Repository
public interface QuestionarioRepository extends CrudRepository<Questionario, Long>{

}
