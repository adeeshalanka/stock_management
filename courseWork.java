import java.util.*;
class suppier{
	String id;
	String name;
}
class category{
	String cname;
}
class Item{
	String id;
	String sid;
	String Category;
	String desc;
	double price;
	int qtyOnHand;
}
class courseWork{
	
	public static String []lable={"loging page","WELCOME IJSE STOCK MANGEMENT SYSTEM"};
	public static String []icon={"Change the credentials","Suppier Manage","Stock mange","Log out","Exit the System"};
	public static Scanner input=new Scanner(System.in);
	public static void main(String args[]){
		
		
		loging();
	}
	public static String username="admin";
	public static String password="1234";
	public static void loging(){
		System.out.printf("+-------------------------------------------------+%n");
		System.out.printf("%-20s"+"%s"+"%20s%n","|",lable[0],"|");
		System.out.printf("+-------------------------------------------------+%n");
		
		boolean flag=false;
		while(flag!=true){
			System.out.print("user name : ");
			String uname=input.next();
			if(uname.equals(username)){
				System.out.println();
				while(flag!=true){
				System.out.print("password : ");
				String pw=input.next();
				if(pw.equals(password)){
					flag=true;
					clearConsole();
					homepage();
					
				}
				else{
					System.out.println("incorrect password.try again");
					System.out.println();
				}
			}
		}
			else{
				System.out.println("incoreect user name.Try again");
				System.out.println();
			}
		}
		
	}
	
	private final static void clearConsole() {
		 final String os = System.getProperty("os.name");
        try {
            if (os.equals("Windows 10")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
}
	public static void homepage(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-20s"+"%s"+"%20s%n","|",lable[1],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%s%d%s %s","[",1,"]",icon[0]);
		System.out.printf("%9s%d%s %s%n","[",2,"]",icon[1]);
		System.out.printf("%s%d%s %s","[",3,"]",icon[2]);
		System.out.printf("%20s%d%s %s%n","[",4,"]",icon[3]);
		System.out.printf("%s%d%s %s%n\n","[",5,"]",icon[4]);
		select();
	}
	public static void select(){
		System.out.print("Enter the option continue : ");
		int num=input.nextInt(); 
		clearConsole();  
		if(num==1){
			Change_the_credentials();
		}
			if(num==2){
				Suppier_Manage();
		}
		if(num==3){
			stock_Manage();
		}
		
		
		if(num==4){
			logout();
		}
		if(num==5){
			exit();
		}
	}
	
	public static String [] stock_page={"Manage the item categories","Add item","Get items supplier wise","view items","Rank items per unit price","home page"};
		public static void stock_Manage(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%34s%n","|",icon[2],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		System.out.printf("%s%d%s %-40s","[",1,"]",stock_page[0]);
		System.out.printf("%s%d%s %s%n","[",2,"]",stock_page[1]);
		System.out.printf("%s%d%s %-40s","[",3,"]",stock_page[2]);
		System.out.printf("%s%d%s %s%n","[",4,"]",stock_page[3]);
		System.out.printf("%s%d%s %-40s","[",5,"]",stock_page[4]);
		System.out.printf("%s%d%s %s%n\n","[",6,"]",stock_page[5]);
		select3();
		}
		public static void select3(){
			System.out.print("Enter an option to continue --> ");
			int num=input.nextInt();
			clearConsole();
			if(num==1){
				Manage_item_categories();
			}
			if(num==2){
				Add_item();
			}
		}
		
		public static Item[] item=new Item[0];
		public static void Add_item(){
			System.out.printf("+----------------------------------------------------------------------+%n");
			System.out.printf("%-30s"+"%s"+"%34s%n","|",stock_page[1],"|");
			System.out.printf("+----------------------------------------------------------------------+%n\n");
			if(item_category.length==0){
				System.out.print("Oops!It seems that you don't have any item categories in the system....Do you want to add new item category?(y/n) : ");
				char tr=input.next().charAt(0);
				if(tr=='y'|tr=='Y'){
					clearConsole();
					add_new_item_category();
				}
				else if(tr=='n'|tr=='N'){
					clearConsole();
					stock_Manage();
				}
				else{
					System.out.println("wrong input!");
					clearConsole();
					Add_item();
				}
			}
			if(suppiers.length==0){
				System.out.print("Oops!It seems that you don't have any suppliers in the system....Do you want to add new item suppliersa?(y/n) : ");
				char tr=input.next().charAt(0);
				if(tr=='y'||tr=='Y'){
					clearConsole();
					addsuppiers();
				}
				else if(tr=='n'||tr=='N'){
					clearConsole();
					stock_Manage();
				}
				else{
					System.out.println("wrong input!");
					clearConsole();
					Add_item();
				}
			}
			boolean flag=false;
			item=grow4();
			item[item.length-1]=new Item();
			l6: while(flag!=true){
				System.out.print("Item code : ");
				String ic=input.next();
				for(int i=0;i<item.length;i++){
				
					if(ic.equals(item[i].id)){
						System.out.println("Item code already added!try again..");
						
						continue l6;
						
					}
				}
				if(flag==false){
					item[item.length-1].id=ic;
					
					flag=true;
					System.out.println("\nSupplier list :");
					suppierlist();
					System.out.print("Enter the supplier number :");
					int x=input.nextInt();
					item[item.length-1].sid=suppiers[x-1].id;
					System.out.println();
					System.out.println("Item categories : ");
					Item_categories_list();
					System.out.print("Enter the category number : ");
					int py=input.nextInt();
					item[item.length-1].Category=item_category[py-1].cname;
					System.out.print("Discription : ");
					String discription=input.next();
					item[item.length-1].desc=discription;
					System.out.print("unit price : ");
					double price=input.nextDouble();
					item[item.length-1].price=price;
					System.out.print("Qty on hand : ");
					int qty=input.nextInt();
					item[item.length-1].qtyOnHand=qty;
					System.out.println();
					System.out.print("added successfully!Do you want add another item(y/n) ");
					char in=input.next().charAt(0);
					if(in=='y'||in=='Y'){
						clearConsole();
						Add_item();
					}
					if(in=='n'||in=='N'){
						clearConsole();
						stock_Manage();
					}
				}
			}
		}
		
		public static void Item_categories_list(){
			System.out.printf("+-----------------------------------------------------------+%n");
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%n","|","#","|","Category name","|");
			System.out.printf("+------------------------------------------------------------+%n");
			for(int i=0;i<item_category.length;i++){
			System.out.printf("%-10s%-20d%-10s%-20s%-10s%n","|",(i+1),"|",item_category[i].cname,"|");
			System.out.printf("--------------------------------------------------------------%n");
		}
	}
			
		public static void suppierlist(){
			System.out.printf("+-----------------------------------------------------------------------------------------+%n");
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%-20s%-10s%n","|","#","|","suppier name","|","suppier id","|");
			System.out.printf("+-----------------------------------------------------------------------------------------+%n");
		for(int i=0;i<suppiers.length;i++){
			System.out.printf("%-10s%-20d%-10s%-20s%-10s%-20s%-10s%n","|",(i+1),"|",suppiers[i].id,"|",suppiers[i].name,"|");
			System.out.printf("-------------------------------------------------------------------------------------------%n");
		}
	}
		
		public  static Item [] grow4(){
			Item []temp=new Item[item.length+1];
			for(int i=0;i<item.length;i++){
				
					temp[i]=item[i];
				}
			return temp;
		}
		
		public static String[]Mic_page={"add new item category","delete item category","update item category","stock management"};
		public static void Manage_item_categories(){
			System.out.printf("+---------------------------------------------------------------------------+%n");
		System.out.printf("%-20s"+"%s"+"%31s%n","|",stock_page[0],"|");
		System.out.printf("+---------------------------------------------------------------------------+%n\n");
		System.out.printf("%s%d%s %-40s","[",1,"]",Mic_page[0]);
		System.out.printf("%s%d%s %s%n","[",2,"]",Mic_page[1]);
		System.out.printf("%s%d%s %-40s","[",3,"]",Mic_page[2]);
		System.out.printf("%s%d%s %s%n","[",4,"]",Mic_page[3]);
		System.out.println();
		select4();
	}
	public static void select4(){
			System.out.print("Enter an option to continue --> ");
			int num=input.nextInt();
			clearConsole();
			if(num==1){
				add_new_item_category();
			}
			if(num==2){
				delete_item_category();
			}
			if(num==3){
				update_item_categary();
			}
			if(num==4){
				stock_Manage();
			}
		}
		
		public static category[] item_category=new category[0];
		public static void add_new_item_category(){
			System.out.printf("+---------------------------------------------------------------------+%n");
		System.out.printf("%-20s"+"%s"+"%34s%n","|","add item category","|");
		System.out.printf("+---------------------------------------------------------------------+%n\n");
		
		boolean flag=false;
		l4: while(flag!=true){
		System.out.print("category name : ");
		String item=input.next();
		
		for(int i=0;i<item_category.length;i++){
		if(item.equals(item_category[i].cname)){
		System.out.println("allready exists.try another category! ");
		continue l4;
		}
	}
		item_category=grow3();
		item_category[item_category.length-1]=new category();
		item_category[item_category.length-1].cname=item; 
		System.out.print("added successfully!.Do you want to add anothr item category(y/n) : ");
		char bh=input.next().charAt(0);
		if(bh=='y'||bh=='Y'){
			clearConsole();
			add_new_item_category();
		}
		if(bh=='n'||bh=='N'){
			flag=true;
			clearConsole();
			Manage_item_categories();
		}
	}
	}

		public static category[] grow3(){
			category[]temp=new category[item_category.length+1];
			for(int i=0;i<item_category.length;i++){
				temp[i]=item_category[i];
			}
			return temp;
		}
		
		public static void delete_item_category(){
			System.out.printf("+-------------------------------------------------------------------+%n");
			System.out.printf("%-20s"+"%s"+"%29s%n","|","delete item category","|");
			System.out.printf("+-------------------------------------------------------------------+%n\n");
			boolean flag=false;
			l6: while(flag!=true){
				System.out.print("item category : ");
				String itme=input.next();
				for(int i=0;i<item_category.length;i++){
					if(itme.equals(item_category[i].cname)){
						int x=i;
						item_category=growd(x);
						flag=true;
					}
				}
				if(flag==false){
				System.out.println("can't find item category..try again!");
				continue l6;
			}
			System.out.print("Delete successfully.Do you want to delete another item category(y/n) : ");
			char ox=input.next().charAt(0);
			if(ox=='y'||ox=='Y'){
				clearConsole();
				delete_item_category();
			}
			if(ox=='n'||ox=='N'){
				clearConsole();
				Manage_item_categories();
			}
		}
		}
			
			public static category[] growd(int x){    
				category []temp=new category[item_category.length-1];
				for(int i=0,j=0;i<item_category.length;i++){
					if(x!=i){
						temp[j++]=item_category[i];
					}
				}
				return temp;
			}
			
				public static void update_item_categary(){
			System.out.printf("+-------------------------------------------------------------------+%n");
			System.out.printf("%-20s"+"%s"+"%29s%n","|","update item category","|");
			System.out.printf("+-------------------------------------------------------------------+%n\n");
			boolean flag=false;
			l7: while(flag!=true){
				System.out.print("item category : ");
				String itme=input.next();
				for(int i=0;i<item_category.length;i++){
					if(itme.equals(item_category[i].cname)){
						System.out.print("enter the new item category : ");
						String item_c=input.next();
						item_category[i].cname=item_c;
						flag=true;
						break;
					}
				}
				if(flag==false){
					System.out.println("can't find suppier id.try again");
					continue l7;
				}
				System.out.print("Update successfully!Do you want to update another suppier(y/n) ?");
				char dp=input.next().charAt(0);
				if(dp=='y'||dp=='Y'){
				clearConsole();
				update_item_categary();
			}
			if(dp=='n'||dp=='N'){
				clearConsole();
				Manage_item_categories();
			}
		}
	}
			
		
		
	public static String [] suppier_page={"add suppier","update suppier","delete suppier","view suppier","search suppier","home page"};
		public static void Suppier_Manage(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",icon[1],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		System.out.printf("%s%d%s %-40s","[",1,"]",suppier_page[0]);
		System.out.printf("%s%d%s %s%n","[",2,"]",suppier_page[1]);
		System.out.printf("%s%d%s %-40s","[",3,"]",suppier_page[2]);
		System.out.printf("%s%d%s %s%n","[",4,"]",suppier_page[3]);
		System.out.printf("%s%d%s %-40s","[",5,"]",suppier_page[4]);
		System.out.printf("%s%d%s %s%n\n","[",6,"]",suppier_page[5]);
		select2();
		}
		public static void select2(){
			System.out.print("Enter an option to continue --> ");
			int num=input.nextInt();
			clearConsole();
			if(num==1){
				addsuppiers();
			}
			if(num==2){
				update_suppiers();
				}
			if(num==3){
				delete_suppiers();
			}
			if(num==4){
				view_suppiers();
			}
			if(num==5){
				search_suppiers();
			}
			if(num==6){
				homepage();
			}
		}
		public static suppier[] suppiers=new suppier[0];
		
		public static void addsuppiers(){
			System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[0],"|");
		System.out
		.printf("+-------------------------------------------------------------------------+%n\n");
		boolean flag=false;
		l1: while(flag!=true){
		System.out.print("suppier id : ");
		String id=input.next();
		for(int i=0;i<suppiers.length;i++){
			
		if(id.equals(suppiers[i].id)){
		System.out.println("allready exists.try another suppier id! ");
		continue l1;
	}
}
		suppiers=grow();
		suppiers[suppiers.length-1]=new suppier();
		suppiers[suppiers.length-1].id=id;
		System.out.print("suppier name : ");
		suppiers[suppiers.length-1].name=input.next();
		
		System.out.print("Added successfully!Do you want to add another suppier?(y/n) : ");
		char op=input.next().charAt(0);
		if(op=='y'||op=='Y'){
			clearConsole();
			addsuppiers();
		}
		if(op=='n'||op=='N'){
			flag=true;
			clearConsole();
			Suppier_Manage();
		}
	}
}

	public static suppier[] grow(){
		suppier []temp=new suppier[suppiers.length+1];
		for(int i=0;i<suppiers.length;i++){
			temp[i]=suppiers[i];
			
		}
		return temp;
	}
	
	public static void update_suppiers(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[1],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
			
			boolean flag=false;
			l1: while(flag!=true){
			System.out.print("suppier id : ");
			String id=input.next();
			for(int i=0;i<suppiers.length;i++){
				if(id.equals(suppiers[i].id)){
					System.out.println("suppier name :"+suppiers[i].name+"\n");
					System.out.print("Enter the new suppier name : ");
					String name=input.next();
					suppiers[i].name=name;
					flag=true;                              //else ekak dala mehem else{System.out.println("can't find suppier id.try again");
		                                                           //continue l1; } kiyala danna ba....
					break;
				}
			}
			if(flag==false){                                //ehema danna bari nisa if ekak dala mehema aran thiyenne
					System.out.println("can't find suppier id.try again");
					continue l1;
				}
				
		System.out.print("Update successfully!Do you want to update another suppier(y/n) ?");
			char op=input.next().charAt(0);
			if(op=='y'||op=='Y'){
				clearConsole();
				update_suppiers();
			}
			if(op=='n'||op=='N'){
				clearConsole();
				Suppier_Manage();
			}
		}
	}
	
		public static void delete_suppiers(){
			System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[2],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		boolean flag=false;
		l2: while(flag!=true){
			System.out.print("suppier id : ");
			String id=input.next();
			for(int i=0;i<suppiers.length;i++){
				if(id.equals(suppiers[i].id)){
					int x=i;
					suppiers=grow2(x);
					flag=true;
				}
			}
			if(flag==false){
				System.out.println("can't find suppier id..try again!");
				continue l2;
			}
			System.out.print("Delete successfully.Do you want to delete another suppiers(y/n) : ");
			char ox=input.next().charAt(0);
			if(ox=='y'||ox=='Y'){
				clearConsole();
				delete_suppiers();
			}
			if(ox=='n'||ox=='N'){
				clearConsole();
				Suppier_Manage();
			}
		}
		}
		public static suppier[] grow2(int x){
			suppier temp2[]=new suppier[suppiers.length-1];
			for(int i=0,j=0;i<suppiers.length;i++){
					if(x!=i){
					temp2[j++]=suppiers[i];
				}
			}
			return temp2;
		
	}
	
	public static void view_suppiers(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[3],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		System.out.printf("+-----------------------------------------------------------+%n");
		System.out.printf("%-10s%-20s%-10s%-20s%-10s%n","|","suppier id","|","suppier name","|");
		System.out.printf("+-----------------------------------------------------------+%n");
		for(int i=0;i<suppiers.length;i++){
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%n","|",suppiers[i].id,"|",suppiers[i].name,"|");
			System.out.printf("-------------------------------------------------------------%n");
		}
		System.out.print("Do you want to go suppier manage page(y/n) : ");
		char oy=input.next().charAt(0);
		if(oy=='y'||oy=='Y'){
			clearConsole();
			Suppier_Manage();
		}
		if(oy=='n'||oy=='N'){
			clearConsole();
			view_suppiers();
		}
	}
		
		public static void search_suppiers(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[4],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		boolean flag =false;
		l3: while(flag!=true){
			System.out.print("suppier id : ");
			String id=input.next();
			for(int i=0;i<suppiers.length;i++){
				if(id.equals(suppiers[i].id)){
					System.out.println("suppier name : "+suppiers[i].name);
					flag=true;
					break;
				}
				
			}
			if(flag==false){
				System.out.println("can't find suppier id!.try again .");
				continue l3;
			}
			System.out.print("search successfully!.Do you want to search another find(y/n) : ");
			char ss=input.next().charAt(0);
			if(ss=='y'||ss=='Y'){
				clearConsole();
				search_suppiers();
			}
			if(ss=='n'||ss=='N'){
				clearConsole();
				Suppier_Manage();
			}
		}
	}
		
		public static void exit(){
			System.exit(0);
		}
		
		public static void logout(){
			loging();
		}
		
		public static void Change_the_credentials(){
		
			System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%23s%n","|",icon[0],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n");
		boolean flag=false;
		while(flag!=true){
			System.out.print("please Enter the user name to verify it's you : ");
			String vname=input.next();
			if(vname.equals(username)){
				System.out.println("Heyy "+vname);
				while(flag!=true){
					System.out.print(username+" Enter your current password : ");
					String vpw=input.next();
					if(vpw.equals(password)){
						
						System.out.println();
						while(flag!=true){
						System.out.print("Enter your current password :");
						String cpw=input.next();
						if(cpw.equals(password)){
							flag=true;
						System.out.print("Enter your new password : ");
						String newpw=input.next();
						password=newpw;
						System.out.print("password changed successfully!");
						System.out.print("Do you want go home page(y/n) : ");
						char op=input.next().charAt(0);
						if(op=='y'){
							clearConsole();
							homepage();
							System.out.println("\n");
							
							select();
						
						}
					}
					else{System.out.println("try try");}
				}
			}
					else{
						System.out.println("Incorrect password.try again\n");
					}
				}
			}
			else{System.out.println("Invalid user name.try again\n");
			}
		}
	}
	
	}
