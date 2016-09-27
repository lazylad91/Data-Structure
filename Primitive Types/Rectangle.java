/* Rectangles whose sides are parallel to x axis and y axis. Find whether if two rectangles have a nonempty intersection or not */

class Rectangle {
    public static void main(String args[]){
        int x,y, height, width;
        
        public Rectangle(int x, int y, int height, int width){
            this.x=x;
            this.y=y;
            this.height=height;
            this.width=width;
        }
        
        public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2){
            if(isRectangleIntersect(r1, r2)){
                
            }
        }
        
        public static boolean isRectangleIntersect(Rectangle r1, Rectangle r2){
            return r1.x <= (r2.x+r2.width) && (r1.x+r1.width) >= r2.x                      // This indicate rectangle R1.x is in between r2 widht range
            && r1.y <= (r2.y + r2.height) && (r1.y + r1.height) >= r2.y;       
        }
            
    }
    
    
}