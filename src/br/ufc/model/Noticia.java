package br.ufc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="noticia")
public class Noticia {

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titulo;
	private String subtitulo;
	private String texto;
	
	@Column(name="data_noticia")
	private Date dataNoticia;
	
	@ManyToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name="id_autor",
				referencedColumnName="id", unique=false)
	private Usuario idAutor;
		
	@ManyToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name="id_secao",
				referencedColumnName="id", unique=false)
	private Secao idSecao;
	
	@OneToMany(mappedBy="idNoticia",
			   targetEntity=Comentario.class,
			   fetch=FetchType.EAGER)
	private List<Comentario> comentarios;
	
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
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getTexto() {
		return texto; 
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDataNoticia() {
		return dataNoticia;
	}
	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}
	public Usuario getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Usuario idAutor) {
		this.idAutor = idAutor;
	}
	public Secao getIdSecao() {
		return idSecao;
	}
	public void setIdSecao(Secao idSecao) {
		this.idSecao = idSecao;
	}
	
	
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Noticia))
			return false;
		
		Noticia ref = (Noticia)obj;
		if(ref.getId()==this.id)
			return true;
		return false;	
	}	
}
