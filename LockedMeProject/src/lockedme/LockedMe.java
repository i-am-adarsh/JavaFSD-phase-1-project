package lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe
	{
	static final  String LockedMeFilesPath ="D:\\SIMPLILEARN\\phase 1\\LockedMeProject";
	static final  String ErrorMessage ="oops!! some error occured,please contact at admin@lockedme.com";
	static final String endmessage ="Thank You For Using LockedMe.Com , Please Visit Us Again.";
	

	public static void main(String[] args)
	{
		Scanner obj =new Scanner(System.in);
		int ch;
		
		do
		{
			displayMenu();
			System.out.println("\nEnter Your Choice :-");
			ch=Integer.parseInt(obj.next());	
			switch(ch)
			{
			case 1:getFiles();
			break;
			case 2:insertFiles();
			break;
			case 3:deleteFiles();
			break;
			case 4:searchFiles();
			break;
			case 5:System.exit(0);
			break;
			default:System.out.println("Invalid option , Please Check And Try Again");
			break;
			
			}
			
		}while(ch>0 && ch<6);
		obj.close();
	}
		
	/**
	 * This function will show welcome screen and menu
	 */
	public static void displayMenu()
	{
		System.out.println("\t*****************************************************************");
		System.out.println("\t\t\t\tWELCOME TO LOCKEDME.COM");
		System.out.println("\t*****************************************************************");
		System.out.println("\t\t\t\t\tCreated By Adarsh Raj");
		System.out.println("\t\t\t\t\t***********************");
		System.out.println("Select from the options given below :-\n");
		System.out.println("1.Display All The Files\n");
		System.out.println("2.Add A New File\n");
		System.out.println("3.Delete A File\n");
		System.out.println("4.Search For A File\n");
		System.out.println("5.Exit");
		
	}
	/**
	 * This function will return all files in the project directory
	 */
	public static void getFiles()
	{
		try 
		{
			File folder =new File(LockedMeFilesPath);
			File[] listofFiles = folder.listFiles();
		
		//checking if the files exists in the project directory
		
		if(listofFiles.length==0)
			System.out.println("No File Exists In The Directory");
		
		//if files exists 
		else
			for(var l:listofFiles)
		   System.out.println(l.getName());
		   System.out.println(endmessage);
		
		}
			catch(Exception Ex)
		{
			System.out.println(ErrorMessage);
		}
		
	}
	/**
	 * This function will insert a new file in the directory
	 */
	public static void insertFiles()
	{
		Scanner obj =new Scanner(System.in);
		try
		{
			String filename;
			//displaying message to enter the file name to add
			System.out.println("Enter The File Name That You Want To Add :-");
			//taking input from the user 
			filename=obj.nextLine();
			 
			int linescount;
			System.out.println("Enter The Number Of Lines You Want To Add :-");
			linescount=Integer.parseInt(obj.nextLine());
			//writing in the new file created
			 FileWriter myWriter = new FileWriter(LockedMeFilesPath+ "\\"+ filename);
			 for(int i=1;i<=linescount;i++)
			 {
				 System.out.println("Enter Text For Line Number :"+i);
				 myWriter.write(obj.nextLine()+"\n");
				 
			 }
		      System.out.println("File Created Successfully\n");
		      System.out.println(endmessage);
		      myWriter.close();
		      
		}
		catch(Exception Ex)
		{
			System.out.println(ErrorMessage);
		}
		
	}
	/**
	 * This function will delete the files from the directory
	 */
	public static void deleteFiles()
	{
		Scanner obj =new Scanner(System.in);
		try
		{
		String filename;
		
		System.out.println("Enter The File Name You Want To Delete");
		
		//taking file name as a input from the user
		filename=obj.nextLine();
		
		File file = new File(LockedMeFilesPath+"\\"+filename);
		
		//if file exists
		if(file.exists())
		{ 
			file.delete(); // deletes the file
		System.out.println("File " +filename+ " deleted successfully\n");
		System.out.println(endmessage);
		}
		else
			System.out.println("File "+filename+ " Was Not Found"); // FNF File Not Found
		}
		catch(Exception Ex)
		{
			System.out.println(ErrorMessage);
		}
       
	}
	/**
	 * This function is used to search for a particular file or filename
	 */
	public static void searchFiles()
	{
		Scanner obj =new Scanner(System.in);
		try 
		{
			String filename;
			System.out.println("Enter The File Name That You Want To Search :-");
			//taking user input for the file name
			filename=obj.nextLine();
			
			File folder =new File(LockedMeFilesPath);
			File[] listofFiles = folder.listFiles();
			
			LinkedList<String> filenames=new LinkedList<String>();
			//for each loop
			for(var l:listofFiles)
		    //adding each file name in filenames
			filenames.add(l.getName());
			//checking if file exists or not
			if(filenames.contains(filename))
			{
			System.out.println("File is Found\n");
			System.out.println(endmessage);
			}
	       else
		    System.out.println("File is not availaible");
		
		}
			
		catch(Exception Ex)
		{
			System.out.println(ErrorMessage);
		}
		
	
	 }
	
	
	}

	
