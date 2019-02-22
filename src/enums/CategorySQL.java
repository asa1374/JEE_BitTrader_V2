package enums;

public enum CategorySQL {
	LIST,COUNT;
	@Override
	public String toString() {
		StringBuffer sql = new StringBuffer();
		switch(this) {
		case LIST :
			sql.append("select * \r\n" + 
					"from (select rownum rrnum, t.* \r\n" + 
						"from (select rownum rnum, c.*\r\n" + 
								"from categories c\r\n" + 
								"order by rnum desc) t)\r\n" + 
					"where rrnum between ? and ?");
			break;
		case COUNT :
			sql.append("select count(*) count from categories");
			break;
		default :
			break;
		}
		return sql.toString();
	}
}
