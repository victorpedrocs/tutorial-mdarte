package br.mdarte.exemplo.academico.to;

public class EstudanteTOExample
extends br.ufrj.coppetec.to.AbstractTOExample
{
    public static EstudanteTOExample newInstance()
	{
		return new EstudanteTOExample();
	}
 	
    private java.lang.String matricula;

	public java.lang.String getMatricula(){
        return this.matricula;
    }

    public void setMatricula(java.lang.String matricula){
        this.matricula = matricula;
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


	
	private java.util.Collection curso = new java.util.ArrayList<br.mdarte.exemplo.academico.to.CursoTOExample>();
	
	public java.util.Collection<br.mdarte.exemplo.academico.to.CursoTOExample> getCurso(){
    		return this.curso;
    }

    public void setCurso(java.util.Collection<br.mdarte.exemplo.academico.to.CursoTOExample> curso){
    	this.curso = curso;
	}

 
	public void setCursoInverse(java.util.Collection<br.mdarte.exemplo.academico.to.CursoTOExample> curso){
    	java.util.Collection<br.mdarte.exemplo.academico.to.CursoTOExample> temp = this.curso;
		this.curso = curso;
		
		if(temp != null){
			for(java.util.Iterator it = temp.iterator(); it.hasNext();){
				br.mdarte.exemplo.academico.to.CursoTOExample cursoNext = (br.mdarte.exemplo.academico.to.CursoTOExample)it.next();
				if(cursoNext.getEstudantes() != null)
					cursoNext.getEstudantes().remove(this);
			}
		}

		if(curso != null){
			for(java.util.Iterator it = curso.iterator(); it.hasNext();){
        			br.mdarte.exemplo.academico.to.CursoTOExample cursoNext = (br.mdarte.exemplo.academico.to.CursoTOExample)it.next();
        			if(!cursoNext.getEstudantes().contains(this))
        				cursoNext.getEstudantes().add(this);
        		}
        	}
       }

    	public void addCurso(br.mdarte.exemplo.academico.to.CursoTOExample cursoTemp){
			if(curso == null)
				setCurso(new java.util.ArrayList());	
    		
			if(!curso.contains(cursoTemp))
    			curso.add(cursoTemp);
  
    		java.util.Collection<EstudanteTOExample> estudantes = cursoTemp.getEstudantes();
	
    		if(!estudantes.contains(this))
    			estudantes.add(this);

    		cursoTemp.setEstudantes(estudantes);
    		this.setCurso(curso);
    	}
    
    	public void removeCurso(br.mdarte.exemplo.academico.to.CursoTOExample cursoTemp){
    		java.util.Collection<br.mdarte.exemplo.academico.to.CursoTOExample> curso = this.getCurso();
				
    		if(curso != null){
        			curso.remove(cursoTemp);
    		}
			
    		java.util.Collection estudantes = cursoTemp.getEstudantes();
			
    		if(estudantes != null)
    			estudantes.remove(this);

			cursoTemp.setEstudantes(estudantes);
	
			this.setCurso(curso);
    	}
}
