package enums;

public enum ProductSQL {
	REGISTER, LIST, RETRIEVE;
	
	@Override
	public String toString() {
		StringBuffer sql = new StringBuffer();
		switch(this) {
		case REGISTER :
			sql.append("insert into Products(PRODUCT_ID,PRODUCT_NAME,SUPPLIER_ID,CATEGORY_ID,UNIT,PRICE)\n" + 
					"values(PRODUCT_ID.NEXTVAL,?,?,?,?,?)");
			break;
		case LIST :
			sql.append("select * \n" + 
					"from (select rownum rrnum, t.* \r\n" + 
					"    from (select rownum rnum, c.*\r\n" + 
					"        from Products c\r\n" + 
					"        order by rnum desc) t)\r\n" + 
					"where rrnum between ? and ?");
			break;
		case RETRIEVE:
			sql.append("select * from products where PRODUCT_ID like ?");
			break;
		default :
			break;
		}
		return sql.toString();
	}
}
