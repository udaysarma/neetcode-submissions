class Solution {
    /**
     * @param {number[]} gas
     * @param {number[]} cost
     * @return {number}
     */
    canCompleteCircuit(gas: number[], cost: number[]): number {
        const totalStations = gas.length;

        const getNextGasStation = (index: number): number => {
            return index + 1 === totalStations ? 0 : index + 1;
        }

        const checkIfTravellable = (startGasStation: number): number => {
            let runningGasStation = startGasStation;
            let remainingGas = 0;

            remainingGas += gas[runningGasStation];
            remainingGas -= cost[runningGasStation];
            if (remainingGas < 0) return -1;
            runningGasStation = getNextGasStation(runningGasStation);

            while (true) {
                remainingGas += gas[runningGasStation];
                remainingGas -= cost[runningGasStation];
                if (remainingGas < 0) return -1;
                if (runningGasStation === startGasStation) return startGasStation;
                runningGasStation = getNextGasStation(runningGasStation);
            }
        }

        for (let sgs = 0; sgs < totalStations; sgs++) {
            if (checkIfTravellable(sgs) >= 0) return checkIfTravellable(sgs);
        }

        return -1;
    }
}
