package view;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import controller.AlunoController;
import controller.CursosController;
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

import controller.OrientacaoController;

public class TelaInserirOrientacao extends JFrame {
	
	private static final long serialVersionUID = 6909508245638580811L;
    private JPanel contentPane;
    private JTextField txtSistemaDeOrientacao;
    private JTextField txtPropriedadeDaFatec_1;
    private JTextArea textAreaDescricao;
  
   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInserirOrientacao frame = new TelaInserirOrientacao();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	
//====================================================================================================================================
//============================================================ TELA BASE =============================================================
//====================================================================================================================================
public TelaInserirOrientacao() {
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
		


	        JLabel lblTemaDoTcc = new JLabel("Tema do TCC:");
	        lblTemaDoTcc.setForeground(Color.WHITE);
	        lblTemaDoTcc.setFont(new Font("Tahoma", Font.BOLD, 12));
	        lblTemaDoTcc.setBounds(46, 176 + 50, 100, 14);
	        contentPane.add(lblTemaDoTcc);


	
	        
	        JComboBox<String> comboBox = new JComboBox<String>();
	        comboBox.setBounds(156, 173 + 50, 347, 20);
	        comboBox.addFocusListener(new FocusAdapter() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                comboBox.removeAllItems();
	                String[] vet = new String[100];
	                try {
	                    vet = CursosController.pesquisaDados();
	                    for (int v = 0; v < 100; v++) {
	                        if (vet[v] != null) {
	                            comboBox.addItem(vet[v]);
	                        }
	                    }
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	            }
	        });
	        contentPane.add(comboBox);

	        JLabel lblOrientacao = new JLabel("Orientação:");
	        lblOrientacao.setForeground(Color.WHITE);
	        lblOrientacao.setFont(new Font("Tahoma", Font.BOLD, 12));
	        lblOrientacao.setBounds(46, 207 + 50, 86, 14);
	        contentPane.add(lblOrientacao);

	        textAreaDescricao = new JTextArea();
	        JScrollPane scrollPane = new JScrollPane(textAreaDescricao);
	        scrollPane.setBounds(46, 230 + 50, 457, 100);
	        contentPane.add(scrollPane);

	        JButton btnSalvar = new JButton("Salvar");
	        btnSalvar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String descricao = textAreaDescricao.getText();
	                JOptionPane.showMessageDialog(TelaInserirOrientacao.this, "Orientação salva com sucesso!");
	                textAreaDescricao.setText("");
	            }
	        });
	        btnSalvar.setBounds(46, 356 + 50, 89, 23);
	        contentPane.add(btnSalvar);
	        btnSalvar.addActionListener(new OrientacaoController(comboBox, textAreaDescricao, btnSalvar));


	        JButton btnFechar = new JButton("Fechar Janela");
			btnFechar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnFechar.setBounds(125,500, 134, 32);
			contentPane.add(btnFechar);
		JButton btnRegras_1_2 = new JButton("");
		btnRegras_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		JButton btnVisualizarUltimaDescricao = new JButton("Visualizar Última Descrição");
		btnVisualizarUltimaDescricao.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		            JOptionPane.showMessageDialog(TelaInserirOrientacao.this, "Programador preguiçoso.");
		        }

		});
		btnVisualizarUltimaDescricao.setBounds(160, 356 + 50, 200, 23);
		contentPane.add(btnVisualizarUltimaDescricao);}

		




}
	