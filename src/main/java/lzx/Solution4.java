package lzx;

/***
 * @Author: lzx
 * @Description: 合并两个有序链表
 * @Date: 2023/2/5
 **/
public class Solution4 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode cur = new ListNode(-1);
        ListNode res = cur;

        // 两条链表都不为空的
        if (list1!=null & list2!=null){
            if(list1.val > list2.val){
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }if (list1.val <= list2.val){
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        //如果l1还有剩余
        if (list1!=null) cur.next = list1;
        //如果l2还有剩余
        if (list2!=null) cur.next = list2;

        return res.next;
    }
}
