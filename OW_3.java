import java.util.Scanner;
import java.io.IOException;
import gattu.chakko;

class OW_3
{

		static int RAM = 1000;
		static int n,sum=0,x=0,last=0,a=0;
		static boolean run=true;
		static Scanner sc = new Scanner(System.in);
		static int pro[][] = new int[100][2];
		static int proN = 65;
		static int i=0;
		static int rs=0;

		static void addpro(int id,int si)
		{
		  	   
		  	    i++;
		  	    last++;
		}

		static void Delete()
		{
			System.out.print("Enter Process ID : ");
			int de = (int)sc.next().charAt(0);
			int temp=0;
			for(int j=0;j<i;j++)
			{
				if(pro[j][1]==de)
				{
					pro[j][1]=32;
					System.out.println("Deleted ID : "+(char)de);
					sum-=pro[j][0];
					temp=1;
				}
			}
			if(temp==0)
			{
				System.out.println("Invalid ID : "+(char)de);
			}
		}

		static void Insert()
		{
			int c;
			
			System.out.println("\t\t+----------------------+");
			System.out.println("\t\t|    1. First fit      |");
			System.out.println("\t\t|    2. Best fit       |");
			System.out.println("\t\t|    3. Next fit       |");
			System.out.println("\t\t|    4. Exit !!!!      |");
			System.out.println("\t\t+----------------------+");
			System.out.print("- - - - - - - - - - - - - - - - ->");
			System.out.print("\n Enter your choice  :  ");
			c=sc.nextInt();
			System.out.println("-+-+-+-+-+-+--+-+-+-+-+-+--+-+-+-+-+-+-");
	
			switch(c)
			{
				case 1:
				//First fit
					FirstFit();
				break;
			
				case 2:
				//Best fit
					BestFit();
				break;
	
				case 3:
				//Next fit
					NextFit();
				break;
				
				case 4:
				//Exit !!!
				break;
			}
		}

		static void Display()
		{

			System.out.println("Display Process Partition : \n\n");
				System.out.println("\t\t+---+-----");
			for (int j=0;j<i ;j++ ) {
				System.out.println("\t\t| "+(char)pro[j][1]+" | "+pro[j][0]);
				System.out.println("\t\t+---+-----");
			}
				

			System.out.println("remain space : "+rs);
		}

		static void FirstFit()
		{
			int id=0,si=0,tmp=0;
			System.out.print("ID : ");
		  	id=(int)sc.next().charAt(0);
		  	System.out.print("Size :");
		  	si=sc.nextInt();
		  	sum+=si;
		  	if(sum>RAM)
		  	{
		  		System.out.println(" - - - - ->   RAM Full !!!  <- - - - -");
		  		
		  		sum-=si;
		  	}
		  	else
		  	{
		  		if(i==0)
		  		{
		  			pro[i][1]=id;
		  	    	pro[i][0] = si;
		  	    	i++;
		  		}
		  		else
		  		{
		  			for(int j=0;j<i;j++)
		  			{
		  				if(si<=pro[j][0] && pro[j][1]==32)
		  				{
		  					sum+=si;
		  					rs=(pro[j][0]-si);
		  					
		  					pro[j][0]=si;
		  					pro[j][1]=id;
		  					tmp=1;
		  					last=j;
		  					break;
		  				}
		  			}
		  			if(tmp==0)
		  			{
		  				pro[i][1]=id;
		  	    		pro[i][0] = si;
		  	    		i++;
		  			}
		  		}
		  		
		  	}
		}


		static void NextFit()
		{
			int id=0,si=0,tmp=0;
			System.out.print("ID : ");
		  	id=(int)sc.next().charAt(0);
		  	System.out.print("Size :");
		  	si=sc.nextInt();
		  	sum+=si;
		  	if(sum>RAM)
		  	{
		  		System.out.println(" - - - - ->   RAM Full !!!  <- - - - -");
		  		Display();
		  		sum-=si;
		  	}
		  	else
		  	{
		  		if(i==0)
		  		{
		  			pro[i][1]=id;
		  	    	pro[i][0] = si;
		  	    	i++;
		  		}
		  		else
		  		{
		  			for(int j=last;j<i;j++)
		  			{
		  				if(si<=pro[j][0] && pro[j][1]==32)
		  				{
		  					sum-=si;
		  					pro[j][1]=id;
		  					sum=sum+pro[j][0];
		  					tmp=1;
		  					last=j;
		  					break;
		  				}
		  			}
		  			if(tmp==0)
		  			{
		  				pro[i][1]=id;
		  	    		pro[i][0] = si;
		  	    		i++;
		  			}
		  		}
		  		
		  	}
		}

		static void BestFit()
		{
			int id=0,si=0,tmp=0,p=0,s=0,min=1000000,def=0;
			int temp[][] = new int[50][50];
			System.out.print("ID : ");
		  	id=(int)sc.next().charAt(0);
		  	System.out.print("Size :");
		  	si=sc.nextInt();
		  	sum+=si;
		  	if(sum>RAM)
		  	{
		  		System.out.println(" - - - - ->   RAM Full !!!  <- - - - -");
		  		Display();
		  		sum-=si;
		  	}
		  	else
		  	{
		  		if(i==0)
		  		{
		  			pro[i][1]=id;
		  	    	pro[i][0] = si;
		  	    	i++;
		  		}
		  		else
		  		{
		  			for(int j=0;j<i;j++)
		  			{
		  					if(si<=pro[j][0] && pro[j][1]==32)
		  					{
		  						def=pro[j][0]-si;
		  						s=j;
		  					}
		  					if(min>def)
		  					{
		  						min=def;
		  						s=j;
		  						tmp=1;
		  					}	
		  			}
		  			if(tmp==1)
		  			{
		  				pro[s][1]=id;
		  			}
		  			if(tmp==0)
		  			{
		  				pro[i][1]=id;
		  	    		pro[i][0] = si;
		  	    		i++;
		  			}
		  		}
		  		
		  	}
		}
	public static void main(String[] args) throws IOException,InterruptedException {
		System.out.println("\t\t\t\t\t ****  *     *          ****  ");
		System.out.println("\t\t\t\t\t*    * *     *              * ");
		System.out.println("\t\t\t\t\t*    * *  *  *   ****    ***  ");
		System.out.println("\t\t\t\t\t*    * * * * *              * ");
		System.out.println("\t\t\t\t\t ****   *   *           ****  ");


		System.out.println("\n\n\n\n\n\t\t-- Group No. 5");
		System.out.println("\t\t-- Keyur Bhalsod  - 91800527004");
		System.out.println("\t\t-- Sakina Makda   - 91800527019");
		System.out.println("\t\t-- Yashvi Khetani - 91800527037");
		System.out.println("\t\t Guide by ");
		System.out.println("\t\t           Prof. Maulik Tanna");
		

		int c=0;
		while(c!=4)
		{
				// System.out.println("\n\n\n\n\n\n\nEnter 0 to Continue.....");
				// a=sc.nextInt();
				new ProcessBuilder("cmd","/c","pause").inheritIO().start().waitFor();
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
				System.out.println(" * * * * * * * * * * * * * * * * * * ");
				System.out.println("\t\t+----------------------+");
				System.out.println("\t\t|    1. Insert Pro.    |");
				System.out.println("\t\t|    2. Delete Pro.    |");
				System.out.println("\t\t|    3. Display        |");
				System.out.println("\t\t|    4. Exit !!!!      |");
				System.out.println("\t\t+----------------------+");
				System.out.print("- - - - - - - - - - - - - - - - ->");
				System.out.print("\n Enter your choice  :  ");
				c=sc.nextInt();
				System.out.println("-+-+-+-+-+-+--+-+-+-+-+-+--+-+-+-+-+-+-");
				switch(c)
				{
					case 1:
					// Insert Process 
						Insert();
					break;

					case 2:
					// Delete Process
						Delete();
						

					break;

					case 3:
					// Display Process
						Display();
						
					break;

					case 4:
					break;
				}
		}
	}
}
