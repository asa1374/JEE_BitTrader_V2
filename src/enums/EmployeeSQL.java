package enums;
//employeeID,manager,name,birthDate,photo,note
public enum EmployeeSQL {
	REGISTER,ACCESS,TEST;
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case REGISTER:
			query.append("INSERT INTO EMPLOYEES(EMPLOYEE_ID,MANAGER,NAME,BIRTHDATE,PHOTO,NOTES)"
					+ " VALUES(EMPLOYEE_ID.NEXTVAL,?,?,?,'1000',?)");
			break;
		case TEST:
			query.append("SELECT COUNT(*) AS COUNT FROM EMPLOYEES");
			break;
		case ACCESS:
			query.append("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID LIKE ? AND NAME LIKE ? ");
			break;
		default:
			break;
		}
		
		return query.toString();
	}
}
