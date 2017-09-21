package com.baseutil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基于hibernate5的基础封装工具类 定义成泛型类，有效避免类型转换错误异常,增强性能（需检验）
 * 
 * @author admin
 *
 */
public class HibernateBaseDao<T> {

	// 创建session工厂
	@Autowired
	private SessionFactory sessionFactory;
	// 泛型实体类类型
	private Class<T> entityClass;

	public HibernateBaseDao() {
		Class<? extends HibernateBaseDao> c = this.getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type param[] = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) param[0];
		}
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	/**
	 * 获取session
	 * 
	 * @return
	 */
	public Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	/**
	 * 保存操作
	 * 
	 * @param t
	 */
	public void save(T t) {
		getSession().save(t);
	}

	/**
	 * 保存或更新操作
	 * 
	 * @param t
	 */
	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	/**
	 * 更新操作
	 * 
	 * @param t
	 */
	public void update(T t) {
		getSession().update(t);
	}

	/**
	 * 通过id查询对象
	 * 
	 * @param id
	 * @returnSS
	 */
	public T get(String id) {

		 return getSession().get(entityClass, id);
	}

	/**
	 * 删除操作
	 * 
	 * @param t
	 */
	public void delete(T t) {
		getSession().delete(t);
	}

	/**
	 * 通过id删除对象
	 * 
	 * @param id
	 */
	public void deleteById(String id) {
          delete(get(id));
	}
    
	/**
     * 创建Query,仅支持单表查询(目测不需要转换，需要测试一下)
     * @param sql
     * @return
     */
	public Query<T> createQuery(String sql){
		
		return getSession().createNativeQuery(sql, entityClass);
	}
	/**
	 * 创建SQLQuery,支持多表查询
	 * @param queryString
	 * @param obj 参数数组
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public SQLQuery<T> createSQLQuery(String queryString,Object obj[]){
		@SuppressWarnings("unchecked")
		SQLQuery<T> query=(SQLQuery<T>) getSession().createSQLQuery(queryString);
		if(obj !=null){ 
			for (int i = 0; i < obj.length; i++) {
				query.setParameter(i, obj[i]);
			}
		}
		
		return query;
	}
	/**
	 * 创建面向对象的标准查询
	 * @return
	 */
	public Criteria createCriteria(){
			
		return getSession().createCriteria(entityClass);
	}
	/**
	 * 创建query,传递map类型参数(需要测试该方法)
	 * @param sql
	 * @param map
	 * @return
	 */
	public NativeQuery<T> createQuery(String sql,Map<String,Object> map){
		NativeQuery<T> nativeQuery= getSession().createNativeQuery(sql);
		if(map !=null && map.size()!=0){
			  
			nativeQuery.setProperties(map);		
			
		}
		return nativeQuery;
	}
	/**
	 * 批处理的方法，以job的方式进行,注意一级缓存问题，数据量过大可能造成内存溢出
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
