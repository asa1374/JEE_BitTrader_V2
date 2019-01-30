package dao;

import java.util.List;

import domain.CategoryDTO;

public interface CategoryDAO {
	public void insertCategory(CategoryDTO cat);
	public List<CategoryDTO> selectCategoryList();
	public List<CategoryDTO> selectCategoris(String searchWord);
	public CategoryDTO selectCategory(String searchWord);
	public int countCategory();
	public void updateCategory(CategoryDTO cat);
	public void deleteCategory(CategoryDTO cat);
}
