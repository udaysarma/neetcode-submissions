class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        if (triplets.length == 0) return false;

        int numberOfCandidatesForFirstColumn = 0;
        for (int i = 0; i < triplets.length; i++) 
            if (triplets[i][0] == target[0]) 
                numberOfCandidatesForFirstColumn += 1;
        
        int[][] candidatesForFirstColumn = new int[numberOfCandidatesForFirstColumn][3];
        int firstColumnCandidatesTracker = 0;
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] == target[0]) {
                candidatesForFirstColumn[firstColumnCandidatesTracker] = triplets[i];
                firstColumnCandidatesTracker += 1;
            }
        }
    
        int numberOfCandidatesForSecondColumn = 0;
        for (int i = 0; i < triplets.length; i++) 
            if (triplets[i][1] == target[1]) 
                numberOfCandidatesForSecondColumn += 1;
        
        int[][] candidatesForSecondColumn = new int[numberOfCandidatesForSecondColumn][3];
        int secondColumnCandidatesTracker = 0;
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][1] == target[1]) {
                candidatesForSecondColumn[secondColumnCandidatesTracker] = triplets[i];
                secondColumnCandidatesTracker += 1;
            }
        }
   
        int numberOfCandidatesForThirdColumn = 0;
        for (int i = 0; i < triplets.length; i++) 
            if (triplets[i][2] == target[2]) 
                numberOfCandidatesForThirdColumn += 1;
        
        int[][] candidatesForThirdColumn = new int[numberOfCandidatesForThirdColumn][3];
        int thirdColumnCandidatesTracker = 0;
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][2] == target[2]) {
                candidatesForThirdColumn[thirdColumnCandidatesTracker] = triplets[i];
                thirdColumnCandidatesTracker += 1;
            }
        }
   
        for (int i = 0; i < numberOfCandidatesForFirstColumn; i++) {
            for (int j = 0; j < numberOfCandidatesForSecondColumn; j++) {
                for (int k = 0; k < numberOfCandidatesForThirdColumn; k++) {
                    if (mergeABCAndCheck(
                        candidatesForFirstColumn[i],
                        candidatesForSecondColumn[j],
                        candidatesForThirdColumn[k],
                        target
                    )) return true;
                }
            }
        }

        return false;
    }

    private int[] mergeTriplets(int[] t1, int[] t2) {
        return new int[] {Math.max(t1[0], t2[0]), Math.max(t1[1], t2[1]), Math.max(t1[2], t2[2])};
    }

    private boolean mergeTripletsAndCheck(int[] t1, int[] t2, int[] target) {
        int[] merged =
            new int[] {Math.max(t1[0], t2[0]), Math.max(t1[1], t2[1]), Math.max(t1[2], t2[2])};
        return Arrays.equals(merged, target);
    }

    private boolean mergeABCAndCheck(int[] a, int[] b, int[] c, int[] target) {
        if (mergeTripletsAndCheck(a, b, target)) {
            return true;
        }

        if (mergeTripletsAndCheck(b, c, target)) {
            return true;
        }

        if (mergeTripletsAndCheck(c, a, target)) {
            return true;
        }

        if (mergeTripletsAndCheck(mergeTriplets(a, b), c, target)) {
            return true;
        }

        return false;
    }
}
