/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import ork.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;
/**
 *
 * @author vika
 */
public class GUI extends JFrame {
    private JTree armyTree;
    private DefaultTreeModel treeModel;
    private JPanel infoPanel;
    private Map<String, OrkBuilderFactory> tribeFactories;
    private Map<String, java.util.List<Ork>> tribeOrcs;

    public GUI() {
        super("Mordor Army Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        tribeFactories = new HashMap<>();
        tribeFactories.put("Mordor", new MordorOrkBuilderFactory());
        tribeFactories.put("Dol Guldur", new DolGuldurOrkBuilderFactory());
        tribeFactories.put("Misty Mountains", new MistyMountainsOrkBuilderFactory());

        tribeOrcs = new HashMap<>();
        for (String tribe : tribeFactories.keySet()) {
            tribeOrcs.put(tribe, new ArrayList<>());
        }

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Mordor Army");
        for (String tribe : tribeFactories.keySet()) {
            root.add(new DefaultMutableTreeNode(tribe));
        }
        treeModel = new DefaultTreeModel(root);
        armyTree = new JTree(treeModel);

        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Orc Information"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(armyTree),
            new JScrollPane(infoPanel));
        splitPane.setDividerLocation(300);

        JPanel controlPanel = new JPanel();
        JButton addOrcButton = new JButton("Add Orc");
        addOrcButton.addActionListener(e -> showAddOrcDialog());
        controlPanel.add(addOrcButton);

        setLayout(new BorderLayout());
        add(splitPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        armyTree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
            if (node == null){
                    return;
            }
            
            Object userObject = node.getUserObject();
            if (userObject instanceof Ork) {
                displayOrcInfo((Ork) userObject);
            } else {
                infoPanel.removeAll();
                infoPanel.revalidate();
                infoPanel.repaint();
            }
        });
    }

    public void showAddOrcDialog() {
        JDialog dialog = new JDialog(this, "Add New Orc", true);
        dialog.setLayout(new GridLayout(0, 2, 10, 10));
        dialog.setSize(400, 300);

        JTextField nameField = new JTextField();
        JComboBox<String> tribeCombo = new JComboBox<>(tribeFactories.keySet().toArray(new String[0]));
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Basic", "Leader", "Scout"});

        dialog.add(new JLabel("Name (optional):"));
        dialog.add(nameField);
        dialog.add(new JLabel("Tribe:"));
        dialog.add(tribeCombo);
        dialog.add(new JLabel("Type:"));
        dialog.add(typeCombo);

        JButton createButton = new JButton("Create");
        createButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                name = NameGenerator.generateOrcName();
            }
            
            String tribe = (String) tribeCombo.getSelectedItem();
            String type = (String) typeCombo.getSelectedItem();

            OrcDirector director = new OrcDirector(tribeFactories.get(tribe));
            Ork newOrc;
            if ("Leader".equals(type)) {
                newOrc = director.createLeaderOrk(name);
            } else if ("Scout".equals(type)) {
                newOrc = director.createScoutOrk(name);
            } else {
                newOrc = director.createBasicOrk(name);
            }

            tribeOrcs.get(tribe).add(newOrc);
            DefaultMutableTreeNode tribeNode = findTribeNode(tribe);
            if (tribeNode != null) {
                DefaultMutableTreeNode orcNode = new DefaultMutableTreeNode(newOrc);
                treeModel.insertNodeInto(orcNode, tribeNode, tribeNode.getChildCount());
            }

            dialog.dispose();
        });

        dialog.add(createButton);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public DefaultMutableTreeNode findTribeNode(String tribeName) {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);
            if (tribeName.equals(node.getUserObject())) {
                return node;
            }
        }
        return null;
    }

    public void displayOrcInfo(Ork orc) {
        infoPanel.removeAll();

        infoPanel.add(new JLabel("Name: " + orc.getName()));
        infoPanel.add(new JLabel("Weapon: " + orc.getWeapon()));
        infoPanel.add(new JLabel("Armor: " + orc.getArmor()));
        infoPanel.add(new JLabel("Banner: " + orc.getBanner()));

        addProgressBar("Strength", orc.getStrength(), 100);
        addProgressBar("Agility", orc.getAgility(), 100);
        addProgressBar("Intelligence", orc.getIntelligence(), 50);
        addProgressBar("Health", orc.getHealth(), 200);

        infoPanel.revalidate();
        infoPanel.repaint();
    }

    public void addProgressBar(String name, int value, int max) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(name + ": " + value), BorderLayout.WEST);
        
        JProgressBar bar = new JProgressBar(0, max);
        bar.setValue(value);
        bar.setStringPainted(true);
        panel.add(bar, BorderLayout.CENTER);
        
        infoPanel.add(panel);
    }
} 
