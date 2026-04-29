package com.ricardo.taskmanager;
import java.util.stream.*;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;


public class ProcessManager {
	
	
	
    List<Process> idAndName() { 
    	
    	List<Process> list = new ArrayList<>();

    	
        ProcessHandle.allProcesses()
    	.forEach(p -> {
    		
        	String path;
        	String name;
        	String starttime;
        	Instant instanttime;
        	String username;
        	long cpuuse;
        	Duration durationcpu;
        	
        	Process processes = new Process();

            path = p.info().command().orElse("N/A");
            if (path.equals("N/A")) {
                name = "N/A";
            }
            else {
                name = Path.of(path).getFileName().toString();
            }
            
            durationcpu = p.info().totalCpuDuration().orElse(Duration.ZERO);
            if (durationcpu.equals(Duration.ZERO)) {
            	cpuuse = 0;
            }
            else {
            	cpuuse = durationcpu.getSeconds();
            }
            
            instanttime = p.info().startInstant().orElse(Instant.MIN);
            if (instanttime.equals(Instant.MIN)) {
            	starttime = "MissingTime";
            }
            else {
            	starttime = instanttime.toString();
            }
            
            username = p.info().user().orElse("User missing");
            
            long id = p.pid();
            
            processes.user = username;
            processes.starttime = starttime;
            processes.cpuuse = cpuuse;
            processes.processname = name;
            processes.id = id;
           
            
            list.add(processes);
            
        });
        
        return list;
        
        
    }
    
}

 
