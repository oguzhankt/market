package oguzhankt;

import java.util.ArrayList;

public class KategoriTree {
    private String kategoriAdi;
    private int idCounter = 0;

    public int getIdCounter() {
        return idCounter;
    }

    public ArrayList<String> getNodeNames(){
        ArrayList<String > nodeNames = new ArrayList<>();
        Node root = this.find(0);

        while(root!=null){

            while(root!=null){
                nodeNames.add(root.getKtgr().getName());
                root = root.left;
            }
            root = root.right;
        }

        return nodeNames;
    }

    public static  Node root;

    public KategoriTree(String kategoriAdi){
        this.root = null;
        this.kategoriAdi = kategoriAdi;
    }

    public Node find(int id){

        Node current = root;
        while(current!=null){
            if(current.getKtgr().getId()==id){
                return current;
            }else if(current.getKtgr().getId()>id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        current = null;
        return current;

    }

    public boolean delete(int id){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while(current.getKtgr().getId()!=id){
            parent = current;
            if(current.getKtgr().getId()>id){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){

            //now we have found the minimum element in the right sub tree
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode){
        Node successsor =null;
        Node successsorParent =null;
        Node current = deleleNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!=deleleNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    public void insert(Kategori k){

        k.setId(idCounter);
        idCounter++;

        Node newNode = new Node(k);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(k.getId()<current.getKtgr().getId()){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void display(Node root){

        if(root!=null){
            display(root.left);
            System.out.println("Ürün Türü :" + root.getKtgr().getName());
            System.out.println(" " + root.getKtgr().toString());
            display(root.right);
        }

    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }
}

    class Node{
    private Kategori ktgr;
    Node left;
    Node right;

        public Kategori getKtgr() {
            return ktgr;
        }

        public void setKtgr(Kategori ktgr) {
            this.ktgr = ktgr;
        }

        public Node(Kategori k){

        this.ktgr = k;
        left = null;
        right = null;

    }


}

