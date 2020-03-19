package programmers.level2.스킬트리;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        for(String skill_tree : skill_trees) {
            count = skill.startsWith(retainSkill(skill_tree, skill)) ? count+1 : count;
        }

        return count;
    }

    public String retainSkill(String skill_tree, String skill) {
        return skill_tree.replaceAll("[^"+skill+"]", "");
    }
}