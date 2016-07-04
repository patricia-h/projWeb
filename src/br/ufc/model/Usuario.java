package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name="usuario")
public class Usuario {

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="{usuario.nome.vazio}")
	@Size(min=5,message="{usuario.nome.min}")
	private String nome;
	
	private String email;
	
	private String login;
	
	private String senha;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="papel_usuario"
			,joinColumns=@JoinColumn(name="id_usuario", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="id_papel", referencedColumnName="id"))
	private List<Papel> papeis;
	
	@OneToMany(mappedBy="autor",
			   targetEntity=Classificado.class,
			   fetch=FetchType.EAGER)
	private List<Classificado> classificados;
	
	@OneToMany(mappedBy="idAutor",
			   targetEntity=Noticia.class,
			   fetch=FetchType.EAGER)
	private List<Noticia> noticias;
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	public List<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
	public List<Classificado> getClassificados() {
		return classificados;
	}
	public void setClassificados(List<Classificado> classificados) {
		this.classificados = classificados;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Usuario))
			return false;
		
		Usuario ref = (Usuario)obj;
		if(ref.getId()==this.id)
			return true;
		return false;	
	}
}
