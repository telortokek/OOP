import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<Guitar> g = new ArrayList<Guitar>();
	Guitar a;
	Guitar e;
	String amp,brand,model,type,hybrid;
	int num;
	
	public int menu() {
		int ch;
		System.out.println("1. Insert Guitar");
		System.out.println("2. View Guitar Catalogue");
		System.out.println("3. Delete Guitar");
		System.out.println("4. Exit");
		System.out.print("Input menu: ");ch = scan.nextInt();
		return ch;
	}
	
	public void insert() {
		int ch;
		System.out.println();
		System.out.println("Input guitar type: ");
		System.out.println("1. Electric");
		System.out.println("2. Accoustic");
		System.out.println("3. Cancel");
		System.out.print("Input: "); ch = scan.nextInt();
		if(ch==2) {
			scan.nextLine();
			System.out.println("+---------------+");
			System.out.println("| Insert Guitar |");
			System.out.println("+---------------+");
			type = "Acoustic";
			amp = "-";
			do {
				System.out.print("Input model [ 5 - 10 characters ]: "); model = scan.nextLine();
			}while(model.length()<5 || model.length()>10);
			do {
				System.out.print("Input brand [ Yamaha | Fender | Cort ] [ Case Sensitive ]: "); brand = scan.nextLine();
			}while(!brand.equals("Fender") && !brand.equals("Yamaha") && !brand.equals("Cort"));
			do {
				System.out.print("Input numberOfStrings [ 6 - 8 ]: "); num = scan.nextInt();
			}while(num<6 || num>8);
			scan.nextLine();
			do {
				System.out.print("Is the guitar Hybrid?? [ Yes | No ] [ Case Insensitive ]: "); hybrid = scan.nextLine();
			}while(!hybrid.equalsIgnoreCase("yes") && !hybrid.equalsIgnoreCase("no"));
			System.out.println();
			a = new Acoustic(amp, brand, model, type, hybrid, ch);
			g.add(a);
			System.out.println("New acoustic guitar added!");
			System.out.print("Press enter to continue"); scan.nextLine();
			
		}else if(ch==1) {
			scan.nextLine();
			System.out.println("+---------------+");
			System.out.println("| Insert Guitar |");
			System.out.println("+---------------+");
			type = "Electric";
			hybrid = "-";
			do {
				System.out.print("Input model [ 5 - 10 characters ]: "); model = scan.nextLine();
			}while(model.length()<5 || model.length()>10);
			do {
				System.out.print("Input brand [ Yamaha | Fender | Cort ] [ Case Sensitive ]: "); brand = scan.nextLine();
			}while(!brand.equals("Fender") && !brand.equals("Yamaha") && !brand.equals("Cort"));
			do {
				System.out.print("Input numberOfStrings [ 6 - 8 ]: "); num = scan.nextInt();
			}while(num<6 || num>8);
			scan.nextLine();
			do {
				System.out.print("Includes Amp? [ Yes | No ] [ Case Insensitive ]: "); amp = scan.nextLine();
			}while(!amp.equalsIgnoreCase("yes") && !amp.equalsIgnoreCase("no"));
			System.out.println();
			e = new Electric(amp, brand, model, type, hybrid, ch);
			g.add(e);
			System.out.println("New electric guitar added!");
			System.out.print("Press enter to continue"); scan.nextLine();
		}else if(ch==3) {
			menu();
		}
	}
	public void view() {
		if(g.size()==0) {
			System.out.println("There are no guitars in the catalog yet!");
			System.out.print("Press enter to continue"); scan.nextLine();scan.nextLine();
		}else {
			System.out.println("+----+------------+----------+---------+---------+--------+------+---------+");
			System.out.println("| No | Type       | Model    | Brand   | Strings | Hybrid | Amp  | Price   |");
			System.out.println("+----+------------+----------+---------+---------+--------+------+---------+");
			for(int i=0; i<g.size(); i++) {
				System.out.printf("| %-2d | %-10s | %-8s | %-7s | %-7d | %-6s | %-4s | %-7d |\n",i+1,g.get(i).getType(),g.get(i).getModel(),g.get(i).getBrand(),
						g.get(i).getNum(),g.get(i).getHybrid(),g.get(i).getAmp(),g.get(i).calculatePrice());
			}
		}
		System.out.println("+----+------------+----------+---------+---------+--------+------+---------+");
	}
	public void delete() {
		System.out.println("+---------------+");
		System.out.println("| Delete Guitar |");
		System.out.println("+---------------+");
		if(g.size()==0) {
			System.out.println("There are no guitars in the catalog yet!");
			System.out.print("Press enter to continue"); scan.nextLine();scan.nextLine();
			System.out.println();
		}else {
			int ch;
			view();
			System.out.print("Choose index to delete [ 1 - "+g.size()+" ]: "); ch = scan.nextInt();
			g.remove(ch-1);
			System.out.println("Guitar "+ch+" deleted!");
			System.out.print("Press enter to continue"); scan.nextLine(); scan.nextLine();
			System.out.println();
		}
	}
	public Main() {
		// TODO Auto-generated constructor stub
		int ch =0;
		do {
			ch = menu();
			if(ch==1) {
				insert();
				System.out.println();
			}else if(ch==2) {
				System.out.println("+------------------+");
				System.out.println("| Guitar Catalogue |");
				System.out.println("+------------------+");
				view();
				System.out.println();
			}else if(ch==3) {
				delete();
			}
		}while(ch!=4);
	}

	public static void main (String[] args) {
		new Main();
	}
}
