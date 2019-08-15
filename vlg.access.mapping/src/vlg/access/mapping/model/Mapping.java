package vlg.access.mapping.model;

import java.io.IOException;
import vlg.access.mapping.view.Main;

public class Mapping{

	
	public void map(String letter, String name, String user, String password) {
		
		System.out.println("Mapping letter:" + letter + " name:" + name);
		try {
	        // Execute a command without arguments
	        //String command = "C:\\Windows\\system32\\net.exe use F: \\\\server\\share /user:user password";
	        String command = "C:\\Windows\\system32\\net.exe use " + letter + ": \\\\REDE-VLG\\" + name + " /USER:" + user + "  " + password;
	        Process child = Runtime.getRuntime().exec(command);
	        
	        //child.destroy();
	        child.getOutputStream().close();
	        System.out.println(command);
	        //return "    Sucessful!";
	        
	    } catch (IOException e) {
	    	//return "    Faild! - " + e.getMessage();
	    }
	}
	
	public void unmap(String letter) {
		try {
	        String command = "C:\\Windows\\system32\\net.exe use " + letter + ": /delete /y";
	        Process child = Runtime.getRuntime().exec(command);
	        
	        //child.destroy();
	        child.getOutputStream().close();
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	}
	
	public void rename(String letter, String name) {
		String line= "(New-Object -ComObject Shell.Application).NameSpace('" + letter + ":\').Self.Name = '" + name + "'";
		String command = "powershell.exe  " + line;
		 
		Process powerShellProcess;
		try {
			powerShellProcess = Runtime.getRuntime().exec(command);
			
			powerShellProcess.getOutputStream().close();
			powerShellProcess.destroy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
