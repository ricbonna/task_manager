# Task Manager

Task Manager is a Java-based command-line application that retrieves and displays a list of all currently running operating system processes. It utilizes the Java ProcessHandle API introduced in Java 9 to fetch system-level process information without relying on external libraries or OS-specific commands.

## Features

The application extracts and displays the following details for each running process:

- **Process Name**: The executable name of the process.
- **Process ID (PID)**: The unique identifier assigned by the operating system.
- **User**: The system user that owns or initiated the process.
- **CPU Usage**: The total CPU duration consumed by the process, displayed in seconds.
- **Start Time**: The timestamp indicating when the process was launched.

## Project Structure

The project follows a standard Maven directory structure.

| File | Description |
| ---- | ----------- |
| `App.java` | The main entry point of the application. It instances the manager , retrieves the process list and outputs the details to the console. |
| `Process.java` | A data model class representing an individual system process, containing fields for ID, CPU usage, start time, user and process name. |
| `ProcessManager.java` | The core logic class that interacts with `ProcessHandle.allProcesses()` to gather system process data and map it to `Process` objects. |
| `pom.xml` | The Maven configuration file defining project metadata, build settings and the JUnit dependency. |

## Requirements

- Java Development Kit (JDK) 21 or higher
- Apache Maven 3.6+

## Building and Running

1. Clone the repository to your local machine.
2. Navigate to the project root directory where the `pom.xml` file is located.
3. Compile the project using Maven:

```bash
mvn clean install
```

4. Run the application from your IDE or by executing the compiled classes.

## Technical Details

The application leverages the `java.lang.ProcessHandle` interface to stream all visible processes. It handles missing information gracefully, substituting "N/A" or "MissingTime" when the operating system restricts access to specific process details due to permission limitations.
