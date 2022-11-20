package sd.api.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class BancoDeQuestoes implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Questionario questionario;
	
	/*
	@OneToOne
	@MapsId
	@JoinColumn(name = "idAdministrador")
	private Administrador administrador;
	*/
	
	@ElementCollection
	private List<Questao> questoes = new ArrayList<Questao>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BancoDeQuestoes other = (BancoDeQuestoes) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BancoDeQuestoes [id=" + id + ", questionario=" + questionario + ", questoes=" + questoes + "]";
	}
}
