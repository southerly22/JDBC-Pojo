package lzx;
/***
 * @Author: lzx
 * @Description: 反转链表
 * @Date: 2023/2/4
 **/
public class Solution1 {
    public ListNode ReverseList(ListNode head) {
        //判空操作
        if (head == null) return null;

        ListNode pre = null;
        ListNode next = null;

        while (head!=null) {
            next = head.next; //保留当前节点的下一个节点，防止断链
            head.next = pre; //头节点指向null，变尾节点
            pre = head; //pre往后移动
            head = next; //head节点往后移动
        }
        return pre;
    }
}
