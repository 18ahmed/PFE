package com.sopra.project.service.interfaces;

import java.io.IOException;
import java.util.Map;

import com.sopra.project.model.InstalMod;

public interface DupService {
	
	
	 public void addProjet(InstalMod InstalMod);
	    public void fileDup(String a, String b);
	    public void duplication(String user,String ip, String mp,String cmdScript);
	    public void CopyFiledup (String user,String ip,String mp,String file,String placeToCopy);
	    public void Rapportdup(String user,String ip,String mp,String emplPDF ,String nomPDF ,String desPDF,String emplPDFWin ,String emplPDFWin1);
	    public Map<Integer, String> dupMod(String script) throws IOException;


}
