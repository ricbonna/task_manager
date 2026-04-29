package com.ricardo.taskmanager;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
 

public class App 
{
    public static void main( String[] args )
    {

    	ProcessManager manager = new ProcessManager();
    			
		List<Process> list = manager.idAndName();
    		list.forEach(p -> {
    			System.out.println("Name: " + p.processname + " ID: " + p.id + " User: " + p.user + " CPU: " + p.cpuuse + " " + p.starttime);
    			
    		});
    	
  
    	 		
    	 		
    	 	    
    	
    	
    	

        
    }
}
