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

    	ProcessHandle.allProcesses()
    		.forEach(p -> {
    			String path = p.info().command().orElse("N/A");
    			if(path.equals("N/A")) {
    				System.out.println("N/A PID: " + p.pid());
    			}
    			else {
    				String name = Path.of(path).getFileName().toString();
					System.out.println(name + " PID: " + p.pid());
					
    			}
    					
    		});
    			
    		
    		
    	
  
    	 		
    	 		
    	 	    
    	
    	
    	

        
    }
}
