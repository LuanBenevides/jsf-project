package br.com.myJSFsistema;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "controlePessoa")
@SessionScoped
public class ControlePessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Boolean opcaoSelecionada;
	private Boolean pessoaFisica;
	
	private Integer id;
	private String name;
	private String cpf;
	private String cnpj;
	private String saidaDadosUsuario;
	
	public ControlePessoa() {
		opcaoSelecionada = false;
	}

	public void tipoChange(ValueChangeEvent e) {
		pessoaFisica = (Boolean) e.getNewValue();
		selecionar();
	}
	
	public String selecionar() {
		opcaoSelecionada = true;
		String selecao = pessoaFisica == true ? "Pessoa fisica" : "Pessoa Juridica";
		FacesMessage msg = new FacesMessage("Tipo selecionado: " + selecao);
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "formPessoa";
	}
	
	public String exibirDados() {
		saidaDadosUsuario = "";
		saidaDadosUsuario += "Valores recebidos: ";
		saidaDadosUsuario += "<br/>" + (pessoaFisica ? "Nome:" + name : "Razão social: " + name);
		saidaDadosUsuario += "<br/>" + (pessoaFisica ? "Cpf: " + cpf : "Cnpj: " + cnpj );
		FacesMessage msg = new FacesMessage("Dados recebidos com successo!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "dadosPessoa";
	}
	
	public String voltar() {
		opcaoSelecionada = false;
		id = null;
		name = "";
		cpf = "";
		cnpj = "";
		return "formPessoa";
	}
	
	public Boolean getOpcaoSelecionada() {
		return opcaoSelecionada;
	}

	public void setOpcaoSelecionada(Boolean opcaoSelecionada) {
		this.opcaoSelecionada = opcaoSelecionada;
	}

	public Boolean getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(Boolean pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSaidaDadosUsuario() {
		return saidaDadosUsuario;
	}

	public void setSaidaDadosUsuario(String saidaDadosUsuario) {
		this.saidaDadosUsuario = saidaDadosUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
