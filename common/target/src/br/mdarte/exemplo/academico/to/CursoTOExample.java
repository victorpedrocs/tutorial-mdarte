package br.mdarte.exemplo.academico.to;

public class CursoTOExample
extends br.ufrj.coppetec.to.AbstractTOExample
{
    public static CursoTOExample newInstance()
	{
		return new CursoTOExample();
	}
 	
    private java.lang.String codigo;

	public java.lang.String getCodigo(){
        return this.codigo;
    }

    public void setCodigo(java.lang.String codigo){
        this.codigo = codigo;
	}
    private java.lang.String nome;

	public java.lang.String getNome(){
        return this.nome;
    }

    public void setNome(java.lang.String nome){
        this.nome = nome;
	}
    private java.lang.Long id;

	public java.lang.Long getId(){
        return this.id;
    }

    public void setId(java.lang.Long id){
        this.id = id;
	}


	
	private java.util.Collection estudantes = new java.util.ArrayList<br.mdarte.exemplo.academico.to.EstudanteTOExample>();
	
	public java.util.Collection<br.mdarte.exemplo.academico.to.EstudanteTOExample> getEstudantes(){
    		return this.estudantes;
    }

    public void setEstudantes(java.util.Collection<br.mdarte.exemplo.academico.to.EstudanteTOExample> estudantes){
    	this.estudantes = estudantes;
	}

 
	public void setEstudantesInverse(java.util.Collection<br.mdarte.exemplo.academico.to.EstudanteTOExample> estudantes){
    	java.util.Collection<br.mdarte.exemplo.academico.to.EstudanteTOExample> temp = this.estudantes;
		this.estudantes = estudantes;
		
		if(temp != null){
			for(java.util.Iterator it = temp.iterator(); it.hasNext();){
				br.mdarte.exemplo.academico.to.EstudanteTOExample estudanteNext = (br.mdarte.exemplo.academico.to.EstudanteTOExample)it.next();
				if(estudanteNext.getCurso() != null)
					estudanteNext.getCurso().remove(this);
			}
		}

		if(estudantes != null){
			for(java.util.Iterator it = estudantes.iterator(); it.hasNext();){
        			br.mdarte.exemplo.academico.to.EstudanteTOExample estudanteNext = (br.mdarte.exemplo.academico.to.EstudanteTOExample)it.next();
        			if(!estudanteNext.getCurso().contains(this))
        				estudanteNext.getCurso().add(this);
        		}
        	}
       }

    	public void addEstudantes(br.mdarte.exemplo.academico.to.EstudanteTOExample estudanteTemp){
			if(estudantes == null)
				setEstudantes(new java.util.ArrayList());	
    		
			if(!estudantes.contains(estudanteTemp))
    			estudantes.add(estudanteTemp);
  
    		java.util.Collection<CursoTOExample> curso = estudanteTemp.getCurso();
	
    		if(!curso.contains(this))
    			curso.add(this);

    		estudanteTemp.setCurso(curso);
    		this.setEstudantes(estudantes);
    	}
    
    	public void removeEstudantes(br.mdarte.exemplo.academico.to.EstudanteTOExample estudanteTemp){
    		java.util.Collection<br.mdarte.exemplo.academico.to.EstudanteTOExample> estudantes = this.getEstudantes();
				
    		if(estudantes != null){
        			estudantes.remove(estudanteTemp);
    		}
			
    		java.util.Collection curso = estudanteTemp.getCurso();
			
    		if(curso != null)
    			curso.remove(this);

			estudanteTemp.setCurso(curso);
	
			this.setEstudantes(estudantes);
    	}
}
