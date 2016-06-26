class QuickUnionWeighted {
    
    public int[] data;
    public int[] sz;
    
    QuickUnionWeighted(int n){
        data = new int[n];
        sz = new int[n];
         for(int i=0; i<n; i++){
            sz[i]=1;
        }
        for(int i=0; i<n; i++){
            data[i]=i;
        }
    }  
    
    public Boolean findAConnection(int p,int q){
        int r1 = findRoot(p);
        int r2 = findRoot(q);
        if(r1==r2)
        return true;
        return false;
    }
    
    public int findRoot(int x){
        while(true){
            if(x==data[x])
            return x;
            else
            x=data[x];
        }
    }
    
    public Boolean makeUnion(int p,int q){
        int x= findRoot(p);
        int y= findRoot(q);
        if(sz[x]>sz[y]){
           data[q]=x;
           sz[x]=sz[x]+sz[y];
        }
        else{
           data[p]=y; 
           sz[y]=sz[x]+sz[y];
        }
        return true;
    }
    
    public void printArray(){
        System.out.println("Current status of nodes");
        for(int i=0;i<data.length;i++){
            System.out.println("  "+ i+" is connected to "+data[i]);
        }
    }
    
}