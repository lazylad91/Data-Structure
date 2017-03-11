/* Check whether two linked list intersect or not
1 We can find the difference in the length and we can move one pointer kth diff ahead that length - in this case
diff is 2, so we will move the pointer of longer list by 2 and also we will check both should have same tail.
Then we will move one by one both pointer and where they are equal we will return it
    1-2-3-4-5-6-7-8-9
            |
        10-11
2 Second method is to take 2 pointers and start it from both the list - p1 on l1 and p2 on l2, when either of them reaches the end
exchange the assignment. Assign p1 on l2 head and p2 on 11 head. Iterate them again, they will meet at intersection. As doing so the no
of nodes travel are equal. For ex l1 - 8 l2 - 10, Intersection is at 5 element of l2. so L2 has 2 extra nodes. and intersection is at 
3rd element of l1 and 5th of l2. On first iteration p1 will cover 8 nodes, p2 will cover 10. Then p2 will cover 3 nodes and p1 will cover 5
to reach intersection.
TOtal number of nodes covered by both - 13. So condition will be true.
*/

public class Intersection {
    public static void main(String[] args){
        
    }
}