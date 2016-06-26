class QuickUnionClient{
    public static void main(String args[]){
        QuickUnion qu = new QuickUnion(10);
        qu.makeUnion(3,4);
        qu.printArray();
        qu.makeUnion(2,5);
        qu.printArray();
        qu.makeUnion(2,8);
        qu.printArray();
        qu.makeUnion(4,9);
        qu.printArray();
        System.out.println(qu.findAConnection(3,4));
        System.out.println(qu.findAConnection(2,8));
        System.out.println(qu.findAConnection(3,9));
        System.out.println(qu.findAConnection(0,1));
        System.out.println(qu.findAConnection(2,4));
        
        QuickUnionWeighted quw = new QuickUnionWeighted(10);
        quw.makeUnion(3,4);
        quw.printArray();
        quw.makeUnion(2,5);
        quw.printArray();
        quw.makeUnion(2,8);
        quw.printArray();
        quw.makeUnion(4,9);
        quw.printArray();
        System.out.println(quw.findAConnection(3,4));
        System.out.println(quw.findAConnection(2,8));
        System.out.println(quw.findAConnection(3,9));
        System.out.println(quw.findAConnection(0,1));
        System.out.println(quw.findAConnection(2,4));
    }
}