package enums;
//employeeID,manager,name,birthDate,photo,note
public enum EmployeeSQL {
	REGISTER,TEST;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case REGISTER:
			query = "INSERT INTO EMPLOYEES(EMPLOYEE_ID,MANAGER,NAME,BIRTHDATE,PHOTO,NOTES)"
					+ " VALUES(EMP_SEQ.NEXTVAL,?,?,?,?,?)";
			break;
		case TEST:
			query = "SELECT COUNT(*) AS COUNT FROM EMPLOYEES";
			break;
		default:
			break;
		}
		
		return query;
	}
}
