import java.util.LinkedList;

public class HashTable {
    private class Node{
        private int key;
        private String value;
        public Node(int key,String value){
            this.key = key;
            this.value = value;
        }
    };

    private LinkedList<Node>[] nodes = new LinkedList[5];

    public void put(int key,String value){
        int index = hash(key);

        if(nodes[index] == null) nodes[index] = new LinkedList<>();

        for(var node: nodes[index]){
            if(key == node.key){
                node.value = value;
                return;
            }
        }

        nodes[index].addLast(new Node(key,value));
    }

    public String get(int key){
        int index = hash(key);

        if(nodes[index] != null){
            for(var node: nodes[index]){
                if(node.key == key)
                    return node.value;
            }
        }

        return null;
    }

    public void remove(int key){
        int index = hash(key);

        if(nodes[index] != null){
            for(var node: nodes[index]){
                if(node.key == key) {
                    nodes[index].remove(node);
                    return;
                }
            }
        }

        System.out.println("Invalid Operation, No such element");
    }
    private int hash(int key){
        return key % nodes.length;
    }

    public void print(){
        for(int i=0; i<nodes.length; i++) {
            if(nodes[i] == null)
                continue;
            for (var node : nodes[i])
                System.out.println("Key = " + node.key + " Value = " + node.value);
        }
    }
}
