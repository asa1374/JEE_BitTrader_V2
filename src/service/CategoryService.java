package service;

import java.util.List;

import domain.CategoryDTO;
import proxy.Proxy;

public interface CategoryService {
	public void resistCategory(CategoryDTO cat);
	public List<?> bringCategoryList(Proxy pxy);
	public List<CategoryDTO> retrieveCategoris(String searchWord);
	public CategoryDTO retrieveCategory(String searchWord);
	public int countCategory(Proxy pxy);
	public void modifyCategory(CategoryDTO cat);
	public void removeCategory(CategoryDTO cat);
}
