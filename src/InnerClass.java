class DataStructure {

    private final static int SIZE = 15;

    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        for (int i = 0; i < SIZE; i++) {
            this.arrayOfInts[i] = i;
        }
    }

    public void printEven() {
        DataStructureIterator iterator = new EventIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()+" ");
        }
        System.out.println();
    }

    interface DataStructureIterator extends java.util.Iterator<Integer> {
    }

    private class EventIterator implements DataStructureIterator {

        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return nextIndex < SIZE;
        }

        @Override
        public Integer next() {
            Integer retValue = arrayOfInts[nextIndex];
            nextIndex+=2;
            return retValue;
        }
    }

    public static void main(String args[]) {

        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        DataStructure.EventIterator ei = ds.new EventIterator();
        ds.printEven();
    }

}