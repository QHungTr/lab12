package trees;

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class FamilyTree {

    private static class TreeNode {
        private String name;
        private TreeNode parent;
        private ArrayList<TreeNode> children;

        TreeNode(String name) {
            this.name = name;
            children = new ArrayList<>();
        }

        String getName() {
            return name;
        }

        void addChild(TreeNode childNode) {
            children.add(childNode);
            childNode.parent = this;
        }

        // Searches subtree at this node for a node
        // with the given name. Returns the node, or null if not found.
        TreeNode getNodeWithName(String targetName) {
            if (this.name.equals(targetName)) {
                return this;
            }

            // Recursively search through the children
            for (TreeNode child : children) {
                TreeNode result = child.getNodeWithName(targetName);
                if (result != null) {
                    return result;
                }
            }

            // Return null if the node with the given name is not found
            return null;
        }
    }

    public static void main(String[] args) {
        // Sample tree creation
        TreeNode root = new TreeNode("Grandparent");
        TreeNode parent1 = new TreeNode("Parent1");
        TreeNode parent2 = new TreeNode("Parent2");
        TreeNode child1 = new TreeNode("Child1");
        TreeNode child2 = new TreeNode("Child2");

        root.addChild(parent1);
        root.addChild(parent2);
        parent1.addChild(child1);
        parent2.addChild(child2);

        // Search for a node by name
        TreeNode foundNode = root.getNodeWithName("Child1");
        if (foundNode != null) {
            System.out.println("Found node: " + foundNode.getName());
        } else {
            System.out.println("Node not found.");
        }
    }
}
