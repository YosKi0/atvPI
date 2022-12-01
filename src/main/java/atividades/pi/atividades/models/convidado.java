package atividades.pi.atividades.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class convidado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String rg;

	@ManyToOne
	private atv302 evento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public atv302 getEvento() {
		return evento;
	}

	public void setEvento(atv302 evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "convidado [id=" + id + ", nome=" + nome + ", rg=" + rg + ", evento=" + evento + "]";
	}

}
