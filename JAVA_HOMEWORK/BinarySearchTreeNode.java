package nodeandTree;

public class BinarySearchTreeNode {

	public  BinarySearchTreeNode  leftChild;
	public  BinarySearchTreeNode rightChild;
	public  int  ele;
	public BinarySearchTreeNode (int ele){
		this.ele =ele ;
		
		
	}
	public BinarySearchTreeNode() {
		// TODO Auto-generated constructor stub
	}
    public BinarySearchTreeNode getLeftChild(){
    	
    	return this.leftChild ;
    }
    public BinarySearchTreeNode getRightChild(){
    	return this.rightChild;
    }
    public void setLeftChild(BinarySearchTreeNode leftChild){
    	this.leftChild =leftChild ;
    }
    public void setRightChild(BinarySearchTreeNode rightChild){
    	this.rightChild =rightChild ;
    	
    }
    public int getValue(){
    	return this.ele ;
    }
    public void setValue(char ele){
    	this.ele =ele ;
    }
   
	
}
