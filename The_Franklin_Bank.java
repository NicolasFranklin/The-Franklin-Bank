/**
 * Title: Franklin Bank
 * Description of Purpose: This program simulates the functions of a bank teller
 * Author: Nicolas Franklin
 * Start: September 22nd 2015
 * End: October 3rd 2015
 */

import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class The_Franklin_Bank
{

    public static void main(String[] args) throws Exception
    {

    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); //Needed to get input from user

		//Date
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));

		//Readers and Writers for names.txt
		FileWriter fwNames = new FileWriter("names.txt", true);
    	PrintWriter writer = new PrintWriter(fwNames);

    	FileReader  frNames = new FileReader("names.txt");
    	BufferedReader reader= new BufferedReader(frNames);

		//Declaring Variables
    	int exit=0, choice, existAcc=0;

    	//When file reading is unavailable, user starts with $100 in each Acc.
    	double cheqBal=100.0, savBal=100.0;

		//Used to check if a username is valid
    	boolean username=false, invalid=false;

    	//The name is printed at the start, but its doccumented out so I need to make it blank in order to avoid error
    	String name="", user="", cheqBalString="", savBalString="";

		//Title Screen
		System.out.println("\n\n\n\n\n                     ***************************************************");
		System.out.println("                     *       ______               _    _ _             *");
		System.out.println("                     *      |  ____|             | |  | (_)            *");
		System.out.println("                     *      | |__ _ __ __ _ _ __ | | _| |_ _ __        *");
		System.out.println("                     *      |  __| '__/ _` | '_ \\| |/ / | | '_ \\       *");
		System.out.println("                     *      | |  | | | (_| | | | |   <| | | | | |      *");
		System.out.println("                     *      |_|  |_|  \\__,_|_| |_|_|\\_\\_|_|_| |_|      *");
		System.out.println("                     *        _    ____              _        _        *");
		System.out.println("                     *       | |  |  _ \\            | |      | |       *");
		System.out.println("                     *      / __) | |_) | __ _ _ __ | | __  / __)      *");
		System.out.println("                     *      \\__ \\ |  _ < / _` | '_ \\| |/ /  \\__ \\      *");
		System.out.println("                     *      (   / | |_) | (_| | | | |   <   (   /      *");
		System.out.println("                     *       |_|  |____/ \\__,_|_| |_|_|\\_\\   |_|       *");
		System.out.println("                     *                                                 *");
		System.out.println("                     ***************************************************");

		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n Press Enter to continue... ");
		br.readLine();
		clear();
		System.out.println("");


		//Loop for entering whether you want to create an acc. Loops if choice is invalid
		do
		{

			//set invalid to false when re-looping
			invalid=false;



			System.out.println(" If you have an existing account, press 1");
			System.out.println(" If you would like to create an account, press 2");
			System.out.print(" Choice: ");
			existAcc=Integer.parseInt(br.readLine());
			System.out.println("");



			//If you have an account
			if(existAcc==1)
			{


				System.out.print(" What is your name: ");
				name=br.readLine();
				System.out.print("\n What is your corresponding username: ");
				user=br.readLine();


				//Writing each name to a line and checking if it = user.
				String names;
				while ((names = reader.readLine()) != null)
				{
					//If its the same, make username true
					if(user.compareTo(names)==0)
					{
						username=true;
					}

				}


				//If username was triggered, name found
				if(username==true)
					System.out.println(" Name Found!");


				//If username was not triggered, name wasnt found
				if(username==false)
				{
					System.out.println(" Name not found... You do NOT belong to this bank... Closing Program");
					System.exit(0);
				}


				//Prompt to save and quit
				System.out.println(" MAKE SURE YOU SAVE AND EXIT !!!!!!");
				br.readLine();
			}

			//If you want to create an account
			else if(existAcc==2)
			{
				System.out.println(" You have chosen to create an account");
				System.out.print(" What is your name: ");
				name=br.readLine();
				System.out.print("\n What is your corresponding username: ");
				user=br.readLine();
			}

			else
			{
				System.out.println(" Invalid");
				invalid=true;
			}


    	}while (invalid==true);


		//Readers and Writers for userDataTEMP.txt   //NOTE: THESE LINES CREATE THE FILE
		FileWriter fwTemp = new FileWriter(user+"TempData.txt", true);
		PrintWriter pwTemp = new PrintWriter(fwTemp);

		FileReader  frTemp = new FileReader(user+"TempData.txt");
		BufferedReader br2Temp = new BufferedReader(frTemp);

		//Readers and Writers for userData.txt   //NOTE: THESE LINES CREATE THE FILE
		FileWriter fw = new FileWriter(user+"Data.txt");
		PrintWriter pw = new PrintWriter(fw);

		FileReader  fr = new FileReader(user+"Data.txt");
		BufferedReader br2= new BufferedReader(fr);


		//Reading the balances to variables
		cheqBalString = br2Temp.readLine();
			System.out.print(cheqBal + "\n");

		savBalString = br2Temp.readLine();
			System.out.print(savBal + "\n");

			
			

		//tracing
		System.out.print(cheqBalString + "String\n");
		System.out.print(savBalString + "String\n");



		
		
		//If it IS null. it will create NullPointer Ex
		if(cheqBalString!=null)
		{
			//Convering Strings to Doubles
			cheqBal = Double.parseDouble(cheqBalString);
			savBal = Double.parseDouble(savBalString);
		}



		//Readers and Writers for userTransData.txt   //NOTE: THESE LINES CREATE THE FILE
		FileWriter fw1 = new FileWriter(user+"TransData.txt", true);
    	PrintWriter pw1 = new PrintWriter(fw1);

    	FileReader  fr1 = new FileReader(user+"TransData.txt");
    	BufferedReader br1= new BufferedReader(fr1);




		//Printing User to Names.txt
		writer.println(user);
		writer.close();
		clear();

		System.out.println(" Welcome "+name);
		if(existAcc==2)
		{
			System.out.println(" We see that this is your first time here!");
			System.out.println(" Allow the bank to start you off with $100 in each account!");
		}


		do
		{
			//Main selection screen
			System.out.println("\n\n\n Please make a selection \n\n\n\n\n");
			System.out.println(" 1. Deposits");
			System.out.println(" 2. Withdrawls");
			System.out.println(" 3. Transfers from a chequing account to a savings account (or vice versa)");
			System.out.println(" 4. Display Transaction History."); //Print file
			System.out.println(" 5. SAVE and Exit.\n\n\n\n\n\n\n\n\n\n\n\n");

			System.out.print(" Choice: ");
			choice=Integer.parseInt(br.readLine());



			//DEPOSITS
			if(choice==1)
			{
				clear();

				System.out.println(" Which account would you like to access?");
				System.out.println(" Press 1 for Chequing, or 2 for Savings");
				System.out.print(" ");
				int whatAccount=Integer.parseInt(br.readLine());
				System.out.println("");

				//CHEQUING
				if(whatAccount==1)
				{
					System.out.println(" Your current balance for Chequing is $"+cheqBal);
					System.out.println(" How much money would you like to deposit?");
					System.out.print(" Amount: $");
					double amount=Double.parseDouble(br.readLine());

					//Adding the amount into cheqBal
					cheqBal=cheqBal+amount;

					//Printing Cheqbal
					System.out.println("\n Your current balance for Chequing is $"+cheqBal);


					//Printing the transaction history
					pw1.println("Deposit of $"+amount+" to Chequing at "+(df.format(dateobj)));



					System.out.print(" Press enter to continue");
					br.readLine();
					System.out.println("");

				}

				//SAVINGS
				else if(whatAccount==2)
				{
					System.out.println(" Your current balance for Savings is $"+savBal);
					System.out.println(" How much money would you like to deposit?");
					System.out.print(" Amount: $");
					double amount=Double.parseDouble(br.readLine());

					//Adding the amount into savBal
					savBal=savBal+amount;

					//Printing savBal
					System.out.println("\n Your current balance for Savings is $"+savBal);


					//Printing the transaction history
					pw1.println("Deposit of $"+amount+" to Savings at "+(df.format(dateobj)));



					System.out.print(" Press enter to continue");
					br.readLine();
					System.out.println("");
				}

				else
					System.out.println(" Invalid choice");

			}





			//WITHDRAWLS
			else if(choice==2)
			{

				clear();

				System.out.println(" Which account would you like to access?");
				System.out.println(" Press 1 for Chequing, or 2 for Savings");
				System.out.print(" ");

				int whatAccount=Integer.parseInt(br.readLine());
				System.out.println("");

				//CHEQUING
				if(whatAccount==1)
				{
					//NotEnough must be declared OUTSIDE the do-while because it is used as a parameter
					boolean notEnough=false;

					double amount=0.0;

					do
					{
						//This is so that when the it loops back, notEnough is set back to false
						notEnough=false;

						System.out.println(" Your current balance for Chequing is $"+cheqBal);
						System.out.println("\n How much money would you like to withdraw?");
						System.out.print(" Amount: $");
						amount=Double.parseDouble(br.readLine());
						System.out.println("");

						//If the amount is greater than you have in the account, error; loop back
						if(amount>cheqBal)
						{
							System.out.println(" Sorry, you do not have enough money!");
							notEnough=true;
							System.out.println("\n");
						}


					}while(notEnough==true);

					//If it passes the "notEnough" loop, we can now make the adjustments to balance
					cheqBal=cheqBal-amount;

					System.out.println("\n Your current balance for Chequing is $"+cheqBal);


					//Write to TransHistory.txt (NEW LINE)
					//Withdrawl of $(amount) from Chequing on (DATE)
					pw1.println("Withdrawl of $"+amount+" from Chequing at "+(df.format(dateobj)));

					System.out.print("\n Press enter to continue");
					br.readLine();
					System.out.println("");

				}

				//SAVINGS
				else if(whatAccount==2)
				{
					boolean notEnough=false;
					double amount=0.0;

					do
					{
						notEnough=false;
						System.out.println(" Your current balance for Savings is $"+savBal);
						System.out.println(" How much money would you like to withdraw?");
						System.out.print(" Amount: $");
						amount=Double.parseDouble(br.readLine());
						System.out.println("");

						if(amount>savBal)
						{
							System.out.println(" Sorry, you do not have enough money!");
							notEnough=true;
							System.out.println("\n");
						}


					}while(notEnough==true);

					savBal=savBal-amount;

					System.out.println("");
					System.out.println(" Your current balance for Savings is $"+savBal);


					//Write to TransHistory.txt (NEW LINE)
					//Withdrawl of $(amount) from Savings on (DATE)

					pw1.println("Withdrawl of $"+amount+" from Savings at "+(df.format(dateobj)));



					System.out.print("\n Press enter to continue");
					br.readLine();
					System.out.println("");
				}

				else
					System.out.println(" Invalid choice");

			}

			//TRANSFER
			else if(choice==3)
			{
				clear();

				System.out.println(" Press 1 to transfer from Chequing TO Savings");
				System.out.println(" Press 2 to transfer from Savings TO Chequing");
				System.out.print(" Choice: ");
				int whatAccount=Integer.parseInt(br.readLine());
				System.out.println("");

				//CHEQ->SAV
				if(whatAccount==1)
				{
					double amount=0.0;
					boolean notEnough=false;

					do
					{
						notEnough=false;
						System.out.println(" How much would you like to transfer into Savings?");
						System.out.print(" Amount: $");
						amount=Double.parseDouble(br.readLine());
						System.out.println("");

						//Since transfer is FROM cheq, we must make sure that the amount is NOT > cheqBal
						if(amount>cheqBal)
						{
							System.out.println(" Sorry, you do not have enough money!");
							notEnough=true;
							System.out.println("");
						}


					}while(notEnough==true);

					//If we pass the loop, adjustments can be made to the balances
					savBal=savBal+amount;
					cheqBal=cheqBal-amount;

					//Print the balances of each accounts
					System.out.println("\n Chequing balance: $"+cheqBal);
					System.out.println(" Savings balance: $"+savBal);



					//Write to TransHistory.txt (NEW LINE)
					//Transfer of $(amount) from Chequing to Savings on (DATE)

					pw1.println("Tranfered $"+amount+" into Savings at "+(df.format(dateobj)));



					System.out.print("\n Press enter to continue");
					br.readLine();
					System.out.println("");

				}

				//SAV->CHEQ
				else if(whatAccount==2)
				{

					double amount=0.0;
					boolean notEnough=false;

					do
					{
						notEnough=false;
						System.out.println(" How much would you like to transfer into Chequing?");
						System.out.print(" Amount: $");
						amount=Double.parseDouble(br.readLine());
						System.out.println("");

						if(amount>savBal)
						{
							System.out.println(" Sorry, you do not have enough money!");
							notEnough=true;
							System.out.println("");
						}


					}while(notEnough==true);

					cheqBal=cheqBal+amount;
					savBal=savBal-amount;

					//Print the balances of each accounts
					System.out.println(" Savings balance: $"+savBal);
					System.out.println(" Chequing balance: $"+cheqBal);
					System.out.print("");


					//Write to TransHistory.txt (NEW LINE)
					//Transfer of $(amount) from Savings to Chequing on (DATE)

					pw1.println("Tranfered $"+amount+" into Chequing at "+(df.format(dateobj)));





					System.out.print(" Press enter to continue");
					br.readLine();
					System.out.println("");


				}




				else
					System.out.println("Invalid");

			}




			//TRANSACTION HISTORY ONLY PRINTS ONCE THEN ITS DONE (WHY)?
			else if(choice==4)
			{

				clear();


				//pw1 TransData Close
				pw1.close();


				//Printing the Transaction History
				String TransHistory="";
				while ((TransHistory = br1.readLine()) != null)
					System.out.print(TransHistory + "\n");


				br.readLine();
			}

			//EXIT and SAVE
			else if(choice==5)
			{

				pwTemp.println(cheqBal);
    			pwTemp.println(savBal);

				//TempData close
    			pwTemp.close();


				pw.println(cheqBal);
				pw.println(savBal);

				//pw Data Close
				pw.close();

				//Exit
				exit=1;
			}


			//INVALID
			else
			{
				System.out.print(" Invalid");
				br.readLine();
				System.out.println("");
			}





			System.out.println("Chequing: "+cheqBal);
			System.out.println("Savings: "+savBal);

			System.out.println("ChequingString: "+cheqBalString);
			System.out.println("SavingsString: "+savBalString);



			clear();


		}while(exit==0);




    }

    static void clear()
    {
    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


}

