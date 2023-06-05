package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OrientacaoController implements ActionListener {

    private JComboBox<String> comboBox;
    private JTextArea textAreaDescricao;
    private JButton btnSalvar;
    public OrientacaoController( JComboBox<String> comboBox,
            JTextArea textAreaDescricao, JButton btnSalvar) {
        this.comboBox = comboBox;
        this.textAreaDescricao = textAreaDescricao;
        this.btnSalvar = btnSalvar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalvar) {
        	String tema = comboBox.getSelectedItem().toString();
        	String descricao = textAreaDescricao.getText();
        	salvarOrientacao(tema, descricao);

            textAreaDescricao.setText("");
        }
    }

    private void salvarOrientacao(String tema, String descricao) {
        String path = System.getProperty("user.home") + File.separator + "BDAlunos";
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, "orientacao.csv");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(tema +  ";" + descricao);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String recuperarUltimaDescricaoDoGrupo(String grupo) {
        String ultimaDescricao = null;
        String path = System.getProperty("user.home") + File.separator + "BDAlunos";
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, "orientacao.csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {


            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(","); 

                String descricao = fields[0];
                String grupoDaDescricao = fields[1];

                if (grupoDaDescricao.equals(grupo) && (ultimaDescricao == null || descricao.compareTo(ultimaDescricao) > 0)) {
                    ultimaDescricao = descricao;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ultimaDescricao;
    }


}
