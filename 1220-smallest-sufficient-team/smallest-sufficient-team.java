class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;

        // Map each skill to an index
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }

        // Convert each person's skill list to a bitmask
        int[] personSkills = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int skillMask = 0;
            for (String skill : people.get(i)) {
                if (skillIndex.containsKey(skill)) {
                    skillMask |= (1 << skillIndex.get(skill));
                }
            }
            personSkills[i] = skillMask;
        }

        // DP to store minimum team for each skill set (bitmask)
        Map<Integer, List<Integer>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());  // No skills required = empty team

        for (int i = 0; i < personSkills.length; i++) {
            Map<Integer, List<Integer>> temp = new HashMap<>(dp);
            for (int mask : dp.keySet()) {
                int withPerson = mask | personSkills[i];
                if (!temp.containsKey(withPerson) || temp.get(withPerson).size() > dp.get(mask).size() + 1) {
                    List<Integer> newTeam = new ArrayList<>(dp.get(mask));
                    newTeam.add(i);
                    temp.put(withPerson, newTeam);
                }
            }
            dp = temp;
        }

        int fullMask = (1 << n) - 1;
        List<Integer> result = dp.get(fullMask);
        return result.stream().mapToInt(i -> i).toArray();
    }
}