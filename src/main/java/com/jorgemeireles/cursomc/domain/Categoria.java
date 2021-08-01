package com.jorgemeireles.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Faz o mapeamento objeto-relacional, JPA converte  obejto para tabelas no banco e vice-versa.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//Serializable converte a classe em  bits para que os objetos sejam gravados em arquivos, trafegar em rede entre outras coisas mais.
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // defini a estratégia de geração automáticas dos ID's
	private Integer id;
	private String nome;

	@JsonManagedReference// Faz isso no lugar que quer venha os objetos associados 
	@ManyToMany(mappedBy="categorias")//Um outro nmapeamento utilizando o que já foi feito na categoria
	private List<Produto> produtos = new ArrayList<>();

	public Categoria() {

	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
