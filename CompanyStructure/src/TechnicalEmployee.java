public class TechnicalEmployee extends Employee {

	public int checkIns;  // Successful check ins.

	/*When its created it starts with 75k salary with 0 check ins.*/
	public TechnicalEmployee(String name){
		super(name,75000);
		checkIns =0;
	}

	//Return the successful check ins of the employee.
	public int getCheckIns() {
		return checkIns;
	}

	// Return employee's status by showing the attributes of it.
	@Override
	public String employeeStatus() {

		return "ID:"+ getEmployeeID() + ", "+getName()  +" has "+ getCheckIns()+"" +" successful check ins.";
	}

}