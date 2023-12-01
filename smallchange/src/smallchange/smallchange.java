package smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallchange {
	public static void main(String[] args) {

		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		String key = "";
		String details = "---------small change details-----------";
		double money=0;
		double balance=0;
		Date date=null;
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");
		do {
			System.out.println("\n==========Small Change Menu=========");
			System.out.println("\t\t\t 1 small change details");
			System.out.println("\t\t\t 2 small change incomes");
			System.out.println("\t\t\t 3 small change payment");
			System.out.println("\t\t\t 4 small change exits");

			System.out.println("Please choose(1-4)");
			key = scanner.next();
			String note;
			switch (key) {
			case "1":
				System.out.println(details);
				break;
			case "2":
				System.out.println("Incomes is");
				money=scanner.nextDouble();
				if(money <=0) {
					System.out.println("error input,incomes is bigger than zero");
					break;
				}
				balance +=money;
				date = new Date();
				details += "\n"+ "incomes\t+"+money+"\t"+sdf.format(date)+"\tBalances:\t"+balance;
				break;
			case "3":
				System.out.println("Payment is");
				money=scanner.nextDouble();
				if(money<=0 || money>balance) {
					System.out.println("payment must bigger than zero and less than "+balance);
					break;
				}
				System.out.println("Please input the note");
				note = scanner.next();
				balance -= money;
				date=new Date();
				details += "\n"+ note +"\t-"+ money+"\t"+sdf.format(date)+"\tBalances:\t"+balance;
				break;
			case "4":
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
				break;
			default:
				System.out.println("error,wrong choice");

			}

		} while (loop);
		System.out.println("-------exited small change sys---------");
	}
}
