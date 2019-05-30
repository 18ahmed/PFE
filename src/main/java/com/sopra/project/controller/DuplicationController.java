package com.sopra.project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.project.repository.InstalModRepository;
import com.sopra.project.service.interfaces.DupService;
import com.sopra.project.service.interfaces.InstalModService;

@RestController

public class DuplicationController {
	
	
	 
	     @Autowired
	 DupService dupService;

	     String user = "ahmedmn";
		 String ip="192.168.188.135";
		 String mp="ahmed=";
		 	
		 
		////**********************donné installation serveur de traitement************           
	 		//fileTrait
		String fileTrait ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupTrai"; 
		String fileTrait1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupTrai";  
			//instalTrait
		String cmdScriptTrait=". ./Clonnage/Traitclone/test.sh";
		
			//CopyFileTrait
		String fileBaseTocopyTrait ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupTrai";
		String placeToCopyTrait ="./Clonnage/Traitclone/";
			//RapportTrait
		String emplPDFTrait ="./Bureau";
		String nomPDFTrait ="rapporttrait.pdf";
		String desPDFTrait ="D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapporttrai.pdf";
		String emplPDFWinTrait = "D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapporttrai.pdf";
		String emplPDFWinTrait1 = "rundll32 url.dll,FileProtocolHandler D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapporttrai.pdf";
		   
	 
	 
	 	////**********************donné installation serveur de presentation************
			//filePres
		String filePres ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupPres"; 
		String filePres1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupPres";  
			//instalPres
		String cmdScriptPres=". ./Clonnage/Presclone/presclone.sh";
		
			//CopyFilePres
		String fileBaseTocopyPres ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupPres";
		String placeToCopyPres ="./Clonnage/Presclone/";
			//RapportPres
		String emplPDFPres ="./Bureau";
		String nomPDFPres ="rapportpres.pdf";
		String desPDFPres ="D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapportpres.pdf";
		String emplPDFWinPres = "D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapportpres.pdf";
		String emplPDFWinPres1 = "rundll32 url.dll,FileProtocolHandler D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapportpres.pdf";
		   
	 
	////**********************donné installation serveur de generation************ 
			//fileGen
		String fileGen ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupGen"; 
		String fileGen1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupGen";  
			//instalGen
		String cmdScriptGen=". ./Clonnage/Genclone/genclone.sh";
		
			//CopyFileGen
		String fileBaseTocopyGen ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupGen";
		String placeToCopyGen ="./Clonnage/Genclone/";
			//RapportGen
		String emplPDFGen ="./Bureau";
		String nomPDFGen ="rapportgen.pdf";
		String desPDFGen ="D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapportgen.pdf";
		String emplPDFWinGen = "D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapportgen.pdf";
		String emplPDFWinGen1 = "rundll32 url.dll,FileProtocolHandler D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapportgen.pdf";
		   
	 
	
	////**********************donné installation serveur Modelisation************ 
		String fileMod = "D:/Profiles/mbouzaien/Desktop/test.ps1" ;
		String fileMod1 = "rundll32 url.dll,FileProtocolHandler D:/Profiles/mbouzaien/Desktop/test.ps1";
		String instalMod = "cmd /c powershell D:/Profiles/mbouzaien/Desktop/test.ps1";
		
		
		////**********************donné installation serveur de Base************           

	 //fileBase
String fileBase ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupBD"; 
String fileBase1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupBD";  
	//instalBase
String cmdScriptBase=". ./Clonnage/BDclone/bdclone.sh";

	//CopyFileBase
String fileBaseTocopyBase ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Paramfile\\paramfiledupBD";
String placeToCopyBase ="./Clonnage/BDclone/";
	//RapportBase
String emplPDFBase ="./Bureau";
String nomPDFBase ="rapportbd.pdf";
String desPDFBase ="D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapportbd.pdf";
String emplPDFWinBase = "D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapportbd.pdf";
String emplPDFWinBase1 = "rundll32 url.dll,FileProtocolHandler D:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Duplication\\Rapport\\Rapportbd.pdf";



	
	
	
	 
	  
	
	//******************************Duplication de serveur de Traitement*******************************
    @PostMapping("api/projet/RapportTraitDup")
    public void RapportTraitDup()  {
    	dupService.Rapportdup(user, ip, mp, emplPDFTrait, nomPDFTrait, desPDFTrait, emplPDFWinTrait, emplPDFWinTrait1);
    	
    	
    }
    
    	@PostMapping("api/projet/CopyFileTraitDup")
    	public void CopyFileTraitDup () {
    	
    		dupService.CopyFiledup(user, ip, mp, fileBaseTocopyTrait, placeToCopyTrait);
    	
    	}
        
    	@PostMapping("api/projet/dupTrait")
    	public void dupTrait() {
    	
    		dupService.duplication(user, ip, mp, cmdScriptTrait);
    		
	    }
     	
  
    	@PostMapping("api/projet/fileTraitDup")
    	public void fileTraitDup()  {	  	  
    		dupService.fileDup(fileTrait, fileTrait1);
    	} 
	
    	//******************************Installation de serveur de Presentation*******************************
        @PostMapping("api/projet/RapportPresDup")
        public void RapportPresDup()  {
        	dupService.Rapportdup(user, ip, mp, emplPDFPres, nomPDFPres, desPDFPres, emplPDFWinPres, emplPDFWinPres1);
        	
        	
        }
        
        	@PostMapping("api/projet/CopyFilePresDup")
        	public void CopyFilePresDup () {
        	
        		dupService.CopyFiledup(user, ip, mp, fileBaseTocopyPres, placeToCopyPres);
        	
        	}
            
        	@PostMapping("api/projet/dupPres")
        	public void dupPres() {
        	
        		dupService.duplication(user, ip, mp, cmdScriptPres);
        		
    	    }
         	
      
        	@PostMapping("api/projet/filePresDup")
        	public void filePresDup()  {	  	  
        		dupService.fileDup(filePres, filePres1);
        	} 
    	
        	
        	//******************************Installation de serveur de Generation*******************************
            @PostMapping("api/projet/RapportGenDup")
            public void RapportGenDup()  {
            	dupService.Rapportdup(user, ip, mp, emplPDFGen, nomPDFGen, desPDFGen, emplPDFWinGen, emplPDFWinGen1);
            	
            	
            }
            
            	@PostMapping("api/projet/CopyFileGenDup")
            	public void CopyFileGenDup () {
            	
            		dupService.CopyFiledup(user, ip, mp, fileBaseTocopyGen, placeToCopyGen);
            	
            	}
                
            	@PostMapping("api/projet/dupGen")
            	public void dupGen() {
            	
            		dupService.duplication(user, ip, mp, cmdScriptGen);
            		
        	    }
             	
          
            	@PostMapping("api/projet/fileGenDup")
            	public void fileGenDup()  {	  	  
            		dupService.fileDup(fileGen, fileGen1);
            	} 
        	
	
  //******************************Installation de serveur de Modelisation*******************************
  
            	
            	 //Installation de serveur de Modelisation
            	  @PostMapping("api/projet/dupMod")
            	   public  void dupMod() throws IOException   {

            		  dupService.dupMod(instalMod);
            	       
            	                  }
            	  
            	  @PostMapping("api/projet/fileModDup")
            	  	public void fileModDup()  {
            		  dupService.fileDup(fileMod, fileMod1);} 
 
  //******************************Installation de serveur de Base de donné*******************************
    @PostMapping("api/projet/RapportBaseDup")
    public void RapportBaseDup()  {
    	dupService.Rapportdup(user, ip, mp, emplPDFBase, nomPDFBase, desPDFBase, emplPDFWinBase, emplPDFWinBase1);
    	
    	
    }
    
    	@PostMapping("api/projet/CopyFileBaseDup")
    	public void CopyFileBaseDup () {
    	
    		dupService.CopyFiledup(user, ip, mp, fileBaseTocopyBase, placeToCopyBase);
    	
    	}
        
    	@PostMapping("api/projet/dupBase")
    	public void dupBase() {
    	
    		dupService.duplication(user, ip, mp, cmdScriptBase);
    		
	    }
     	
  
//ouvrire le fichier de parametre pour l'installation du serveur de base de donné
    	@PostMapping("api/projet/fileBaseDup")
    	public void fileBaseDup()  {	  	  
    		dupService.fileDup(fileBase, fileBase1);
    	} 
  

  
  

}
