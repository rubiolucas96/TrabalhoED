package controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Curso;
import br.com.leandrocolevati.Lista.Lista;
import br.edu.fateczl.ordenacao.QuickSort;
import view.TelaManterAlunos;

public class CursosController implements ActionListener {
		private JTextField tfID;
		private JTextField tfNome;	
		private JTextArea taLista;
		private static boolean mensagemArquivoNaoEncontradoExibida = false;
		public CursosController(JTextField tfID, JTextField tfNome,JTextArea taLista) {
			super();
			this.tfID = tfID;
			this.tfNome = tfNome;
			this.taLista = taLista;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Gravar")) {
				try {
					insereDados();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (cmd.equals("Alterar")) {
				try {
					alteraDados();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (cmd.equals("Excluir")) {
				try {
					excluiDados();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if (cmd.equals("pesquisar")) {
				try {
					String conteudo = "";
					String[] vet = pesquisaDados();
					taLista.setText("");
						for(int v=0;v<100;v++) {
	  					if (vet[v] == null || vet[v] == "null") {
	  						
	  					} else {
	  						conteudo = conteudo + vet[v]+"\n";
	  					}
						}
						taLista.setText(conteudo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		
	
//======================================== Criar Arquivo ======================================
//=============================================================================================

	public void writeFile(Object CursoObject) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "BDAlunos";
		File arq = new File(path, "grupos.csv");

		Curso curso = new Curso();
		curso = (Curso) CursoObject;
		
		boolean existe = false;
		
		 if(arq.exists()) {
			 existe = true;
		 }

		 if (existe==false) {
			 curso.CursoID = 1;
		 } else {
			 LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(arq));
			 linhaLeitura.skip(arq.length());
			 curso.CursoID = linhaLeitura.getLineNumber()+1;
			 linhaLeitura.close();
		 }

		 FileWriter fileWriter = new FileWriter(arq, existe);
		 PrintWriter print = new PrintWriter(fileWriter);
		 print.write(curso.CursoID+";"+curso.CursoNome+"\n");
		 print.flush();
		 print.close();
		 fileWriter.close();
		
	}

//========================================= Ler Arqvo =========================================
//=============================================================================================
	public static Lista readFile() throws IOException {
	    String path = System.getProperty("user.home") + File.separator + "BDAlunos";
	    File arq = new File(path, "grupos.csv");
	    Lista lista = new Lista();

	    if (arq.exists() && arq.isFile()) {
	        FileInputStream fluxo = new FileInputStream(arq);
	        InputStreamReader leitor = new InputStreamReader(fluxo);
	        BufferedReader buffer = new BufferedReader(leitor);

	        String linha = buffer.readLine();
	        int i = 0;
	        while (linha != null) {
	            String[] partes = linha.split(";");
	            if (partes.length >= 2 && !partes[1].isEmpty() && !"null".equals(partes[1])) {
	                Curso curso = new Curso();
	                curso.CursoID = Integer.parseInt(partes[0]);
	                curso.CursoNome = partes[1];
	                try {
	                    if (i == 0) {
	                        lista.addFirst(curso);
	                        i = 1;
	                    } else {
	                        lista.addLast(curso);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            linha = buffer.readLine();
	        }
	        buffer.close();
	        leitor.close();
	        fluxo.close();

	    } else {
	    	
	    	 if (!mensagemArquivoNaoEncontradoExibida) {
	             JOptionPane.showMessageDialog(null, "Cadastrar o Tema do TCC na 2° tela.\nOu na pasta BDAlunos criar o arquivo grupos.csv", "Erro", JOptionPane.ERROR_MESSAGE);
	             mensagemArquivoNaoEncontradoExibida = true;
	    	 }
	    }
	    return lista;
	}



	public void rewriteFile(Object CursoObject, Lista lista) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "BDAlunos";
		File arq = new File(path, "grupos.csv");
			
		Curso curso = new Curso();
		curso = (Curso) CursoObject;
		
		int ID = curso.CursoID;
		String Nome = curso.CursoNome;

			
		String conteudo = "";
		
		boolean existe = false;
			
		int tamanho=lista.size();
			 
		 for (int i=0; i<=tamanho - 1; i++) {
			 try {
				 if (i==(ID - 1)) {
					conteudo = conteudo+ID+";"+Nome+"\n";		 
				 } else {
					 curso = (model.Curso) lista.get(i);
					 conteudo = conteudo+curso.CursoID+";"+curso.CursoNome+"\n";
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 FileWriter fileWriter = new FileWriter(arq, existe);
		 PrintWriter print = new PrintWriter(fileWriter);
		 print.write(conteudo);
		 print.flush();
		 print.close();
		 fileWriter.close();
			
	}

	public void insereDados() throws IOException {
	    Curso curso = new Curso();

	    if (!tfNome.getText().isEmpty()) {
	        if (tfID.getText().isEmpty()) {
	            curso.CursoNome = tfNome.getText();

	            writeFile(curso);
	            JOptionPane.showMessageDialog(null,"Registro Gravado");
	            tfNome.setText("");
	            tfID.setText("");
	            taLista.setText("");
	        } else {
	            JOptionPane.showMessageDialog(null,"ID não pode ser preenchido na inclusão","ERRO",JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null,"Informe o nome do Tema do TCC","ERRO",JOptionPane.ERROR_MESSAGE);
	    }
	}

	
	public void alteraDados() throws IOException {
		Curso curso = new Curso();

		if (!tfNome.getText().isEmpty()) {
					curso.CursoID=Integer.parseInt(tfID.getText());
					curso.CursoNome = tfNome.getText();
						rewriteFile(curso, readFile());
						JOptionPane.showMessageDialog(null,"Registro Alterado");
						tfNome.setText("");
						tfID.setText("");
						taLista.setText("");
		} else {
			JOptionPane.showMessageDialog(null,"Informe nome do Tema do TCC","ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void excluiDados() throws IOException {
	    Curso curso = new Curso();

	    if (!tfID.getText().isEmpty()) {
	        AlunoController aluno = new AlunoController(tfID, null, null, null, null, null, null, null, null, null);
	        if (aluno.verificaCurso(Integer.parseInt(tfID.getText()))) {
	            JOptionPane.showMessageDialog(null, "Registro não pode ser excluído, tem aluno vinculado ao Tema do TCC.", "ERRO", JOptionPane.ERROR_MESSAGE);
	        } else {
	            curso.CursoID = Integer.parseInt(tfID.getText());
	            curso.CursoNome = tfNome.getText();
	            rewriteFile(curso, readFile());
	            JOptionPane.showMessageDialog(null, "Registro Excluído");
	            tfNome.setText("");
	            tfID.setText("");
	            taLista.setText("");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Selecione o registro a excluir", "ERRO", JOptionPane.ERROR_MESSAGE);
	    }
	}


	public static String[] pesquisaDados() throws Exception {
		QuickSort sort = new QuickSort();

		Lista cursos=null;
		try {
			cursos = readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] vet = new String[100];	
		
		int tamanho = cursos.size();
		
		if  (tamanho>0) {

		} else {
			
		}
		int j=0;	
		for (int i=0;i<tamanho;i++) {
			Curso curso = new Curso();
			curso = (Curso) cursos.get(i);
			if  (curso.CursoID == 0) {
				j=j+1;
			} else {
				vet[i-j] = curso.CursoNome + ";"+curso.CursoID;
			}
		}
				
		vet = sort.quickSort(vet, 0, tamanho - 1 - j);
		return vet;

	}
	


	public String readID(int ID) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "BDAlunos";
		File arq = new File(path, "grupos.csv");

		if(arq.exists() && arq.isFile()) {
			String retorno=null;
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			Curso curso = new Curso();

			String linha = buffer.readLine();

			while(linha != null) {
				String[] partes = linha.split(";");
				if (Integer.parseInt(partes[0]) == ID) {
					curso.CursoID = Integer.parseInt(partes[0]);
					curso.CursoNome = partes[1];
					retorno = curso.toString();
					buffer.close();
					leitor.close();
					fluxo.close();
					return retorno;
				} else {
					linha = buffer.readLine();
				}
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException ("Erro na leitura do arquivo");
		}
		return null;
	}

}	