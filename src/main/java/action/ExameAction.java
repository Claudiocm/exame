package main.java.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import main.java.dao.ExameDAO;
import main.java.modelo.Exame;

public class ExameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Exame exame;
	private List<Exame> exames;
	private ExameDAO dao;

	public String salvarExame() throws Exception {
		dao = new ExameDAO();
		dao.cadastrar(exame);
		return "Exame salvo com sucesso";
	}

	public String listarExames() throws Exception {
		dao = new ExameDAO();
		exames = dao.getExames();
		return "exame";
	}

	public String removerExame(int id) throws Exception {
		dao = new ExameDAO();
		dao.remove(id);
		return "Exame removido com sucesso";
	}

	public String editarExameId(int id) throws Exception {

		dao = new ExameDAO();
		exame = dao.exameId(id);

		return "Preparando";

	}

	public String editarExame() throws Exception {
		dao = new ExameDAO();
		dao.editar(exame);
		return "Exame editado com sucesso";
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public String execute() throws Exception {
		if (exame != null) {
			return "success";
		} else {
			return "error";
		}
	}

	public void validate() {
		if (exame.getDescricao().length() == 0) {
			addFieldError("exame.getDescricao", "A descri��o � obrigat�rio!.");
		}

		if (exame.getValor().equals(null)) {
			addFieldError("exame.getValor()", "O valor � obrigat�rio!.");
		}
	}

}
