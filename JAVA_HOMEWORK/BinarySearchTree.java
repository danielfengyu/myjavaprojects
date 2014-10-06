package nodeandTree;



public class BinarySearchTree {
	private BinarySearchTreeNode root;
	public  BinarySearchTree(BinarySearchTreeNode root) {
		// TODO Auto-generated constructor stub
		this.root =root;
	}
	BinarySearchTreeNode getRoot(){
		return root;
	}
	public BinarySearchTreeNode search(BinarySearchTreeNode root, int key){
		
		BinarySearchTreeNode current =root;
		while((root!=null)&&(key!=current .getValue()))
		{
			System.out.println("njjkk");
			current =(key <current.getValue()
					?search(current.leftChild, key ):search(current.rightChild, key ));
		}
		return current ;
	} 
	public void  insertNode(int value) {
		BinarySearchTreeNode p=root,prev=null;
		while(p!=null )
		{
			prev=p;
			if(p.getValue()<value )
			{
				p=p.rightChild;
			}
			else {
				p=p.leftChild ;
			}
			
		}
		if(root==null)
		{
			root=new BinarySearchTreeNode();
			root.ele=value ;
			
		}else if(prev .getValue()<value ){
			prev.rightChild =new BinarySearchTreeNode();
			prev.ele =value ;
		}
		else {
			prev.leftChild=new BinarySearchTreeNode();
			prev.ele=value;
		}
	}
	public void deleteNode(BinarySearchTreeNode node){
		BinarySearchTreeNode tmp=node;
		if(node!=null){
			if(node.rightChild==null){
				node=node.leftChild;
			}
			else if(node.leftChild !=null){
				node=node.rightChild ;
			}
			else{
				tmp=node.leftChild ;
				while(tmp.rightChild !=null)
					tmp=tmp.rightChild ;
				
					tmp.rightChild =node.rightChild ;
					tmp=node;
					node=node.leftChild ;
				
			}
		   tmp=null;
		}
	}
	public static void main(String[] args) {   
		BinarySearchTreeNode node=new BinarySearchTreeNode(12);
		
		BinarySearchTree tree=new BinarySearchTree(node);
		
		tree.insertNode(23);
		tree.insertNode(2);
		tree.insertNode(8);
		tree.insertNode(27);
		tree.insertNode(99);
		tree.insertNode(15);
		System.out.println("njjkk");
		BinarySearchTreeNode resultNode=tree.search(node, 27);
		System.out.println("结点元素的值是："+resultNode.ele);
		if(resultNode .leftChild !=null)
		{
			System .out .println("左孩子的值是："+resultNode.leftChild.ele);
		}
		else{
			System .out .println("没有左孩子结点！");
		}
		if(resultNode .rightChild !=null)
		{
			System .out .println("右孩子的值是："+resultNode.rightChild.ele);
		}
		else{
			System .out .println("没有右孩子结点！");
		}
	}
}


