package main.java.action;

import java.util.List;
import javax.xml.ws.Action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import main.java.dao.PacienteDAO;
import main.java.modelo.Paciente;

public class PacienteAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Paciente paciente;
	private List<Paciente> pacientes;
	private PacienteDAO dao;

	@Action(input="salvar")
	public String salvarPaciente() throws Exception {
		dao = new PacienteDAO();
		dao.cadastrar(paciente);
		return "Paciente salvo com sucesso";
	}

	@Action(output="listarPaciente")
	public String listarPacientes() throws Exception {
		dao = new PacienteDAO();
		pacientes = dao.getPacientes();
		return "paciente";
	}

	@Action(input="removerPaciente")
	public String removerPaciente(int id) throws Exception {
		dao = new PacienteDAO();
		dao.remove(id);
		return "Paciente removido com sucesso";
	}

	@Action(input = "editarId")
	public String editarId(int id) throws Exception {

		dao = new PacienteDAO();

		paciente = dao.pacienteId(id);

		return "Preparando";

	}

	@Action(input="editarPaciente")
	public String editarPaciente() throws Exception {
		dao = new PacienteDAO();
		dao.editar(paciente);
		return "Paciente editado com sucesso";
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public String execute() throws Exception {
		if (paciente != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	public void validate() {
		if (paciente.getNome().length() == 0) {
			addFieldError("paciente.getPctNome()", "O nome � obrigat�rio!.");
		}

		if (paciente.getDataNascimento().equals(null)) {
			addFieldError("paciente.getPctNascimento()", "A data de nascimento � obrigat�rio!.");
		}

		if (paciente.getSexo().length() == 0) {
			addFieldError("paciente.getPctSexo()", "O Sexo do paciente � obrigat�rio");
		}

		if (paciente.getTelefone().length() == 0) {
			addFieldError("paciente.getPctFone()", "O Telefone � obrigat�rio!");
		}
	}
}
