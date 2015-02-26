package br.mdarte.exemplo.academico.cd;

import org.apache.commons.beanutils.PropertyUtils;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.ufrj.coppetec.to.AbstractTO;
import br.ufrj.coppetec.to.AbstractTOExample;

public class TOUtil{

	public static AbstractTOExample getExample(Collection templates, AbstractTOExample example){
		if(templates == null || templates.size() == 0) return null;
		templates = getSuperclasses(templates, example);
		templates = sortTemplates(templates);
		
		Iterator it = templates.iterator();
		
		while(it.hasNext()){
			Object template = it.next();
			try{
				 PropertyUtils.copyProperties(example, template);
			}catch (Exception e) {
				throw new RuntimeException();
			}
		}
		
		return example;
	}
	
	private static java.util.Collection sortTemplates(java.util.Collection templates){
		java.util.List templatesTemp = new ArrayList();
		
		Iterator it = templates.iterator();
		
		while(it.hasNext()){
			int i;
			Object template = it.next();
			
			for(i = 0; i < templatesTemp.size() && templatesTemp.get(i).getClass().isAssignableFrom(template.getClass()); i++) break;
			
			templatesTemp.add(i, template);
		}
		
		return templatesTemp;
	}
	
	private static java.util.Collection getSuperclasses(java.util.Collection templates, AbstractTOExample example){
		java.util.List templatesTemp = new ArrayList();
		
		Iterator it = templates.iterator();
		
		while(it.hasNext()){
			Object template = it.next();
			try{
				if(template.getClass().isAssignableFrom(example.getClass())) 
					templatesTemp.add(template);
			}catch (Exception e) {
				throw new RuntimeException();
			}
		}
		
		return templatesTemp;
	}
	
	public static AbstractTOExample getExample(AbstractTOExample template, AbstractTOExample example){
		if(template == null) return null;
		List templates = new ArrayList();
		templates.add(template);
		return getExample(templates, example);
	}
	
	public static Boolean isCollectionChanged(java.util.Collection<AbstractTO> toCollection, java.util.Collection<AbstractEntity> entityCollection){
		Boolean emptyToCollection = toCollection == null || (toCollection != null && toCollection.size() == 0);
		Boolean emptyEntityCollection = entityCollection == null || (entityCollection != null && entityCollection.size() == 0);
		if(emptyToCollection && emptyEntityCollection) return false;
		if(toCollection.size() != entityCollection.size()) return true;
		
		for(int i = 0; i < toCollection.size();i++){
			br.mdarte.exemplo.academico.cd.AbstractEntity entity = (br.mdarte.exemplo.academico.cd.AbstractEntity)((java.util.List)entityCollection).get(i);
			AbstractTO to = (AbstractTO)((java.util.List)toCollection).get(i);
			
			if(entity.getId() == null || to.getId() == null) return true;
			if(!entity.getId().equals(to.getId())) return true;
		}
		
		return false;
	}
	
	public static Boolean isEntityChanged(AbstractTO to, AbstractEntity entity){
		if(to == null && entity == null) return false;
		if(to == null && entity != null) return true;
		if(to != null && entity == null) return true;
		if(to != null && to.getId() == null) return true;
		
		if(!to.getId().equals(entity.getId())) return true;
		
		return false;
	}
	
	public static AbstractEntity getEntityFromCollection(AbstractTO abstractTO, Collection entidades){
		if(abstractTO == null) return null;
		if(abstractTO.getId() == null) return null;
		
		Iterator it = entidades.iterator();
		while(it.hasNext()){
			AbstractEntity entity = (AbstractEntity)it.next();
			if(entity.getId().equals(abstractTO.getId())) return entity;
		}
		
		return null;
	}
}