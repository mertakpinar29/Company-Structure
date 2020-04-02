import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {

	protected ArrayList<Accountant> accountants; //Currently managed accountant's list.
	protected int headCount =0;                  //Size of the people this business lead could manage.

	/*Business Lead has twice as of salary compared to an accountant and has 10 head counts as oppose to technical
	lead's 5*/
	public BusinessLead(String name) {
		super(name);
		this.baseSalary = getBaseSalary() * 2;  //Their salary is twice of the accountants.
		this.headCount = 10;                    //They start with the headcount of 10.
		this.accountants = new ArrayList<>();   //They manage accountants.
	}


	//Check if there is any available spot for new accountants otherwise return false;
	public boolean hasHeadCount(){
		if(this.accountants.size()<this.headCount){
			return true;
		}
		else{
			return false;
		}
	}

	/*Assigning an accountant to a technical leader by checking if the business lead has enough room for the
	accountant and calculating the budget via adding a new accountant's salary to the total while multiplying by 1.1;
	In this way we can also determine the budget of the business lead. If there is no assigned accountant, there wont
	 be any budget for the business lead.*/
	public boolean addReport(Accountant acc, TechnicalLead supportedTeam){
		if(hasHeadCount()){
			accountants.add(acc);   //Adding accountant a to this Business lead's list.
			acc.setManager(this);   //Setting accountant a's manager as this business lead.
			this.bonusBudget += acc.baseSalary*1.1;   //Updating this business lead's bonus budget
			acc.supportTechTeam(supportedTeam);  //That employee's team they are supporting should be updated to
			// Reflect the reference to the technical lead given.
			return true;
		}
		else{
			return false;
		}
	}

	/*Request the budget according the this business lead's bonus budget capability, this will return true if the
	requested amount is less than the bonus this business lead has.*/
	public boolean requestBonus(Employee employee, double bonus){
		if(getBonusBudget()>=bonus){
			this.bonusBudget=this.bonusBudget-bonus;
			employee.bonusBudget=employee.bonusBudget+bonus;
			return true;
		}
		else {
			return false;
		}
	}


	/*Approve the bonus if the requester of the bonus is supported by the relevant accountant and the accountant
	has enough room for the requested amount, return true otherwise false.*/
	public boolean busApproveBonus(Employee employee, double bonus){
		for (int i=0;i<accountants.size();i++){
			if((accountants.get(i).getTechTeamSupported()).equals(employee.manager) && accountants.get(i).accApproveBonus(bonus)) {
				employee.bonus += bonus;
				accountants.get(i).bonusBudget -= bonus;
				return true;
			}
		}
		return  false;
	}

	public String getTeamStatus(){
		if(this.accountants.isEmpty()){
		/*This string building is just for mark-up purposes. Basically we are erasing the dot at the end of the
		sentence. The give an example; 1 George has 0 successful check ins. no direct reports yet. becomes
		1 Geroge has 0 successful check ins no direct reports yet. */
			StringBuilder stringBuilder = new StringBuilder(this.employeeStatus());
			stringBuilder.deleteCharAt(this.employeeStatus().length()-1);
			return stringBuilder + " and has no accountant in team.";
		}else{
			//Deleting the dot at the end of the employee status for technical lead;
			StringBuilder stringBuilder = new StringBuilder(this.employeeStatus());
			stringBuilder.deleteCharAt(this.employeeStatus().length()-1);
			//Concatenating "with and is managing:"
			stringBuilder.append(" and is managing: ");
			//Concatenating with team members' employee statuses.
			for(int i =0; i<accountants.size(); i++){
				stringBuilder.append("\n").append(accountants.get(i).employeeStatus());
			}
			return stringBuilder.toString();

		}
	}

}