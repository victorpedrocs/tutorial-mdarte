package br.mdarte.exemplo.academico.cd;
public abstract class AbstractEntity implements br.ufrj.coppetec.Entity{
	
	public abstract Long getId();

	public abstract AbstractDAO getDaoImpl();
	
	public abstract br.ufrj.coppetec.to.AbstractTOExample getTOExample();
	
	protected abstract AbstractEntity getEntityFromTO(br.ufrj.coppetec.to.AbstractTO to, java.util.HashMap map) throws Exception;
	
	public abstract br.ufrj.coppetec.to.AbstractTO buildTO(br.ufrj.coppetec.to.AbstractTOExample to, java.util.HashMap map) throws Exception;
	
	public abstract String getEntityKey();
	
	public abstract java.util.Collection THIS();
	
	public abstract Boolean needUpdate(br.ufrj.coppetec.to.AbstractTO abstractTO);
	
	protected static AbstractEntity getEntityInstanceFromTO(br.ufrj.coppetec.to.AbstractTO to, java.util.HashMap map) throws br.ufrj.coppetec.to.TOException {
		try{
			Class clazz = Class.forName(to.getEntityClassName());
			AbstractEntity entity = (AbstractEntity)clazz.newInstance();
			return entity.getEntityFromTO(to, map);
		}catch (Exception e) {
			throw new br.ufrj.coppetec.to.TOException("Erro ao transformar de entidade para um TO");
		}
	}	
}
