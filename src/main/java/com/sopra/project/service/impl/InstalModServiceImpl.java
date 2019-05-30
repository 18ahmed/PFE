package com.sopra.project.service.impl;

import java.io.File;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.sopra.project.model.InstalMod;
import com.sopra.project.repository.InstalModRepository;
import com.sopra.project.service.interfaces.InstalModService;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.sopra.project.repository.InstalModRepository;

import com.sopra.project.service.interfaces.InstalModService;

@Service
@Transactional
public class InstalModServiceImpl implements InstalModService {

	@Autowired
	InstalModRepository instalRepository;
	
	@Override
	public void addProjet(InstalMod instalMod) {
		instalRepository.save(instalMod);
		
	}
	
	@Override
	public void file(String a, String b)  {
	  	try{
	  		if ((new File(a)).exists()) {
	  			Process p = Runtime.getRuntime().exec(b);
	            p.waitFor();
	            } else {
	            System.out.println("File does not exist");}
	      } catch (Exception ex) {
	        ex.printStackTrace();
	      }}

	@Override
	public void instal(String user, String ip, String mp, String cmdScript) {
try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, ip, 22);
	    	session.setPassword(mp);
	    	session.setConfig(config);
	    	session.connect();
	    	
			    //If you want you can change the directory using the following line.
	    	
System.out.println("Connected");
	    	
	    	Channel channel=session.openChannel("exec");
		    	    	
	       ((ChannelExec) channel).setCommand(cmdScript);
 	   
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

	@Override
	public void CopyFile(String user, String ip, String mp, String file, String placeToCopy) {
		try {
			JSch jsch = new JSch();
			Session session = null;
			session = jsch.getSession(user,ip,22);
			session.setPassword(mp);
			session.setConfig("StrictHostKeyChecking", "no");
			    session.connect();
			ChannelSftp channel = null;
			channel = (ChannelSftp)session.openChannel("sftp");
			channel.connect();
			    File localFile = new File(file);
			    
			    
			    //If you want you can change the directory using the following line.
			  channel.cd(placeToCopy);
			     
			channel.put(new FileInputStream(localFile),localFile.getName());
			 

			  channel.setInputStream(null);
			  ((ChannelSftp) channel).setOutputStream(System.err);
			  InputStream in = channel.getInputStream();
			  channel.connect();

			  
			  
			  channel.disconnect();
			session.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	}

	@Override
	public void Rapport(String user, String ip, String mp, String emplPDF, String nomPDF, String desPDF,
			String emplPDFWin, String emplPDFWin1) {
		try {
            JSch jsch = new JSch();
			Session session = null;
            session = jsch.getSession(user,ip,22);
            session.setPassword(mp);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
			ChannelSftp channel = null;

            channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect();

            channel.cd(emplPDF);
            byte[] buffer = new byte[1024];
            BufferedInputStream bis = new BufferedInputStream(channel.get(nomPDF));
            File newFile = new File(desPDF);
            OutputStream os = new FileOutputStream(newFile);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int readCount;
            while ((readCount = bis.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos.write(buffer, 0, readCount);
            }
            bis.close();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	try{
	  		if ((new File(emplPDFWin)).exists()) {
	  			Process p = Runtime.getRuntime().exec(emplPDFWin1);
	            p.waitFor();
	            } else {
	            System.out.println("File does not exist");}
	      } catch (Exception ex) {
	        ex.printStackTrace();
	      }
		
	}

	@Override
	public Map<Integer, String> instalMod(String script) throws IOException   {

    	
	       // ErrorFrame errorFrame = new ErrorFrame();

	        

	    			 System.out.println("aaaaaaaaaa");
	     		//Runtime.getRuntime().exec(" ./D:\\user.sh");

	     		Runtime runtime = Runtime.getRuntime();

	     		
	             Process proc = runtime.exec(script);
	   	  	 
	             proc.getOutputStream().close();

	             InputStream inputstream = proc.getInputStream();

	                 InputStreamReader inputstreamreader = new InputStreamReader(inputstream);

	                 BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

	                 
	                 Map <Integer,String> lignes = new HashMap<Integer,String>();
	                 Integer id =new Integer(0);
	                  String line ;

	                 while ((line = bufferedreader.readLine()) != null) {
	             	            	
	             	            	
	        	     lignes.put(id, line);
	        	     id = id+1;

	        	     System.out.println(line);
	        	     

	        	      
	        	     
	                      }
	             	           
	                 Set<Entry<Integer, String>> setLhm = lignes.entrySet();
	                 Iterator<Entry<Integer, String>> it2 = setLhm.iterator();
	                 while(it2.hasNext()){
	                    Entry<Integer, String> e = it2.next();
	                    System.out.println(e.getKey() + " : " + e.getValue());
	            
	       	//instalModService.addProjet(instalMod);
	           Map<String, Boolean> success = new TreeMap<String, Boolean>();
	           success.put("response", true);
	           
	                 }
	           
	                 return lignes;

	                  
		
	}
  

}
