package com.sopra.project.controller;

import java.io.File;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.sopra.project.repository.InstalModRepository;
import com.sopra.project.service.interfaces.InstalModService;
import com.sopra.project.service.interfaces.VerifService;

@RestController

public class VerifController {
	
	@Autowired
	 InstalModRepository instalModRepository;
	     @Autowired
	 VerifService verifService;
	
	     String user = "ahmedmn";
		 String ip="192.168.188.135";
		 String mp="ahmed=";
	     
	   /////////// donné version 
		 String cmdScriptVer = ".  /Menu/version.sh";
	 //////////// donné User 
		 		//verif
		 String cmdScriptUser = ". ./Menu/user/user.sh" + 
		 		"";
		 		//file User
		 String fileUser ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\userfile.txt";
		 String fileUser1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\paramfile\\userfile.txt";
		 		
		//CopyUser
		 String fileBaseTocopyUser ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\userfile.txt";
		 String placeToCopyUser ="./Menu/user/";
		 //rapportUser
		 String emplPDFUser ="./Bureau";
		 String nomPDFUser ="RapportUser.pdf";
		 String desPDFUser ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportUser.pdf";
		 String emplPDFWinUser = "d:\\\\Profiles\\\\amounani\\\\Desktop\\\\PleiadesIntegration\\\\Verification\\\\Rapport\\\\RapportUser.pdf";
		 String emplPDFWinUser1 = "rundll32 url.dll,FileProtocolHandler d:\\\\Profiles\\\\amounani\\\\Desktop\\\\PleiadesIntegration\\\\Verification\\\\Rapport\\\\RapportUser.pdf";
		 		
	     
////////////donné Fs 
		 
		//file Fs
		 String fileFs ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\matrice.csv";
		 String fileFs1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\matrice.csv";
		 
		 
			//CopyFs
		 String fileBaseTocopyFs ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\matrice.csv";
		 String placeToCopyFs ="./Menu/fs/";
		 //verif
	 String cmdScriptFs = ". ./Menu/fs/fs.sh";
	 		
	 		//rapportFs
	 String emplPDFFs ="./Bureau";
	 String nomPDFFs ="RapportFS.pdf";
	 
	 String desPDFFs ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportFS.pdf";
	 String emplPDFWinFs = "d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportFS.pdf";
	 String emplPDFWinFs1 = "rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportFS.pdf";	

	 
	 	
	 
////////////donné Pck 
	 
		//file Pck
String filePck ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\package.txt";
String filePck1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\package.txt";

//CopyFs
String fileBaseTocopyPck ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\package.txt";
String placeToCopyPck ="./Menu/package/";

//verif
String cmdScriptPck = ". ./Menu/package/package.sh";
//rapportFs
String emplPDFPck ="./Bureau";
String nomPDFPck ="RapportPackage.pdf";


String desPDFPck ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportPackage.pdf";
String emplPDFWinPck = "d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportPackage.pdf";
String emplPDFWinPck1 = "rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportPackage.pdf";
		

////////////donné Pta


//file Pck
String filePta ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\service.txt";
String filePta1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\service.txt";
//CopyFs
String fileBaseTocopyPta ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\service.txt";
String placeToCopyPta ="./Menu/service/";

//verif
String cmdScriptPta = ". ./Menu/service/servicepta.sh";

//rapportFs
String emplPDFPta ="./Bureau";
String nomPDFPta ="RapportPta.pdf";

String desPDFPta ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportPta.pdf";
String emplPDFWinPta = "d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportPta.pdf";
String emplPDFWinPta1 = "rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Rapport\\RapportPta.pdf";


////////////donné Flux

//file Flux

String fileFlux ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\matriceflux.csv";
String fileFlux1 ="rundll32 url.dll,FileProtocolHandler d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\matriceflux.csv";
//CopyFlux
String fileBaseTocopyFlux ="d:\\Profiles\\amounani\\Desktop\\PleiadesIntegration\\Verification\\Paramfile\\matriceflux.csv";
String placeToCopyFlux ="./Menu/Flux";

//verif
String cmdScriptFlux = ". ./Menu/Flux/test.sh";



//rapportFlux
String emplPDFFlux ="./Bureau";
String nomPDFFlux ="rapport.pdf";
String desPDFFlux ="D:\\Profiles\\amounani\\Desktop\\Rapport.pdf";
String emplPDFWinFlux = "D:\\Profiles\\amounani\\Desktop\\Rapport.pdf";
String emplPDFWinFlux1 = "rundll32 url.dll,FileProtocolHandler D:\\Profiles\\amounani\\Desktop\\Rapport.pdf";

      
	
	     
	     //***************************************** la version de l'env 
	     
	     @PostMapping("api/projet/verifVersion")
	     
	     public void verifVersion()  {
	 	  verifService.verif(user, ip, mp, cmdScriptVer);
	 	      	            
	     }
	     
	     
	     
	     //**************************************************** user**************************
	     
@PostMapping("api/projet/verifUser")
	     
	    public void verifUser()  {
	verifService.verif(user, ip, mp, cmdScriptUser);
	 	  
}
@PostMapping("api/projet/fileUser")
public void fileUser()  {
	verifService.file(fileUser, fileUser1);
}

@PostMapping("api/projet/rapportUser")
public void rapportUser() {
	verifService.Rapport(user, ip, mp, emplPDFUser, nomPDFUser, desPDFUser, emplPDFWinUser, emplPDFWinUser1);
}

@PostMapping("api/projet/copyUser")
public void copyUser() {
	verifService.CopyFile(user, ip, mp, fileBaseTocopyUser, placeToCopyUser);
}
 
	     
	     //***************************************** fs******************************

@PostMapping("api/projet/verifFs")

	public void verifFs()  {
	verifService.verif(user, ip, mp, cmdScriptFs);   
}
@PostMapping("api/projet/fileFs")
public void fileFs()  {
	verifService.file(fileFs, fileFs1);
}
@PostMapping("api/projet/rapportFS")
public void rapportFS() {
	verifService.Rapport(user, ip, mp, emplPDFFs, nomPDFFs, desPDFFs, emplPDFWinFs, emplPDFWinFs1);
}

@PostMapping("api/projet/copyFS")
public void copyFS() {
	verifService.CopyFile(user, ip, mp, fileFs, placeToCopyFs);
}

	     
	     //****************************************package******************************
@PostMapping("api/projet/verifPackage")
public void verifPackage()  {
	verifService.verif(user, ip, mp, cmdScriptPck);   
}
@PostMapping("api/projet/filePackage")
public void filePackage()  {
	verifService.file(filePck, filePck1);
}
@PostMapping("api/projet/rapportPackage")
public void rapportPackage() {
	verifService.Rapport(user, ip, mp, emplPDFPck, nomPDFPck, desPDFPck, emplPDFWinPck, emplPDFWinPck1);
}

@PostMapping("api/projet/copyPackage")
public void copyPackage() {
	verifService.CopyFile(user, ip, mp, filePck, placeToCopyPck);
}
    
	     //*****************************************PTa******************************

@PostMapping("api/projet/verifPta")
public void verifPta()  {
	verifService.verif(user, ip, mp, cmdScriptPta);   
}
@PostMapping("api/projet/filePta")
public void filePta()  {
	verifService.file(filePta, filePta1);
}
@PostMapping("api/projet/rapportPta")
public void rapportPta() {
	verifService.Rapport(user, ip, mp, emplPDFPta, nomPDFPta, desPDFPta, emplPDFWinPta, emplPDFWinPta1);
}

@PostMapping("api/projet/copyPta")
public void copyPta() {
	verifService.CopyFile(user, ip, mp, filePta, placeToCopyPta);
}

	     //*************************************flux************************************
  
@PostMapping("api/projet/verifFlux")
public void verifFlux()  {
	verifService.verif(user, ip, mp, cmdScriptFlux);   
}
@PostMapping("api/projet/fileFlux")
public void fileFlux()  {
	verifService.file(fileFlux, fileFlux1);
}
@PostMapping("api/projet/rapportFlux")
public void rapportFlux() {
	verifService.Rapport(user, ip, mp, emplPDFFlux, nomPDFFlux, desPDFFlux, emplPDFWinFlux, emplPDFWinFlux1);
}

@PostMapping("api/projet/copyFlux")
public void copyFlux() {
	verifService.CopyFile(user, ip, mp, fileFlux, placeToCopyFlux);
}


}
