class over_lap_circle_and_rectangle {
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestX = Math.max(x1, Math.min(x2, xCenter));
        int nearestY = Math.max(y1, Math.min(y2, yCenter));

        int distX = xCenter - nearestX;
        int distY = yCenter - nearestY;
        
        return distX * distX + distY * distY <= radius*radius;
    }

    public static void main(String[] args) {
        System.out.println(checkOverlap(1, 0, 0, 1, -1, 3, 1)); // true
    }
}