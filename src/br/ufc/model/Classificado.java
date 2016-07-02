package br.ufc.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name="classificado")
public class Classificado {

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//@NotNull(message="{classificado.titulo.vazio}")
	//@Size(min=5,message="{classificado.titulo.min}")
	private String titulo;
	
	private String texto;
	private double preco;
	private String telefone;
	
	@Column(name="melhor_oferta")
	private String melhorOferta;
	
	@Column(name="data_oferta")
	private Date dataOferta;
	
	//@Column(name="id_autor")	
	//private long idAutor;
		
	/*@ManyToOne(optional=false)
	@JoinColumn(name="id_autor",
				referencedColumnName="id")*/
		
	@ManyToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name="id_autor",
				referencedColumnName="id", unique=false)
	private Usuario autor;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getMelhorOferta() {
		return melhorOferta;
	}
	public void setMelhorOferta(String melhorOferta) {
		this.melhorOferta = melhorOferta;
	}
	public Date getDataOferta() {
		return dataOferta;
	}
	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}
			
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Classificado))
			return false;
		
		Classificado ref = (Classificado)obj;
		if(ref.getId()==this.id)
			return true;
		return false;	
	}
		
}
