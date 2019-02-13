package enums;
//CUSTOMER_ID,password,CONTACT_NAME
//ADDRESS,CITY,POSTAL_CODE,ssn
public enum CustomerSQL {
	SIGNUP,SIGNIN,LIST,COUNT;
	@Override
	public String toString() {
		StringBuffer sql = new StringBuffer();
		switch(this) {
		case SIGNUP :
			sql.append("insert into customers(customer_id,customer_name,password,address,city,postal_code,ssn,phone)" + 
					"values(?,?,?,?,?,?,?,?)");
			break;
		case SIGNIN :
			sql.append("SELECT * FROM customers WHERE customer_id LIKE ? AND password LIKE ? ");
			break;
		case LIST :
			sql.append("select * \r\n" + 
					"from (select rownum rrnum, t.* \r\n" + 
					"    from (select rownum rnum, c.*\r\n" + 
					"        from customers c\r\n" + 
					"        order by rnum desc) t)\r\n" + 
					"where rrnum between ? and ?");
			break;
		case COUNT :
			sql.append("select count(*) count from customers");
			break;
		default :
			break;
		}
		return sql.toString();
	}
}
