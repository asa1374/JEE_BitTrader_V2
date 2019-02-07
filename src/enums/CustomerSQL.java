package enums;
//CUSTOMER_ID,password,CONTACT_NAME
//ADDRESS,CITY,POSTAL_CODE,ssn
public enum CustomerSQL {
	SIGNUP,SIGNIN;
	@Override
	public String toString() {
		StringBuffer sql = new StringBuffer();
		switch(this) {
		case SIGNUP :
			sql.append("insert into customers(customer_id,customer_name,password,address,city,postal_code,ssn)" + 
					"values(?,?,?,?,?,?,?)");
			break;
		case SIGNIN :
			sql.append("SELECT * FROM customers WHERE customer_id LIKE ? AND password LIKE ? ");
			break;
		default :
			break;
		}
		return sql.toString();
	}
}
