class Vector2D {
    private int[][] v;
    private int i, j;

    public Vector2D(int[][] v) {
        this.v = v;
        i = j = 0;
        update();
    }

    public int next() {
        update();
        return v[i][j++];
    }

    public boolean hasNext() {
        update();
        return i != v.length;
    }

    private void update() {
        while (i < v.length && j == v[i].length) {
            i++;
            j = 0;
        }
    }
}