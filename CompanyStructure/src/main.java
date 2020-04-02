import java.util.Scanner;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ArrayList<SoftwareEngineer> softwareEngineers = new ArrayList<>();
		ArrayList<TechnicalLead> technicalLeads = new ArrayList<>();
		ArrayList<Accountant> accountants = new ArrayList<>();
		ArrayList<BusinessLead> businessLeads = new ArrayList<>();

		BusinessLead b1 = new BusinessLead("Ayten");
		SoftwareEngineer s1= new SoftwareEngineer("Cavit");
		Accountant a1 = new Accountant("Yaprak");
		TechnicalLead t1 = new TechnicalLead("Ömer");
		softwareEngineers.add(s1);
		accountants.add(a1);
		technicalLeads.add(t1);
		businessLeads.add(b1);

		boolean runner1 = true;
		while (runner1) {

			//THE MAIN MENU.
			System.out.println("---------MAIN MENU---------");
			System.out.println("***PRESS 1 TO SEE EMPLOYEES' CURRENT STATUS");
			System.out.println("***PRESS 2 TO CREATE AN EMPLOYEE");
			System.out.println("***PRESS 3 TO OPERATION MENU FOR EMPLOYEES");
			System.out.println("***PRESS 0 TO TERMINATE THE PROGRAM");
			System.out.print("YOUR CHOICE: ");
			int tempChoice = input.nextInt();
			switch (tempChoice) {

				//See all the employee info from the menu.
				case 1:
					employeeInfo(softwareEngineers, technicalLeads, accountants, businessLeads);
					break;

				//Add new employee to the system.
				case 2:
					addNewEmployee(softwareEngineers, technicalLeads, accountants, businessLeads, input);
					break;

				//Do operations with the employees.
				case 3:
					System.out.println("");
					System.out.println("---------OPERATION MENU---------");
					boolean runner3 = true;
					//An inner loop for the multiple selections.
					while (runner3) {
						//THE MENU FOR IDS
						System.out.println("1 TO SOFTWARE ENGINEERS' OPERATIONS");
						System.out.println("2 TO TECHNICAL LEADS'  OPERATIONS");
						System.out.println("3 TO ACCOUNTANTS' OPERATIONS");
						System.out.println("4 TO BUSINESS LEADS' OPERATIONS");
						System.out.println("5 TO GO BACK");
						System.out.print("YOUR CHOICE: ");
						int operationChoice = input.nextInt();

						switch (operationChoice) {

							//SOFTWARE ENGINEER SECTION

							case 1:
								//THERE IS NO SOFTWARE ENGINEER
								if (softwareEngineers.isEmpty()) {
									System.out.println("\nThere is no software engineer at the moment.\n");
									break;
								} else {
									optionsForSoftwareEngineer(softwareEngineers, input);
								}
								break;

							//TECHNICAL LEAD SECTION
							case 2:
								//THERE IS NO TECHNICAL LEAD
								if (technicalLeads.isEmpty()) {
									System.out.println("\nThere is not any technical lead at the moment.\n");
									break;
								}else{
									optionsForTechnicalLead(softwareEngineers,technicalLeads,input);
									break;
								}

							case 3:
								//THERE IS NO ACCOUNTANT
								if (accountants.isEmpty()) {
									System.out.println("\nThere is not any accountant at the moment.\n");
									break;
								} else{
									optionsForAccountant(accountants,technicalLeads,input);
									break;
								}

							case 4:

								//THERE IS NO BUSINESS LEAD
								if (businessLeads.isEmpty()) {
									System.out.println("\nThere is not any business lead at the moment.\n");
									break;
								} else{
									optionsForBusinessLead(businessLeads, accountants, technicalLeads, input);
									break;
								}

								//GOING THE FROM THE MENU
							case 5:
								System.out.println("");
								runner3 = false;
								break;
						}
					}
					break;
				case 0:
					runner1 = false;
				default:
					System.err.println("Invalid option.");
					System.out.println("");
			}
		}
	}

	//Printing employee's status.
	public static void employeeInfo(ArrayList<SoftwareEngineer> softwareEngineers,
	                                ArrayList<TechnicalLead> technicalLeads,
	                                ArrayList<Accountant> accountants, ArrayList<BusinessLead> businessLeads) {

		//SOFTWARE ENGINEER INFO.
		System.out.println("");
		if (softwareEngineers.isEmpty()) {
			System.out.println("There is no Software Engineers at the moment.\n");
		} else {
			System.out.println("SOFTWARE ENGINEERS: \n");
			for (int i = 0; i < softwareEngineers.size(); i++) {
				System.out.println(softwareEngineers.get(i).employeeStatus() + "\n");
				System.out.println("- - - - - - - - - - - - - - - -");
			}
		}

		//TECHNICAL LEAD INFO.
		if (technicalLeads.isEmpty()) {
			System.out.println("There is no Technical Leads at the moment.\n");
		} else {
			System.out.println("TECHNICAL LEADS: \n");
			for (int i = 0; i < technicalLeads.size(); i++) {
				System.out.println(technicalLeads.get(i).employeeStatus() + "\n");
				System.out.println("- - - - - - - - - - - - - - - -");
			}
		}

		//ACCOUNTANT INFO.
		if (accountants.isEmpty()) {
			System.out.println("There is no Accountants at the moment.\n");
		} else {
			for (int i = 0; i < accountants.size(); i++) {
				System.out.println("ACCOUNTANTS: \n");
				System.out.println(accountants.get(i).employeeStatus() + "\n");
				System.out.println("- - - - - - - - - - - - - - - -");
			}
		}

		//BUSINESS LEAD INFO.
		if (businessLeads.isEmpty()) {
			System.out.println("There is no Business Leads at the moment.\n");
		} else {
			for (int i = 0; i < businessLeads.size(); i++) {
				System.out.println("BUSINESS LEADS: \n");
				System.out.println(businessLeads.get(i).employeeStatus() + "\n");
			}
		}

	}

	//Adding new employee to the system.
	public static void addNewEmployee(ArrayList<SoftwareEngineer> softwareEngineers,
	                                  ArrayList<TechnicalLead> technicalLeads,
	                                  ArrayList<Accountant> accountants, ArrayList<BusinessLead> businessLeads,
	                                  Scanner input) {
		System.out.println("");
		boolean runner2 = true;
		//THE MENU FOR THE CREATING A NEW EMPLOYEE
		while (runner2) {

			//MENU FOR CREATION
			System.out.println("---------EMPLOYEE CREATION MENU---------");
			System.out.println("PRESS 1 TO CREATE A SOFTWARE ENGINEER.");
			System.out.println("PRESS 2 TO CREATE A TECHNICAL LEAD.");
			System.out.println("PRESS 3 TO CREATE A ACCOUNTANT");
			System.out.println("PRESS 4 TO CREATE A BUSINESS LEAD.");
			System.out.println("PRESS 5 TO GO BACK.");
			System.out.print("YOUR CHOICE: ");
			int createEmp = input.nextInt();
			System.out.println("");

			switch (createEmp) {

				//CREATE A SOFTWARE ENGINEER
				case 1:
					System.out.print("Name of the software engineer: ");
					String seName = input.next();
					SoftwareEngineer se = new SoftwareEngineer(seName);
					softwareEngineers.add(se);
					System.out.println("\n");
					break;

				//CREATE A TECHNICAL LEAD
				case 2:
					System.out.print("Name of the technical lead: ");
					String tlName = input.next();
					TechnicalLead tl = new TechnicalLead(tlName);
					technicalLeads.add(tl);
					System.out.println("\n");
					break;

				//CREATE AN ACCOUNTANT
				case 3:
					System.out.print("Name of the accountant: ");
					String accName = input.next();
					Accountant acc = new Accountant(accName);
					accountants.add(acc);
					System.out.println("\n");
					break;

				//CREATE A BUSINESS LEAD
				case 4:
					System.out.print("Name of the business lead: ");
					String busName = input.next();
					BusinessLead bsl = new BusinessLead(busName);
					businessLeads.add(bsl);
					System.out.println("\n");
					break;
				default:
					System.err.println("Invalid input.");
					break;
				//GOING BACK TO THE PREVIOUS MENU
				case 5:
					runner2 = false;

			}
		}
	}

	//Specific options for software engineers.
	public static void optionsForSoftwareEngineer(ArrayList<SoftwareEngineer> softwareEngineers, Scanner input) {


		//GOING THROUGH OVER SOFTWARE ENGINEER ARRAY
		System.out.println("\nSOFTWARE ENGINEERS:\n");
		for (int i = 0; i < softwareEngineers.size(); i++) {
			System.out.println(softwareEngineers.get(i).employeeStatus() + "\n");
			System.out.println("- - - - - - - - - - - - - - - -");
		}

		//ASKING THE ID FOR OPERATIONS FOR LATER ON
		System.out.print("Enter Employee's ID to make operations: ");
		int seID = input.nextInt();
		System.out.println("");
		for (int i = 0; i < softwareEngineers.size(); i++) {
			if (seID == softwareEngineers.get(i).getEmployeeID()) {
				boolean runner4 = true;
				while (runner4) {
					System.out.println("1 TO SET CODE ACCESS."); //setcodeaccess
					System.out.println("2 TO CHECK IF THAT SOFTWARE ENGINEER HAS ACCESS TO CODE."); //getcodeaccess
					System.out.println("3 TO GET SUCCESSFUL CHECK-INS OF THAT SOFTWARE ENGINEER."); //getsuccesfull checkins
					System.out.println("4 TO CHECK IF THIS SOFTWARE ENGINEER'S MANAGER APPROVES OF HIS/HER CHECK-IN");//checkincode
					System.out.println("5 TO GO BACK");
					System.out.print("YOUR CHOICE: ");
					int seChoice = input.nextInt();
					switch (seChoice) {
						case 1:
							System.out.println("\nPRESS 1 TO GIVE ACCESS TO CODE.");
							System.out.println("PRESS 2 TO BLOCK ACCESS TO CODE.");
							System.out.print("YOUR CHOICE: ");
							int codeAcess = input.nextInt();
							if (codeAcess == 1) {
								softwareEngineers.get(i).setCodeAccess(true);
								System.out.println("Code allowance has been set to true");
								System.out.println("");
								break;
							} else if (codeAcess == 2) {
								softwareEngineers.get(i).setCodeAccess(false);
								System.out.println("Code allowance has been set to false");
								System.out.println("");
								break;
							} else {
								System.err.println("Invalid option.");
								System.out.println("");
								break;
							}
						case 2:
							boolean getCodeAccess = softwareEngineers.get(i).getcodeAccess();
							if (getCodeAccess) {
								System.out.println("\n" + softwareEngineers.get(i).getName() + " has access to code.\n");
								break;
							} else {
								System.out.println("\n" + softwareEngineers.get(i).getName() + " doesn't have access to code\n");
								break;
							}
						case 3:
							System.out.println("\n" + softwareEngineers.get(i).getName() + " has "
									+ softwareEngineers.get(i).getSuccessfulCheckIns() + " successful check-ins.\n");
							break;
						case 4:
							if (softwareEngineers.get(i).getManager() != null) {
								boolean approveCheckIn = softwareEngineers.get(i).checkInCode();
								if (approveCheckIn) {
									System.out.println(softwareEngineers.get(i).getName() + "'s check-in has approved.");
									break;
								} else {
									System.out.println(softwareEngineers.get(i).getName() + "'s check-in has not approved. " +
											softwareEngineers.get(i).getName() + " no longer has access to code.");
									break;
								}
							} else {
								System.out.println("\nThis employee's manager has not been set.\n");
								break;
							}
						case 5:
							runner4 = false;
							System.out.println("");
							break;
						default:
							break;
					}
				}
			}

		}
	}

	//Specific options for Technical Leads
	public static void optionsForTechnicalLead(ArrayList<SoftwareEngineer> softwareEngineers,
	                                           ArrayList<TechnicalLead> technicalLeads,
	                                           Scanner input){
		System.out.println("");
		System.out.println("TECHNICAL LEADS: \n");
		for (int i = 0; i < technicalLeads.size(); i++) {
			System.out.println(technicalLeads.get(i).employeeStatus() + "\n");
			System.out.println("- - - - - - - - - - - - - - - -");
		}
		System.out.print("\nEnter Employee's ID to make operations: \n");
		int tlID = input.nextInt();
		System.out.println("");
		for (int i = 0; i < technicalLeads.size(); i++) {
			if (tlID == technicalLeads.get(i).getEmployeeID()) {
				boolean runner5 = true;
				while (runner5) {
					System.out.println("PRESS 1 TO SEE IF THERE IS ENOUGH ROOM FOR OTHER SOFTWARE ENGINEERS");
					System.out.println("PRESS 2 TO ADD A NEW SOFTWARE ENGINEER TO TEAM");
					System.out.println("PRESS 3 TO APPROVE A CHECK-IN.");
					System.out.println("PRESS 4 TO CHECK IF THE BONUS AMOUNT REQUESTED WOULD BE APPROVED BY THE BUSINESS LEAD.");
					System.out.println("PRESS 5 TO GET TEAM INFORMATION");
					System.out.println("PRESS 6 TO GO BACK.");
					System.out.print("YOUR CHOICE: ");
					int tlCohice = input.nextInt();
					switch (tlCohice) {
						case 1:
							boolean tlHeadCount = technicalLeads.get(i).hasHeadCount();
							if (tlHeadCount) {
								System.out.println(technicalLeads.get(i).getName() + " has less direct reports than his/her headcount."
										+ "\nYou may add new direct report.\n");
								break;
							} else {
								System.out.println(technicalLeads.get(i).getName() + "s list of direct reports is full.");
								break;
							}
						case 2:

							for (int x = 0; x < softwareEngineers.size(); x++) {
								System.out.println(softwareEngineers.get(x).employeeStatus() + "\n");
								System.out.println("- - - - - - - - - - - - - - - -");
							}
							System.out.println("\nEnter the ID of the Employee that you want to add " + technicalLeads.get(i).getName()
									+ "'s list of direct reports:\n");
							int directReportID = input.nextInt();

							for (int x = 0; x < softwareEngineers.size(); x++) {
								if (directReportID == softwareEngineers.get(x).getEmployeeID()) {
									technicalLeads.get(i).addReport(softwareEngineers.get(x));
									System.out.println("\nEmployee added to the list of direct reports.\n");
									break;
								}
							}
							break;
						case 3:
							System.out.println(technicalLeads.get(i).getTeamStatus());
							System.out.println("\nEnter the ID of the Employee that you want to approve his/her check-in\n");
							int tlApproveID = input.nextInt();
							for (int y = 0; y < softwareEngineers.size(); y++) {
								if (softwareEngineers.get(y).getEmployeeID() == tlApproveID) {
									technicalLeads.get(i).approveCheckIn(softwareEngineers.get(y));
									System.out.println("\nCheck-in approved.\n");
									break;
								}
							}
							break;
						case 4:

							if(technicalLeads.get(i).getAccountantSupport()!=null&&technicalLeads.get(i).getAccountantSupport().getManager()!=null
									&&technicalLeads.get(i).softwareEngineers.size()!=0) {
								System.out.println(technicalLeads.get(i).getTeamStatus() + "\n");
								System.out.println("\nEnter the ID of the Software Engineer that you want to request bonus for.\n");
								Integer seRequestBonusID = input.nextInt();
								System.out.println("Enter the bonus amount");
								double seRequestBonusAmount = input.nextDouble();
								ArrayList<Integer>SEIDs=new ArrayList<>();
								for(int m=0;m<softwareEngineers.size();m++){
									SEIDs.add(softwareEngineers.get(m).getEmployeeID());
								}
								int indexTransition;
								for (int y = 0; y < softwareEngineers.size(); y++) {
									if (seRequestBonusID == softwareEngineers.get(y).getEmployeeID()) {
										BusinessLead tempbsl= (BusinessLead) technicalLeads.get(i).getAccountantSupport().getManager();
										indexTransition=SEIDs.indexOf(seRequestBonusID);
										tempbsl.busApproveBonus(softwareEngineers.get(indexTransition),seRequestBonusAmount);
										//technicalLeads.get(i).requestBonus(softwareEngineers.get(y), seRequestBonusAmount);
										boolean tlRequestBonus = technicalLeads.get(i).requestBonus(softwareEngineers.get(y), seRequestBonusAmount);
										if (tlRequestBonus) {
											System.out.println("\nBonus can be approved.\nEmployee will get his bonus.");
										} else {
											System.out.println("\nBonus can not be approved\n");
										}
									}

								}
							}
							else{System.out.println("\nto use that function this technical lead's must have an " +
									"accountant and that accountant" +
									"must have a business lead that manages him/her.\nAlso this technical lead's list of direct reports cant be empty.\n" +
									"You cant do bonus operations at the moment.\n");}
							break;
						case 5:
							System.out.println(technicalLeads.get(i).getTeamStatus());
							break;

						case 6:
							runner5 = false;
							break;
						default:
							break;
					}
				}
			}
			break;
		}
	}
	//Specific options for Accountans.
	public static void optionsForAccountant(ArrayList<Accountant> accountants,
	                                        ArrayList<TechnicalLead> technicalLeads ,Scanner input){

		System.out.println("\nAccountants:\n");
		for (int i = 0; i < accountants.size(); i++) {
			System.out.println(accountants.get(i).employeeStatus() + "\n");
			System.out.println("- - - - - - - - - - - - - - - -");
		}
		System.out.println("\nEnter employee ID to make operations\n");
		int accID = input.nextInt();
		for (int i = 0; i < accountants.size(); i++) {
			if (accID == accountants.get(i).getEmployeeID()) {
				boolean runner6 = true;
				while (runner6) {
					System.out.println("\nPRESS 1 TO SEE WHICH TECHNICAL LEAD THIS ACCOUNTANT SUPPORTING.");
					System.out.println("PRESS 2 TO SET A TEAM THAT THIS ACCOUNTANT WILL BE SUPPORTING.");
					System.out.println("PRESS 3 TO SEE IF THERE IS ENOUGH ROOM FOR SUGGESTED BONUS IN THE BUDGET.");
					System.out.println("PRESS 4 FOR EMPLOYEE STATUS.");
					System.out.println("PRESS 5 TO GO BACK.\n");
					int accChoice = input.nextInt();
					switch (accChoice) {
						case 1:
							if (accountants.get(i).getTechTeamSupported() == null) {
								System.out.println("\nThis accountant is not supporting any Technical Lead at the moment.\n");
								break;
							} else {
								System.out.println("\n" + accountants.get(i).getName() + " is currently supporting "
										+ accountants.get(i).getTechTeamSupported() + "'s team.\n");
								break;
							}
						case 2:
							if (technicalLeads.size() != 0) {
								System.out.println("\nTechnical Leads:\n");
								for (int m = 0; m < technicalLeads.size(); m++) {
									System.out.println(technicalLeads.get(m).employeeStatus() + "\n");
									System.out.println("- - - - - - - - - - - - - - - -");
								}
								System.out.println("\nEnter the ID of the Technical Lead that will be supported\n");
								int supportID = input.nextInt();
								for (int n = 0; n < technicalLeads.size(); n++) {
									if (supportID == technicalLeads.get(n).getEmployeeID()) {
										accountants.get(i).supportTechTeam(technicalLeads.get(n));
										System.out.println("\nThis accountant is now supporting "
												+ technicalLeads.get(n).getName() + "\n");
										break;
									}
								}
							} else {
								System.out.println("List of technical leads is empty.\n" +
										"Operation can not be done.\n");
								break;
							}
							break;
						case 3:
							System.out.println("\nEnter the bonus amount\n");
							double amountBonus = input.nextDouble();
							boolean bonusCheck = accountants.get(i).accApproveBonus(amountBonus);
							if (bonusCheck) {
								System.out.println("\nThat amount is available.\n");
								break;
							} else {
								System.out.println("\nBonus can not be used.\n");
								break;
							}
						case 4:
							System.out.println(accountants.get(i).employeeStatus() + "\n");
							break;
						case 5:
							runner6 = false;
							break;
						default:
							break;
					}
				}
			}

		}
	}

	//Specific options for Business lLeads.
	public static void optionsForBusinessLead(ArrayList<BusinessLead>businessLeads, ArrayList<Accountant> accountants
			, ArrayList<TechnicalLead> technicalLeads, Scanner input) {
		System.out.println("Business Leads:\n");
		for (int i = 0; i < businessLeads.size(); i++) {
			System.out.println(businessLeads.get(i).employeeStatus() + "\n");
			System.out.println("- - - - - - - - - - - - - - - -");
		}
		System.out.println("\nEnter Employee ID to make operations\n");
		int busLeadID = input.nextInt();
		for (int i = 0; i < businessLeads.size(); i++) {
			if (busLeadID == businessLeads.get(i).getEmployeeID()) {
				boolean runner7 = true;
				while (runner7) {
					System.out.println("\nPRESS 1 TO SEE IF THE NUMBER OF DIRECT REPORTS THIS MANAGER HAS IS LESS THAN HIS/HER HEADCOUNT.");
					System.out.println("PRESS 2 TO ADD AN ACCOUNTANT TO THIS BUSINESS LEAD'S TEAM AND " +
							"REFERENCE OF A TECHNICAL LEAD THAT THE " +
							"ADDED ACCOUNTANT WILL BE SUPPORTING.");
					System.out.println("PRESS 3 TO REQUEST A BONUS FOR EMPLOYEE");   //business lead's budget will be used.
					System.out.println("PRESS 4 TO GET TEAM STATUS.");
					System.out.println("PRESS 5 TO GO BACK.\n");
					int busLeadChoice = input.nextInt();
					switch (busLeadChoice) {
						case 1:
							boolean busLeadHasHeadCount = businessLeads.get(i).hasHeadCount();
							if (busLeadHasHeadCount) {
								System.out.println("\n" + businessLeads.get(i).getName() + " has less direct reports than " +
										"his/her head count.\nYou may add new direct reports.\n");
								break;
							} else {
								System.out.println("\n" + businessLeads.get(i).getName() + "s list of direct reports is full.\n");
								break;
							}
						case 2:
							ArrayList<Integer> accIDs = new ArrayList<>();
							ArrayList<Integer> techIDs = new ArrayList<>();
							for (int m = 0; m < accountants.size(); m++) {
								accIDs.add(accountants.get(m).getEmployeeID());
							}
							for (int n = 0; n < technicalLeads.size(); n++) {
								techIDs.add(technicalLeads.get(n).getEmployeeID());
							}
							if (accountants.size() != 0) {
								System.out.println("\nAccountants:\n");
								for (int a = 0; a < accountants.size(); a++) {
									System.out.println(accountants.get(a).employeeStatus() + "\n");
									System.out.println("- - - - - - - - - - - - - - - -");
								}
								System.out.println("\nEnter the ID of the accountant that you want to add to the list of directs " +
										"reports of " + businessLeads.get(i).getName() + "\n");
								int accAddReportID = input.nextInt();
								boolean ifContainsAcc = false;

								if (accIDs.contains(accAddReportID)) {
									ifContainsAcc = true;
								}

								if (!ifContainsAcc) {
									System.out.println("\nYou have entered invalid ID.\n");
									break;

								} else {
									if (technicalLeads.size() != 0) {
										System.out.println("\nTechnical Leads:\n");
										for (int x = 0; x < technicalLeads.size(); x++) {
											System.out.println(technicalLeads.get(x).employeeStatus() + "\n");
											System.out.println("- - - - - - - - - - - - - - - -");
										}
										System.out.println("\nEnter the ID of the Technical Lead that you want to make your accountant" +
												" support.\n");
										int tlAddReportID = input.nextInt();
										boolean ifContainsTL = false;
										if (techIDs.contains(tlAddReportID)) {
											ifContainsTL = true;
										}
										if (!ifContainsTL) {
											System.out.println("\nYou have entered an invalid ID\n");
											break;
										} else {
											for (int z = 0; z < accountants.size(); z++) {
												if (accountants.get(z).getEmployeeID() == accAddReportID) {
													for (int l = 0; l < technicalLeads.size(); l++) {
														if (technicalLeads.get(l).getEmployeeID() == tlAddReportID) {
															businessLeads.get(i).addReport(accountants.get(z), technicalLeads.get(l));
															System.out.println("\nOperation Successful.\n");
															break;
														}
													}
												}
											}
										}
										break;
									} else {
										System.out.println("\nThere is not any technical lead at the company right now." +
												"");
										break;
									}
								}
							} else {
								System.out.println("\nThere is not any accountant at the company right now.");
								break;
							}

						case 3:
							if (businessLeads.get(i).accountants.size() != 0) {
								System.out.println("\nAccountants:\n");
								for (int a = 0; a < accountants.size(); a++) {
									System.out.println(accountants.get(a).employeeStatus() + "\n");
									System.out.println("- - - - - - - - - - - - - - - -");
								}
								System.out.println("\nEnter the ID of the accountant that you want to request bonus for.\n");
								int accRequestID = input.nextInt();
								for (int m = 0; m < accountants.size(); m++) {
									if (accountants.get(m).getEmployeeID() == accRequestID) {
										System.out.println("\nEnter the bonus amount\n");
										double accBonusAmount = input.nextDouble();
										businessLeads.get(i).requestBonus(accountants.get(m), accBonusAmount);
										boolean busRequestBonus = businessLeads.get(i).requestBonus(accountants.get(m), accBonusAmount);
										if (busRequestBonus) {
											System.out.println("Operation successful");
											break;
										} else {
											System.out.println("Operation ineffective");
											break;
										}
									} else {
										System.out.println("Invalid ID.");
									}
								}
								break;
							} else {
								System.out.println("This Business Lead's list of direct reports is empty at the moment.\nCant do bonus operations.");
								break;
							}

						case 4:
							System.out.println("\n" + businessLeads.get(i).getTeamStatus());
							break;
						case 5:
							runner7 = false;
							break;
						default:
							break;
					}
				}
			}
			break;
		}
	}

}

