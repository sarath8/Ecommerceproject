package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;


	@Repository("CategoryDAO")
	public class CategoryDAOImpl implements CategoryDAO {

		@Autowired
		private SessionFactory sessionFactory;
		
		public CategoryDAOImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public List<Category> list() {
			@SuppressWarnings({ "unchecked" })
			List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listCategory;
		}

		@Transactional
		public Category getByCategoryId(int categoryid) {
			String hql = "from Category where CategoryId ='" + categoryid + "'";
			Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>) (query).list();

			if (listCategory != null && !listCategory.isEmpty()) {
				return listCategory.get(0);
			}
			return null;
		}

		@Transactional
		public Category getByCategoryName(String categoryname) {
			String hql = "from Category where CategoryName ='" + categoryname + "'";
			Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>) (query).list();

			if (listCategory != null && !listCategory.isEmpty()) {
				return listCategory.get(0);
			}
			return null;
		}

		@Transactional
		public void saveOrUpdate(Category category) {
			
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		}

		@Transactional
		public void delete(int categoryId) {
			Category categoryToDelete = new Category();
			categoryToDelete.setCategoryId(categoryId);
			sessionFactory.getCurrentSession().delete(categoryToDelete);
		}

		
		
	
}
