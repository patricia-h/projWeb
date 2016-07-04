package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="papel")
public class Papel {

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull(message="{papel.nome.vazio}")
	@Size(min=5,message="{papel.nome.min}")
	private String papel;
	
	@ManyToMany(mappedBy="papeis", fetch=FetchType.LAZY)
	private List<Usuario> usuarios;	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Papel))
			return false;
		
		Papel ref = (Papel)obj;
		if(ref.getId()==this.id)
			return true;
		return false;	
	}
	
	
	
}
