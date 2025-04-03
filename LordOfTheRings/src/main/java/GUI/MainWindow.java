package GUI;

import Orcs.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.Map;

public class MainWindow extends JFrame {
    private final DefaultMutableTreeNode rootNode;
    private final DefaultTreeModel treeModel;
    private final JTree armyTree;
    private final JPanel infoPanel;
    private final JComboBox<Ork.Tribe> tribeComboBox;
    private final JComboBox<String> roleComboBox;
    
    public MainWindow() {
        setTitle("Армия Мордора");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        
        // Создаем дерево армии
        rootNode = new DefaultMutableTreeNode("Армия Мордора");
        treeModel = new DefaultTreeModel(rootNode);
        armyTree = new JTree(treeModel);
        
        // Создаем панель управления
        JPanel controlPanel = new JPanel();
        tribeComboBox = new JComboBox<>(Ork.Tribe.values());
        String[] roles = {"Базовый", "Командир", "Разведчик"};
        roleComboBox = new JComboBox<>(roles);
        JButton createButton = new JButton("Создать орка");
        
        controlPanel.add(new JLabel("Племя:"));
        controlPanel.add(tribeComboBox);
        controlPanel.add(new JLabel("Роль:"));
        controlPanel.add(roleComboBox);
        controlPanel.add(createButton);
        
        // Создаем информационную панель
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Информация об орке"));
        
        // Добавляем компоненты на форму
        add(new JScrollPane(armyTree), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.EAST);
        
        // Обработчики событий
        createButton.addActionListener(e -> createOrk());
        armyTree.addTreeSelectionListener(e -> showOrkInfo());
        
        // Инициализируем узлы племен
        for (Ork.Tribe tribe : Ork.Tribe.values()) {
            rootNode.add(new DefaultMutableTreeNode(tribe.toString()));
        }
        treeModel.reload();
    }
    
    private void createOrk() {
        Ork.Tribe selectedTribe = (Ork.Tribe) tribeComboBox.getSelectedItem();
        String selectedRole = (String) roleComboBox.getSelectedItem();
        
        OrkBuilderFactory builderFactory = switch (selectedTribe) {
            case MORDOR -> new MordorOrkBuilderFactory();
            case DOL_GULDUR -> new DolGuldurOrkBuilderFactory();
            case MISTY_MOUNTAINS -> new MistyMountainsOrkBuilderFactory();
        };
        
        OrcDirector director = new OrcDirector(builderFactory);
        Ork newOrk = switch (selectedRole) {
            case "Командир" -> director.createLeaderOrk();
            case "Разведчик" -> director.createScoutOrk();
            default -> director.createBasicOrk();
        };
        
        // Добавляем орка в дерево
        for (int i = 0; i < rootNode.getChildCount(); i++) {
            DefaultMutableTreeNode tribeNode = (DefaultMutableTreeNode) rootNode.getChildAt(i);
            if (tribeNode.getUserObject().toString().equals(selectedTribe.toString())) {
                tribeNode.add(new DefaultMutableTreeNode(newOrk));
                treeModel.reload(tribeNode);
                break;
            }
        }
    }
    
    private void showOrkInfo() {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
            armyTree.getLastSelectedPathComponent();
            
        infoPanel.removeAll();
        
        if (node != null && node.getUserObject() instanceof Ork ork) {
            // Добавляем информацию об орке
            infoPanel.add(new JLabel("Имя: " + ork.getName()));
            infoPanel.add(new JLabel("Племя: " + ork.getTribe()));
            infoPanel.add(new JLabel("Оружие: " + ork.getWeapon()));
            infoPanel.add(new JLabel("Броня: " + ork.getArmor()));
            infoPanel.add(new JLabel("Знамя: " + ork.getBanner()));
            
            // Добавляем прогресс-бары для характеристик
            Map<String, Integer> attributes = ork.getAttributes();
            for (Map.Entry<String, Integer> entry : attributes.entrySet()) {
                JPanel attributePanel = new JPanel(new BorderLayout());
                attributePanel.add(new JLabel(entry.getKey() + ": "), BorderLayout.WEST);
                
                JProgressBar progressBar = new JProgressBar(0, 100);
                progressBar.setValue(entry.getValue());
                progressBar.setStringPainted(true);
                attributePanel.add(progressBar, BorderLayout.CENTER);
                
                infoPanel.add(attributePanel);
            }
        }
        
        infoPanel.revalidate();
        infoPanel.repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
} 