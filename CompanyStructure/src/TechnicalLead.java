import java.util.ArrayList;
public class TechnicalLead extends TechnicalEmployee {

	protected ArrayList<SoftwareEngineer> softwareEngineers;
	protected Accountant accountantSupport;
	protected int headCount =0;

	/* Create a new Technical lead who has the salary of technical employee but multiplied by 1.3, has 4 head counts
	which means that one particular manager can manage up to 4 different software engineers. */
	public TechnicalLead(String name){
		super(name);
		baseSalary*=1.3;
		headCount=4;
		this.softwareEngineers=new ArrayList<>();
	}

	//Check if there is any available spot for new accountants otherwise return false;
	public boolean hasHeadCount(){
		if(softwareEngineers.size()<headCount){
			return true;
		}
		else {
			return false;
		}
	}

	/*Add a new software engineer to team if the team has an available spot and doesn't contain the software engineer.*/
	public boolean addReport(SoftwareEngineer SE){
		if(hasHeadCount()){
			softwareEngineers.add(SE); //adding an employee to the list if there is any space in softwareEngineers arraylist.
			SE.setManager(this);       //defining the manager of the employee we just added to list.
			return true;               //if employee added successfully.
		}
		else {
			return false;
		}
	}
	/*To give a permission for the check in, manager requires software engineers to be in their team and have to be
		available to code. */
	public boolean approveCheckIn(SoftwareEngineer SE){
		if(SE.getManager().equals(this)&& SE.getcodeAccess()){          //checking if that SE belongs to this manager and if SE has access to code
			return true;                                                //returns true if that SE provides these conditions.
		}
		else {
			return false;
		}
	}

	/**/
	public boolean requestBonus(Employee employee, double bonus){
		BusinessLead businessLead =(BusinessLead)getAccountantSupport().getManager();
		if(businessLead.busApproveBonus(employee,bonus)){
			return true;
		}
		else {return false;}

	}
	public String getTeamStatus(){
		if(this.softwareEngineers.isEmpty()){
		/*This string building is just for mark-up purposes. Basically we are erasing the dot at the end of the
		sentence. The give an example; 1 George has 0 successful check ins. no direct reports yet. becomes
		1 Geroge has 0 successful check ins no direct reports yet. */
			StringBuilder stringBuilder = new StringBuilder(this.employeeStatus());
			stringBuilder.deleteCharAt(this.employeeStatus().length()-1);
			return stringBuilder + " and has no software engineer in team.";
		}else{
			//Deleting the dot at the end of the employee status for technical lead;
			StringBuilder stringBuilder = new StringBuilder(this.employeeStatus());
			stringBuilder.deleteCharAt(this.employeeStatus().length()-1);
			//Concatenating "with and is managing:"
			stringBuilder.append(" and is managing: ");
			//Concatenating with team members' employee statuses.
			for(int i =0; i<softwareEngineers.size(); i++){
				stringBuilder.append("\n").append(softwareEngineers.get(i).employeeStatus());
			}
			return stringBuilder.toString();

		}
	}


	//Set the supporter accountant.
	public void setAccountantSupport(Accountant accountantSupport) {
		this.accountantSupport = accountantSupport;
	}
	//Get the supporter accountant.
	public Accountant getAccountantSupport(){
		return accountantSupport;
	}

}