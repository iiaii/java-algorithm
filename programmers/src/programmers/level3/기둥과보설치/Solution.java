package programmers.level3.기둥과보설치;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        PriorityQueue<Building> buildings = new PriorityQueue<>((a,b) -> {
            if(a.getX() == b.getX()) {
                if(a.getY() == b.getY()) {
                    return a.getType()-b.getType();
                }
                return a.getY()-b.getY();
            }
            return a.getX()-b.getX();
        });
        boolean[][] type0 = new boolean[n+1][n];
        boolean[][] type1 = new boolean[n][n+1];

        for (int[] frame : build_frame) {
            if(frame[3] == 1) {
                if(frame[2] == 0) {
                    if(frame[1] == 0 || type0[frame[0]][frame[1]-1] || type1[frame[0]-1][frame[1]]) {
                        type0[frame[0]][frame[1]] = true;
                        buildings.add(new Building(frame[0], frame[1], frame[2]));
                    }
                } else {
                    if(type0[frame[0]][frame[1]-1] || type0[frame[0]+1][frame[1]-1] || (type1[frame[0]-1][frame[1]] && type1[frame[0]+1][frame[1]])) {
                        type1[frame[0]][frame[1]] = true;
                        buildings.add(new Building(frame[0], frame[1], frame[2]));
                    }
                }
            } else {
                Building building = getBuilding(buildings, frame[0], frame[1], frame[2]);
                if(building.getType() == 0) {
                    if(type0[building.getX()][building.getY()+1]) {
                        continue;
                    }
                    if(type1[building.getX()][building.getY()+1]) {
                        if(!type0[building.getX()+1][building.getY()] && !(type1[building.getX()-1][building.getY()+1] && type1[building.getX()+1][building.getY()+1])) {
                            continue;
                        }
                    }
                    if(type1[building.getX()-1][building.getY()+1]) {
                        if(!type0[building.getX()-1][building.getY()] && !(type1[building.getX()-2][building.getY()+1] && type1[building.getX()][building.getY()+1])) {
                            continue;
                        }
                    }
                    type0[building.getX()][building.getY()] = false;
                } else {
                    if(type0[building.getX()+1][building.getY()+1]) {
                        continue;
                    }
                    if(type1[building.getX()+1][building.getY()]) {
                        if(!type0[building.getX()+1][building.getY()-1] && !type0[building.getX()+2][building.getY()-1]) {
                            continue;
                        }
                    }
                    if(type1[building.getX()-1][building.getY()]) {
                        if(!type0[building.getX()][building.getY()-1] && !type0[building.getX()-1][building.getY()-1]) {
                            continue;
                        }
                    }
                    type1[building.getX()][building.getY()] = false;
                }
                buildings.remove(building);
            }
        }
        int[][] result = new int[buildings.size()][3];
        int index = 0;
        while(!buildings.isEmpty()) {
            Building building = buildings.poll();
            result[index][0] = building.getX();
            result[index][1] = building.getY();
            result[index++][2] = building.getType();
        }
        return result;
    }

    public Building getBuilding(PriorityQueue<Building> buildings, int x, int y, int type) {
        for (Building building : buildings) {
            if(building.getX() == x && building.getY() == y && building.getType() == type) {
                return building;
            }
        }
        return null;
    }
}

class Building {
    private int x;
    private int y;
    private int type;

    public Building(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }
}

