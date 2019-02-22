package dao;

import java.util.List;

import domain.CategoryDTO;
import proxy.Proxy;

public interface CategoryDAO {
	public void insertCategory(CategoryDTO cat);
	public List<?> selectCategoryList(Proxy pxy);
	public List<?> selectCategoris(Proxy pxy);
	public CategoryDTO selectCategory(String searchWord);
	public int countCategory(Proxy pxy);
	public void updateCategory(CategoryDTO cat);
	public void deleteCategory(CategoryDTO cat);
}
