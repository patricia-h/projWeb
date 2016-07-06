package br.ufc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="comentario")
public class Comentario {

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String texto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_noticia",
				referencedColumnName="id", unique=false)
	private Noticia idNoticia;
	
	@ManyToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name="id_autor",
				referencedColumnName="id", unique=false)	
	private Usuario autorComentario;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Noticia getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(Noticia idNoticia) {
		this.idNoticia = idNoticia;
	}	
	
	public Usuario getAutorComentario() {
		return autorComentario;
	}

	public void setAutorComentario(Usuario autorComentario) {
		this.autorComentario = autorComentario;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Comentario)){
			return false;
		}
		Comentario ref = (Comentario)obj; 
		if(ref.getId()==this.id)
			return true;
		return false;
	}	
}
