package smallchangeoop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallchangeoop {
	boolean loop = true;
	Scanner scanner = new Scanner(System.in);
	String details = "---------small change details-----------";
	double money=0;
	double balance=0;
	Date date=null;
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String key ="";
	String note="";
	
	public void mainMenu() {
		do {
			System.out.println("\n==========Small Change Menu=========");
			System.out.println("\t\t\t 1 small change details");
			System.out.println("\t\t\t 2 small change incomes");
			System.out.println("\t\t\t 3 small change payment");
			System.out.println("\t\t\t 4 small change exits");

			System.out.println("Please choose(1-4)");
			key = scanner.next();
			switch (key) {
			case "1":
				this.detail();
				break;
			case "2":
				this.income();
				break;
			case "3":
				this.pay();
				break;
			case "4":
				this.exit();
				break;
			default:
				System.out.println("error,wrong choice");
			}
		} while (loop);
		System.out.println("-------exited small change sys---------");
	}
	public void detail() {
		System.out.println(this.details);
	}
	public void income() {
		System.out.println("Incomes is");
		money=scanner.nextDouble();
		if(money <=0) {
			System.out.println("error input,incomes is bigger than zero");
			return;
		}
		balance +=money;
		date = new Date();
		details += "\n"+ "incomes\t+"+money+"\t"+sdf.format(date)+"\tBalances:\t"+balance;
	}
	public void pay() {
		System.out.println("Payment is");
		money=scanner.nextDouble();
		if(money<=0 || money>balance) {
			System.out.println("payment must bigger than zero and less than "+balance);
			return;
		}
		System.out.println("Please input the note");
		note = scanner.next();
		balance -= money;
		date=new Date();
		details += "\n"+ note +"\t-"+ money+"\t"+sdf.format(date)+"\tBalances:\t"+balance;
		
	}
	public void exit() {
		String choice="";
		while(true) {
			System.out.println("Are you sure to exit? y/n");
			choice=scanner.next();
			if("y".equals(choice) || "n".equals(choice)) {
				break;
			}
		}
		if(choice.equals("y")) {
			loop = false;
		}
	}
}

