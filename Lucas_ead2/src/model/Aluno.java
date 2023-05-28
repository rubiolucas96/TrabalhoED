package model;

public class Aluno {
	
	public String nome;
	public String ra;
	public String email;
	public int curso;
	public Object semestre;
	public String periodo;



	
	@Override
	public String toString() {
		return nome+";"+ra+";"+email+";"+curso+";"+semestre+";"+periodo;
	}
}