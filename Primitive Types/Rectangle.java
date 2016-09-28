/* Rectangles whose sides are parallel to x axis and y axis. Find whether if two rectangles have a nonempty intersection or not */

class Rectangle {
    int x,y, height, width;
    
    public static void main(String args[]){
        Rectangle r1 = new Rectangle(1,1,2,2);
        Rectangle r2 = new Rectangle(2,0,3,2);
        System.out.println("Sending two Rectangles for Check :");
        Rectangle r3 = intersectRectangle(r1,r2);
        System.out.println(" " + r3.x + " " + r3.y +" " + r3.width + " " + r3.height);
    }
        public Rectangle(int x, int y, int height, int width){
            this.x=x;
            this.y=y;
            this.height=height;
            this.width=width;
        }
        
        public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2){
            if(isRectangleIntersect(r1, r2)){
                System.out.println("Yes the two rectangles intersect");
                return new Rectangle(Math.max(r1.x,r2.x),Math.max(r1.y,r2.y),Math.min(r1.x+r1.width,r2.x+r2.width)-Math.max(r1.x,r2.x),Math.min(r1.y+r1.height,r2.y+r2.height)-Math.max(r1.y,r2.y));
            }
            else
            return new Rectangle(0,0,-1,-1);
        }
        
        public static boolean isRectangleIntersect(Rectangle r1, Rectangle r2){
            return r1.x <= (r2.x+r2.width) && (r1.x+r1.width) >= r2.x                      // This indicate rectangle R1.x is in between r2 widht range
            && r1.y <= (r2.y + r2.height) && (r1.y + r1.height) >= r2.y;       
        }
            
    
    
    
}