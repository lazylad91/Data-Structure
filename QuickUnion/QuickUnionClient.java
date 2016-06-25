class QuickUnionClient{
    public static void main(String args[]){
        QuickUnion qu = new QuickUnion(10);
        qu.makeUnion(3,4);
        qu.makeUnion(2,5);
        qu.makeUnion(2,8);
        qu.makeUnion(4,9);
        System.out.println(qu.findAConnection(3,4));
        System.out.println(qu.findAConnection(2,8));
        System.out.println(qu.findAConnection(3,9));
        System.out.println(qu.findAConnection(0,1));
        System.out.println(qu.findAConnection(2,4));
    }
}