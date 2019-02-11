package enums;
//CUSTOMER_ID,password,CONTACT_NAME
//ADDRESS,CITY,POSTAL_CODE,ssn
public enum CustomerSQL {
	SIGNUP,SIGNIN,LIST;
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
			sql.append("SELECT * FROM customers");
			break;
		default :
			break;
		}
		return sql.toString();
	}
}
