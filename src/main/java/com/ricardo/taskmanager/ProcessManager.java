package com.ricardo.taskmanager;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProcessManager {
	
	
	
    List<Process> idAndName() { 
    	
    	List<Process> list = new ArrayList<>();

    	
        ProcessHandle.allProcesses()
    	.forEach(p -> {
        	String path;
        	String name;
        	Process processes = new Process();

            path = p.info().command().orElse("N/A");
            if (path.equals("N/A")) {
                name = "N/A";
            }
            else {
                name = Path.of(path).getFileName().toString();
            }
            long id = p.pid();
            
            processes.processname = name;
            processes.id = id;
            
            list.add(processes);
            
        });
        
        return list;
        
        
    }
    
}

 
