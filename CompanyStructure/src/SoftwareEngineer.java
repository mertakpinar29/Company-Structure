public class SoftwareEngineer extends TechnicalEmployee {

	public boolean codeAccess; // Availability of the engineer's showing whether is available to code or not.

	/*When there is a new Software Engineer, their attributes are the followings; No code access and no code check ins.*/
	public SoftwareEngineer(String name){
		super(name);
		setCodeAccess(false);
	}

	//Check if the software engineer is available to write codes.
	public boolean getcodeAccess(){
		return codeAccess;
	}

	//Return how many check ins a software engineer has.
	public void setCodeAccess(boolean codeAccess){
		this.codeAccess=codeAccess;
	}

	//Return how many check ins a software engineer has.
	public int getSuccessfulCheckIns(){
		return checkIns;
	}

	/*In order to check in a code, you need to have the permission from the related manager.
		Two things are required, The software engineer should be in the technical lead's team and also must be
		available for coding. Otherwise, this method returns false.*/
	public boolean checkInCode(){
		TechnicalLead manager=(TechnicalLead) this.getManager();
		if(manager.approveCheckIn(this)){             //Checking if the software engineer's manager approved his
			// check-in.
			this.checkIns++;                              //Returns true if manager approved.
			return true;
		}
		else{
			codeAccess=false;
			return false;
		}
	}

}