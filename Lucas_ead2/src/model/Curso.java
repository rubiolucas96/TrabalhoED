package model;

public class Curso {

	public int CursoID;
	public String CursoNome;


	@Override
	public String toString() {
		return CursoID+";"+CursoNome;
		
	}
}