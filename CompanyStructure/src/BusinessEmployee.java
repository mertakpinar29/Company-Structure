public class BusinessEmployee extends Employee {


	public BusinessEmployee(String name){
		super(name,50000);
	}

	//Return the bonus budget.
	public double getBonusBudget(){
		return bonusBudget;
	}
	//Return the employee status with every information belonging to it.
	public String employeeStatus() {
		return "ID:" +getEmployeeID() +", " + getName() + " with a budget of "+ getBonusBudget();
	}
}