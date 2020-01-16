import java.util.*;

class Solution {
    public LinkedList<Function> functions;
    public int[] solution(int[] progresses, int[] speeds) {
        functions = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        setFunctions(progresses, speeds);

        while(!functions.isEmpty()) {
            developFunctions();
            addIfDeployed(answer, deployFunctions());
        }
        
        return convertToArray(answer);
    }

    public void setFunctions(int[] progresses, int[] speeds) {
        for(int i=0 ; i<progresses.length ; i++) {
            functions.add(new Function(progresses[i], speeds[i]));
        }
    }

    public void addIfDeployed(ArrayList<Integer> list, int deployments) {
        if(deployments > 0) {
            list.add(deployments);
        }
    }

    public void developFunctions() {
        for(Function f : functions) {
            f.develop();
        }
    }

    public int deployFunctions() {
        int count = 0;
        
        while(canDeploy()) {
            functions.remove();
            count++;
        }

        return count;
    }

    public boolean canDeploy() {
        return !functions.isEmpty() && functions.peek().isCompleted();
    }

    public int[] convertToArray(ArrayList<Integer> list) {
        int[] answer = new int[list.size()];
        
        for(int i=0 ; i<answer.length ; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

class Function {
    private int progress;
    private int speed;

    public Function(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }

    public void develop() {
        this.progress += this.speed;
    }

    public boolean isCompleted() {
        return this.progress>=100 ? true : false;
    }
}