package dao;

import java.util.List;

import domain.CategoryDTO;

public class CategoryDAOImpl implements CategoryDAO{
	private static CategoryDAOImpl instance = new CategoryDAOImpl();
	private CategoryDAOImpl() {}
	public static CategoryDAOImpl getInstance() {return instance;}
	
	@Override
	public void insertCategory(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryDTO> selectCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> selectCategoris(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO selectCategory(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCategory(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int countCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

}
