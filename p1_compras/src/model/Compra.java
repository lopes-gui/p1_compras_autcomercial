package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import controllers.CompraJPAController;

@Entity
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id_compra;
	private String valor;
	private Date data;
	private String pagamento;
	private Boolean recebido;
	private Pessoa cliente;

	public Compra() {
		
	}

	public Integer getId_compra() {
		return id_compra;
	}

	public void setId_compra(Integer id_compra) {
		this.id_compra = id_compra;
	}


	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public Boolean getRecebido() {
		return recebido;
	}

	public void setRecebido(Boolean recebido) {
		this.recebido = recebido;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Compra(Integer id_compra, Integer id, String valor, Date data, String pagamento, Boolean recebido,
			Pessoa cliente) {
		super();
		this.id_compra = id_compra;
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.pagamento = pagamento;
		this.recebido = recebido;
		this.cliente = cliente;
	}

	

	

}