class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        java.util.Arrays.sort(boxTypes, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);
            }
        });
        int count = 0;
        for(int i=0; i<boxTypes.length; i++){
            if(truckSize<=0){
                break;
            }
            if(truckSize >= boxTypes[i][0]){
                count+=boxTypes[i][0]*boxTypes[i][1];
                truckSize=truckSize-boxTypes[i][0];
            }else{
                if(truckSize>0){
                    count+=truckSize*boxTypes[i][1];
                    truckSize=0;
                }
            }
        }
        return count;
    }
}