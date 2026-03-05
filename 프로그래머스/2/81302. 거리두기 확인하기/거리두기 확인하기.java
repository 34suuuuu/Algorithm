class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
       for(int i = 0; i < 5; i++){
            answer[i] = isValid(places[i]);
        }
        
        return answer;
    }
    
    public int isValid(String[] place){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                char cur = place[i].charAt(j);
                
                if(cur != 'P') continue;
                
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    
                    if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                    char next = place[nx].charAt(ny);
                    
                    if(next == 'P') return 0;
                    else if(next == 'X') continue;
                    else if(next == 'O'){
                        
                        for(int n = 0; n < 4; n++){
                            int nnx = nx + dx[n];
                            int nny = ny + dy[n];
                            if(nnx < 0 || nnx >= 5 || nny < 0 || nny >= 5) continue;
                            if(nnx == i && nny == j) continue;

                            char nnext = place[nnx].charAt(nny);
                            
                            if(nnext == 'P') return 0;
                            else continue;
                        }                        
                    }
                }
            }
        }
        return 1;
    }
}