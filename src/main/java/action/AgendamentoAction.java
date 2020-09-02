package main.java.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import main.java.dao.AgendamentoDAO;
import main.java.modelo.Agendamento;

public class AgendamentoAction extends ActionSupport {
	private Agendamento agendamento;
	private List<Agendamento> agendamentos;
	private AgendamentoDAO dao;

	public String salvarAgendamento() throws Exception {
		dao = new AgendamentoDAO();
		dao.cadastrar(agendamento);
		return "Agendamento salvo com sucesso";
	}

	public String listarAgendamentos() throws Exception {
		dao = new AgendamentoDAO();
		agendamentos = dao.getAgendamentos();
		return "agendamentos";
	}

	public String removerAgendamento(int id) throws Exception {
		dao = new AgendamentoDAO();
		dao.remove(id);
		return "Agendamento removido com sucesso";
	}

	public String editarAgendamentoId(int id) throws Exception {
		dao = new AgendamentoDAO();

		agendamento = dao.agendamentoId(id);

		return "Preparando";

	}
	
	public String editarAgendamentoPaciente(String nome) throws Exception {
		dao = new AgendamentoDAO();

		agendamento = dao.agendamentoPaciente(nome);

		return "Preparando";

	}

	public String editarAgendamento() throws Exception {
		dao = new AgendamentoDAO();
		dao.editar(agendamento);
		return "Agendamento editado com sucesso";
	}
	
	

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public String execute() throws Exception {
		if (agendamento != null) {
			return "success";
		} else {
			return "success";
		}
	}

	public void validate() {
		if (agendamento.getDataNascimento().equals(null)) {
			addFieldError("agendamento.getDataNascimento()", "A data da consulta � obrigat�rio!.");
		}

		if (agendamento.getPaciente().getId().equals(null)) {
			addFieldError("agendamento.getPaciente().getId()", "O Paciente � obrigat�rio!.");
		}

		if (agendamento.getExame().equals(null)) {
			addFieldError("agendamento.getExame().getId()", "O Exame � obrigat�rio");
		}
	}
}
