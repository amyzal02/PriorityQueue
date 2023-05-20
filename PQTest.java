public class PQTest{
    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue(10);

        pq.insert(new Interval(6, 8)); //2    
        pq.print();
     
        pq.insert(new Interval(0, 8)); // 8 
        pq.print();


        pq.insert(new Interval(4, 7)); // 3  
        pq.print();
      
        pq.insert(new Interval(0, 5));
        pq.print();


        pq.insert(new Interval(0, 9)); // 9 
        pq.print();

        pq.insert(new Interval(0, 14));
        pq.print();


        pq.insert(new Interval(0, 6));
        pq.print();

        pq.insert(new Interval(0, 13)); 
        pq.print();


        pq.insert(new Interval(10, 15)); //5
        pq.print();

        pq.insert(new Interval(0, 10));
        pq.print();
        

        //.out.println("After for loop. Printing pq: ");
        //pq.print();

        System.out.println("Calling remove max-----------------------------------------------------------");
        pq.remove_max();
       pq.print();


        System.out.println("Calling remove max--------------------------------------------------------");
        pq.remove_max();
        pq.print();

        System.out.println("inserting 1, 6");
        pq.insert(new Interval(1, 6));
        pq.print();


        System.out.println("Calling remove max--------------------------------------------------------");
        pq.remove_max();
        pq.print();

        System.out.println("inserting 0, 10");
        pq.insert(new Interval(0, 10));
        pq.print();

        System.out.println("Calling remove max--------------------------------------------------------");
        pq.remove_max();
        pq.print();

        System.out.println("inserting 0, 1");
        pq.insert(new Interval(0, 1));
        pq.print();

        System.out.println("Printing pq: ");
        pq.print();



    }
}