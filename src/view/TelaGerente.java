package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaGerente extends JFrame {
    public TelaGerente() {
        setTitle("Painel do Gerente");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(28, 40, 51));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel titulo = new JLabel("Painel do Gerente");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        JButton btnCadastroCliente = criarBotao("Cadastrar Cliente", new Color(42, 157, 143));
        JButton btnCadastroVeiculo = criarBotao("Cadastrar Veículo", new Color(42, 157, 143));
        btnCadastroCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new TelaCadastroCliente().setVisible(true);
            }
        });
        btnCadastroVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroVeiculo().setVisible(true);
            }
        });
       
    
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painel.add(titulo, gbc);
        gbc.gridy = 1;
        painel.add(btnCadastroCliente, gbc);
        gbc.gridy = 2;
        painel.add(btnCadastroVeiculo, gbc);
        add(painel);
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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaGerente().setVisible(true);
        });
    }
}

