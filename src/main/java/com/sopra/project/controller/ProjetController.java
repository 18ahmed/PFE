package com.sopra.project.controller;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.sopra.project.model.Projet;
import com.sopra.project.model.User;
import com.sopra.project.param.DisableParam;
import com.sopra.project.repository.ProjetRepository;
import com.sopra.project.service.interfaces.ProjetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * @author 
 */
@RestController
public class ProjetController   {
	
	

    @Autowired
    ProjetService projetService;
    @Autowired
    ProjetRepository projetRepository; 

    @PostMapping("api/projet/add")

    public @ResponseBody
    Map<String, Boolean> addUser(Model model, @RequestBody  Projet projet) {
        try {
            projetService.addProjet(projet);
            Map<String, Boolean> success = new TreeMap<String, Boolean>();
            success.put("response", true);
            return success;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            Map<String, Boolean> echec = new TreeMap<String, Boolean>();
            echec.put("response", false);
            return echec;
        }
        }
    
    
    @GetMapping("api/projet/getAllProjets")
	 List<Projet> getAllProjets(Model model) {
		return projetRepository.getprojets();
	}
    
   @PostMapping("api/projet/update")
    public @ResponseBody Map<String, Boolean> updateuser(Model model, @RequestBody Projet projet) {

        Projet projetToUpdate = projetService.getProjetById(projet.getId());

        if (projetToUpdate != null) {
        	projetToUpdate.setName(projet.getName());
        	projetToUpdate.setDescription(projet.getDescription());
        	projetToUpdate.setDate_debut(projet.getDate_debut());
        	projetToUpdate.setDate_fin(projet.getDate_fin());

            

            try {
                projetService.editProjet(projetToUpdate);
                Map<String, Boolean> success = new TreeMap<String, Boolean>();
                success.put("response", true);
                return success;
            } catch (Exception e) {
                e.printStackTrace();
                Map<String, Boolean> echec = new TreeMap<String, Boolean>();
                echec.put("response", false);
                return echec;
            }
        } else {
            Map<String, Boolean> echec = new TreeMap<String, Boolean>();
            echec.put("response", false);
            return echec;
        }
    }

    @PostMapping("api/projet/remove")
    public @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<Long> ids) {
        Long idProjetToDelete = null;
        try {
            System.out.println(ids.size());
            for (int i = 0; i < ids.size(); i++) {
                idProjetToDelete = ids.get(i);
                if (idProjetToDelete != null)
                    projetService.deleteProjet(idProjetToDelete);
            }

            Map<String, Boolean> success = new TreeMap<String, Boolean>();
            success.put("response", true);
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Boolean> echec = new TreeMap<String, Boolean>();
            echec.put("response", false);
            return echec;
        }
    }

    @GetMapping("api/projet/getbyid")
    Projet getServerById(Model model, Long id) {

        return projetService.getProjetById(id);
    }

    @GetMapping("api/projet/getbyname")
    Projet getProjetByName(Model model, String name) {
        return projetService.getProjetByName(name);
    }

    @GetMapping("api/projet/getall")
    List<Projet> getallserver(Model model) {
        return projetService.getAll();
    }
    
    
   
    
    
    
    @GetMapping("api/projet/disable") 

	public @ResponseBody Map<String, Boolean> diableprojet(Model model,Projet projet) {
    	 Projet projetToUpdate = projetService.getProjetById(projet.getId());
			System.out.println(projetToUpdate.getId());
 			System.out.println(projet.getEnabled());

			projetToUpdate.setEnabled(!projetToUpdate.getEnabled());
         try {
                 projetService.editProjet(projetToUpdate);
                 Map<String, Boolean> success = new TreeMap<String, Boolean>();
                 success.put("response", true);
                 return success;
             } catch (Exception e) {
                 e.printStackTrace();
                 Map<String, Boolean> echec = new TreeMap<String, Boolean>();
                 echec.put("response", false);
                 return echec;
             }
        
     }
		
    
    
	/*	@PostMapping("api/projet/instalMod")
			public void scriptUser() throws IOException {
			System.out.println("aaaaaaaaaa");
			//Runtime.getRuntime().exec(" ./D:\\user.sh");

			Runtime runtime = Runtime.getRuntime();

	        String cmds = (String) "cmd /c powershell D:/Profiles/mbouzaien/Desktop/test.ps1";
			
	        Process proc = runtime.exec(cmds);
	        proc.getOutputStream().close();

	        InputStream inputstream = proc.getInputStream();

	            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);

	            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

	        String line;

	        while ((line = bufferedreader.readLine()) != null) {

	            System.out.println(line);          

	      }

	 

	}

*/
   
    String command1="xterm -e ll";		
    @PostMapping("api/projet/test")			
	public void testscript() {
    	
try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession("user", "192.168.126.192", 22);
	    	session.setPassword("user");
	    	session.setConfig(config);
	    	session.connect();
	    	System.out.println("Connected");
	    	

	    	Channel channel=session.openChannel("exec");
	       


	        ((ChannelExec) channel).setCommand(command1);
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{Thread.sleep(1000);}catch(Exception ee){}
	        }
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }

	}
    }
    
  

