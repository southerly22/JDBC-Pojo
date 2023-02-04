package lzx;

public class Node {
    private int data; //数据
    private Node next; //下一个地址的引用

    //构造方法
    public Node(int data){
        this.data = data;
    }

    // 获取下一个节点的方法
    public Node next(){
        return this.next;
    }
    //获取节点中的数据
    public int getData(){
        return this.data;
    }

    //追加节点
    public Node append(Node node){
        //1.获得当前节点
        Node currentNode = this;
        while (true){
            Node nextNode = currentNode.next;
            if (nextNode == null){ //最后一个节点
                break;
            }
            currentNode = nextNode;
        }
        currentNode.next = node;
        return this;
    }
}
