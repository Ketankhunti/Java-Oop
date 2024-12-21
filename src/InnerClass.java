class DataStructure {

    private final static int SIZE = 15;

    private int[] arrayOfInts = new int[SIZE];

    public int get(int index) {
        return arrayOfInts[index];
    }

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

    public static void print(DataStructureIterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next()+" ");
        }
        System.out.println();
    }

    public void print(java.util.function.Function<Integer,Boolean> function){
        for (int i = 0; i < SIZE; i++) {
            if(function.apply(i)){
                System.out.print(arrayOfInts[i]+" ");
            }
        }
        System.out.println();

    }

    public static Boolean isEvenIndex(int index) {
        if (index % 2 == 0) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public static Boolean isOddIndex(Integer index) {
        if (index % 2 == 0) return Boolean.FALSE;
        return Boolean.TRUE;
    }

    public static void main(String args[]) {

        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        DataStructure.EventIterator ei = ds.new EventIterator();

        System.out.println("printEven()");
        ds.printEven();

        System.out.println("print(DataStructureIterator) with "
                + "getEvenIterator");
        print(ei);

        System.out.println("print(DataStructureIterator) with "
                + "anonymous class, odd indicies");

        ds.print(new DataStructureIterator() {

                     private int index = 0;

                     @Override
                     public boolean hasNext() {
                         return index < SIZE;
                     }

                     @Override
                     public Integer next() {
                         int retVal = ds.get(index);
                         index += 2;
                         return retVal;
                     }
        });

        System.out.println("print(Function) even with lambda expressions");
        ds.print(index -> index % 2 == 0);

        System.out.println("print(Function) odd with lambda expressions");
        ds.print(index -> index % 2 == 1);

        System.out.println("print(Function) with method references");
        ds.print(DataStructure::isEvenIndex);
        ds.print(DataStructure::isOddIndex);
    }

}