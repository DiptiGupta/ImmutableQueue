final class ImmutableQueue<T> implements Queue<T>{
    
    private final Node<T> front;
    private final Node<T> end;
    
    public ImmutableQueue(){
        this.front = null;
        this.end = null;
    }
    
    private ImmutableQueue(Node<T> f, Node<T> e){
        front = f;
        end = e;
    }
    
    /* public void traverse(){
        Node<T> temp = front;
        while(temp!=null){
            System.out.println(this.front.data);
        temp = temp.next;
        }
    }
    */
    public Queue<T> enQueue(T t){
        
        Node n = new Node(t);
        
        if(this.end == null)
            return new ImmutableQueue(n,n);
        
        this.end.next = n;
        
        
        return new ImmutableQueue(this.front,n);
        
        
    }
     public Queue<T> deQueue() {
         if(front == null)
            return this;
        
         
         if(front.next == null)
            return new ImmutableQueue(null,null);
            
        return new ImmutableQueue(front.next,end);
        
     }
    
    public T head(){
        return this.front.data;
    }
    public boolean isEmpty(){
        if(this.front == null)
            return true;
        return false;
    }
    
}
