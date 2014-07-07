package com.sain.goodlife.dao.common.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.sain.goodlife.dao.common.impl.parent.IdSequenceDaoParent;

@Repository("idSequenceDao")
public class IdSequenceDaoImpl extends IdSequenceDaoParent {

	private static final Log log = LogFactory.getLog(IdSequenceDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long getNextVal(String tableName) {
		long id = 0;

		Session session = sessionFactory.openSession();

		String getNextValHQL = "SELECT nextVal FROM IdSequencePoEntity WHERE tableName=:tableName";
		Query getNextValQuery = session.createQuery(getNextValHQL);
		getNextValQuery.setString("tableName", tableName);
		List<?> idList = getNextValQuery.list();

		if(CollectionUtils.isEmpty(idList) == false){
			id = (Long) idList.get(0);
		}

		try{
			String updateNextValHQL = "UPDATE IdSequencePoEntity SET nextVal=nextVal+1 WHERE tableName=:tableName";
			Query updateNextValQuery = session.createQuery(updateNextValHQL);
			updateNextValQuery.setString("tableName", tableName);
			updateNextValQuery.executeUpdate();
		} catch (RuntimeException re){
			id = 0;
			log.error(re.getMessage());
		} finally {
			session.close();
		}

		return id;
	}

}
