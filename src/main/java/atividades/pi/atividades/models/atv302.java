package atividades.pi.atividades.models;

public class atv302 {

	private String nome;
	private String local;
	private String data;
	private String horario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "atv302 [nome=" + nome + ", local=" + local + ", data=" + data + ", horario=" + horario + "]";
	}

}
