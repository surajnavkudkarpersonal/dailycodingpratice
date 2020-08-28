/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Day3 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "X,";

        StringBuilder builder = new StringBuilder();
        builder.append(root.val);
        builder.append(",");
        builder.append(serialize(root.left));
        builder.append(serialize(root.right));

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue < String > nodes = new LinkedList < > ();
        nodes.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);

    }

    public TreeNode deserializeHelper(Queue < String > nodes) {
        String valueOfNode = nodes.poll();
        if (valueOfNode.equals("X"))
            return null;
        TreeNode newNode = new TreeNode(Integer.parseInt(valueOfNode));
        newNode.left = deserializeHelper(nodes);
        newNode.right = deserializeHelper(nodes);

        return newNode;

    }
}
