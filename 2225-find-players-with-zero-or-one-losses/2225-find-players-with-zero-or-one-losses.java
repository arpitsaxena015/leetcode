class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();  // player -> kitni baar haara

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            
            lossCount.putIfAbsent(winner, 0);
            
            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());  
        answer.add(new ArrayList<>());  

        for (Map.Entry<Integer, Integer> entry : lossCount.entrySet()) {
            int player = entry.getKey();
            int losses = entry.getValue();

            if (losses == 0) {
                answer.get(0).add(player);
            } else if (losses == 1) {
                answer.get(1).add(player);
            }
        }

        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));

        return answer;
    }












}