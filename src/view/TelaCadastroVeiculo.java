package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.VeiculoDAO;
import exception.DuplicadoEx;
import exception.FormatoInvalidoEx;
import model.Carro;
import model.Veiculo;

public class TelaCadastroVeiculo extends JFrame {
	public TelaCadastroVeiculo() {
		setTitle("Cadastro de Veículo");
		setSize(400, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		JPanel painel = new JPanel(new GridBagLayout());
		painel.setBackground(new Color(28, 40, 51));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    JLabel titulo = new JLabel("Cadastro de Veículo");
	    titulo.setForeground(Color.WHITE);
	    titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
	    
	    JLabel lblModelo = criarLabel("Modelo:");
	    JTextField txtModelo = new JTextField(15);
	    JLabel lblPlaca = criarLabel("Placa:");
	    JTextField txtPlaca = new JTextField(15);
	    JLabel lblAno = criarLabel("Ano:");
	    JTextField txtAno = new JTextField(15);
	    
	    JButton btnSalvar = criarBotao("Salvar", new Color(42, 157, 143));
	    JButton btnCancelar = criarBotao("Cancelar", Color.RED);
	    btnSalvar.addActionListener(e -> {
	        String modelo = txtModelo.getText();
	        String placa = txtPlaca.getText();
	        String ano = txtAno.getText();
	        
	        try {
	            // Validação dos campos
	            if (modelo.isEmpty() || placa.isEmpty() || ano.isEmpty()) {
	                throw new FormatoInvalidoEx("Preencha todos os campos!");
	            }
	            
	            // Verifica se a placa já existe
	            VeiculoDAO veiculoDAO = new VeiculoDAO();
	            if (veiculoDAO.buscarVeiculoPorPlaca(placa) != null) {
	                throw new DuplicadoEx("Veículo com placa " + placa + " já cadastrado.");
	            }
	            
	            // Cria o veículo e salva no sistema
	            Veiculo veiculo = new Carro(placa, modelo, ano);
	            veiculoDAO.adicionarVeiculo(veiculo);
	            
	            // Exibe mensagem de sucesso
	            JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	            
	            // Limpa os campos
	            txtModelo.setText("");
	            txtPlaca.setText("");
	            txtAno.setText("");
	        } catch (FormatoInvalidoEx | DuplicadoEx ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Ano inválido. Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    });
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    painel.add(titulo, gbc);
	    
	    gbc.gridwidth = 1;
	    gbc.gridy = 1;
	    painel.add(lblModelo, gbc);
	    gbc.gridx = 1;
	    painel.add(txtModelo, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    painel.add(lblPlaca, gbc);
	    gbc.gridx = 1;
	    painel.add(txtPlaca, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    painel.add(lblAno, gbc);
	    gbc.gridx = 1;
	    painel.add(txtAno, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.gridwidth = 2;
	    painel.add(btnSalvar, gbc);
	    
	    gbc.gridy = 5;
	    painel.add(btnCancelar, gbc);
	    
	    add(painel);
	}
	
	private JLabel criarLabel(String texto) {
		JLabel label = new JLabel(texto);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("SansSerif", Font.BOLD, 14));
		return label;
    }
	
    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setBackground(cor);
        botao.setForeground(Color.BLACK);
        botao.setFont(new Font("SansSerif", Font.BOLD, 14));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setPreferredSize(new Dimension(200, 35));
        
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            botao.setBackground(cor.darker());
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            botao.setBackground(cor);
        }
    });
        
        return botao;
	}
    
}

