/*
***********Created by Dev***********
This is a Java program that will convert a text file into a html file(index.html)
this program will also add Navigation bar in the webpage, with logo and link to at most 3 div classes
*/
import java.io.*;
import java.util.*;
public class start
{
    public static void main( String[] args )
    {
    	try 
    	{

	      File file = new File("index.html");	//This will make a new HTML File 
	      File js=new File("Main.js");			//This will make a new JS file 
	    	

	      FileWriter JSwriter=new FileWriter(js);		
	      PrintWriter Jp=new PrintWriter(JSwriter);

	      FileWriter fw=new FileWriter(file);
	      PrintWriter pw=new PrintWriter(fw);

	      System.out.println("Enter the title of the Webpage");	//This will ask for the title on the webpage 
	      Scanner scan=new Scanner(System.in);
	      String title=scan.nextLine();
	      title=checkString(title);

	     //------This will ask for the color on the backgroung of the webpage
	      System.out.println("Enter the background color on the Website ");
	      String color=scan.nextLine();
	      //This will ask the color of the text
	      System.out.println("Enter the Text-Color");
	     
	      String text_color=scan.nextLine();	      
	      addJS(pw,Jp,scan,color,text_color);

    	}		
    	 catch (IOException e) 
    	{
	      e.printStackTrace();
		}
    }

 //This method will add the basic HTML such as heading,navbar,<div> in the index.html file 
 //This will also link JS and Materialize to the html.
    public static void makeHtmlFile(String s,PrintWriter pw,String first,String second,String third)
    	{
    	 pw.println("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>"+s+"</title><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css\"></head>");
    	 pw.println("<body id=\"body\"><div class=main id=\"main\"> </div>");
    	 pw.println("<div id=\""+ first+"\" class="+"\"#"+first+"\"><h3>"+first+"</h3></div>");
    	 pw.println("<div id=\""+second+"\" class=\"#"+second+"\"><h3>"+second+"</h3></div>");
    	 pw.println("<div id=\""+third+"\" class=\"#"+third+"\"><h3>"+third+"</h3></div>");
    	 pw.println("<script src=\"Main.js\"></script>");
    	 pw.println("</body></html>");
	   	 pw.close();
	    }
//This method will make Styling such as background-color,navigationBar color, Text-color
//This method will also take text file as input and it will add the content in that file to HTML page 
	    public static void addJS(PrintWriter pw,PrintWriter JP,Scanner scan,String color,String text_color){
	    	System.out.println("Enter the background-color on the Navbar");
	    	String background=scan.nextLine();
	    	
	    	System.out.println(" ----------------------------------------------------");
	    	System.out.println("| LOGO                        Home Contact About Me |");
	 		System.out.println(" ----------------------------------------------------");	    		
	    	System.out.println("Enter the logo of the Navbar");
	    	
	    	String s=scan.nextLine();
	    	s=checkString(s);
	    	
	    	System.out.println("Enter three links or the menu option in the Nav bar ex:Home , About, Contact");
	    	System.out.println(" ----------------------------------------------------");
	    	System.out.println("|"+s+"          		  ______   Contact About Me |");
	 		System.out.println(" ----------------------------------------------------");	
	    	System.out.println("Enter the first one ");
	    	String first=scan.nextLine();
	    	first=checkString(first);

	    	System.out.println("Enter three links or the menu option in the Nav bar ex:Home , about, Contact");
	    	System.out.println(" ----------------------------------------------------");
	    	System.out.println("|"+s+"          	   		   "+ first+"______ About Me |");
	 		System.out.println(" ----------------------------------------------------");	
			System.out.println("Enter the second one ");
	    	System.out.println("or press enter to skip this one");
	    	String second=scan.nextLine();
	    	second=checkString(second);

	    	System.out.println("Enter three links or the menu option in the Nav bar ex:Home , about, Contact");
	    	System.out.println(" ----------------------------------------------------");
	    	System.out.println("|"+s+"          	   		   "+ first+"  "+second+"______ |");
	 		System.out.println(" ----------------------------------------------------");	
	    	System.out.println("Enter the  third one ");
	    	System.out.println("or press enter to skip this one");

	    	String third=scan.nextLine();
	    	third=checkString(third);

	    	System.out.println("Enter the name of the file in which Content of "+first+" is present.");
	     	String content=scan.nextLine();
	     	content=givestring(content);

	    	 String second_content="";
	    	 String third_content="";
	    	 if(second.equals(" ") || second.equals(""))
	       {
	    	 //if the user skips the second title on the navbar
	  	   }

	     else
	     {	 
			System.out.println("Enter the name of the file in which Content of "+second+" is present.");
	    	second_content=scan.nextLine();
	     	second_content=givestring(second_content);
	     }

	     if(third.equals(" ") || third.equals(""))
	     {
	     	//if the user skips the third title on the navbar
	     }
	     else
	     { 
	     	System.out.println("Enter the name of the file in which Content of "+third+" is present.");
	     		third_content=scan.nextLine();
	     		third_content=givestring(third_content);
	     }
	    	 makeHtmlFile(s,pw,first,second,third);
	    		
	    	JP.println("window.onload=function(){");
	    	JP.println("var v=document.getElementById('main')");
	    	JP.println("v.innerHTML='<nav>'+'<div class=\"nav-wrapper\" style=\"background-color:"+background+";\">'+'<a href=\"#\" class=\"brand-logo\">'"+ "+'"+ s +"'+"  +"'</a>'+ '<ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">'+'<li>'+'<a href=\"#"+first+"\">'"+"+'"+first+"'+"+"'</a>'+'</li>'+'<li>'+'<a href=\"#"+second+"\">'"+"+'"+second+"'+"+"'</a>'+'</li>'+ '<li>'+'<a href=\"#"+third+"\">'"+"+'"+third+"'+"+"'</a>'+'</li>'+ '</ul>'+ '</div>'+ '</nav>';");
	    	JP.println("}");
	    	JP.println("var v=document.getElementById('"+first+"');");
	    	JP.println("v.setAttribute(\"style\",\"width:1000px; Color:"+text_color+"; margin: 40px 50px 20px 150px;min-height: 560px\");");
	    	JP.println("v.innerHTML+='<p>'"+"+'"+content+"'+"+"'</p>';");
				
			JP.println("var bd=document.getElementById('body')");
			JP.println(" bd.setAttribute(\"style\",\"background-color:"+ color+"\")");	
			JP.println("var v2=document.getElementById('"+ second+"');");
			JP.println("v2.innerHTML+='<p>'"+"+'"+second_content+"'+"+"'</p>';");
	    	JP.println("v2.setAttribute(\"style\",\"width:1000px; Color:"+text_color+";margin: 40px 50px 20px 150px;min-height: 560px\");");	   
			JP.println("var v3=document.getElementById('"+third+"');");
			JP.println("v3.innerHTML+='<p>'"+"+'"+third_content+"'+"+"'</p>';");	 
	    	JP.println("v3.setAttribute(\"style\",\"width:1000px; Color:"+text_color+"; margin: 40px 50px 20px 150px;min-height: 560px\");");
	  
			JP.close();

	    }	

//This method will check if there are any special characters such as 
// "",',<,>,&,\n,\ and return the changed HTML syntax of the string that will not interrupt java compiler
	   public static  String checkString(String content)
	   {
	   	String s="";
	   	for(int i=0;i<content.length();i++)
	   	{
	   		char c=content.charAt(i);	
	   		if(c =='\"')
	   		{
	   		s+="&quot;";
	   		}
	   		else if(c=='<')
	   		{
	   			s+="&lt;";
	   		}
	   		else if(c=='>')
	   		{
	   			s+="&amp;";
	   		}
	   		else if(c=='\n')
	   		{
	   			s+="<br>";
	   		}
	   		else if(c=='\'')
	   		{
	   			s+="&apos;";
	   		}
	   		else
	   		{
	   		s+=c;
	   		}
	   	}
	   return s;
	   }

//This method will take the text file and convert it into string file after replacing all the special 
//characters
	   public static String givestring(String file_name)
	   {
	   	String s="";
	   	String r="";
	   	File file=new File(file_name);
	   	try
	   	{
	   		Scanner scan=new Scanner(file);
	   		while(scan.hasNextLine())
	   		{
	   			s=scan.nextLine();
	   			s=checkString(s);
	   			r+=s;
	   		}
	   	}
	   	catch (FileNotFoundException e)
	   	 {
        System.out.println("Sorry Invalid file name");
        // System.out.println("Please try again");
        // Scanner sc=new Scanner(System.in);
        // String ss=sc.nextLine();
        // givestring(ss);
   		 }
	   
    // System.out.println(r);
return r;
	   }

}