package br.com.myJSFsistema.bean;

import javax.faces.bean.ManagedBean;

import br.com.myJSFsistema.dao.DaoGeneric;
import br.com.myJSFsistema.domain.Funcionario;

@ManagedBean(name = "funcionarioBean")
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	private DaoGeneric<Funcionario> dao = new DaoGeneric<Funcionario>();
	
	public String salvar() {
		dao.salvar(funcionario);
		return "";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public DaoGeneric<Funcionario> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Funcionario> dao) {
		this.dao = dao;
	}
	
}
