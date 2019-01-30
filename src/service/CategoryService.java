package service;

import java.util.List;

import domain.CategoryDTO;

public interface CategoryService {
	public void resistCategory(CategoryDTO cat);
	public List<CategoryDTO> bringCategoryList();
	public List<CategoryDTO> retrieveCategoris(String searchWord);
	public CategoryDTO retrieveCategory(String searchWord);
	public int countCategory();
	public void modifyCategory(CategoryDTO cat);
	public void removeCategory(CategoryDTO cat);
}
