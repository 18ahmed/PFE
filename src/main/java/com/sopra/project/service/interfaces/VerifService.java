package com.sopra.project.service.interfaces;

public interface VerifService {
	
	
		public void file(String a, String b);
	    public void verif(String user,String ip, String mp,String cmdScript);
	    public void CopyFile (String user,String ip,String mp,String file,String placeToCopy);
	    public void Rapport(String user,String ip,String mp,String emplPDF ,String nomPDF ,String desPDF,String emplPDFWin ,String emplPDFWin1);
	    

}
