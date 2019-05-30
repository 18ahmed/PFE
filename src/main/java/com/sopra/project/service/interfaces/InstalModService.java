package com.sopra.project.service.interfaces;


import java.io.IOException;
import java.util.Map;

import com.sopra.project.model.*;

public interface InstalModService {
	
	
    public void addProjet(InstalMod InstalMod);
    public void file(String a, String b);
    public void instal(String user,String ip, String mp,String cmdScript);
    public void CopyFile (String user,String ip,String mp,String file,String placeToCopy);
    public void Rapport(String user,String ip,String mp,String emplPDF ,String nomPDF ,String desPDF,String emplPDFWin ,String emplPDFWin1);
    public Map<Integer, String> instalMod(String script) throws IOException;

}
