class CountSquares {
    Set<List<Integer>> points = new HashSet<>();
    Map<List<Integer>, Integer> pointOccrCountMap = new HashMap<>();

    public CountSquares() {
    }

    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);

        points.add(p);
        pointOccrCountMap.put(
            p,
            pointOccrCountMap.getOrDefault(p, 0) + 1
        );
    }

    public int count(int[] query) {
        int result = 0;

        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);

            // Only consider points vertically aligned with query.
            if (x != query[0] || y == query[1]) {
                continue;
            }

            int d = Math.abs(y - query[1]);
            int pointCount = pointOccrCountMap.get(point);

            // Square to the right
            int right =
                pointCount
                * pointOccrCountMap.getOrDefault(
                    Arrays.asList(query[0] + d, query[1]), 0)
                * pointOccrCountMap.getOrDefault(
                    Arrays.asList(x + d, y), 0);

            // Square to the left
            int left =
                pointCount
                * pointOccrCountMap.getOrDefault(
                    Arrays.asList(query[0] - d, query[1]), 0)
                * pointOccrCountMap.getOrDefault(
                    Arrays.asList(x - d, y), 0);

            result += left + right;
        }

        return result;
    }
}