package br.com.myJSFsistema;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controlePrincipal")
@SessionScoped
public class ControlePrincipal implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensagem = "Sistema em JSF 2.2";
	
	public ControlePrincipal() {
		SimpleDateFormat data = 
				new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS");
		mensagem = "Este BEAN foi criado no momeno: " 
				+ data.format(Calendar.getInstance().getTime());
	}
	
	public String sobre() {
		mensagem = "Você navegou de maneira dinâmica.";
				
		return "sobre";
	}
	
	public String sobreRedirecionado() {
		mensagem = "Você foi redirecionado para a página /sobre.xhtml";
		return "sobre?faces-redirect=true";
	}
	
	public String geraErro() {
		return "error";
	}
	
	public String geraLogin() {
		return "login";
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
