class SnakeGame {
    
    private static Map<String, int[]> DIRECTION = Map.of("U", new int[] { 0, -1 }, "D", new int[] { 0, 1 },
                                              "L", new int[] { -1, 0 }, "R", new int[] { 1, 0 });
    
    private int width;
    private int height;
    private int[][] food;
    
    private int posX;
    private int posY;
    
    private int foodIndex;
    private int score;
    private ArrayDeque<String> snakeBodyList;
    private HashSet<String> snakeBodySet;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodIndex = 0;
        score = 0;
        posX = 0;
        posY = 0;
        snakeBodyList = new ArrayDeque<>();
        snakeBodySet = new HashSet<>();
        
        String pos = encode(0, 0);
        snakeBodyList.add(pos);
        snakeBodySet.add(pos);
    }
    
    public int move(String direction) {
        int[] directionArray = DIRECTION.get(direction);
        int nextX = directionArray[1] + posX;
        int nextY = directionArray[0] + posY;
        
        if (!isValidMove(nextX, nextY)) {
            return -1;
        }
        String pos = encode(nextX, nextY);
        if (foodIndex < food.length && food[foodIndex][0] == nextX && food[foodIndex][1] == nextY) {
            score++;
            foodIndex++;
        }
        else {
            String lastPos = snakeBodyList.removeLast();
            snakeBodySet.remove(lastPos);
        }
        snakeBodyList.addFirst(pos);
        snakeBodySet.add(pos);
        
        posX = nextX;
        posY = nextY;
        
        return score;
    }

    
    private boolean isValidMove(int x, int y) {
        if (x < 0 || x >= height || y < 0 || y >= width) {
            return false;
        }
        String pos = encode(x, y);

        if (!snakeBodyList.peekLast().equals(pos) && snakeBodySet.contains(pos)) {
            return false;
        }
        
        return true;
    }
    
    private String encode(int x, int y) {
        return x + "," + y;
    }
    
    private int[] decode(String s) {
        String[] split = s.split(",");
        
        return new int[] { Integer.parseInt(split[0]), Integer.parseInt(split[1]) };
    }
}