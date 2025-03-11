import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int m = n / 2;

        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(n, m, 0, new ArrayList<>(), combinations);
        
        long bestWin = -1;
        List<Integer> bestCombination = null;

        for (List<Integer> comb : combinations) {
            long winCount = computeWinCount(dice, comb);
            if (winCount > bestWin) {
                bestWin = winCount;
                bestCombination = comb;
            }
        }

        int[] answer = new int[bestCombination.size()];
        for (int i = 0; i < bestCombination.size(); i++) {
            answer[i] = bestCombination.get(i) + 1;
        }
        Arrays.sort(answer);
        return answer;
    }
    
    private void generateCombinations(int n, int m, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == m) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < n; i++) {
            current.add(i);
            generateCombinations(n, m, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    private long computeWinCount(int[][] dice, List<Integer> indicesA) {
        int n = dice.length;
        Set<Integer> setA = new HashSet<>(indicesA);
        List<Integer> indicesB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!setA.contains(i)) indicesB.add(i);
            
        }

        Map<Integer, Long> distA = getDistribution(dice, indicesA);
        Map<Integer, Long> distB = getDistribution(dice, indicesB);
        
        long win = 0;
        // 모든 (s_A, s_B) 쌍에 대해 s_A > s_B인 경우의 수를 누적
        for (Map.Entry<Integer, Long> entryA : distA.entrySet()) {
            int sumA = entryA.getKey();
            long countA = entryA.getValue();
            for (Map.Entry<Integer, Long> entryB : distB.entrySet()) {
                int sumB = entryB.getKey();
                if (sumA > sumB) {
                    win += countA * entryB.getValue();
                }
            }
        }
        return win;
    }
    
    private Map<Integer, Long> getDistribution(int[][] dice, List<Integer> indices) {
        Map<Integer, Long> distribution = new HashMap<>();
        distribution.put(0, 1L);

        for (int idx : indices) {
            Map<Integer, Long> newDist = new HashMap<>();
            int[] faces = dice[idx];

            for (int face : faces) {
                for (Map.Entry<Integer, Long> entry : distribution.entrySet()) {
                    int newSum = entry.getKey() + face;
                    newDist.put(newSum, newDist.getOrDefault(newSum, 0L) + entry.getValue());
                }
            }

            distribution = newDist;
        }

        return distribution;
    }
}
