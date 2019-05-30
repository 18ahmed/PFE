package com.sopra.project.controller;

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
import com.sopra.project.service.impl.InstalModServiceImpl;
import com.sopra.project.service.interfaces.InstalModService;

@RestController

public class InstalModController  {
	
	
	 @Autowired
	 InstalModRepository instalModRepository;
	     @Autowired
	 InstalModService instalModService;
	    
	     
	     String user = "ahmedmn";
		 String ip ="192.168.188.135";
		 String mp ="ahmed=";
		 	
			////**********************donné installation serveur de traitement************           
	 		//fileTrait
		String fileTrait ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallTrai"; 
		String fileTrait1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallTrai";  
			//instalTrait
		String cmdScriptTrait=". ./Install/InstallTrait/test.sh";
		
			//CopyFileTrait
		String fileBaseTocopyTrait ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallTrai"; 
		String placeToCopyTrait ="./Install/InstallTrait/";
			//RapportTrait
		//Linux /// String emplPDFTrait ="./Bureau";
		String nomPDFTrait ="rapporttrait.pdf";
		String emplPDFTrait ="./Bureau";

		String desPDFTrait ="D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\RapportTrait.pdf";
		String emplPDFWinTrait = "D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\RapportTrait.pdf";
		String emplPDFWinTrait1 = "rundll32 url.dll,FileProtocolHandler D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\RapportTrait.pdf";
		   
	 
	 
	 	////**********************Donnés installation serveur de presentation************ 
			//filePres
		String filePres ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallPres"; 
		String filePres1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallPres";  
			//instalPres
		String cmdScriptPres=". ./Install/InstallPres/installpres.sh";
		
			//CopyFilePres
		String fileBaseTocopyPres ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallPres";
		String placeToCopyPres ="./Install/InstallPres/";
			//RapportPres
		String emplPDFPres ="./Bureau";
		String nomPDFPres ="rapportpres.pdf";
		String desPDFPres ="D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\RapportPres.pdf";
		String emplPDFWinPres = "D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\RapportPres.pdf";
		String emplPDFWinPres1 = "rundll32 url.dll,FileProtocolHandler D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\RapportPres.pdf";
		   
	 
	////**********************Données installation serveur de generation************ 
			//fileGen
		String fileGen ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallGen"; 
		String fileGen1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallGen";  
			//instalGen
		String cmdScriptGen=". ./Install/InstallGen/gen.sh";
		
			//CopyFileGen
		String fileBaseTocopyGen ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallGen";
		String placeToCopyGen ="./Install/InstallGen/";
			//RapportGen
		String emplPDFGen ="./Bureau";
		String nomPDFGen ="rapportgen.pdf";
		String desPDFGen ="D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\RapportGen.pdf";
		String emplPDFWinGen = "D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\RapportGen.pdf";
		String emplPDFWinGen1 = "rundll32 url.dll,FileProtocolHandler D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\RapportGen.pdf";
		   
	 
	
	////**********************donné installation serveur Modelisation************ 
		String fileMod = "D:/Profiles/mbouzaien/Desktop/test.ps1" ;
		String fileMod1 = "rundll32 url.dll,FileProtocolHandler D:/Profiles/mbouzaien/Desktop/test.ps1";
		String instalMod = "cmd /c powershell D:/Profiles/mbouzaien/Desktop/test.ps1";
		
		
		////**********************donné installation serveur de Base************           

	 //fileBase
String fileBase ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallBD"; 
String fileBase1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallBD";  
	//instalBase
String cmdScriptBase=". ./Install/InstallBD/installbd.sh";

	//CopyFileBase
String fileBaseTocopyBase ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Paramfile\\paramfileInstallBD";
String placeToCopyBase ="./Install/InstallBD/";
	//RapportBase
String emplPDFBase ="./Bureau";
String nomPDFBase ="rapportbd.pdf";
String desPDFBase ="D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\Rapportbd.pdf";
String emplPDFWinBase = "D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\Rapportbd.pdf";
String emplPDFWinBase1 = "rundll32 url.dll,FileProtocolHandler D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Installation\\Rapport\\Rapportbd.pdf";


	
	
	////**********************données installation serveur de modelisation************ 

	 
	  
	
	//******************************Installation de serveur de Traitement*******************************
    @PostMapping("api/projet/RapportTrait")
    public void RapportTrait()  {
    	instalModService.Rapport(user, ip, mp, emplPDFTrait, nomPDFTrait, desPDFTrait, emplPDFWinTrait, emplPDFWinTrait1);
    	
    	
    }
    
    	@PostMapping("api/projet/CopyFileTrait")
    	public void CopyFileTrait () {
    	
    	instalModService.CopyFile(user, ip, mp, fileBaseTocopyTrait, placeToCopyTrait);
    	
    	}
        
    	@PostMapping("api/projet/instalTrait")
    	public void instalTrait() {
    	
    		instalModService.instal(user, ip, mp, cmdScriptTrait);
    		
	    }
     	
  
    	@PostMapping("api/projet/fileTrait")
    	public void fileTrait()  {	  	  
    		instalModService.file(fileTrait, fileTrait1);
    	} 
	
    	//******************************Installation de serveur de Presentation*******************************
        @PostMapping("api/projet/RapportPres")
        public void RapportPres()  {
        	instalModService.Rapport(user, ip, mp, emplPDFPres, nomPDFPres, desPDFPres, emplPDFWinPres, emplPDFWinPres1);
        	
        	
        }
        
        	@PostMapping("api/projet/CopyFilePres")
        	public void CopyFilePres () {
        	
        	instalModService.CopyFile(user, ip, mp, fileBaseTocopyPres, placeToCopyPres);
        	
        	}
            
        	@PostMapping("api/projet/instalPres")
        	public void instalPres() {
        	
        		instalModService.instal(user, ip, mp, cmdScriptPres);
        		
    	    }
         	
      
        	@PostMapping("api/projet/filePres")
        	public void filePres()  {	  	  
        		instalModService.file(filePres, filePres1);
        	} 
    	
        	
        	//******************************Installation de serveur de Generation*******************************
            @PostMapping("api/projet/RapportGen")
            public void RapportGen()  {
            	instalModService.Rapport(user, ip, mp, emplPDFGen, nomPDFGen, desPDFGen, emplPDFWinGen, emplPDFWinGen1);
            	
            	
            }
            
            	@PostMapping("api/projet/CopyFileGen")
            	public void CopyFileGen () {
            	
            	instalModService.CopyFile(user, ip, mp, fileBaseTocopyGen, placeToCopyGen);
            	
            	}
                
            	@PostMapping("api/projet/instalGen")
            	public void instalGen() {
            	
            		instalModService.instal(user, ip, mp, cmdScriptGen);
            		
        	    }
             	
          
            	@PostMapping("api/projet/fileGen")
            	public void fileGen()  {	  	  
            		instalModService.file(fileGen, fileGen1);
            	} 
        	
	
  //******************************Installation de serveur de Modelisation*******************************
  
            	
            	 //Installation de serveur de Modelisation
            	  @PostMapping("api/projet/instalMod")
            	   public  void addInstalMod() throws IOException   {

            	    	instalModService.instalMod(instalMod);
            	       
            	                  }
            	  
            	  @PostMapping("api/projet/fileMod")
            	  	public void fileMod()  {
            		  	instalModService.file(fileMod, fileMod1);} 
 
  //******************************Installation de serveur de Base de donné*******************************
    @PostMapping("api/projet/RapportBase")
    public void RapportBase()  {
    	instalModService.Rapport(user, ip, mp, emplPDFBase, nomPDFBase, desPDFBase, emplPDFWinBase, emplPDFWinBase1);
    	
    	
    }
    
    	@PostMapping("api/projet/CopyFileBase")
    	public void CopyFileBase () {
    	
    	instalModService.CopyFile(user, ip, mp, fileBaseTocopyBase, placeToCopyBase);
    	
    	}
        
    	@PostMapping("api/projet/instalBase")
    	public void instalBase() {
    	
    		instalModService.instal(user, ip, mp, cmdScriptBase);
    		
	    }
     	
  
//ouvrire le fichier de parametre pour l'installation du serveur de base de donné
    	@PostMapping("api/projet/fileBase")
    	public void fileBase()  {	  	  
    		instalModService.file(fileBase, fileBase1);
    	} 
  

  
  

}
