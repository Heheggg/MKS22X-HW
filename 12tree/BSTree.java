public class BSTree<T extends Comparable<T>>{
    
    private class TreeNode{
	private T data;
	private TreeNode left,right;
	private int counter;

	public TreeNode(){
	    this(null);
	}

	public TreeNode(T x){
	    data = x;
	}

	public T getData(){
	    return data;
	}

	public TreeNode getLeft(){
	    return left;
	}

	public TreeNode getRight(){
	    return right;
	}

	public void setRight(TreeNode x){
	    right = x;
	}

	public void setLeft(TreeNode x){
	    left = x;
	}

	public void setData(T x){
	    data = x;
	}
	
	public boolean hasRight(){
	    return right!=null;
	}

	public boolean hasLeft(){
	    return left!=null;
	}

	public boolean hasData(){
	    return data!=null;
	}

	public boolean hasChildren(){
	    return hasRight()||hasLeft();
	}

	public int height(){
	    int leftHeight = 1;
	    int rightHeight = 1;
	    if(hasRight()){
		rightHeight = getRight().height();
	    }
	    if(hasLeft()){
		leftHeight = getLeft().height();
	    }
	    return Math.max(leftHeight,rightHeight);
	}

	public void add(T x){
	    if(data==null){
		data = x;
	    }else{
		if(getData().compareTo(x) < 0){
		    if(hasRight()){
			getRight().add(x);
		    }else{
			setRight(new TreeNode(x));
		    }
		}else{
		    if(hasLeft()){
			getLeft().add(x);
		    }else{
			setLeft(new TreeNode(x));
		    }
		}
	    }
	}

	public String toString(){
	    if(hasLeft() && hasRight()){
		return getData() + " " + getLeft().toString() + " " + getRight().toString();
	    }else if(hasLeft()){
		return getData() + " " + getLeft().toString()+ " _";
	    }else if(hasRight()){
		return getData() + " _ " + getRight().toString();
	    }else{
		return getData()+" _ _";
	    }
	}

	public boolean contains(T x){
	    boolean a = false;
	    if(getData().compareTo(x) == 0){
	        return true;
	    }
	    if(getData().compareTo(x) < 0){
		if(hasRight()){
		    a = getRight().contains(x);
		}
	    }else{
		if(hasLeft()){
		    a = getLeft().contains(x);
		}
	    }
	    return a;	    
	}

	public boolean remove(T x, TreeNode root ){
	    if(getData()==null){
		return getLeft().remove(x,this);
	    }else if (getData().compareTo(x) > 0){
		if(hasLeft()){
		    return getLeft().remove(x,this);
		}else{
		    return false;
		}
	    }else if(getData().compareTo(x) < 0){
		if(hasRight()){
		    return getRight().remove(x,this);
		}else{
		    return false;
		}
	    }else{
		if(hasRight() && hasLeft()){
		    setData(getRight().getMin());
		    getRight().remove(getData(),this);
		}else if (root.getLeft() == this){
		    root.setLeft(hasLeft() ? getLeft():getRight());
		}else if(root.right == this){
		    root.setRight(hasRight() ? getLeft():getRight());
		}
		return true;
	    }
	}

	private T getMin(){
	    if(!hasLeft()){
		return getData();
	    }else{
		return getLeft().getMin();
	    }
	}
    }

    private TreeNode root;

    public BSTree(){
	this(null);
    }

    public BSTree(T x){
	root = new TreeNode(x);
    }

    public void add(T x){
	root.add(x);
    }

    public int getHieght(){
	return root.height();
    }

    public boolean contains(T x){
	return root.contains(x);
    }

    public String toString(){
	return root.toString();
    }

    public boolean remove(T x){
	if(!root.contains(x)|| root==null){
	    return false;
	}else{
	    if(root.getData().compareTo(x)==0){
		TreeNode temp = new TreeNode();
		temp.setLeft(root);
		root = temp;
		root.remove(x,root);
		root = root.getLeft();
		return true;
	    }else{
		return root.remove(x,null);
	    }
	}
	    
    }

}
