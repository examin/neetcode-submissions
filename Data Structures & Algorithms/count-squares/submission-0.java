class CountSquares {
Map<Integer, Map<Integer, Integer>> points;
    public CountSquares() {
         points = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];

        points.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = points.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];

        if (!points.containsKey(x))
            return 0;

        int result = 0;

        Map<Integer, Integer> yMap = points.get(x);

        for (int ny : yMap.keySet()) {

            if (ny == y)
                continue;

            int countVertical = yMap.get(ny);
            int d = ny - y;

            Map<Integer, Integer> right = points.getOrDefault(x + d, new HashMap<>());
            Map<Integer, Integer> left  = points.getOrDefault(x - d, new HashMap<>());

            result += countVertical * (
                right.getOrDefault(y, 0) * right.getOrDefault(ny, 0) +
                left.getOrDefault(y, 0)  * left.getOrDefault(ny, 0)
            );
        }
        return result;
    }
}
