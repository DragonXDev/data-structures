package Trees.Tries;

public class TrieNode {

    private char data;
    private TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[27];
    }

    public TrieNode(char letter) {
        data = letter;
        children = new TrieNode[27];
    }

    public char getLetter() {
        return data;
    }

    public TrieNode getChild(char letter) {
        for (int i = 0; i < children.length; i++) {
            if (children[i] == null) {
                continue;
            }
            if (children[i].getLetter() == letter) {
                return children[i];
            }
        }
        return null;
    }

    public TrieNode addChild(char letter) {
        TrieNode child = getChild(letter);
        if (child != null) {
            return child;
        }

        children[letter - 'A'] = new TrieNode(letter);
        return children[letter - 'A'];
    }

    public void removeLetter(char letter) {
        for (int i = 0; i < children.length; i++) {
            if (children[i] == null) {
                continue;
            }
            if (children[i].getLetter() == letter) {
                children[i] = null;
                return;
            }
        }
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public int getNumChildren() {
        int count = 0;
        if (children != null) {
            for (TrieNode t : children) {
                if (t != null) {
                    count++;
                }
            }
        }
        return count;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }
}