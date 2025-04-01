package Trees.Tries;

public class Trie {

    private TrieNode root;
    private int counter;
    boolean flag;

    public Trie() {
        root = new TrieNode();
        counter = 1;
        flag = true;
    }

    public TrieNode insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            curr = curr.addChild(word.charAt(i));
        }
        return curr.addChild('[');
    }

    public TrieNode search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            curr = curr.getChild(word.charAt(i));
            if (curr == null) {
                return null;
            }
        }
        return curr.getChild('[');
    }

    public void remove(String word, TrieNode curr, int pos) {
        if (pos == word.length()) {
            curr.removeLetter('[');
            return;
        }

        TrieNode nextNode = curr.getChild(word.charAt(pos));

        remove(word, nextNode, pos + 1);

        if (nextNode.getNumChildren() == 0 && nextNode.getChild('[') == null) {
            curr.removeLetter(word.charAt(pos));
        }
    }

    public boolean remove(String word) {
        if (search(word) == null)
            return false;
        remove(word, root, 0);
        return true;
    }

    public void printTrie(TrieNode curr, String prev) {

        if (curr.getChild('[') != null) {
            if (counter == 1) {
                System.out.println(prev + curr.getLetter());
                counter++;
            } else if (counter == 2) {
                System.out.print(prev + curr.getLetter());
                counter++;
            } else
                System.out.print("\n" + prev + curr.getLetter());
        }
        TrieNode[] children = curr.getChildren();
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                printTrie(children[i], prev + curr.getLetter());
            }
        }
    }

    public void printTrie() {
        System.out.println("Words in your Trie: ");
        printTrie(root, "");
    }
}