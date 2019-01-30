package service;

import java.util.List;
import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import domain.CategoryDTO;

public class CategoryServiceImpl implements CategoryService{
	private static CategoryServiceImpl instance = new CategoryServiceImpl();
	private CategoryServiceImpl() {dao = CategoryDAOImpl.getInstance();}
	public static CategoryServiceImpl getInstance() {return instance;}
	CategoryDAO dao;
	@Override
	public void resistCategory(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryDTO> bringCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> retrieveCategoris(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO retrieveCategory(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyCategory(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCategory(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int countCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

}
