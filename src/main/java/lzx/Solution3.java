package lzx;

/***
 * @Author: lzx
 * @Description: 反转链表
 * @Date: 2023/2/4
 **/
public class Solution3 {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 判空
        if (head == null || k==1 || head.next==null) return head;
        ListNode res = new ListNode(0); //头节点
        ListNode pre = res;
        ListNode cur = head;
        ListNode tmp = null;
        int lenth = 0;
        // 算出链表长度
        while (head != null){
            lenth+=1;
            head = head.next;
        }
        System.out.println("lenth = " + lenth);
        for (int i=0;i < lenth/k;i++){
            for (int j=1; j<k; j++){ //每k个数 只用反转k-1次即可
                tmp = cur.next; //当前节点下一个节点
                cur.next = tmp.next;//当前指向 当前节点的下下一个节点
                tmp.next = pre.next; // tmp.next = cur是不对的 例如：{1，2，3}，3
                pre.next = tmp;
            }
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }
}
