public class Accountant extends BusinessEmployee {

	private TechnicalLead techTeamSupported; // Supported team is the team that technical lead has.


	//When its created, it doesn't support any of teams and doesn't have any bonus budget available.
	public Accountant(String name){
		super(name);
		bonusBudget=0;
	}

	//Return the supported team currently this accountant supports, if there is non it returns null.
	public TechnicalLead getTechTeamSupported(){
		return techTeamSupported;
	}

	/* Setting the technical lead's team as a supported one. This methods also calculates the budget of this particular
	accountant by adding all software engineers' salaries in order to create a total budget for the accountant. Also,
	there is an additional %10 bonus on top of each salary. */
	public void supportTechTeam(TechnicalLead techLead){
		techLead.setAccountantSupport(this);
		this.techTeamSupported=techLead;
		for(int i=0;i<techLead.softwareEngineers.size();i++){
			this.bonusBudget += techLead.softwareEngineers.get(i).getBaseSalary() +
					techLead.softwareEngineers.get(i).getBaseSalary() * 0.1;
		}
	}

	/*Approve the requested bonus if there is a room for that in the budget, if this accountant doesn't support any
		team then false should be return. */
	public boolean accApproveBonus(double bonus){
		if(bonus>this.getBonusBudget()){ //Checking bonusBudget to see if the amount of the requestedBonus is available
			return false;                //Returns false if there is not enough bonus in budget
		}
		else{
			return true;                 //Returns true if requested bonus is available in budget.
		}
	}

	// Return employee's status by showing the attributes of it.
	@Override
	public String employeeStatus() {
		return super.employeeStatus()+" currently supporting: \n"+ this.getTechTeamSupported();
	}
}