public abstract class Employee {

	private static int IDcount;
	protected String name;
	protected double baseSalary;
	private int employeeID;
	protected Employee manager;
	private Accountant accountantSupport;
	protected double bonus;

	protected double bonusBudget;

	public Employee(String name,double baseSalary){
		this.name=name;
		this.baseSalary=baseSalary; 		//whenever you use that method IDCount will be added by 1.So that every ID will be unique.
		this.employeeID += ++IDcount;
	}

	//Set the supporter accountant.
	public void setAccountantSupport(Accountant accountantSupport) {
		this.accountantSupport = accountantSupport;
	}


	//Return the salary of the employee.
	public double getBaseSalary() {
		return baseSalary;
	}

	//Return the name of the employee.
	public String getName() {
		return name;
	}

	//Return the id of the employee.
	public int getEmployeeID(){
		return employeeID;
	}

	//Set the manager of the employee.
	public void setManager(Employee manager){
		this.manager=manager;
	}

	//Get the employee's manager.
	public Employee getManager(){
		return manager;
	}

	//Check if the two ids are equal.
	public boolean equals(Employee otherEmployee){
		if(this.getEmployeeID()==otherEmployee.getEmployeeID()){
			return true;
		}
		else{
			return false;
		}
	}


	public String toString() {
		return getName() +" with the ID of " + getEmployeeID();
	}

	//This method will be implemented individually across the classes.
	public abstract String employeeStatus();


}