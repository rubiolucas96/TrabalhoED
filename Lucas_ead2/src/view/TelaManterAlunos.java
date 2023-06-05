package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import controller.AlunoController;
import controller.CursosController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TelaManterAlunos extends JFrame {
	
	private static final long serialVersionUID = 6909508245638580811L;
	private JPanel contentPane;
	private JTextField txtSistemaDeOrientacao;
	private JTextField txtPropriedadeDaFatec_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
				TelaManterAlunos frame = new TelaManterAlunos();
				frame.setVisible(true);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		
	}
	
//====================================================================================================================================
//============================================================ TELA BASE =============================================================
//====================================================================================================================================
public TelaManterAlunos() {
		setBackground(new Color(214, 220, 228));
		setTitle("Gerenciamento de TCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1024, 680);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//----------------------------------------------------------------------------------------------------------------------------
		JLabel LOGO = new JLabel("");
		LOGO.setHorizontalAlignment(SwingConstants.CENTER);
		LOGO.setBackground(Color.WHITE);
		LOGO.setIcon(new ImageIcon("C:\\TEMP\\logo.png"));
		LOGO.setBounds(0, 0, 207, 93);
		contentPane.add(LOGO);
		
		//----------------------------------------------------------------------------------------------------------------------------
		txtSistemaDeOrientacao = new JTextField();
		txtSistemaDeOrientacao.setEditable(false);
		txtSistemaDeOrientacao.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSistemaDeOrientacao.setForeground(Color.WHITE);
		txtSistemaDeOrientacao.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtSistemaDeOrientacao.setText("Gerenciamento de TCC                  ");
		txtSistemaDeOrientacao.setBackground(Color.BLACK);
		txtSistemaDeOrientacao.setBounds(0, 0, 1020, 93);
		contentPane.add(txtSistemaDeOrientacao);
		txtSistemaDeOrientacao.setColumns(10);
		
		txtPropriedadeDaFatec_1 = new JTextField();
		txtPropriedadeDaFatec_1.setText("Propriedade da FATEC Zona Leste. Todos os direitos reservados ®");
		txtPropriedadeDaFatec_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPropriedadeDaFatec_1.setForeground(Color.WHITE);
		txtPropriedadeDaFatec_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtPropriedadeDaFatec_1.setEditable(false);
		txtPropriedadeDaFatec_1.setColumns(10);
		txtPropriedadeDaFatec_1.setBackground(Color.BLACK);
		txtPropriedadeDaFatec_1.setBounds(0, 616, 1008, 25);
		contentPane.add(txtPropriedadeDaFatec_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(46, 125 + 50, 40, 17);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(lblNome.getFont().deriveFont(Font.BOLD));
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(46, 146 + 50, 457, 20);
		
		contentPane.add(textField);
		
		JButton btnRegras_1_2 = new JButton("");
		btnRegras_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
	
		
		JLabel lblra = new JLabel("RA");
		lblra.setBounds(557, 125 + 50, 40, 17);
		lblra.setForeground(Color.WHITE);
		lblra.setFont(lblra.getFont().deriveFont(Font.BOLD));
		contentPane.add(lblra);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(557, 146 + 50, 156, 20);
		contentPane.add(textField_1);
		
		JButton btnRegras_1_2_1 = new JButton("");

		
		JComboBox comboBox = new JComboBox();
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBox.removeAllItems();
				String[] vet = new String[100];
				try {
					vet = CursosController.pesquisaDados();
					for(int v=0;v<100;v++) {
							if (vet[v] == null) {
								
							} else {
								comboBox.addItem(vet[v]);
							}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch cafeblock
					e1.printStackTrace();
				}
			}
		});
		comboBox.setBounds(46, 193 + 50, 292, 22);
		contentPane.add(comboBox);
		
		JLabel lblCurso = new JLabel("Tema do TCC");
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(lblra.getFont().deriveFont(Font.BOLD));
		lblCurso.setBounds(46, 177 + 50, 319, 17);
		
		contentPane.add(lblCurso);
		
		JButton btnCursos = new JButton("");
		btnCursos.setActionCommand("Cursos");
		btnCursos.setToolTipText("Manter cursos");
		btnCursos.setIcon(new ImageIcon("C:\\TEMP\\lupa.png"));
		btnCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCursos.setBounds(348, 183 + 52, 32, 32);
		contentPane.add(btnCursos);
		
		
		
		JComboBox comboBox_2 = new JComboBox();
	
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(46, 226 + 50, 423, 17);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(lblra.getFont().deriveFont(Font.BOLD));
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(46, 244 + 50, 533, 20);
		contentPane.add(textField_2);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(0, 500, 1020, 100); 
		panelBotoes.setBackground(Color.BLACK);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10)); 
		
		
		

		JButton btnGravar_1 = new JButton("Inserir Alunos");
		btnGravar_1.setPreferredSize(new Dimension(120, 40)); 
		panelBotoes.add(btnGravar_1);
		
		
		
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setBounds(450, 179 + 50, 110, 17);
		lblSemestre.setForeground(Color.WHITE);
		lblSemestre.setFont(lblra.getFont().deriveFont(Font.BOLD));
		contentPane.add(lblSemestre);
		
		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setBounds(637, 175 + 50, 165, 17);
		lblPeriodo.setForeground(Color.WHITE);
		lblPeriodo.setFont(lblra.getFont().deriveFont(Font.BOLD));
		contentPane.add(lblPeriodo);
		
		JLabel lblInserindoAlunos = new JLabel("Inserindo Alunos");
		lblInserindoAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserindoAlunos.setForeground(Color.WHITE); 
		lblInserindoAlunos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInserindoAlunos.setBounds(46, 104 + 50, 907, 17);
		contentPane.add(lblInserindoAlunos);
		int deslocamentoY = 50;
		lblInserindoAlunos.setBounds(50, 105 + deslocamentoY, 850, 17);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(450, 193 + 50, 110, 22);
		contentPane.add(comboBox_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBounds(637, 193 + 50, 186, 22);
		contentPane.add(comboBox_1_1_1);
		
//----------------------------------------------------------------------------------------------------------------------------

		comboBox_1_1.addItem(" ");
		comboBox_1_1.addItem("4");
		comboBox_1_1.addItem("5");
		comboBox_1_1.addItem("6");


		comboBox_1_1_1.addItem(" ");
		comboBox_1_1_1.addItem("Manha");
		comboBox_1_1_1.addItem("Tarde");
		comboBox_1_1_1.addItem("Noite");
		



		String[] vet = new String[100];
		try {

		    for (String item : vet) {
		        if (item != null) {
		            comboBox.addItem(item);
		        }
		    }
		} catch (Exception e1) {
		    e1.printStackTrace();
		}

		JButton btnInserirOrientacao = new JButton("Inserir Orientação");
		btnInserirOrientacao.setPreferredSize(new Dimension(140, 40));
		panelBotoes.add(btnInserirOrientacao);

		btnInserirOrientacao.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        TelaInserirOrientacao telaInserirOrientacao = new TelaInserirOrientacao();
		        telaInserirOrientacao.setVisible(true);
		    }
		});
		
		
		JPanel panelSubarea = new JPanel();
		panelSubarea.setBounds(46, 320 + 30, 500, 200);
		panelSubarea.setBackground(Color.WHITE);
		panelSubarea.setLayout(new BorderLayout()); 
		contentPane.add(panelSubarea);

		JLabel lblSubarea = new JLabel("");
		lblSubarea.setBounds(10, 10, 100, 20);
		panelSubarea.add(lblSubarea, BorderLayout.NORTH); 

		JTextArea textAreaResultados = new JTextArea();
		
		textAreaResultados.setLineWrap(true); 
		textAreaResultados.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textAreaResultados);
		panelSubarea.add(scrollPane, BorderLayout.CENTER);

		JComboBox comboBox3 = new JComboBox<>();
		comboBox3.setBounds(130, 270 + 50, 150, 20);
		comboBox3.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        comboBox3.removeAllItems();
		        String[] vet = new String[100];
		        try {
		            vet = CursosController.pesquisaDados();
		            for (int v = 0; v < vet.length; v++) {
		                if (vet[v] != null) {
		                    comboBox3.addItem(vet[v]);
		                }
		            }
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		contentPane.add(comboBox3);


		JLabel lblId = new JLabel("Filtrar por ID");
		lblId.setBounds(46, 270 + 50, 100, 17);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(lblra.getFont().deriveFont(Font.BOLD));
		contentPane.add(lblId);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(320, 270 + 50, 80, 20);
		contentPane.add(btnBuscar);

		btnBuscar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Object selectedItem = comboBox3.getSelectedItem();
		        
		        if (selectedItem != null) {
		            String selectedOption = selectedItem.toString();
		            
		            String[] partis = selectedOption.split(";");
		            String number = partis[1];
		            int parsedNumber = Integer.parseInt(number);
		            
		            lblId.setText("Filtrar por ID: " + String.valueOf(parsedNumber));
		            
		            String id = String.valueOf(parsedNumber);
		            
		            if (!id.isEmpty()) {
		                int hash = Math.abs(id.hashCode() % (Integer.parseInt(id) + 1));
		                String folderPath = System.getProperty("user.home") + File.separator + "BDAlunos";
		                File folder = new File(folderPath);
		                File file = new File(folder, "alunos.csv");
		                
		                try {
		                    BufferedReader reader = new BufferedReader(new FileReader(file));
		                    String line;
		                    StringBuilder data = new StringBuilder();
		                    
		                    while ((line = reader.readLine()) != null) {
		                        String[] parts = line.split(";");
		                        
		                        if (parts.length >= 4 && parts[3].equals(Integer.toString(hash))) {
		                            data.append("Nome ").append(parts[0]).append("\n");
		                            data.append("Ra: ").append(parts[1]).append("\n");
		                            data.append("Email: ").append(parts[2]).append("\n");
		                            data.append("Semestre: ").append(parts[4]).append("\n");
		                            data.append("Turma: ").append(parts[5]).append("\n");
		                            data.append("\n");
		                        }
		                    }
		                    
		                    textAreaResultados.setText(data.toString());
		                    reader.close();
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		            } 
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção.");
		        }
		    }
		});


		
		//----------------------------------------------------------------------------------------------------------------------------

		AlunoController alunoCTR = new AlunoController(textField, textField_1, textField_2,
				textField, comboBox, comboBox_2, comboBox_1_1, comboBox_1_1_1, btnGravar_1, btnGravar_1);

		btnGravar_1.addActionListener(alunoCTR);
		btnRegras_1_2.addActionListener(alunoCTR);
		btnRegras_1_2_1.addActionListener(alunoCTR);
		btnCursos.addActionListener(alunoCTR);
	}

}